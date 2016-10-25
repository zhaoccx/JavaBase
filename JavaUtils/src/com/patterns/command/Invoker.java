package com.patterns.command;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 上午11:40:27
 */
public class Invoker {

	private Command command;

	/**
	 * @param command
	 *            the command to set
	 */
	public void setCommand(Command command) {
		this.command = command;
	}

	public void action() {
		this.command.execute();
	}
}
