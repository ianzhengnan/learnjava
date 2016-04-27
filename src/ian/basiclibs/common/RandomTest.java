package ian.basiclibs.common;

import java.util.Random;

public class RandomTest{

	public static void main(String[] args){

		Random rm = new Random();

		// int[] its = new int[5];
		// rm.nextInts(its);
		int i = 0;
		while(i < 30){
			System.out.println(rm.nextInt(28));
			i++;
		}
	}

}