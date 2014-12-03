package com.hw.zc.day2;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
		teseFroe();
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void testThree() {
		// List<String> c = new Vector();
		// List ceList = new Vector<String>();
		// List<String> list = new ArrayList<String>();
		Vector vector = new Vector<String>();
		Vector<Object> vector2 = vector;
		vector.add("aaa");
		System.out.println(vector2.get(0));
	}

	@SuppressWarnings("unused")
	public static void teseFroe() throws Exception {
		Collection<? extends Number> collection = new Vector<Integer>();
		Collection<? super Integer> collection2 = new Vector<Number>();

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 1);
		map.put("d", 1);
		map.put("e", 1);

		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}
		// add(3, 4);

		Map<String, Integer> add = add(map);
	}

	@SuppressWarnings("unused")
	private static <T> T add2(T[] t, int i, int j) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	private static <T extends Map<String, Integer>> T add(Map may) {
		return null;

	}
}
