package com.zzl.thinking.chapter21.section21_5_4.queue;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable {
	// 队列
	private BlockingQueue<LiftOff> rockets;
	
	
	public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
		this.rockets = rockets;
	}
	
	// 添加
	public void add(LiftOff lo) {
		try {
			// 将指定元素插入此队列中，将等待可用的空间（如果有必要）。
			rockets.put(lo);
		} catch (InterruptedException e) {
			System.out.println("Interrupter during put()");
		}
	}

	public void run() {
		try {
			// 线程未中断
			while (!Thread.interrupted()) {
				// 获取并移除此队列的头部，在元素变得可用之前一直等待（如果有必要）。
				LiftOff rocket = rockets.take();
				rocket.run();
			}
		} catch (InterruptedException e) {
			// 中断输出
			System.out.println("Waking from take()");
		}
		System.out.println("Exiting LiftOffRunner");
	}

}
