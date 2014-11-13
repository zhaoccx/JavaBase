package com.zcc.regexp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	private static int count = 1;

	public static void main(String[] args) {
		// 简单认识正则表达式的概念

		// p("abc".matches("..."));
		// p("a8729a".replaceAll("\\d", "-"));
		// Pattern p = Pattern.compile("[a-z]{3}");
		// Matcher m = p.matcher("fgh");
		// p(m.matches());
		// p("fgha".matches("[a-z]{3}"));

		// 初步认识. * + ?

		// p("a".matches("."));
		// p("aa".matches("aa"));
		// p("aaaa".matches("a*"));
		// p("aaaa".matches("a+"));
		// p("".matches("a*"));
		// p("aaaa".matches("a?"));
		// p("".matches("a?"));
		// p("a".matches("a?"));
		// p("214523145234532".matches("\\d{3,100}"));
		// p("192.168.0.aaa".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
		// p("192".matches("[0-2][0-9][0-9]"));

		// 范围

		// p("a".matches("[abc]"));
		// p("a".matches("[^abc]"));
		// p("A".matches("[a-zA-Z]"));
		// p("A".matches("[a-z]|[A-Z]"));
		// p("A".matches("[a-z[A-Z]]"));
		// p("R".matches("[A-Z&&[RFG]]"));

		// 认识\s \w \d \

		// p(" \n\r\t".matches("\\s{4}"));
		// p(" ".matches("\\S"));
		// p("a_8".matches("\\w{3}"));
		// p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));
		// p("\\".matches("\\\\"));

		// POSIX Style
		// p("a".matches("\\p{Lower}"));

		// boundary
		// p("hello sir".matches("^h.*"));
		// p("hello sir".matches(".*ir$"));
		// p("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
		// p("hellosir".matches("^h[a-z]{1,3}o\\b.*")); // whilte lines
		// p(" \n".matches("^[\\s&&[^\\n]]*\\n$"));
		//
		// p("aaa 8888c".matches(".*\\d{4}."));
		// p("aaa 8888c".matches(".*\\b\\d{4}."));
		// p("aaa8888c".matches(".*\\d{4}."));
		// p("aaa8888c".matches(".*\\b\\d{4}."));

		// email
		// p("asdfasdfsafsf@dsdfsdf.com".matches("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+"));

		// matches find lookingAt

		// Pattern p2 = Pattern.compile("\\d{3,5}");
		// String s = "123-34345-234-00";
		// Matcher m2 = p2.matcher(s);
		// p(m2.matches());
		// m2.reset();
		// p(m2.find());
		// p(m2.start() + "-" + m2.end());
		// p(m2.find());
		// p(m2.start() + "-" + m2.end());
		// p(m2.find());
		// p(m2.start() + "-" + m2.end());
		// p(m2.find());
		// p(m.start() + "-" + m.end());
		// p(m2.lookingAt());
		// p(m2.lookingAt());
		// p(m2.lookingAt());
		// p(m2.lookingAt());

		// replacement

		// Pattern p3 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		// Matcher m3 =
		// p3.matcher("java Java JAVa JaVa IloveJAVA you hateJava afasdfasdf");
		// StringBuffer buf = new StringBuffer();
		// int i = 0;
		// while (m3.find()) {
		// i++;
		// if (i % 2 == 0) {
		// m3.appendReplacement(buf, "java");
		// } else {
		// m3.appendReplacement(buf, "JAVA");
		// }
		// }
		// m3.appendTail(buf);
		// p(buf);

		// group

		Pattern p4 = Pattern.compile("(\\d{3,5})([a-z]{2})");
		String s2 = "123aa-34345bb-234cc-00";
		Matcher m4 = p4.matcher(s2);
		while (m4.find()) {
			p(m4.group());
		}

		// qulifiers

		// Pattern p5 = Pattern.compile(".{3,10}+[0-9]");
		// String s3 = "aaaa5bbbb68";
		// Matcher m5 = p5.matcher(s3);
		// if (m5.find())
		// p(m5.start() + "-" + m5.end());
		// else
		// p("not match!");

		// non-capturing groups

		// Pattern p6 = Pattern.compile(".{3}(?=a)");
		// String s4 = "444a66b";
		// Matcher m6 = p6.matcher(s4);
		// while (m6.find()) {
		// p(m6.group());
		// }

		// back refenrences

		// Pattern p7 = Pattern.compile("(\\d(\\d))\\2");
		// String s7 = "122";
		// Matcher m7 = p7.matcher(s7);
		// p(m7.matches());

		// flags的简写
		// Pattern p8 = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
		// p("Java".matches("(?i)(java)"));
	}

	public static void p(Object o) {
		System.out.println(o);

		System.out.println("*****************" + count++);
	}
}
