package ian.awt.layout;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class CardLayoutTest{

	private Frame f = new Frame("CardLayout测试");

	private String[] names = {"第一张","第二张","第三张","第四张","第五张"};

	private Panel pl = new Panel();

	public void init(){

		final CardLayout c = new CardLayout();
		pl.setLayout(c);
		for (int i = 0; i < names.length; i++) {
			pl.add(names[i], new Button(names[i]));
		}

		Panel p = new Panel();
		ActionListener listener = e -> {

			switch(e.getActionCommand()){

				case "上一张":
					c.previous(pl);
					break;
				case "下一张":
					c.next(pl);
					break;
				case "第一张":
					c.first(pl);
					break;
				case "最后一张":
					c.last(pl);
					break;
				case "第三张":
					c.show(pl, "第三张");
					break;
			}
		};

		Button previous = new Button("上一张");
		previous.addActionListener(listener);

		Button next = new Button("下一张");
		next.addActionListener(listener);

		Button first = new Button("第一张");
		first.addActionListener(listener);

		Button last = new Button("最后一张");
		last.addActionListener(listener);

		Button third = new Button("第三张");
		third.addActionListener(listener);

		p.add(previous);
		p.add(next);
		p.add(first);
		p.add(last);
		p.add(third);

		f.add(pl);
		f.add(p, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new CardLayoutTest().init();
	}
}