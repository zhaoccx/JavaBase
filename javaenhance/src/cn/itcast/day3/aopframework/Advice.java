package cn.itcast.day3.aopframework;

import java.lang.reflect.Method;

public interface Advice {
	void beforeMethod(Method method);

	void afterMethod(Method method);
}
