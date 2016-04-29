package ian.collections.interfaces;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class InteratorTest{

	public static void main(String[] args){

		// Collection books = new HashSet();
		Collection books = new ArrayList();
		books.add("book1");
		books.add("book2");
		books.add("book3");
		books.add("book4");
		books.add("book5");

		Iterator it = books.iterator();

		while(it.hasNext()){

			String book = (String)it.next();
			System.out.println(book);

			if(book.equals("book3")){
				it.remove();
			}
			book = "Testing string";
		}
		System.out.println(books);

	}

}