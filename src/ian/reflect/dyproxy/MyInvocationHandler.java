package ian.reflect.dyproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{

	// 需要被代理的对象
	private Object target;

	public void setTarget(Object target){
		this.target = target;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Exception{
		DogUtil du = new DogUtil();
		du.method1();

		Object result = method.invoke(target, args);

		du.method2();

		return result;
	}
}