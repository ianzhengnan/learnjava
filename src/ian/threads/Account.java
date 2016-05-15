package ian.threads;
	
import java.util.concurrent.locks.ReentrantLock;

public class Account{

	private final ReentrantLock lock = new ReentrantLock();
	private String accountNo;
	private double balance;

	public Account(String accountNo, double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}

	// setter and getters
	public void setAccountNo(String accountNo){
		this.accountNo = accountNo;
	}
	public String getAccountNo(){
		return this.accountNo;
	}

	// public void setBalance(double balance){
	// 	this.balance = balance;
	// }
	public double getBalance(){
		return this.balance;
	}

	// 提供一个线程安全的draw方法来完成取钱操作
	/*public synchronized void draw(double drawAmount){
		// total amount > draw amount
		if (balance >= drawAmount) {
			
			System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);

			try{
				Thread.sleep(1);
			}catch(InterruptedException ex){
				ex.printStackTrace();
			}

			balance -= drawAmount;
			System.out.println("\t余额为：" + balance);
		}else{
			System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足");
		}
	}*/

	public void draw(double drawAmount){

		lock.lock();
		try{
			if (balance >= drawAmount) {
			
				System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);

				try{
					Thread.sleep(1);
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}

				balance -= drawAmount;
				System.out.println("\t余额为：" + balance);

			}else{
				System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足");
			}

		}finally{
			lock.unlock();
		}

		// total amount > draw amount
		
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