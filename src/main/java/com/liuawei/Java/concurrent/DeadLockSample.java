package com.liuawei.Java.concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeadLockSample extends Thread {

	private String first;
	private String second;

	public DeadLockSample(String name, String first, String second) {
		super(name);
		this.first = first;
		this.second = second;
	}

	@Override
	public void run() {
		synchronized (first) {
			System.out.println(this.getName() + " obtained: " + first);
			try {
				Thread.sleep(1000);
				synchronized (second) {
					System.out.println(this.getName() + " obtained: " + first);
				}
			} catch (Exception e) {
				System.out.println("中断异常:" + e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				long[] threIds = threadMXBean.findMonitorDeadlockedThreads();
				if (threIds != null) {
					ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threIds);
					System.out.println("dead thread:");
					for (ThreadInfo threadInfo : threadInfos) {
						System.out.println(threadInfo.getThreadId() + "  name:" + threadInfo.getThreadName()
								+ "  lockName:" + threadInfo.getLockName());
					}
				}

			}
		}, 1L, 5L, TimeUnit.SECONDS);
		String lockA = "lockA";
		String lockB = "lockB";
		DeadLockSample sample1 = new DeadLockSample("Thread1", lockA, lockB);
		DeadLockSample sample2 = new DeadLockSample("Thread2", lockB, lockA);
		sample1.start();
		sample2.start();
		System.out.println("怕是要死锁");
		sample1.join();
		sample2.join();
	}
}
