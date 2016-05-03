package ian.collections.list;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class ListTest{


	public static void main(String[] args){

		List books = new ArrayList();

		books.add("Java learning");
		books.add("Python learning");
		books.add(new String("Javascript learning"));

		books.add(1, "kaka");
		System.out.println(books);

		books.remove(2);
		System.out.println(books);

		// books.add(34);
		// System.out.println(books);

		System.out.println(books.indexOf(34));
		books.add("Python learning");
		System.out.println(books);
		System.out.println(books.lastIndexOf("Python learning"));

		List books2 = books.subList(2,4);
		System.out.println(books2);
		for(int i = 0; i < books2.size(); i++){

			System.out.println(books2.get(i));
		}

		// sort() and replaceAll()
		books.sort((o1,o2)->((String)o1).length() - ((String)o2).length());
		System.out.println(books);

		// books2.replaceAll(ele -> ((String)ele).length());
		// System.out.println(books2);

		// ListIterator 
		ListIterator lit = books.listIterator();
		while(lit.hasNext()){
			System.out.println(lit.next());
			lit.add("------------分隔符-------------");
		}
		System.out.println("=========下面开始反向迭代==========");
		while(lit.hasPrevious()){
			System.out.println(lit.previous());
		}

	}

}