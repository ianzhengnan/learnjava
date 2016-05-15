package ian.threads;

public class DrawTest{

	public static void main(String[] args) {
		Account acct = new Account("9558 7810 9876 3451 234", 1000);
		new DrawThread("甲", acct, 800).start();
		new DrawThread("乙", acct, 800).start();
	}
}