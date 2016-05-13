package ian.io;

import java.nio.channels.FileChannel;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.CharBuffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;


public class FileChannelTest{

	public static void main(String[] args) {
		
		File f = new File("FileChannelTest.java");
		try(
				//创建FileInputStream, 以该文件输入流创建FileChannel
				FileChannel inChannel = new FileInputStream(f).getChannel();
				FileChannel outChannel = new FileOutputStream("a.txt").getChannel();
				
			){

				MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
				// 使用GBK的字符集来创建解码器
				Charset charset = Charset.forName("GBK");

				outChannel.write(buffer);

				buffer.clear();
				//创建解码器
				CharsetDecoder decoder = charset.newDecoder();
				//使用解码器把ByteBuffer转换成CharBuffer
				CharBuffer charBuffer = decoder.decode(buffer);

				System.out.println(charBuffer);
		} catch (IOException ex){

			ex.printStackTrace();
		}
	}

}