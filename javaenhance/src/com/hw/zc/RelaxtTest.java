package com.hw.zc;

import java.lang.reflect.Field;

public class RelaxtTest {
	public static void main(String[] args) throws Exception {
		Point ojbd = new Point();
		@SuppressWarnings("rawtypes")
		Class cls = ojbd.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			if (field.getType() == String.class) {
				field.setAccessible(true);
				String sed = (String) field.get(ojbd);
				String nString = sed.replace('a', 'b');
				field.set(ojbd, nString);
			}
		}
		System.out.println(ojbd);
	}
}
