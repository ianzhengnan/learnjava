package ian.generic.genericmethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class MyUtils {
	
	public static <T> T copy(Collection<? super T> dest,
		Collection<T> src){

		T last = null;
		for (T ele : src) {
			last = ele;
			dest.add(ele);
		}
		return last;
	}

	public static void main(String[] args) {
		List<Number> ln = new ArrayList<>();
		List<Integer> li = new ArrayList<>();
		li.add(5);
		li.add(-3);
		li.add(18);

		Integer last = copy(ln, li);
		System.out.println(ln);
	}

}