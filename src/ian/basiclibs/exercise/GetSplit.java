package ian.basiclibs.exercise;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class GetSplit{

	public static void main(String[] args){


		String str = "A1B2C3D4E5F6G7H8";

		String[] arrStr = new String[8];
		int[] arrInt = new int[8];

		Pattern p = Pattern.compile("(\\D+?)(\\d+?)");
		Matcher m = p.matcher(str);

		int i = 0;
		while(m.find()){
			// System.out.println(m.group());
			arrStr[i] = m.group().substring(0,1);
			arrInt[i] = new Integer(m.group().substring(1,2));
			System.out.println(arrStr[i] + "--->" + arrInt[i]);
		}

	}

}
