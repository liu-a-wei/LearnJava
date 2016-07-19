package com.liuawei.concurrent;

import java.util.PriorityQueue;


public class NoBlockQueueDemo {

	private int queueSize = 10;
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

	public static void main(String[] args) {
		NoBlockQueueDemo test = new NoBlockQueueDemo();
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
				synchronized (queue) {
					while (queue.size() == 0) {
						System.out.println("队列空--正在等待数据填充！");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
							System.out.println("队列空--正在等待数据填充异常！");
							queue.notify();
						}
					}
					queue.poll();

					queue.notify();

					System.out.println("从队列中消费数据！" + queue.size());
				}

			}

		}
	}

	class Producer extends Thread {

		public void run() {
			produce();
		}

		private void produce() {
			while (true) {
				synchronized (queue) {
					while (queue.size() == queueSize) {
						System.out.println("队列已满--正在等待数据消费！");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("队列已满--正在等待数据消费异常！");
							queue.notify();
						}
					}
					// 插入元素
					queue.offer(1);
					queue.notify();
					System.out.println("从队列中生产数据！" + queue.size());
				}

			}

		}
	}
}
