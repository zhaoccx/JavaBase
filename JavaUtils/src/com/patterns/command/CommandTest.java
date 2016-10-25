package com.patterns.command;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 上午11:00:01
 */
public class CommandTest {
	public static void main(String[] args) {

		Invoker invoker = new Invoker();
		invoker.setCommand(new AddRequireCommand());
		invoker.action();

	}
}
