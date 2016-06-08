package ian.reflect.generic;

import java.util.Date;
import javax.swing.JFrame;

public class IanObjectFactory2{

	public static <T> T getInstance(Class<T> cls){
		try{
			return cls.newInstance();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		Date d = IanObjectFactory2.getInstance(Date.class);
		JFrame jf = IanObjectFactory2.getInstance(JFrame.class);
	}
}