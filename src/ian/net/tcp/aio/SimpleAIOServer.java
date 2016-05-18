package ian.net.tcp.aio;

import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.ByteBuffer;

import java.net.InetSocketAddress;

import java.util.concurrent.Future;

public class SimpleAIOServer{

	static final int PORT = 30000;

	public static void main(String[] args) throws Exception{
		try(
			AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
		){
			serverChannel.bind(new InetSocketAddress(PORT));
			while(true){
				Future<AsynchronousSocketChannel> future = serverChannel.accept();
				AsynchronousSocketChannel socketChannel = future.get();
				socketChannel.write(ByteBuffer.wrap("欢迎你来到AIO的世界！".getBytes("UTF-8"))).get();
			}
		}
	}
}