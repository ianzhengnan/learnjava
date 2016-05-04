package ian.generic.genericmethods;


class Foo{

	public <T> Foo(T t){
		System.out.println(t);
	}
}

public class GenericConstructor{

	public static void main(String[] args) {
		new Foo("你好啊！");
		new Foo(12345);
		new <String> Foo("疯狂Java讲义");
		// new <String> Foo(12.34);
	}

}