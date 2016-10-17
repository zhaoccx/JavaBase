package com.patterns.builder;

import java.util.List;

/**
 *
 * @author zhaocc
 * @time 2016年10月17日 下午3:59:03
 */
public abstract class CarBuilder {
	public abstract void setSequence(List<Step> sequence);

	public abstract CarModule getCarModel();
}
