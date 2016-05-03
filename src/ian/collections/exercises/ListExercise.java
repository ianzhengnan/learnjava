package ian.collections.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;

public class ListExercise{


	public static void main(String[] args){

		List ls = new ArrayList();

		ls.add("Hello");
		ls.add("java");
		ls.add("python");
		ls.add("Ruby");
		ls.add("test");
		ls.add("learning");
		ls.add("Perl");
		ls.add("Go");
		ls.add("test");
		ls.add("learning");
		ls.add("Perl");
		ls.add("Go");

		System.out.println(ls);
		System.out.println(ls.get(5));

		ls.remove(3);
		System.out.println(ls);

//---------------------------------------------------
		String[] stArr = new String[]{"a", "b", "a", "b", "c", "a", "b", "c", "b"};
		List<String> al = Arrays.asList("a", "b", "a", "b", "c", "a", "b", "c", "b");

		System.out.println(al);

		HashMap hm = new HashMap();

		al.forEach(obj -> hm.put(obj, Collections.frequency(al, obj)));

		System.out.println(hm);
	}

}