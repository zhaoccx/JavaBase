package com.zcc.cn;

public class ActionMain {
	public static void main(String[] args) {
		while (true) {
			HttpFind.run();
			HttpFindtwo.getWebCon("http://cl.org.ru/read.php?tid=1296368");
		}
	}
}
