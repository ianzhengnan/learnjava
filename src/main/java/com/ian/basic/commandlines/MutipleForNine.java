package com.ian.basic.commandlines;


public class MutipleForNine {

	public static void main(String args[]){

		for(int i = 1; i <= 9; i++){

			for(int j = 1; j <= i; j++){

				System.out.printf("%d x %d = %d ", i, j, i*j);
				if(j == i){
					System.out.println();
				}
			}
		}
	}
}