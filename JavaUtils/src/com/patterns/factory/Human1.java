package com.patterns.factory;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午4:00:29
 */
public class Human1 implements IHuman {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.factory.IHuman#laugh()
	 */
	@Override
	public void laugh() {
		System.out.println(this.getClass().getName() + "laugh");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.factory.IHuman#cry()
	 */
	@Override
	public void cry() {
		System.out.println(this.getClass().getName() + "cry");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.factory.IHuman#talk()
	 */
	@Override
	public void talk() {
		System.out.println(this.getClass().getName() + "talk");
	}

}
