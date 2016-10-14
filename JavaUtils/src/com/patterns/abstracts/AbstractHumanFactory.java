package com.patterns.abstracts;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午5:21:37
 */
public abstract class AbstractHumanFactory implements IHumanFactory {

	protected IHuman createHuman(HumanEnum enums) {
		IHuman human = null;

		if (!"".equals(enums.getValue())) {
			try {
				human = (IHuman) Class.forName(enums.getValue()).newInstance();
			} catch (Exception e) {
				System.out.println("0000000000000000000000000000");
			}
		}
		return human;
	}
}
