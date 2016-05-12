package ian.io;

import java.io.PrintStream;
import java.io.IOException;
import java.io.FileOutputStream;

import java.util.Scanner;

public class WriteToProcess{

	public static void main(String[] args) throws IOException {
		
		Process p = Runtime.getRuntime().exec("java ian.io.ReadStandard");
		try(
				PrintStream ps = new PrintStream(p.getOutputStream());
			){

				ps.println("这是普通字符串，Ian输入");
				ps.println(new WriteToProcess());
		}

	}
}

class ReadStandard{

	public static void main(String[] args) {
		
		try(
				Scanner sc = new Scanner(System.in);
				PrintStream ps = new PrintStream(new FileOutputStream("out.txt"));
			){
				sc.useDelimiter("\n");
				while(sc.hasNext()){
					ps.println("键盘输入的内容是：" + sc.next());
				}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}