package cn.itcast.day3.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
	public static void main(String[] args) {
		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("I dead");
			}

		});
		// 如果没有下面的代码，程序一直处于不结束状态，
		service.shutdown();
		// service.shutdownNow();
	}

}
