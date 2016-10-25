package com.patterns.command;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 上午11:20:03
 */
public abstract class Command {

	protected Group rg = new RequirementGroup();
	protected Group pg = new PageGroup();
	protected Group cg = new CodeGroup();

	public abstract void execute();

}
