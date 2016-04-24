package ian.oo.interfacestest;

import ian.oo.interfaces.Output;

interface Product{
	int getProduceTime();
}

public class Printer implements Output, Product{

	private String[] printData = new String[MAX_CACHE_LINE];

	private int dataNum = 0;

	public void out(){
		while(dataNum > 0){
			System.out.println("打印机打印：" + printData[0]);
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}
	public void getData(String msg){
		if (dataNum >= MAX_CACHE_LINE) {
			System.out.println("输出队列已满，添加失败");
		}else{
			printData[dataNum++] = msg;
		}
	}

	public int getProduceTime(){
		return 45;
	}

	public static void main(String[] args){
		Output o = new Printer();
		o.getData("轻量级java EE企业应用实战");
		o.getData("疯狂Java讲义");
		o.out();
		o.getData("疯狂Android讲义");
		o.getData("疯狂Ajax讲义");
		o.out();
		o.print("孙悟空", "猪八戒", "唐僧");
		o.test();

		Product p = new Printer();
		System.out.println(p.getProduceTime());
		Object obj = p;
		System.out.println(obj.toString());
	}

}