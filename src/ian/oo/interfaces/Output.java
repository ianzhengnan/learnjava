package ian.oo.interfaces;

public interface Output{

	int MAX_CACHE_LINE = 50;

	// public abstract 
	void out();
	void getData(String msg);

	// default method
	default void print(String... msgs){
		for(String msg : msgs){
			System.out.println(msg);
		}
	}

	// more default method
	default void test(){
		System.out.println("默认的test方法");
	}

	// class method
	static String staticTest(){
		return "接口里的类方法";
	}

}