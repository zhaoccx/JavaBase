package com.patterns.facade;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 上午9:06:49
 */
public class FacadeImpl implements IFacade {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.facade.IFacade#stepOne(java.lang.String)
	 */
	@Override
	public void stepOne(String context) {
		System.err.println(this.getClass().getName() + "stepOne" + context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.facade.IFacade#stepTwo(java.lang.String)
	 */
	@Override
	public void stepTwo(String two) {
		System.out.println(this.getClass().getName() + "stepTwo" + two);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.facade.IFacade#stepThree()
	 */
	@Override
	public void stepThree() {
		System.out.println(this.getClass().getName() + "stepThree");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.facade.IFacade#stepFour()
	 */
	@Override
	public void stepFour() {
		System.out.println(this.getClass().getName() + "stepFour");
	}

}
