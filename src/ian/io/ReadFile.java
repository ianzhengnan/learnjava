package ian.io;

import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile{

	public static void main(String[] args) throws IOException {
		
		try(
				FileInputStream fis = new FileInputStream("ReadFile.java");
				FileChannel fcin = fis.getChannel();
			){

				//定义一个ByteBuffer对象，用于重复取水
				ByteBuffer bbuff = ByteBuffer.allocate(256);
				//将FileChannel中的数据放入ByteBuffer中
				while(fcin.read(bbuff) != -1){

					// 锁定Buffer的空白区
					bbuff.flip();
					// 创建Charset对象
					Charset charset = Charset.forName("GBK");
					// 创建解码器(CharsetDecoder)对象
					CharsetDecoder decoder = charset.newDecoder();
					// 将ByteBuffer的内容转码
					CharBuffer cbuff = decoder.decode(bbuff);
					System.out.println(cbuff);

					//将 Buffer初始化，为下一次读取做准备
					bbuff.clear();
				}
		}
	}
}