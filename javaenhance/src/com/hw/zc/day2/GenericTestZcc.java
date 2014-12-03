package com.hw.zc.day2;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// ArrayList<Integer> 读 ArrayList typeof Integer
public class GenericTestZcc {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws Exception {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(1L);
		list.add("abc");
		int i = (Integer) list.get(0);
		System.out.println(i);
		testOne();
		testTwo();
		testThree();
	}

	public static void testOne() {
		List<String> list = new ArrayList<String>();
		list.add("acd");
		System.out.println(list.get(0));
		System.out.println(list.size());
	}

	public static void testTwo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		List<Integer> listint = new ArrayList<Integer>();
		List<String> listStrings = new ArrayList<String>();
		System.out.println(listint.getClass() == listStrings.getClass());

		listint.getClass().getMethod("add", Object.class).invoke(listint, "abcde");
		System.out.println(listint.get(0));

	}

	public static void testThree() {
		// List<String> c = new Vector();
		// List ceList = new Vector<String>();
		// List<String> list = new ArrayList<String>();
		Vector vector = new Vector<String>();
		Vector<Object> vector2 = vector;
		vector.add("aaa");
		System.out.println(vector2.get(0));
	}
}
