package com.patterns.facade;

/**
 * 把一个类的方法，通过顺序封装，就是门面模式
 * 
 * @author zhaocc
 * @time 2016年10月17日 上午9:16:43
 */
public class ModenFaccade {
	private IFacade iFacade = new FacadeImpl();
	private FacadCheck check = new FacadCheck();

	public void stepAll(String context, String two) {
		iFacade.stepOne(context);
		iFacade.stepTwo(two);
		check.checkContext(context);
		iFacade.stepThree();
		iFacade.stepFour();
	}
}
