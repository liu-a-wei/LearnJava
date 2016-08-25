package com.liuawei.util.jodatime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;

public class TimeUtil {
	public static String MIDDLE_CHINA_TIME = "yyyy-MM-dd HH:mm";
	public static String LONG_CHINA_TIME = "yyyy-MM-dd HH:mm:ss";
	public static String SHORT_CHINA_TIME = "yyyy-MM-dd";
	
	
	public String formatMIDDLE(long time) {
		return new DateTime(time).toString(MIDDLE_CHINA_TIME);
	}
	public String formatLONG(long time) {
		return new DateTime(time).toString(MIDDLE_CHINA_TIME);
	}
	public String formatSHORT(long time) {
		return new DateTime(time).toString(MIDDLE_CHINA_TIME);
	}
	public static String formatMIDDLE(Date date) {
		return new DateTime(date).toString(MIDDLE_CHINA_TIME);
	}
	
	public static void main(String[] args){
		DateTime dateTime = new DateTime();
		DateTime dateTime2 = new DateTime(1464272892023L);
		DateTime dateTime3 = new DateTime();
		System.out.println(dateTime2.toString(LONG_CHINA_TIME));
		System.out.println(formatMIDDLE(new Date()));
//		2016-05-26 22:09
//		DateTimeFormatter dtf = 
		System.out.println(DateTime.parse("2016-05-26"));
		DateTime now = DateTime.now();
		System.out.println(now.toString(MIDDLE_CHINA_TIME,Locale.CHINESE));
	}
}
