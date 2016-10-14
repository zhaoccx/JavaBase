package com.patterns.abstracts;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午5:31:29
 */
public class HumanFactoryMale extends AbstractHumanFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.abstracts.IHumanFactory#createYHuman()
	 */
	@Override
	public IHuman createYHuman() {
		return super.createHuman(HumanEnum.AbstractHumanYMale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.abstracts.IHumanFactory#createBHuman()
	 */
	@Override
	public IHuman createBHuman() {
		return super.createHuman(HumanEnum.AbstractHumanBMale);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.abstracts.IHumanFactory#createWHuman()
	 */
	@Override
	public IHuman createWHuman() {
		return super.createHuman(HumanEnum.AbstractHumanWMale);
	}
}
