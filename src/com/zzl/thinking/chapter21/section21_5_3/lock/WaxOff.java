package com.zzl.thinking.chapter21.section21_5_3.lock;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
	private Car car;
	

	public WaxOff(Car car) {
		this.car = car;
	}


	public void run() {
		try {
			while (!Thread.interrupted()) {
				car.waitForBuffing();
				System.out.println("Wax Off! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax Off task");
	}
	

}
