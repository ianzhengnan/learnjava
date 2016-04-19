package utils;
import java.io.*;

public class Print {

	public static void print(Object data){
		System.out.println(data);
	}

	public static void print(){
		System.out.println();
	}

	public static void printnb(Object data){
		System.out.print(data);
	}

	public static PrintStream printf(String pattern, Object... args){
		return System.out.printf(pattern, args);
	}

}