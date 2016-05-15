package ian.threads.communicate;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Account{

	private final Lock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();

	private String accountNo;
	private double balance;
	// 存款中是否有钱的标志
	private boolean flag = false;

	public Account(){}

	public Account(String accountNo, double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void setAccountNo(String accountNo){
		this.accountNo = accountNo;
	}
	public String getAccountNo(){
		return accountNo;
	}

	public double getBalance(){
		return this.balance;
	}

	public void draw(double drawAmount){
		lock.lock();
		try{
			if (!flag) {
				cond.await();
			}else{
				System.out.println(Thread.currentThread().getName()
					+ "取钱" + drawAmount);
				balance -= drawAmount;
				System.out.println("账户的余额为：" + balance);
				flag = false;
				cond.signalAll();
			}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public void deposit(double depositAmount){
		lock.lock();
		try{
			if (flag) {
				cond.await();
			}else{
				System.out.println(Thread.currentThread().getName()
					+ " 存款：" + depositAmount);
				balance += depositAmount;
				System.out.println("账户的余额为：" + balance);
				flag = true;
				cond.signalAll();
			}
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public int hashCode(){
		return this.accountNo.hashCode();
	}

	public boolean equals(Object obj){
		if (obj == this) {
			return true;
		}
		if (obj != null && obj.getClass() == Account.class) {
			Account target = (Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}

}