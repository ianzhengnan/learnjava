package ian.exception;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;

public class AutoCloseTest{

	public static void main(String[] args) throws IOException {
		
		try(
			BufferedReader br = new BufferedReader(new FileReader("AutoCloseTest.java"));
			PrintStream ps = new PrintStream(new FileOutputStream("a.txt"));
			)
		{

			System.out.println(br.readLine());
			ps.println("Hello kakak");
		}
	}
}