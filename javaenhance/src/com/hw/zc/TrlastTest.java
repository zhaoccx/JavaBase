package com.hw.zc;

import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

public class TrlastTest {
	public static void main(String[] args) throws Exception {
		InputStream ipsInputStream = TrlastTest.class.getResourceAsStream("/cn/itcast/day1/resources/config.properties");
		Properties props = new Properties();
		props.load(ipsInputStream);
		ipsInputStream.close();

		String coString = props.getProperty("className");
		Collection reObject = (Collection) Class.forName(coString).newInstance();

		System.out.println(reObject.getClass().getName());
	}
}
