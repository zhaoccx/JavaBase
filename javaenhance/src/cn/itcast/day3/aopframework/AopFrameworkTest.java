package cn.itcast.day3.aopframework;

import java.io.InputStream;
import java.util.Collection;

public class AopFrameworkTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		InputStream ips = AopFrameworkTest.class.getResourceAsStream("config.properties");
		Object bean = new BeanFactory(ips).getBean("xxx");
		System.out.println(bean.getClass().getName());
		((Collection) bean).clear();
	}

}