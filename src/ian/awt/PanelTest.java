package ian.awt;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Button;

public class PanelTest{

	public static void main(String[] args) {
		Frame f = new Frame("测试窗口");
		Panel p = new Panel();
		p.add(new TextField(20));
		p.add(new Button("点击我"));
		f.add(p);
		f.setBounds(30,30,300,250);
		f.setVisible(true);
	}
}