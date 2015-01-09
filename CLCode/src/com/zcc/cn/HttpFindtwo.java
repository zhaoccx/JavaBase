package com.zcc.cn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpFindtwo {

	public static int end = 0;

	public static void getWebCon(String domain) {
		for (;;) {

			SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String str = "";
			System.out.println("开始抓取后面地址..(" + domain + ")");
			for (int i = 14; i <= 17; i++) {
				try {
					str = domain + "&page=" + i;
					if ("http://cl.org.ru/read.php?tid=1296368&page=14".equals(str)) {
						str = "http://cl.org.ru/htm_data/7/1411/1296368.html";
					}
					System.out.println(da.format(new Date()));
					System.out.println(str);
					java.net.URL url = new java.net.URL(str);
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
					String line;
					while ((line = in.readLine()) != null) {
						parse(line,str);
					}
					in.close();
					url = null;
					System.out.println(da.format(new Date()));
					System.out.println();
					Thread.sleep((int)(Math.random()*1000));
				} catch (Exception e) {
					System.err.println(e);
					getWebCon("http://cl.org.ru/read.php?tid=1296368");
				}
			}
		}
	}

	public static void main(String[] args) {

		HttpFindtwo.getWebCon("http://cl.org.ru/read.php?tid=1296368"); // 这是要抓取的网页,自己可以试下.

	}

	// http://ww3.sinaimg.cn/mw1024/d263841dtw1emmeyyupytg209408c40b.gif
	private static void parse(String line,String str) {
		SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Pattern pattern =
		// Pattern.compile("http://ww3.sinaimg.cn/mw1024/d263841dtw1emmeyyupytg209408c40b.gif");
		String sm = "2015-01-08 "+Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		System.out.println(sm + " "+str);
		Pattern pattern = Pattern.compile(sm);
		Matcher matcher = pattern.matcher(line);

		while (matcher.find()) {
			System.err.println("ssssssssssssssssssssssss");
			System.err.println("ssssssssssssssssssssssss");
			System.err.println("ssssssssssssssssssssssss");
			System.err.println("ssssssssssssssssssssssss");
			System.err.println("ssssssssssssssssssssssss");
			System.err.println("ssssssssssssssssssssssss");
			System.err.println("ssssssssssssssssssssssss");
			System.err.println(da.format(new Date()));
			System.err.println("码来了。。。。。。。。。。。。。。。。。。。。。。");
		}

	}

}
