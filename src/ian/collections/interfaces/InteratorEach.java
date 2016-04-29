package ian.collections.interfaces;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class InteratorEach{

	public static void main(String[] args){

		Collection books = new ArrayList();
		books.add("book1");
		books.add("book2");
		books.add("book3");
		books.add("book4");
		books.add("book5");

		Iterator it = books.iterator();
		// forEachRemaining(Consumer action). send element one by one to Consumer.accept(T t) 
		it.forEachRemaining(obj -> System.out.println("Interate all collection elements: " + obj));

	}	
}