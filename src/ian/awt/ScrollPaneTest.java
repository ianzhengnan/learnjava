package ian.awt;

import java.awt.Frame;
import java.awt.ScrollPane;
import java.awt.TextField;
import java.awt.Button;

public class ScrollPaneTest{

	public static void main(String[] args) {
		
		Frame f = new Frame("测试窗口");
		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		sp.add(new TextField(20));
		sp.add(new Button("点击我"));

		f.add(sp);

		f.setBounds(200,200,200,400);
		f.setVisible(true);
	}
}