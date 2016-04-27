package ian.basiclibs.runtime;

import java.text.DecimalFormat;

public class RuntimeTest{

	public static void main(String[] args) throws Exception{

		DecimalFormat dt = new DecimalFormat("0.00");
		Runtime rt = Runtime.getRuntime();
		System.out.println("处理器数量：" + rt.availableProcessors());
		System.out.println("空闲内存数：" + dt.format(rt.freeMemory()) + " MB");
		System.out.println("总内存数：" + dt.format(rt.totalMemory()) + " MB");
		System.out.println("可用最大内存数：" + dt.format(rt.maxMemory()) + " MB");

		rt.exec("notepad.exe");
	}

}