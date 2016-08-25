package com.liuawei.Java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LockDemo {

	public static void main(String[] args) {
		new Thread1().start();
		
		new Thread1().start();
	}

}
class Thread1 extends Thread{
	private static Lock lock = new ReentrantLock();
	public void run() {
		insert();
	}
	public void insert(){
		lock.lock();
		System.out.println("获取锁");
		try {
			System.out.println("执行任务:"+Thread.currentThread().getId());
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
			System.out.println("释放锁锁");
		}
	}
}