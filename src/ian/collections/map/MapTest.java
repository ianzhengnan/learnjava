package ian.collections.map;

import java.util.Map;
import java.util.HashMap;

public class MapTest{


	public static void main(String[] args){

		Map map = new HashMap();

		map.put("java learning", 108);
		map.put("python learning", 10);
		map.put("ajax learning", 101);
		map.put("javascript learning", 99);

		System.out.println(map.put("java learning", 109));

		System.out.println(map);

		System.out.println(map.containsKey("python learning"));
		System.out.println(map.containsValue(20));

		for(Object key: map.keySet()){
			System.out.println(key + "-->" + map.get(key));
		}

		map.remove("ajax learning");
		System.out.println(map);

	}

}