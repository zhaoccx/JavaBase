package com.patterns.templatemethod;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午1:38:57
 */
public abstract class CarModel {
	protected abstract void start();

	protected abstract void stop();

	protected abstract void alarm();

	protected abstract void engineBoom();

	final public void run() {
		this.start();

		this.engineBoom();

		if (this.isAlarm()) {
			this.alarm();
		}

		this.stop();

		System.err.println("****************************");
	}

	protected boolean isAlarm() {
		return true;
	}
}
