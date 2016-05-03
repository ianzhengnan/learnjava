package ian.collections.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class ArrayDequeStack{


	public static void main(String[] args){

		ArrayDeque stack = new ArrayDeque();
		stack.push("java learning");
		stack.push("python learning");
		stack.push("javascript learning");

		System.out.println(stack);

		System.out.println(stack.peek());

		System.out.println(stack.pop());

		System.out.println(stack);
		
		System.out.println(stack.pollLast());
		System.out.println(stack);


		LinkedList books = new LinkedList();

		books.offer("疯狂java讲义");
		books.push("轻量级Java EE 企业应用实战");
		books.offerFirst("疯狂Android讲义");

		for(int i = 0; i < books.size(); i++){

			System.out.println("遍历中..." + books.get(i));
		}

		System.out.println(books.peekFirst());
		System.out.println(books.peekLast());
		System.out.println(books.pop());
		System.out.println(books);
		System.out.println(books.pollLast());
		System.out.println(books);

	}

}