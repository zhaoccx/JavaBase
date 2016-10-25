package com.patterns.command;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 上午11:23:59
 */
public class AddRequireCommand extends Command {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.command.Command#execute()
	 */
	@Override
	public void execute() {
		super.rg.find();

		super.rg.add();

		super.rg.plan();

	}
}
