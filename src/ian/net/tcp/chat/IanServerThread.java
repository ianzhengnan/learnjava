package ian.net.tcp.chat;

import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStreamReader;

public class IanServerThread extends Thread{

	private Socket socket;
	BufferedReader br = null;
	PrintStream ps = null;

	public IanServerThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		try{
			// 获取该Socket对应的输入流
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ps = new PrintStream(socket.getOutputStream());
			String line = null;
			while((line = br.readLine()) != null){
				// 如果读到的行以IanProtocol.USER_ROUND开始，并以其结束
				// 则可以确定读到的是用户登录的用户名
				if (line.startsWith(IanProtocol.USER_ROUND) 
					&& line.endsWith(IanProtocol.USER_ROUND)) {
					String userName = getRealMsg(line);
					//如果用户名重复
					if (Server.clients.map.containsKey(userName)) {
						System.out.println("重复");
						ps.println(IanProtocol.NAME_REP);
					}else{
						System.out.println("成功");
						ps.println(IanProtocol.LOGIN_SUCCESS);
						Server.clients.put(userName, ps);
					}
				}else if(line.startsWith(IanProtocol.PRIVATE_ROUND)
					&& line.endsWith(IanProtocol.PRIVATE_ROUND)){
					String userAndMsg = getRealMsg(line);
					//以SPLIT_SIGN分隔字符串， 前半部分时私聊用户， 后半部分是聊天信息
					System.out.println(userAndMsg);
					System.out.println(IanProtocol.SPLIT_SIGN);
					String user = userAndMsg.split(IanProtocol.SPLIT_SIGN)[0];
					String msg = userAndMsg.split(IanProtocol.SPLIT_SIGN)[1];
					System.out.println(user + ":" + msg);
					Server.clients.map.get(user).println(Server.clients.getKeyByValue(ps) + "悄悄对你说：" + msg);
				}else{
					//公聊
					String msg = getRealMsg(line);
					for (PrintStream clientPs : Server.clients.valueSet()) {
						clientPs.println(Server.clients.getKeyByValue(ps) + "说：" + msg);
					}
				}
			}
		}catch(IOException e){
			Server.clients.removeByValue(ps);
			System.out.println(Server.clients.map.size());
			//关闭网络，IO资源
			try{
				if (br != null) {
					br.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (socket != null) {
					socket.close();
				}
			}catch(IOException ex){
				ex.printStackTrace();
			}
		}
	}

	private String getRealMsg(String line){
		return line.substring(IanProtocol.PROTOCOL_LEN, line.length() - IanProtocol.PROTOCOL_LEN);
	}

}