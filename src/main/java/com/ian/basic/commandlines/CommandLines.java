package com.ian.basic.commandlines;
import java.util.Scanner;

public class CommandLines{

	public static void main(String[] args) {
		
		System.out.printf("Welcome to Java command line console:\n");
		System.out.printf(">>>");
		Scanner sc = new Scanner(System.in);

		int cmd = sc.nextInt();

		while(cmd != 0){
			if(cmd == 1){
				System.out.printf("This is for building\n");
				System.out.printf(">>>");
			}else if(cmd == 2){
				System.out.printf("This is for cleaning\n");
				System.out.printf(">>>");
			}else{
				System.out.printf("This is for forking\n");
				System.out.printf(">>>");
			}
			cmd = sc.nextInt();
		}
		
	}

}