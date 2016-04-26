package ian.oo.exercise.interfaces;

@FunctionalInterface
interface FKTest{
	void run();
}


public class FunctionalIFTest {

	public static void main(String[] args){

		// Runnable r = () -> {
		// 	for(int i = 0; i < 10; i++){
		// 		System.out.println(i);
		// 	}
		// };
		
		Object obj = (FKTest)() -> {
			for(int i =0; i < 100; i++){
				System.out.println();
			}
		};
		
		System.out.println("llll");
	}

}