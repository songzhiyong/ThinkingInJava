package com.jerome.basic.beans.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * ThreadPoolExecutor  分析Android AsyncTask相关代码
 * @author Administrator
 *
 */
public class LandOwner {

	public static void main(String args[]) {
		BlockingQueue<Runnable> sWorkQueue = new LinkedBlockingQueue<Runnable>(
				10);

		ThreadFactory sThreadFactory = new ThreadFactory() {
			private final AtomicInteger mCount = new AtomicInteger(1);

			public Thread newThread(Runnable r) {
				System.out.println("AsyncTask #" + mCount.getAndIncrement());
				return new Thread(r, "AsyncTask #" + mCount.getAndIncrement());
			}
		};
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1,
				TimeUnit.SECONDS, sWorkQueue, sThreadFactory);
		WorkerRunnable worker = new WorkerRunnable();
		FutureTask<Integer> jiangong = new FutureTask<Integer>(worker);
		executor.execute(jiangong);
		while (!jiangong.isDone()) {
			try {
				System.out.println("看长工做完了没...");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int amount;
		try {
			amount = jiangong.get();
			System.out.println("工作做完了,上交了" + amount);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}
}