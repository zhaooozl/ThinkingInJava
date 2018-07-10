package com.zzl.thinking.chapter21.section21_5_3.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean waxOn = false;
	
	public void waxed() {
		// 上锁
		lock.lock();
		try {
			// 置为true
			waxOn = true;
			// 唤醒所有等待线程
			condition.signalAll();
		} finally {
			// 解锁
			lock.unlock();
		}
	}
	
	public void buffed() throws InterruptedException {
		// 上锁
		lock.lock();
		try {
			while (waxOn == false) {
				// 当前线程等待
				condition.await();
			}
		} finally {
			// 解锁
			lock.unlock();
		}
	}
	
	public void waitForBuffing() throws InterruptedException {
		// 上锁
		lock.lock();
		try {
			while (waxOn == true) {
				// 当前线程等待
				condition.await();
			}
		} finally {
			// 解锁
			lock.unlock();
		}
	}
}
