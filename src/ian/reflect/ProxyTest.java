package ian.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.lang.reflect.Method;

interface Person{

	void walk();
	void sayHello(String name);
}

class MyInvocationHandler implements InvocationHandler{

	/* 
	执行动态代理对象的所有方法时，都会替换成执行如下的invoke方法
	其中：
	proxy：代表动态代理对象
	method：代表正在执行的方法
	args: 代表调用目标方法时传入的实参
	*/
	public Object invoke(Object proxy, Method method, Object[] args){
		System.out.println("----正在执行的方法：" + method);
		if (args != null) {
			System.out.println("下面是执行该方法是传入的实际参数：");
			for (Object val : args) {
				System.out.println(val);
			}
		}else{
			System.out.println("调用的方法没有实参！");
		}
		return null;
	}
}

public class ProxyTest{
	public static void main(String[] args) throws Exception{
		InvocationHandler handler = new MyInvocationHandler();
		Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader()
			, new Class[]{Person.class}, handler);
		p.walk();
		p.sayHello("孙悟空");
	}
}