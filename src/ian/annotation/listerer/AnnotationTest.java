package ian.annotation.listerer;

import javax.swing.*;

import ian.annotation.listener.ActionListenerFor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AnnotationTest{

	private JFrame mainWin = new JFrame("使用注解绑定事件监听器");

	@ActionListenerFor(listener=OKListener.class)
	private JButton ok = new JButton("确定");

	@ActionListenerFor(listener=CancelListener.class)
	private JButton cancel = new JButton("取消");

	public void init(){
		// init screen
		JPanel jp = new JPanel();
		jp.add(ok);
		jp.add(cancel);
		mainWin.add(jp);
		ActionListenerInstaller.processAnnotations(this);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setSize(680, 480);
		mainWin.setVisible(true);
	}

	public static void main(String[] args) {
		new AnnotationTest().init();
	}
}

class OKListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
		JOptionPane.showMessageDialog(null, "单击确认按钮");
	}
}

class CancelListener implements ActionListener{
	public void actionPerformed(ActionEvent evt){
		JOptionPane.showMessageDialog(null, "单击取消按钮");
	}
}

