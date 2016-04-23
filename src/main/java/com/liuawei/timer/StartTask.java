package com.liuawei.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;


/**
 * @author liuawei
 *
 */
public class StartTask {
	/*
	 * 定时器
	 * 调度任务以后台线程的形式运行，任务可以定期抽重复执行
	 */
	private final static long PERIOD_1MINUTE = 60 * 1000;// 5分钟
	private final static long PERIOD_5MINUTE = 5 * 60 * 1000;// 5分钟
	private final static long PERIOD_30MINUTE = 30 * 60 * 1000;// 30分钟
	private final static long PERIOD_1HOUR = 60 * 60 * 1000;// 1小时
	private final static long PERIOD_24HOUR = 24 * 60 * 60 * 1000;// 24 小时
	
	public static void main(String[] args) {
		
		
		Calendar calendar = Calendar.getInstance();
		//每天23：59：59 执行
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		
		Timer timer = new Timer();
		
		Date date = calendar.getTime();
		if(date.before(new Date())){
			date = addDay(date, 1);
		}
		
//		//测试
//		calendar.set(Calendar.HOUR_OF_DAY, 16);
//		calendar.set(Calendar.MINUTE, 07);
//		calendar.set(Calendar.SECOND, 59);
//		Date testDate = calendar.getTime();
		
		//安排指定的任务在指定的时间执行。如果时间过去,任务立即执行
		timer.schedule(new Task1(), date);
		
		//  delay 时间后执行指定的任务。
		timer.schedule(new Task1(), PERIOD_1MINUTE);
		
		// 指定时间开始， period周期类重复执行。
		timer.schedule(new Task2(), date, PERIOD_1MINUTE);
		
		// delay 时间后执行指定的任务，period周期类重复执行。
		timer.schedule(new Task1(), 0, PERIOD_1MINUTE);

	}
	/**
	 * 在某一天的时间之后新增num天
	 * @param date
	 * @param num
	 * @return
	 */
	private static Date addDay(Date date, int num) {
		Calendar startDT = Calendar.getInstance();
		startDT.setTime(date);
		startDT.add(Calendar.DAY_OF_MONTH, num);
		return startDT.getTime();
	}
}
