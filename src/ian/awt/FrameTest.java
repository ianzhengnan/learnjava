package ian.awt;

import java.awt.Frame;

public class FrameTest{

	public static void main(String[] args){

		Frame fm = new Frame("测试窗口");
		fm.setBounds(30,30,300,250);
		fm.setVisible(true);
	}
}