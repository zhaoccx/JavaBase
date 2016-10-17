package com.patterns.facade;

/**
 * 测试门面模式
 *
 * @author zhaocc
 * @time 2016年10月17日 上午9:11:21
 */
public class FacadeTest {
	public static void main(String[] args) {
		IFacade impl = new FacadeImpl();
		impl.stepOne("11111111111111111111111111");
		impl.stepTwo("222222222222222222222222");
		impl.stepThree();
		impl.stepFour();

		ModenFaccade modenFaccade = new ModenFaccade();
		modenFaccade.stepAll("11111111111111111111", "22222222222222");
	}
}
