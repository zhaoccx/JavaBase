package com.patterns.composite;

/**
 *
 * @author zhaocc
 * @time 2016年11月22日 下午2:56:06
 */
public class Leaf extends Corp {

	// 就写一个构造函数，这个是必须的
	public Leaf(String _name, String _position, int _salary) {
		super(_name, _position, _salary);
	}
}
