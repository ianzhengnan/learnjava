package ian.oo.boxingclasses;

public class BoxingClsTest {

	public static void main(String[] args){

		Integer inObj = 5;
		Object testBool = true;
		int i = inObj;

		if(testBool instanceof Boolean){
			//downcasing to subclass of Object class
			boolean b = (Boolean)testBool;
			System.out.println("the result is " + b);
		} 
	}
}