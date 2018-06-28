package com.liuawei.Java.timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTask1 {

	public  static void main(String[] args){
		Timer timer = new Timer();
		TimerTaskTest1 task = new TimerTaskTest1();
		timer.schedule(task, 2000);
		System.out.println("延迟执行提前返回数据");
	}
	
}

class TimerTaskTest1 extends TimerTask{

	
	@Override
	public void run() {
		System.out.println("我开始执行了");		

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("开始下货了！");		
	}
}