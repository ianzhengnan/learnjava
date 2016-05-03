package ian.collections.tools;

import java.util.Collections;
import java.util.ArrayList;

public class SortTest {


	public static void main(String[] args){

		ArrayList nums = new ArrayList();
		nums.add(2);
		nums.add(-5);
		nums.add(3);
		nums.add(0);
		nums.add(-5);

		System.out.println(nums);
		
		Collections.reverse(nums);
		System.out.println(nums);
		
		Collections.sort(nums);
		System.out.println(nums);

		Collections.shuffle(nums);
		System.out.println(nums);

		Collections.shuffle(nums);
		System.out.println(nums);

		System.out.println(Collections.max(nums));
		System.out.println(Collections.min(nums));

		Collections.replaceAll(nums, 0, 1);
		System.out.println(nums);

		System.out.println(Collections.frequency(nums, -5));

		Collections.sort(nums);
		System.out.println(nums);

		System.out.println(Collections.binarySearch(nums, 2));




	}
}