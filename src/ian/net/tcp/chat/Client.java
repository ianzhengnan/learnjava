package ian.net.tcp.chat;

import java.net.Socket;
import java.net.UnknownHostException;

import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class Client{

	private static final int SERVER_PORT = 30000;
	private Socket socket;
	private PrintStream ps;
	private BufferedReader brServer;
	private BufferedReader keyIn;

	public void init(){
		try{
			keyIn = new BufferedReader(new InputStreamReader(System.in));
			socket = new Socket("127.0.0.1", SERVER_PORT);
			// 获取该socket对应的输入流和输出流
			ps = new PrintStream(socket.getOutputStream());
			brServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String tip = "";

			while(true){
				String userName = JOptionPane.showInputDialog(tip + "输入用户名");
				// 在用户输入的用户名前后加协议字符后发送
				ps.println(IanProtocol.USER_ROUND + userName 
					+ IanProtocol.USER_ROUND);
				// 读取服务器响应
				String result = brServer.readLine();
				// 如果用户名重复， 则开始下次循环
				if (result.equals(IanProtocol.NAME_REP)) {
					tip = "用户名重复！请重新";
					continue;
				}
				// 如果服务器端返回登录成功，则结束循环
				if (result.equals(IanProtocol.LOGIN_SUCCESS)) {
					break;
				}
			}
		}catch(UnknownHostException ex){
			System.out.println("找不到远程服务器，请确定服务器已经启动！");
			closeRs();
			System.exit(1);
		}catch(IOException ex){
			System.out.println("网络异常！请重新登录！");
			closeRs();
			System.exit(1);
		}
		new IanClientThread(brServer).start();
	}

	private void readAndSend(){
		try{
			// 不断地读取键盘
			String line = null;
			while((line = keyIn.readLine()) != null){
				// 如果发送的信号中有冒号，且以//开头，则认为向发送私聊信息
				if (line.indexOf(":") > 0 && line.startsWith("//")) {
					line = line.substring(2);
					ps.println(IanProtocol.PRIVATE_ROUND
						+ line.split(":")[0]
						+ IanProtocol.SPLIT_SIGN
						+ line.split(":")[1]
						+ IanProtocol.PRIVATE_ROUND);
				}else{
					ps.println(IanProtocol.MSG_ROUND
						+ line
						+ IanProtocol.MSG_ROUND);
				}
			}
		}catch(IOException ex){
			System.out.println("网络通讯异常！请重新登录！");
			closeRs();
			System.exit(1);
		}
	}

	private void closeRs(){
		try{
			if(keyIn != null){
				ps.close();
			}
			if (brServer != null) {
				ps.close();
			}
			if (socket != null) {
				keyIn.close();
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		client.init();
		client.readAndSend();
	}
}