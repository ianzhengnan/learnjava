package ian.awt.layout;

import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.Button;

public class FlowLayoutTest{

	public static void main(String[] args) {
		
		Frame f = new Frame("布局测试窗口");
		f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));

		for (int i = 0; i < 10 ; i++) {
			f.add(new Button("按钮" + i));
		}

		f.setBounds(30,30,300,250);
		f.setVisible(true);

	}

}