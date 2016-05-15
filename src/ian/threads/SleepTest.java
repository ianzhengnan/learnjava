package ian.threads;

import java.util.Date;

public class SleepTest{

	public static void main(String[] args) throws Exception {
			
		for (int i = 0; i < 10 ; i++) {
			System.out.println(Thread.currentThread().getName() + "当前时间：" + new Date() + " " + i);
			Thread.sleep(1000);
		}
	}
}