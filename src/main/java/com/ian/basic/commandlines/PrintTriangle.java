package com.ian.basic.commandlines;
import java.util.Scanner;


public class PrintTriangle{

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);
		System.out.print("Please input the triangle level: ");
		int level = sc.nextInt();
		System.out.println();

		for (int i = 0; i < level; i++ ) {
			for(int j = 0; j < level - i - 1 ; j++){
				System.out.print(" ");
			}

			for(int x = 0; x < i * 2 + 1; x++){
				System.out.print("*");
			}
			System.out.println();
		}

	}

}