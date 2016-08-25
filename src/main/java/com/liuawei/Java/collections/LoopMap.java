package com.liuawei.Java.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * map循环遍历
 * @author liuawei
 *
 */
public class LoopMap {
	
	public static void main(String [] args) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("1", 1);
		map.put("2", 2);
		
		//第一种
		for (String key : map.keySet()) {
			System.out.println("key="+key+"value="+map.get(key));
		}
		//第二种
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			 Map.Entry<String, Object> entry =   iterator.next();
			 System.out.println("key="+entry.getKey()+"value="+entry.getValue());
		}
		//第三种推荐
		for (Map.Entry<String, Object> entry: map.entrySet()) {
			 System.out.println("key="+entry.getKey()+"value="+entry.getValue());
		}
	}

}
