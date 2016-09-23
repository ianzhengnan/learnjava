package com.ian.basic.commandlines;

import java.util.Scanner;
import static utils.Print.*;


public class LearnVarious{

	public static void main(String args[]){


		// float f = 1.23f;
		// double d = 1.23;
		// d += 1;

		// char str = '\r';
		// char ch = '\u9999';

		// String strTest = "kakasdfsdfs";
		// System.out.printf("float is %f.\tDouble is %f\nHello, World!\n", f, d);

		// System.out.printf("Hello KaKa!");

		// int[] arrInt = new int[]{1,3,4,5};  
		int[] arrInt = {2,3,4,5,6};

		// arrInt[5] = 12;

		Object[] arrObj = new String[3];
		arrObj[0] = "kkkk";
		arrObj[1] = "KaKa";
		arrObj[2] = "Ian";

		for(int i = 0; i < arrObj.length; i++){
			print(arrObj[i]);
		}

		for(int i = 0; i < arrInt.length; i++){
			print(arrInt[i]);
		}

		for(int i : arrInt){
			print(i);
		}

	}
}