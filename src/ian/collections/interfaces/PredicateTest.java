package ian.collections.interfaces;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Predicate;

public class PredicateTest{

	public static int calAll(Collection books, Predicate p){

		int total = 0;
		for(Object obj : books){
			if (p.test(obj)) {
				total ++;
			}
		}
		return total;
	}

	public static void main(String[] args){

		Collection books = new ArrayList();
		books.add("book3");
		books.add("book3");
		books.add("book3");
		books.add("book4");
		books.add("book5");

		System.out.println(calAll(books, ele -> ((String)ele).contains("2")));
		System.out.println(calAll(books, ele -> ((String)ele).contains("5")));
		System.out.println(calAll(books, ele -> ((String)ele).contains("3")));

	}
}