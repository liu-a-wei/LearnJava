package com.liuawei.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

public class ThreadPoolDemo {
	/*
	 * 　　
	 * 　　newSingleThreadExecutor将corePoolSize和maximumPoolSize都设置为1，也使用的LinkedBlockingQueue
	 */
	
	
	/** 初始化一个线程池**/
	/*
	 *         return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
	 */
	//线程池corePoolSize和maximumPoolSize值是相等的，它使用的LinkedBlockingQueue
	private static ExecutorService pool = Executors.newFixedThreadPool(3);
	/*
	 *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
	 */
	//任务来就创建线程运行，当线程空闲超过60秒，就销毁线程。
	private static ExecutorService pool2 = Executors.newCachedThreadPool();
	/*
	 * new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>())
	 */
	//corePoolSize和maximumPoolSize都设置为1，也使用的LinkedBlockingQueue
	private static ExecutorService pool3 = Executors.newSingleThreadExecutor();
	//自定义线程池
	private static int corePoolSize = 3;
	//keepAliveTime 表示线程没有任务执行时最多保持多久时间会终止。默认情况下，只有当线程池中的线程数大于corePoolSize时
	/*
	 * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。 
	 * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。 
	 * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
	 * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务 
	 */
    private static final RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();	
    private static ThreadPoolExecutor  pool4 = new ThreadPoolExecutor(corePoolSize, 2*corePoolSize, 0, 
			TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5),Executors.defaultThreadFactory(), handler);

	/**
	 * 获取一个线程池
	 * @return
	 */
	public static ThreadPoolExecutor  getThreadPool() {
		return pool4;
	}
	
	public static void main(String[] args){
		
		ThreadPoolExecutor  executorService = getThreadPool();
		for (int i = 0; i < 15; i++) {
			executorService.execute(new MyTask(i));
			System.out.println("线程中的数目："+executorService.getPoolSize()
			+"队列中等待的线程数目"+executorService.getQueue().size()+"已经执行完成的任务"+executorService.getCompletedTaskCount());
		}
	}
}
class MyTask implements Runnable{
	
	private int taskNum;
	public MyTask(int taskNum) {
		this.taskNum = taskNum;
	}
	@Override
	public void run() {
		System.out.println("正在执行任务"+taskNum);
		try {
			Thread.currentThread().sleep(1200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(taskNum+"任务执行完毕");
	}
	
}
