package ian.generic.genericmethods;

class MyClass<E>{

	public <T> MyClass(T t){

		System.out.println("t参数的值为：" + t);
	}
}


public class GenericDiamondTest{

	public static void main(String[] args) {
		
		MyClass<String> mcl = new MyClass<>(5);

		MyClass<String> mc2 = new <Integer> MyClass<String>(5);

		// below statement will case error
		// MyClass<String> mc3 = new <Integer> MyClass<>(5);

	}

}