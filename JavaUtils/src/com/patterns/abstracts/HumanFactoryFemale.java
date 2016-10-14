package com.patterns.abstracts;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午5:31:29
 */
public class HumanFactoryFemale extends AbstractHumanFactory {

	@Override
	public IHuman createYHuman() {
		return super.createHuman(HumanEnum.AbstractHumanYFemale);
	}

	@Override
	public IHuman createBHuman() {
		return super.createHuman(HumanEnum.AbstractHumanBFemale);
	}

	@Override
	public IHuman createWHuman() {
		return super.createHuman(HumanEnum.AbstractHumanWFemale);
	}
}
