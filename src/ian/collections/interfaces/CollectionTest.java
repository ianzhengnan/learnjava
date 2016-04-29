package ian.collections.interfaces;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;

public class CollectionTest{

	public static void main(String[] args){

		Collection c = new ArrayList();

		c.add("ian");
		c.add(9);
		c.add("flks555");
		c.add(8);
		System.out.println("c collection has total: " + c.size());
		c.remove(8);
		System.out.println("c collection has total: " + c.size());

		System.out.println("c contains flks: " + c.contains("flks"));

		System.out.println("c collection elements: " + c);

		Collection books = new HashSet();

		books.add("python1");
		books.add("ian");

		System.out.println("c contains all books? " + c.containsAll(books));

		c.removeAll(books);
		System.out.println("c collection elements: " + c);
		c.clear();
		System.out.println("c collection elements: " + c);
		books.retainAll(c);
		System.out.println("books collection elements: " + books);



	}

}