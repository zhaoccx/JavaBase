package com.patterns.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.utils.ClassUtils;

/**
 *
 * @author zhaocc
 * @time 2016年10月14日 下午4:02:03
 */
public class HumanFactory {

	private static Map<String, IHuman> map = new HashMap<String, IHuman>();

	@SuppressWarnings("rawtypes")
	public static IHuman createHuman(Class man) {
		IHuman human = null;
		try {
			if (map.containsKey(man.getSimpleName())) {
				human = map.get(man.getSimpleName());

			} else {
				human = (IHuman) Class.forName(man.getName()).newInstance();
				map.put(man.getSimpleName(), human);
			}

		} catch (InstantiationException e) {
			System.err.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.err.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.println("不存在" + man.getName());
		}
		return human;
	}

	@SuppressWarnings("rawtypes")
	public static IHuman createHuman() {
		List<Class> list = ClassUtils.getAllClassByInterface(IHuman.class);

		Random random = new Random();
		// int nextInt = random.nextInt(list.size());

		return createHuman(list.get(random.nextInt(list.size())));
	}

}
