package com.patterns.abstracts;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午5:02:19
 */
public class AbstractHumanBFemale extends AbstractHumanB {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.abstracts.IHuman#sex()
	 */
	@Override
	public void sex() {
		System.out.println(this.getClass().getName() + "Female");
	}

}
