package ian.reflect.generic;

import java.util.Date;
import javax.swing.JFrame;

public class Test{

	public static void main(String[] args) {
		Date d = (Date)IanObjectFactory.getInstance("java.util.Date");
		JFrame jf = (JFrame)IanObjectFactory.getInstance("java.util.Date");
	}
}