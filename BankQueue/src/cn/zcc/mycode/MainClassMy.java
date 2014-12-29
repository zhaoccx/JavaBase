package cn.zcc.mycode;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClassMy {
	public static void main(String[] args) {
		for (int i = 1; i < 5; i++) {
			ServiceWindowMy commonWindow = new ServiceWindowMy();
			commonWindow.setWindowID(i);
			commonWindow.start();
		}

		ServiceWindowMy vipWindow = new ServiceWindowMy();
		vipWindow.setType(CustomerTypeMy.VIP);
		vipWindow.start();

		ServiceWindowMy expressWindow = new ServiceWindowMy();
		expressWindow.setType(CustomerTypeMy.EXPRESS);
		expressWindow.start();

		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				Integer number = NumberMachineMy.getInstance().getCommonManager().geterateNewManager();
				System.out.println("第" + number + "号普通客户等待服务");
			}
		}, 0, ConstantsMy.COMMON_CUSTOMER_INTERVAL_TIME, TimeUnit.SECONDS);

		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				Integer number = NumberMachineMy.getInstance().getExpressManager().geterateNewManager();
				System.out.println("第" + number + "号快速客户等待服务");

			}
		}, 0, ConstantsMy.COMMON_CUSTOMER_INTERVAL_TIME * 3, TimeUnit.SECONDS);

		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				Integer number = NumberMachineMy.getInstance().getVipManager().geterateNewManager();
				System.out.println("第" + number + "号VIP客户等待服务");

			}
		}, 0, ConstantsMy.COMMON_CUSTOMER_INTERVAL_TIME * 6, TimeUnit.SECONDS);
	}
}
