package ian.generic.genericmethods;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class GenericMethodTest{

	static <T> void fromArrayToCollection(T[] a, Collection<T> c){

		for(T o : a){
			c.add(o);
		}
	}

	public static void main(String[] args){

		String[] strArr = {"hello", "world"};
		List<String> strList = new ArrayList<>();
		fromArrayToCollection(strArr, strList);
		System.out.println(strList);
	}

}