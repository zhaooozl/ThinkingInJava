package com.zzl.thinking.chapter21.section21_5_3.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean waxOn = false;
	
	public void waxed() {
		// ����
		lock.lock();
		try {
			// ��Ϊtrue
			waxOn = true;
			// �������еȴ��߳�
			condition.signalAll();
		} finally {
			// ����
			lock.unlock();
		}
	}
	
	public void buffed() throws InterruptedException {
		// ����
		lock.lock();
		try {
			while (waxOn == false) {
				// ��ǰ�̵߳ȴ�
				condition.await();
			}
		} finally {
			// ����
			lock.unlock();
		}
	}
	
	public void waitForBuffing() throws InterruptedException {
		// ����
		lock.lock();
		try {
			while (waxOn == true) {
				// ��ǰ�̵߳ȴ�
				condition.await();
			}
		} finally {
			// ����
			lock.unlock();
		}
	}
}
