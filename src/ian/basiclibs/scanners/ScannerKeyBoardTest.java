package ian.basiclibs.scanners;

import java.util.Scanner;

public class ScannerKeyBoardTest {


	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		while(sc.hasNextLine()){
			System.out.println("键盘输入的内容是：" + sc.nextLine());
		}
	}

}