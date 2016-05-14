package ian.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThirdThread{

	public static void main(String[] args) {
		ThirdThread rt = new ThirdThread();

		// 使用lambda或者直接使用Kaka类
		FutureTask<Integer> task = new FutureTask<Integer>(
			(Callable<Integer>)() -> {
			int i = 0;
			for (; i < 100 ; i++) {
				System.out.println(Thread.currentThread().getName()
					+ " 的循环变量i的值：" + i);
			}
			return i;
		}
			// new Kaka()
		);

		for (int i = 0; i < 100 ; i++ ) {
			System.out.println(Thread.currentThread().getName() 
				+ " 循环变量i的值：" + i);
			if (i == 20) {
				new Thread(task, "有返回值的线程").start();
			}
		}

		try{
			System.out.println("子线程的返回值：" + task.get());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

class Kaka implements Callable {

	private int i = 0;
	@Override
	public Integer call(){
		for (; i < 100 ; i++) {
			System.out.println(Thread.currentThread().getName()
					+ " 的循环变量i的值：" + i);
		}
		return i;
	}
}