package ian.io;

import java.nio.CharBuffer;

public class BufferTest{

	public static void main(String[] args) {
		
		CharBuffer buff = CharBuffer.allocate(8);
		System.out.println("Capacity: " + buff.capacity());
		System.out.println("Limit: " + buff.limit());
		System.out.println("position: " + buff.position());

		buff.put('a');
		buff.put('b');
		buff.put('c');

		System.out.println("加入三个元素后，position ＝ " 
			+ buff.position());

		buff.flip();
		System.out.println("执行flip()后，limit ＝ " + buff.limit());
		System.out.println("position = " + buff.position());
		// 取出第一个元素
		System.out.println("第一个元素(position = 0): " + buff.get());
		System.out.println("取出一个元素后，position = " 
			+ buff.position());
		// 调用clear()方法
		buff.clear();
		System.out.println("执行clear()后，limit ＝ " + buff.limit());
		System.out.println("执行clear()后， position ＝ "
			+ buff.position());
		System.out.println("执行clear()后， 缓冲区内容并没有被清除：" 
			+ "第三个元素为：" + buff.get(2));
		System.out.println("执行绝对读取后，position ＝ " 
			+ buff.position());

	}

}