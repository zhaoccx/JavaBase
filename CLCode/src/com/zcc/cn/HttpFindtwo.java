package com.zcc.cn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HttpFindtwo {

	public static void getWebCon(String domain) {
		String str = "";
		System.out.println("开始抓取邮件地址..(" + domain + ")");
		for (int i = 1; i <= 26; i++) {
			StringBuffer sb = new StringBuffer();
			try {
				str = domain + "&page=" + i;
				System.out.println(str);
				java.net.URL url = new java.net.URL(str);
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				String line;
				while ((line = in.readLine()) != null) {
					parse(line);
				}
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
		try {
			String es = null;
			es = new String(line.getBytes("GB2312"), "UTF-8");
			System.out.println(es);
			while (es.contains("水货员")) {
				System.err.println("码来了，，，，，，");
			}
		} catch (UnsupportedEncodingException e) {
		}

//		Pattern p = Pattern.compile("水货员");// 邮箱的正则表达式
//		Matcher m = p.matcher(line);
	}
}
