package ian.net.tcp.aio;

import java.nio.channels.AsynchronousSocketChannel;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import java.net.InetSocketAddress;

public class SimpleAIOClient{

	static final int PORT = 30000;

	public static void main(String[] args) throws Exception {
		ByteBuffer buff = ByteBuffer.allocate(1024);
		Charset utf = Charset.forName("utf-8");
		try(
			AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open();
		){
			clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
			buff.clear();
			clientChannel.read(buff).get();
			buff.flip();
			String content = utf.decode(buff).toString();
			System.out.println("服务器信息：" + content);
		}
	}
}