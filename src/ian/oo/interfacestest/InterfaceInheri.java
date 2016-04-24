package ian.oo.interfacestest;

interface interfaceA{

	int PROP_A = 1;
	void testA();
}

interface interfaceB{
	int PROP_B = 2;
	void testB();
}

interface interfaceC extends interfaceA, interfaceB{
	int PROP_C = 3;
	void testC();
}

public class InterfaceInheri implements interfaceC{

	public void testC(){
		System.out.println("this is testC");
	}

	public void testA(){
		System.out.println("this is testA");
	}

	public void testB(){
		System.out.println("this is testB");
	}

	public static void main(String[] args){
		System.out.println(interfaceC.PROP_A);
		System.out.println(interfaceC.PROP_B);
		System.out.println(interfaceC.PROP_C);
		
		InterfaceInheri intheri = new InterfaceInheri();

		intheri.testA();
		intheri.testB();
		intheri.testC();
	}
}