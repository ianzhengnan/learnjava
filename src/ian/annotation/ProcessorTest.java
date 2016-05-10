package ian.annotation;

import java.lang.reflect.Method;

public class ProcessorTest{

	public static void process(String clazz) throws ClassNotFoundException{

		int passed = 0;
		int failed = 0;

		for (Method m : Class.forName(clazz).getMethods()) {
			
			if (m.isAnnotationPresent(Testable.class)) {			
				try{
					m.invoke(null);
					passed++;
				}catch(Exception ex){
					System.out.println("方法" + m.getName() + "运行失败，异常："
						+ ex.getCause());
					failed++;
				}
			}
		}
		System.out.println("共运行了：" + (passed + failed) 
			+ "个方法， 其中：\n" + "失败了：" + failed + "个，\n"
			+ "成功了：" + passed + "个！");
	}

}