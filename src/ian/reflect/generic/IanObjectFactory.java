package ian.reflect.generic;


public class IanObjectFactory{

	public static Object getInstance(String ClsName) {
		try{
			Class cls = Class.forName(ClsName);
			return cls.newInstance();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
}	