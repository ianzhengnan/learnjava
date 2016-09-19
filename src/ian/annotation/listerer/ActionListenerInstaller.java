package ian.annotation.listerer;

import java.lang.reflect.Field;
import javax.swing.AbstractButton;

import ian.annotation.listener.ActionListenerFor;

import java.awt.event.ActionListener;

public class ActionListenerInstaller{

	public static void processAnnotations(Object obj){

		try{

			Class cl = obj.getClass();

			for (Field f : cl.getDeclaredFields()) {
				
				f.setAccessible(true);
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);

				Object fObj = f.get(obj);
				if (a != null && fObj != null 
					&& fObj instanceof AbstractButton) {
					
					Class<? extends ActionListener> listenerClazz = a.listener();
					ActionListener al = listenerClazz.newInstance();
					AbstractButton ab = (AbstractButton)fObj;

					ab.addActionListener(al);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}