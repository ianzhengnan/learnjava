package ian.awt.layout;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.TextField;

public class GridLayoutTest{

	public static void main(String[] args) {
		
		//Frame默认使用BorderLayout作为布局管理器
		Frame f = new Frame("GridLayout测试");

		Panel inputPl = new Panel();
		inputPl.add(new TextField(30));
		f.add(inputPl, BorderLayout.NORTH);

		Panel keyboardPl = new Panel();
		keyboardPl.setLayout(new GridLayout(3,5,4,4));
		String[] names = {"0", "1", "2", "3", "4"
			,"5", "6", "7", "8", "9", "+", "-", "*", "/", "."};

		for (int i = 0; i < names.length ; i++) {
			
			keyboardPl.add(new Button(names[i]));			
		}

		f.add(keyboardPl);
		f.pack();
		f.setVisible(true);
	}
}