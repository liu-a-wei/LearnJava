package com.liuawei.concurrent;

public class ThreadDemo extends Thread{
		
	public static void main(String[] args){
		testThread();
		System.out.println("-------------------------");
		testRunnable();
	}
	public static void testThread() {
		System.out.println(Thread.currentThread().getId());
		MyThread threadTest = new MyThread("testThread");
		threadTest.start();
		MyThread threadTes2 = new MyThread("testThread1");
		threadTes2.run();
		MyThread threadTes3 = new MyThread("testThread2");
		threadTes3.start();
	}
	public static void testRunnable() {
		System.out.println(Thread.currentThread().getId());
		MyRunnable threadTest = new MyRunnable("testRunnable");
		new Thread(threadTest).start();
		MyRunnable threadTest1 = new MyRunnable("testRunnable1");
		new Thread(threadTest1).start();
		MyRunnable threadTest2 = new MyRunnable("testRunnable2");
		new Thread(threadTest2).start();
	}
}

class MyThread extends Thread{
	private static int num = 0;
	private  String name ;
	public MyThread(String name){
		this.name = name;
		++ num;
	}
	public void run() {
		System.out.println("name:"+name+"第几个："+num+"     "+Thread.currentThread().getId());
	}
}

class MyRunnable implements Runnable{
	private static int num = 0;
	private  String name ;
	public MyRunnable(String name){
		this.name = name;
		++ num;
	}
	@Override
	public void run() {
		System.out.println("name:"+name+"第几个："+num+"     "+Thread.currentThread().getId());
		
	}
}