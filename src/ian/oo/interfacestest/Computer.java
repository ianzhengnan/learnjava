package ian.oo.interfacestest;

import ian.oo.interfaces.Output;

public class Computer{

	private Output out;

	public Computer(Output out){
		this.out = out;
	}

	public void keyIn(String msg){
		out.getData(msg);
	}

	public void print(){
		out.out();
	}


}