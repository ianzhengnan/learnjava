package ian.collections.map;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapTest2{


	public static void main(String[] args){

		Map map = new HashMap();

		map.put("java learning", 108);
		map.put("python learning", 99);
		map.put("ajax learning", 79);

		map.replace("xml learning", 66);
		System.out.println(map);

		map.merge("python learning", 10, (oldVal, param) -> 
			(Integer)oldVal + (Integer)param);

		map.computeIfAbsent("Java", (key) -> ((String)key).length());
		System.out.println(map);

		// if "Java" doesn't exist, below statement is not working.
		map.computeIfPresent("Java", (key, value) -> (Integer)value * (Integer)value);
		System.out.println(map);


		Map hm = new HashMap();
		hm.put(null, null);
		hm.put(null, null);

		hm.put("a", null);

		System.out.println(hm);

		LinkedHashMap lhm = new LinkedHashMap();

		lhm.put("语文", 80);
		lhm.put("数学", 90);
		lhm.put("英语", 96);

		lhm.forEach((key, value) -> System.out.println(key + "-->" + value));

	}

}