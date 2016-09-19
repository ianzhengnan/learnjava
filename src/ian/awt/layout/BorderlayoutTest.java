package ian.awt.layout;

import java.awt.Frame;
import java.awt.Button;
import java.awt.BorderLayout;

public class BorderlayoutTest{

	public static void main(String[] args) {
		
		Frame f = new Frame("BorderLayout测试");

		f.setLayout(new BorderLayout(30, 5));
		f.add(new Button("东"), BorderLayout.EAST);
		f.add(new Button("南"), BorderLayout.SOUTH);
		f.add(new Button("西"), BorderLayout.WEST);
		f.add(new Button("北"), BorderLayout.NORTH);
		f.add(new Button("中"));

		f.pack();
		f.setVisible(true);
	}
}