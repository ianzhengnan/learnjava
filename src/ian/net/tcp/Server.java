package ian.net.tcp;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.PrintStream;
import java.io.IOException;

public class Server{

	public static void main(String[] args) throws IOException{
		try(
			ServerSocket ss = new ServerSocket(30000);
			){
			while(true){
				System.out.println("服务器端服务已经启动在：" + "127.0.0.1:30000....");
				try(
					Socket s = ss.accept();
					PrintStream ps = new PrintStream(s.getOutputStream());
					){
					ps.println("您好！您收到了来自服务器的祝福！");
				}
			}
		}
	}
}