package ian.collections.interfaces;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class ForeachTest{

	public static void main(String[] args){

		Collection books = new ArrayList();
		books.add("book1");
		books.add("book2");
		books.add("book3");
		books.add("book4");
		books.add("book5");

		for(Object obj : books){
			String book = (String)obj;
			System.out.println(book);
			if (book.equals("book4")) {
				books.remove(book);
			}
		}
		System.out.println(books);
	}
}