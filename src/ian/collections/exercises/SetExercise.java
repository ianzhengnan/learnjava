package ian.collections.exercises;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Scanner;
import java.util.LinkedHashSet;

public class SetExercise{


	public static void main(String[] args){

		Set st = new TreeSet();

		Scanner sc = new Scanner(System.in);

		int i = 0;
		while(i < 10){
			st.add(sc.nextLine());
			i++;
		}
		System.out.println(st);

	}
}