package ian.oo.interfacestest.command;

public class CommandTest{

	public static void main(String[] args){
		ProcessArray pa = new ProcessArray();
		int[] target = new int[]{1,4,-4,5};
		pa.process(target, new PrintCommand());
		System.out.println("-------------------");
		pa.process(target, new AddCommand());
	}
}