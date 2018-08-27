package com.liuawei.Java.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class UsualSemaphoreSample {

	public static void main(String[] args) throws InterruptedException {
		Semaphore semaphore = new Semaphore(0, true);
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new SemaphoreWorker(semaphore));
			thread.start();
		}
		semaphore.release(5);
		System.out.println("wating semaphore.release");
		while (semaphore.availablePermits()!=0) {
			Thread.sleep(10000);
		}
		semaphore.release(5);


	}

}



class SemaphoreWorker implements Runnable{

	private Semaphore semaphore;
	
	public  SemaphoreWorker(Semaphore semaphore) {
		this.semaphore = semaphore;
	} 
	
	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()+"已经执行!   availablePermits:"+semaphore.availablePermits());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		
	}
	
}