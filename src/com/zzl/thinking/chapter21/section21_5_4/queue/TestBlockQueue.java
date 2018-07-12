package com.zzl.thinking.chapter21.section21_5_4.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class TestBlockQueue {
	static void getKey() {
		try {
			new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	static void getKey(String message) {
		System.out.println(message);
		getKey();
	}
	static void test(String msg, BlockingQueue<LiftOff> queue) {
		System.out.println(msg);
		LiftOffRunner runner = new LiftOffRunner(queue);
		// 创建一个线程
		Thread t = new Thread(runner);
		// 启动线程
		t.start();
		// 添加5个任务到队列中
		for (int i = 0; i < 5; i++) {
			runner.add(new LiftOff(5));
		}
		getKey("Press 'Enter' (" + msg + ")");
		// 中断线程
		t.interrupt();
		System.out.println("Finished " + msg + " test");
		System.out.println();
	}
	public static void main(String[] args) {
		test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
		test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
		test("SynchronousQueue", new SynchronousQueue<LiftOff>());
	}
	

}
