package ian.collections.interfaces;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.IntStream;


public class IntStreamTest{

	public static void main(String[] args){


		IntStream is = IntStream.builder()
			.add(20)
			.add(34)
			.add(-2)
			.add(18)
			.add(-5)
			.build();

		// the code can be execute only once.
		// System.out.println("is max: " + is.max().getAsInt());
		// System.out.println("is min: " + is.min().getAsInt());
		// System.out.println("is total: " + is.sum());
		// System.out.println("is count: " + is.count());
		// System.out.println("is avg: " + is.average());
		// System.out.println("is all square > 20: " + is.allMatch(ele -> ele * ele > 20));
		// System.out.println("is any square > 20: " + is.anyMatch(ele -> ele * ele > 20));

		// is mapping to a new stream , new stream's element is 2 times plus 1 of the old one
		IntStream newIs = is.map(ele -> ele * 2 + 1);
		// 
		newIs.forEach(System.out::println);

	}

}