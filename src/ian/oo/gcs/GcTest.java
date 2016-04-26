package ian.oo.gcs;

public class GcTest{

	public static void main(String[] args){
		for(int i =0; i < 4; i++){
			new GcTest();
			// System.gc();
			Runtime.getRuntime().gc();
		}
	}
	public void finalize(){
		System.out.println("系统正在清理GcTest对象的资源...");
	}
}