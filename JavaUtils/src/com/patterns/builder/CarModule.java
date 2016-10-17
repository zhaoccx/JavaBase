package com.patterns.builder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午3:11:22
 */
public abstract class CarModule {

	private List<Step> sequence = new ArrayList<>();

	protected abstract void start();

	protected abstract void stop();

	protected abstract void alarm();

	protected abstract void engineBoom();

	final public void run() {

		for (int i = 0; i < this.sequence.size(); i++) {
			Step actionName = this.sequence.get(i);
			if ("start".equalsIgnoreCase(actionName.toString())) {
				this.start();

			} else if ("stop".equalsIgnoreCase(actionName.toString())) {

				this.stop();
			} else if ("alarm".equalsIgnoreCase(actionName.toString())) {

				this.alarm();
			} else if ("engineBoom".equalsIgnoreCase(actionName.toString())) {

				this.engineBoom();
			}
		}

	}

	final public void setSequece(List<Step> sequence) {
		this.sequence = sequence;
	}

}
