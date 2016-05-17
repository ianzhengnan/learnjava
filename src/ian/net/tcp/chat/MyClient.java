package ian.net.tcp.chat;

import java.net.Socket;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MyClient{

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("127.0.0.1", 30000);
		//启动ClientThread线程不断地读取来自服务器的数据
		new Thread(new ClientThread(s)).start();
		// 获取该Socket对应的输出流
		PrintStream ps = new PrintStream(s.getOutputStream());
		String line = null;

		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		while((line = br.readLine()) != null){
			ps.println(line);
		}
	}
}