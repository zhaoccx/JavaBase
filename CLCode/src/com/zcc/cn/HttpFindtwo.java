package com.zcc.cn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpFindtwo {

	public static int end = 0;

	public static void getWebCon(String domain) {
		SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = "";
		System.out.println("开始抓取后面地址..(" + domain + ")");
		for (int i = 16; i <= 18; i++) {
			StringBuffer sb = new StringBuffer();
			try {
				str = domain + "&page=" + i;
				System.out.println(str);
				System.out.println(da.format(new Date()));
				java.net.URL url = new java.net.URL(str);
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				String line;
				while ((line = in.readLine()) != null) {
					parse(line);
				}
				Thread.sleep(1000);
				System.out.println();
				in.close();
				sb = null;
			} catch (Exception e) {
				sb.append(e.toString());
				System.err.println(e);
			}
		}
	}

	public static void main(String[] args) {

		HttpFindtwo.getWebCon("http://cl.org.ru/read.php?tid=1296368"); // 这是要抓取的网页,自己可以试下.

	}

	private static void parse(String line) {
		SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Pattern pattern = Pattern.compile("http://ww3.sinaimg.cn/mw1024/d263841dtw1emmeyyupytg209408c40b.gif");
		Matcher matcher = pattern.matcher(line);

		while (matcher.find()) {
			System.err.println("ssssssssssssssssssssssss");
			System.err.println(da.format(new Date()));
			System.err.println("码来了。。。。。。。。。。。。。。。。。。。。。。");
		}
	}

}
