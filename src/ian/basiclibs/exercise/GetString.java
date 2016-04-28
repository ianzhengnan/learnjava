package ian.basiclibs.exercise;


public class GetString{

	public static void main(String[] args){


		String str = "ABCDEFG";
		String tmp = str.substring(2,4);
		System.out.println(tmp);

		System.out.println(str.substring(str.indexOf("B"), str.indexOf("B") + 1) +
		 " " + str.substring(str.indexOf("F"), str.indexOf("F") + 1));
	}

}