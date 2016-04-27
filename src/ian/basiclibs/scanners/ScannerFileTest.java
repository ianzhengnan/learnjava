package ian.basiclibs.scanners;

import java.util.Scanner;
import java.io.File;

public class ScannerFileTest {

	// add 'throws Exception' make sure the build is successful
	// it means the main function doesn't handle the error of IO exceptions
	public static void main(String[] args) throws Exception{

		// you must run it in the the folder that contain below files
		Scanner sc = new Scanner(new File("test.txt"));
		System.out.println("test.txt内容如下：");
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}

}