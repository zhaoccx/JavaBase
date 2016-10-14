package com.patterns.multition;

/**
 * 测试多例
 * 
 * @author zhaocc
 * @time 2016年10月14日 下午3:11:25
 */
public class MultitionTest {

	/**
	 *
	 * @author zhaocc
	 * @time 2016年10月14日 下午3:11:25
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 10;
		Multition multition = null;
		for (int i = 0; i < max; i++) {
			multition = Multition.getInstance();
			System.err.println("第" + (i + 1) + "个调用的是：");
			multition.getMultionName();
		}
	}

}
