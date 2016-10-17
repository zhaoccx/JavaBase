package com.patterns.templatemethod;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午1:49:32
 */
public class Model1 extends CarModel {
	private boolean alarm = false;

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

	public void setAlarm(boolean alerm) {
		this.alarm = alerm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.templatemethod.CarModel#isAlarm()
	 */
	@Override
	protected boolean isAlarm() {
		// TODO Auto-generated method stub
		return this.alarm;
	}
}
