package com.liuawei.Java.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		List<Map<String, Object>> mapList = new ArrayList<>();
		Map<String, Object> map = null;
		map = new HashMap<>();
		map.put("id", 1);
		map.put("key", "value");
		mapList.add(map);
		map = new HashMap<>();
		map.put("id", 2);
		map.put("key", "value2");
		mapList.add(map);
		int[] arr = mapList.stream().mapToInt(m->{
			return (int) m.get("id");
		}).toArray();

		System.out.println(arr[0]+""+arr[1]);
		
		
		
		
		
		
		
		

		String str1 = "普付宝微信";
		String str2 = "威富通微信";
		String str3 = "微信";
		
		if (str1.contains(str2)) {
			System.out.println(str1.contains(str2));
		}
		if (str3.contains(str2)) {
			System.out.println(str3.contains(str2));
		}
		if (str2.contains(str3)) {
			System.out.println("str2.contains(str3)");
		}
	}

}
