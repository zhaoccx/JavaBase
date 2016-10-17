package com.patterns.builder;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午3:22:46
 */
public class BenzModel extends CarModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.templatemethod.CalModel#start()
	 */
	@Override
	protected void start() {
		System.out.println(this.getClass().getName() + "...start");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.templatemethod.CalModel#stop()
	 */
	@Override
	protected void stop() {
		System.out.println(this.getClass().getName() + "...stop");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.templatemethod.CalModel#alarm()
	 */
	@Override
	protected void alarm() {
		System.out.println(this.getClass().getName() + "...alarm");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.templatemethod.CalModel#engineBoom()
	 */
	@Override
	protected void engineBoom() {
		System.out.println(this.getClass().getName() + "...engineBoom");
	}

}
