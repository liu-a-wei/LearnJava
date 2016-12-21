package com.liuawei.util.json;

import java.sql.Timestamp;
import java.util.Calendar;

public class testOperator {
	public static void main(String[] args){
		Calendar calendar = Calendar.getInstance();
		int hour24 = calendar.get(Calendar.HOUR_OF_DAY);
		calendar.add(Calendar.DATE, -1);
		if(hour24>12){
			calendar.add(Calendar.HOUR, 16);
			System.out.println(""+calendar.getTimeInMillis());
		}else{
			calendar.add(Calendar.HOUR, 12);
			System.out.println(""+calendar.getTimeInMillis());
		}
		System.out.println(new Timestamp(calendar.getTimeInMillis()));
		System.out.println(new Timestamp(System.currentTimeMillis()));
	}
}
