package com.zcc.cn;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpFind {

	public static int flag = 0;

	public static void main(String[] args) {
		try {
			for (;;) {
				flag = 0;
				java.net.URL url = new java.net.URL("http://cl.org.ru/htm_data/7/1411/1296368.html");
				// System.out.println(url.openStream().toString());
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				String ling = "";
				while ((ling = reader.readLine()) != null) {
					SVNs(ling);
				}
				Thread.sleep(2000);
				if (flag == 0) {
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
					System.err.println("码来了。码来了。码来了。码来了。码来了。");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void SVNs(String ling) {
		SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Pattern pattern = Pattern.compile("2015-01-06 22:06");
		Matcher matcher = pattern.matcher(ling);
		while (matcher.find()) {
			System.out.println("ssssssssssssssssssssssss");
			System.out.println(da.format(new Date()));
			flag++;
		}
	}
}
