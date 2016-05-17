package ian.net.tcp.chat;

import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;


public class IanMap<K,V>{

	//创建一个线程安全的HashMap
	public Map<K,V> map = Collections.synchronizedMap(new HashMap<K,V>());
	//根据value来删除指定项
	public synchronized void removeByValue(Object value){
		for (Object key : map.keySet()) {
			if (map.get(key) == value) {
				map.remove(key);
				break;
			}
		}
	}

	// 获取所有value组成的Set的集合
	public synchronized Set<V> valueSet(){
		Set<V> result = new HashSet<V>();
		map.forEach((key, value) -> result.add(value));
		return result;
	}

	// 根据value查找key
	public synchronized K getKeyByValue(V val){
		for (K key : map.keySet()) {
			if (map.get(key) == val || map.get(key).equals(val)) {
				return key;
			}
		}
		return null;
	}

	// 实现put()方法，该方法不允许value重复
	public synchronized V put(K key, V value){
		for (V val : valueSet()) {
			// 如果某个value与视图放入集合的value相同
			// 则抛出一个RuntimeException异常
			if (val.equals(value) && val.hashCode() == value.hashCode()) {
				throw new RuntimeException("MyMap实例中不允许有重复的value!");
			}
		}
		return map.put(key, value);
	}

}