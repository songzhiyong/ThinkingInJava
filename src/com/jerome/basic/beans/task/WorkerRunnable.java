package com.jerome.basic.beans.task;

import java.util.concurrent.Callable;

public class WorkerRunnable implements Callable<Integer> {

		private int hours = 12;
		private int amount;

		@Override
		public Integer call() throws Exception {
			while (hours > 0) {
				System.out.println("I'm working......");
				amount++;
				hours--;
				Thread.sleep(1000);
			}
			return amount;
		}
	}