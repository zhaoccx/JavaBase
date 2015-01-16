package cn.zcc.mycode;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServiceWindowMy {

	private CustomerTypeMy type = CustomerTypeMy.COMMON;

	private int windowID = 1;

	public void setType(CustomerTypeMy type) {
		this.type = type;
	}

	public void setWindowID(int windowID) {
		this.windowID = windowID;
	}

	public void start() {
		Executors.newSingleThreadExecutor().execute(new Runnable() {

			@Override
			public void run() {
				do {
					switch (type) {
					case COMMON:
						commonService();
						break;
					case VIP:
						vipService();
						break;
					case EXPRESS:
						expressService();
						break;
					}
				} while (true);
			}
		});
	}

	private void commonService() {
		String windowName = "第" + windowID + "号" + type + "窗口";
		Integer number = NumberMachineMy.getInstance().getCommonManager().fetchServiceNumber();
		System.out.println(windowName + "正在获取任务");
		if (number != null) {
			long beginTime = System.currentTimeMillis();
			int maxServiceTime = ConstantsMy.MAX_SERVICE_TIME - ConstantsMy.MIN_SERVICE_TIME;
			long serviceTime = new Random().nextInt(maxServiceTime) + 1 + ConstantsMy.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long costTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName + "为第" + number + "个" + type + "客户完成服务，耗时为" + (costTime / 1000) + "秒");
		} else {
			if (type == CustomerTypeMy.COMMON) {
				System.out.println(windowName + "没有取到任务,先休息1秒钟");
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void expressService() {
		String windowName = "第" + windowID + "号" + type + "窗口";
		Integer number = NumberMachineMy.getInstance().getCommonManager().fetchServiceNumber();
		System.out.println(windowName + "正在获取任务");
		if (number != null) {
			long beginTime = System.currentTimeMillis();
			try {
				Thread.sleep(ConstantsMy.MIN_SERVICE_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long costTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName + "为第" + number + "个" + type + "客户完成服务，耗时为" + (costTime / 1000) + "秒");
		} else {
			System.out.println(windowName + "没有取到任务!");
			commonService();
		}
	}

	private void vipService() {
		String windowName = "第" + windowID + "号" + type + "窗口";
		Integer number = NumberMachineMy.getInstance().getCommonManager().fetchServiceNumber();
		System.out.println(windowName + "正在获取任务");
		if (number != null) {
			long beginTime = System.currentTimeMillis();
			int maxServiceTime = ConstantsMy.MAX_SERVICE_TIME - ConstantsMy.MIN_SERVICE_TIME;
			long serviceTime = new Random().nextInt(maxServiceTime) + 1 + ConstantsMy.MIN_SERVICE_TIME;
			try {
				Thread.sleep(serviceTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long costTime = System.currentTimeMillis() - beginTime;
			System.out.println(windowName + "为第" + number + "个" + type + "客户完成服务，耗时为" + (costTime / 1000) + "秒");
		} else {
			System.out.println(windowName + "没有取到任务!");
			commonService();
		}
	}

}
