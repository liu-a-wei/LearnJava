package com.liuawei.util.json;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

public class test {

	public static void main(String[] args) {
//		Integer a = -129;
//		Integer b = -129;
//		System.out.println("值相等："+(a.intValue()==b.intValue()));
//		System.out.println("引用相等："+(a==b));
//		Integer c = 220;
//		Integer d = 220;
//		System.out.println("值相等："+(c.intValue()==d.intValue()));
//		System.out.println("引用相等："+(c==d));
		
		Integer a = 4545;
		if( a instanceof Integer){
			System.out.println("succeed");
		}else{
			System.out.println("error");
		}
		if(null==null){
			System.out.println("null==null is true");
		}
		Integer abc = null;
		if(abc==null){
			System.out.println("null==null is true");

		}
		HashMap<String, String> tets = new HashMap<>();
		tets.put(null, null);
		tets.toString();
		Calendar calendar = Calendar.getInstance();
		int hour24 = calendar.get(Calendar.HOUR_OF_DAY);
		calendar.add(Calendar.DATE, +1);
		if(hour24 > 12){
			calendar.add(Calendar.HOUR, 24);
		}else{
			calendar.add(Calendar.HOUR, 12);
		}
		System.out.println(calendar.getTimeInMillis());
		
		System.out.println(new test().print(null));
	}

	public String print(Object obj){
		return "对象---obj";
	}
	public String print(String str){
		return "字符串---Str";
	}
	
}
