package cn.zcc.mycode;

public class NumberMachineMy {

	private NumberManagerMy commonManager = new NumberManagerMy();
	private NumberManagerMy expressManager = new NumberManagerMy();
	private NumberManagerMy vipManager = new NumberManagerMy();

	public NumberManagerMy getCommonManager() {
		return commonManager;
	}

	public NumberManagerMy getExpressManager() {
		return expressManager;
	}

	public NumberManagerMy getVipManager() {
		return vipManager;
	}

	private NumberMachineMy() {
	}

	public static NumberMachineMy getInstance() {
		return instance;
	}

	private static NumberMachineMy instance = new NumberMachineMy();

}
