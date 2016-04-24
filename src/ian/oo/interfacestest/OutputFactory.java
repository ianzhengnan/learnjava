package ian.oo.interfacestest;

import ian.oo.interfaces.Output;

public class OutputFactory{

	public Output getOutput(){
		return new BetterPrinter();
	}

	public static void main(String[] args){
		OutputFactory of = new OutputFactory();
		Computer cp = new Computer(of.getOutput());
		cp.keyIn("这是第一条信息");
		cp.keyIn("这是第二条信息");
		cp.print();
	}

}