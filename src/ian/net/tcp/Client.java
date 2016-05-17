package ian.net.tcp;

import java.net.Socket;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;


public class Client{

	public static void main(String[] args) throws IOException{
		try(
			Socket socket = new Socket();
			
			// 使用BufferedReader和Scanner都可以
			// BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			){
			socket.connect(new InetSocketAddress("ian", 30000), 10000);
			Scanner sc = new Scanner(socket.getInputStream());
			// String line = br.readLine();
			String line = sc.nextLine();
			System.out.println("来自服务器的数据：" + line);
			sc.close();
		}catch(SocketTimeoutException ex){
			ex.printStackTrace();	
		}
	}
}