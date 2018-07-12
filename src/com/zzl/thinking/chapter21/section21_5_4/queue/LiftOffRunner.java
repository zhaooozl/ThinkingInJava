package com.zzl.thinking.chapter21.section21_5_4.queue;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable {
	// ����
	private BlockingQueue<LiftOff> rockets;
	
	
	public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
		this.rockets = rockets;
	}
	
	// ���
	public void add(LiftOff lo) {
		try {
			// ��ָ��Ԫ�ز���˶����У����ȴ����õĿռ䣨����б�Ҫ����
			rockets.put(lo);
		} catch (InterruptedException e) {
			System.out.println("Interrupter during put()");
		}
	}

	public void run() {
		try {
			// �߳�δ�ж�
			while (!Thread.interrupted()) {
				// ��ȡ���Ƴ��˶��е�ͷ������Ԫ�ر�ÿ���֮ǰһֱ�ȴ�������б�Ҫ����
				LiftOff rocket = rockets.take();
				rocket.run();
			}
		} catch (InterruptedException e) {
			// �ж����
			System.out.println("Waking from take()");
		}
		System.out.println("Exiting LiftOffRunner");
	}

}
