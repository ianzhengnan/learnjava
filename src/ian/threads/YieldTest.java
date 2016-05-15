package ian.threads;

public class YieldTest extends Thread{

	public YieldTest(String name){

		super(name);
	}

	public void run(){
		for (int i = 0; i < 50 ; i++ ) {
			System.out.println(getName() + " " + i);
			if (i == 20) {
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) throws Exception{
		
		YieldTest yt1 = new YieldTest("高级");
		yt1.setPriority(Thread.MAX_PRIORITY);
		yt1.start();

		YieldTest yt2 = new YieldTest("低级");
		yt2.setPriority(Thread.MIN_PRIORITY);
		yt2.start();
	}
}