package ian.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.io.IOException;

public class UdpServer{

	public static final int PORT = 30000;
	private static final int DATA_LEN = 4096;
	byte[] inBuff = new byte[DATA_LEN];

	private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
	private DatagramPacket outPacket;

	String[] books = new String[]{
		"疯狂Java讲义",
		"轻量级Java EE企业应用实战",
		"疯狂Android讲义",
		"疯狂Ajax讲义"
	};

	public void init() throws IOException{
		try(
			DatagramSocket socket = new DatagramSocket(PORT);
		){
			for (int i = 0; i < 1000 ; i++) {
				socket.receive(inPacket);
				System.out.println(inBuff == inPacket.getData());
				System.out.println(new String(inBuff, 0, inPacket.getLength()));
				byte[] sendData = books[i % 4].getBytes();
				outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
				socket.send(outPacket);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		new UdpServer().init();
	}
}