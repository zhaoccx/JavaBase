package com.patterns.decorator;

/**
 *
 * @author zhaocc
 * @time 2016年10月22日 下午2:51:38
 */
public class ReportTest {
	public static void main(String[] args) {
		Report report = new Decorator(new ReportImpl());
		report.report();
	}
}
