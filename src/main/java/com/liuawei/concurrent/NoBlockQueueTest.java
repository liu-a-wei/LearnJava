package com.liuawei.concurrent;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;



public class NoBlockQueueTest {

	private int queueSize = 10;
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

	public static void main(String[] args) {
		BlockQueueTest test = new BlockQueueTest();
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
				synchronized(queue){
					if(queue)
					try {
						int i = queue.take();
						System.out.println("从队列获取一个元素" + i+"队列长度   "+queue.size());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
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
				
					queue.add(1);
					System.out.println("给队列添加一个元素" + i);
 
			}

		}
	}
}
