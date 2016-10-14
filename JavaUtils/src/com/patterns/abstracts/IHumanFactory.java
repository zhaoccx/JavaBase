package com.patterns.abstracts;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午5:22:51
 */
public interface IHumanFactory {

	public IHuman createYHuman();

	public IHuman createBHuman();

	public IHuman createWHuman();
}
