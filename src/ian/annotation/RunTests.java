package ian.annotation;


public class RunTests{

	public static void main(String[] args) throws Exception{
		
		//类名前要加包名, 查文档得知
		ProcessorTest.process("ian.annotation.MyTest");
	}
}