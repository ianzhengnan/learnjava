package ian.collections.interfaces;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;

public class CollectionEach{

	public static void main(String[] args){

		Collection books = new HashSet();
		books.add("book1");
		books.add("book2");
		books.add("book3");

		books.forEach(obj -> System.out.println("Iterate all elements: " + obj));

	}
}