package ian.basiclibs.exercise;

import java.util.Scanner;

public class GetValues{

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		// int[] ints = new int[10];
		// sc.useDelimiter("\n"); // cannot use on nextInt()/nextLong(), the programm will terminat
		int i = 0, sum = 0;
		while(
			//sc.hasNextInt() &&
		 i < 10){
			sum += sc.nextInt();
			i++;
		}

		System.out.println("The Sum is " + sum);

	}

}