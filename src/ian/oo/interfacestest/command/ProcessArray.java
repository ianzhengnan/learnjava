package ian.oo.interfacestest.command;

public class ProcessArray{

	public void process(int[] target, Command cmd){
		cmd.process(target);
	}
}