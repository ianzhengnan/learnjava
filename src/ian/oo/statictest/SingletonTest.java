package ian.oo.statictest;

class Singleton {

	private static Singleton instance;
	
	private Singleton(){}

	public static Singleton getInstance(){
		if(instance == null){
			instance = new Singleton();
		}
		return instance;
	}

}



public class SingletonTest {

	public static void main(String[] args){

		Singleton single1 = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();

		System.out.println(single1 == single2);
	}

}