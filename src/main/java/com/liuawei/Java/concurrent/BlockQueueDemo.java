package com.liuawei.Java.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueDemo {

	private int queueSize = 10;
	private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);

	public static void main(String[] args) {
		BlockQueueDemo test = new BlockQueueDemo();
		Consumer consumer = test.new Consumer();
		consumer.start();
		Producer producer = test.new Producer();
		producer.start();
	}

	class Consumer extends Thread {
		public void run() {
			consume();
		}

		private void consume() {
			while (true) {
				try {
					int i = queue.take();
					System.out.println("从队列获取一个元素" + i+"队列长度   "+queue.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	class Producer extends Thread {
		private int i = 0;

		public void run() {
			++i;
			produce();
		}
		private void produce() {
			while (true) {
				try {
					queue.put(i);
					System.out.println("给队列添加一个元素" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
