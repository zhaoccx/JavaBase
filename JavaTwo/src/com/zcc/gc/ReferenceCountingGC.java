package com.zcc.gc;

public class ReferenceCountingGC {
	public Object instance = null;
	private static final int _1MB = 1024 * 1024;

	// 这个成员属性的唯一意义就是占点内存，以便能够在GC日志中看清楚是否被回收过
	@SuppressWarnings("unused")
	private byte[] bigSize = new byte[2 * _1MB];

	@Deprecated
	public static void testGC() {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();

		objA.instance = objB;
		objB.instance = objA;

		objA = null;
		objB = null;

		// 假设在这行发生GC，那么objA和obj是否能够被回收？
		System.gc();
		System.out.println("**********");
	}

	public static void main(String[] args) {
		testGC();
	}

}
