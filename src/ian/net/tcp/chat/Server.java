package ian.net.tcp.chat;

import java.io.PrintStream;
import java.io.IOException;

import java.net.Socket;
import java.net.ServerSocket;


public class Server{

	private static final int SERVER_PORT = 30000;
	// 用来保存每个客户的名字和对应的输出流
	public static IanMap<String, PrintStream> clients = new IanMap<>();

	public void init(){
		try(
			ServerSocket ss = new ServerSocket(SERVER_PORT);
		){
			while(true){
				Socket socket = ss.accept();
				new IanServerThread(socket).start();
			}
		}catch(IOException ex){
			System.out.println("服务器启动失败，是否端口"
				+ SERVER_PORT + "已经被占用？");
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.init();
	}
}