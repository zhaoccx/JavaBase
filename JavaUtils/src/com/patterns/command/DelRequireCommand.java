package com.patterns.command;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 上午11:36:20
 */
public class DelRequireCommand extends Command {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.patterns.command.Command#execute()
	 */
	@Override
	public void execute() {
		super.rg.find();
		super.rg.delete();
		super.rg.plan();

	}

}
