package ian.basiclibs.common;


public class StringBuilderTest{

	public static void main(String[] args){

		StringBuilder sb = new StringBuilder();

		sb.append("java");
		System.out.println(sb);

		sb.insert(0, "hello");
		System.out.println(sb);

		sb.replace(5,6, ",");
		System.out.println(sb);

		sb.delete(5,6);
		System.out.println(sb);

		sb.reverse();
		System.out.println(sb);
		sb.reverse();

		System.out.println(sb.length());
		System.out.println(sb.capacity());

		sb.setLength(5);
		System.out.println(sb);

		String str = sb.toString();
		System.out.println(str.length());

	}


}