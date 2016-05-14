package ian.threads;


public class FirstThread extends Thread{
	//这里的i对每个thread都是独立的，互相不回影响
	private int i;

	public void run(){

		for (; i < 100 ; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		
		for (int i = 0; i < 100 ; i++) {
			
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				// start first thread
				new FirstThread().start();
				// start second thread
				new FirstThread().start();
			}
		}
	}
}