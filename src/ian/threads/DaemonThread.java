package ian.threads;


public class DaemonThread extends Thread{

	public void run(){
		for (int i = 0; i < 1000 ; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		// set daemon thread
		dt.setDaemon(true);
		// start deamon thread
		dt.start();
		for (int i = 0; i < 20 ; i ++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}

		// main done
		// then the daemon done also
	}
}