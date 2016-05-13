package ian.io;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CharsetDecoder;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;

import java.io.IOException;

public class CharsetTransform{


	public static void main(String[] args) throws IOException {
		
		Charset cn = Charset.forName("GBK");
		CharsetEncoder cnEncoder = cn.newEncoder();
		CharsetDecoder cnDecoder = cn.newDecoder();

		CharBuffer cbuff = CharBuffer.allocate(8);
		cbuff.put('孙');
		cbuff.put('悟');
		cbuff.put('空');
		cbuff.flip();

		ByteBuffer bbuff = cnEncoder.encode(cbuff);
		for (int i = 0; i < bbuff.capacity() ; i++) {
			System.out.println(bbuff.get(i) + "");
		}
		System.out.println("\n" + cnDecoder.decode(bbuff));

		ByteBuffer sBuff = cn.encode("你是我的小啊小苹果");
		System.out.println("\n" + sBuff);
		System.out.println("\n" + cnDecoder.decode(sBuff));

	}
}