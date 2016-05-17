package ian.net.tcp.chat;


public class Test{

	public static void main(String[] args) {
		
		String str = "flks`test";
		String user = str.split("`")[0];
		String msg = str.split("`")[1];
		System.out.println(user + "---" + msg);
	}
}