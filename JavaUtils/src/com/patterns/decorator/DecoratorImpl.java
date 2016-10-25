package com.patterns.decorator;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 下午3:20:08
 */
public class DecoratorImpl extends Decorator {

	/**
	 * @param report
	 */
	public DecoratorImpl(Report report) {
		super(report);
	}

	private void showWnid() {
		System.out.println(this.getClass().getName() + " ... showWnid ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.decorator.Decorator#report()
	 */
	@Override
	public void report() {
		this.showWnid();
		super.report();
	}
}
