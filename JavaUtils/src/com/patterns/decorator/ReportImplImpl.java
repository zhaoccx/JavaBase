package com.patterns.decorator;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 下午2:53:44
 */
public class ReportImplImpl extends ReportImpl {

	private void showHigh() {
		System.out.println(this.getClass().getName() + " ... showHigh ");
	}

	private void showSore() {
		System.out.println(this.getClass().getName() + " ... showSore ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.decorator.ReportImpl#report()
	 */
	@Override
	public void report() {
		this.showHigh();
		super.report();
		this.showSore();
	}

}
