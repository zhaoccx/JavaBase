package cn.itcast.day3.aopframework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.itcast.day3.Advice;

public class ProxyFactoryBean {

	private Advice advice;
	private Object target;

	public Advice getAdvice() {
		return advice;
	}

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object getProxy() {
		Object proxy3 = Proxy.newProxyInstance(target.getClass().getClassLoader(),
		/* new Class[]{Collection.class}, */
		target.getClass().getInterfaces(), new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				/*
				 * long beginTime = System.currentTimeMillis(); Object retVal =
				 * method.invoke(target, args); long endTime =
				 * System.currentTimeMillis();
				 * System.out.println(method.getName() + " running time of " +
				 * (endTime - beginTime)); return retVal;
				 */

				advice.beforeMethod(method);
				Object retVal = method.invoke(target, args);
				advice.afterMethod(method);
				return retVal;

			}
		});
		return proxy3;
	}

}
