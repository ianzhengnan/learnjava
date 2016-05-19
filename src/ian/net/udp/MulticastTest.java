package ian.net.udp;

import java.net.MulticastSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

import java.util.Scanner;

import java.io.IOException;


public class MulticastTest implements Runnable{

	private static final String BROADCAST_IP = "230.0.0.1";
	public static final int BOARDCAST_PORT = 30000;
	private static final int DATA_LEN = 4096;

	private MulticastSocket socket = null;
	private InetAddress broadcastAddress = null;
	private Scanner scan = null;

	byte[] inBuff = new byte[DATA_LEN];
	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	private DatagramPacket outPacket = null;

	public void init() throws IOException{
		try(
			Scanner scan = new Scanner(System.in);
		){
			socket = new MulticastSocket(BOARDCAST_PORT);
			broadcastAddress = InetAddress.getByName(BROADCAST_IP);
			socket.joinGroup(broadcastAddress);
			// 设置本MulticastSocket发送的数据会被回送到自身
			socket.setLoopbackMode(false);
			outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BOARDCAST_PORT);
			// 接收线程要在发送前启动
			new Thread(this).start();
			// 发送线程开始发送
			while(scan.hasNextLine()){
				byte[] buff = scan.nextLine().getBytes();
				outPacket.setData(buff);
				socket.send(outPacket);
			}
		}finally{
			socket.close();	
		}
	}

	public void run(){
		try{
			while(true){
				socket.receive(inPacket);
				System.out.println("聊天信息：" + new String(inBuff, 0, inPacket.getLength()));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException{
		new MulticastTest().init();
	}
}