package com.patterns.decorator;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 下午2:50:41
 */
public class ReportImpl extends Report {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.decorator.Report#report()
	 */
	@Override
	public void report() {
		System.out.println(this.getClass().getName() + " ... report ");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.decorator.Report#sign()
	 */
	@Override
	public void sign() {
		System.out.println(this.getClass().getName() + " ... sign ");
	}

}
