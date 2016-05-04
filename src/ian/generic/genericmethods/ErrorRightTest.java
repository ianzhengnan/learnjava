package ian.generic.genericmethods;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class ErrorRightTest {

	static <T> void test(Collection<? extends T> from, Collection<T> to){
		for (T ele : from) {
			to.add(ele);
		}
	}

	public static void main(String[] args){

		List<Object> ao = new ArrayList<>();
		List<String> as = new ArrayList<>();
		
		test(as, ao);
	}


}