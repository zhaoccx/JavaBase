package com.zcc.cn;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Register {
	private HttpClient httpClient = new DefaultHttpClient();
	private HttpPost httpPost = new HttpPost("http://cl.org.ru/register.php");
	private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-DD-MM HH:mm:ss.S");
	private final String[] allChars = new String[] { "0", "f", "1", "e", "2", "d", "3", "c", "4", "b", "5", "a", "6", "9", "7", "8" };
	private final String[] chars = new String[] { "f", "a", "b", "e", "c", "d" };
	private final String[] numbers = new String[] { "9", "0", "8", "1", "7", "2", "6", "3", "5", "4" };

	public static void main(String[] args) {
		Register register = new Register();
		List<String> lists = null;
		// 数字加某一个加some
		// lists = register.numberAddsomeGetLists("af9dc8e65dd00900", -1);
		// String[] datas = "31@3 fae3 a741 7@6d".split(" ");
		// lists = register.charAddsomeGetLists("8a6@ef174", -1);
		lists = register.hideTwoCharOrNumber("af9d@8e65d@00900", "@");
		// lists = register.sort(Arrays.asList(datas), new ArrayList<String>(),
		// new ArrayList<String>());
		// lists = register.sortAndHidOneString("31@3 fae3 a741 746d", "@");
		// register.registerList(lists);
		System.out.println(lists);
		System.out.println(lists.size());
	}

	/**
	 * 注册单个邀请码
	 * 
	 * @param invcode
	 *            邀请码
	 * @return 是否成功
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public boolean registerSingle(String invcode) throws ClientProtocolException, IOException {
		// 邀请码
		httpPost.setEntity(setPatams(invcode.toLowerCase()));
		HttpResponse httpResponse = null;
		try {
			httpResponse = httpClient.execute(httpPost);
		} catch (Exception e) {
			System.out.println("网络错误");
		}
		HttpEntity entity = httpResponse.getEntity();
		String source = new String(EntityUtils.toString(entity).getBytes("iso-8859-1"), "gbk");
		if (!source.contains("邀請碼錯誤")) {
			System.out.println(source);
			System.err.println("成功:" + invcode);
			System.err.println("成功:" + invcode);
			System.err.println("成功:" + invcode);
			System.err.println("成功:" + invcode);
			System.err.println("成功:" + invcode);
			System.err.println("成功:" + invcode);
			System.exit(0);
			return true;
		} else {
			System.out.println(invcode + " 已经注册了");
		}
		return false;
	}

	/**
	 * 注册数组
	 * 
	 * @param list
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public boolean registerList(List<String> list) {
		Calendar start = Calendar.getInstance();
		Calendar end = null;
		for (int i = 0; i < list.size(); i++) {
			try {
				String invcode = list.get(i); // 邀请码
				HttpResponse httpResponse = null;
				httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BEST_MATCH);
				httpPost.setEntity(setPatams(invcode.toLowerCase()));
				httpResponse = httpClient.execute(httpPost);
				HttpEntity entity = httpResponse.getEntity();
				String source = new String(EntityUtils.toString(entity).getBytes("iso-8859-1"), "gbk");
				if (!source.contains("邀請碼錯誤") && !source.contains("刷新不要快於 2 秒")) {
					System.out.println(source);
					System.err.println("成功注册,注册码为：" + invcode + dateformat.format(new Date()));
					System.err.println("成功注册,注册码为：" + invcode);
					System.err.println("成功注册,注册码为：" + invcode);
					System.err.println("成功注册,注册码为：" + invcode);
					System.err.println("成功注册,注册码为：" + invcode);
					System.err.println("成功注册,注册码为：" + invcode);
					end = Calendar.getInstance();
					System.err.println("一共用时：" + (end.getTimeInMillis() - start.getTimeInMillis()) + "（毫秒）");
					System.exit(0);
					return true;
				} else {
					System.out.println(invcode + " 已经注册了 " + dateformat.format(new Date()));
				}
				Thread.sleep(500);
			} catch (ClientProtocolException cle) {
				System.out.println("客户端《----------》浏览器异常");
			} catch (InterruptedException e) {
				System.out.println("线程有异常");
			} catch (IOException e) {
				System.out.println("IO有异常了。");
			}
		}
		System.err.println("所有的都已经注册了" + dateformat.format(new Date()));
		System.err.println("所有的都已经注册了" + dateformat.format(new Date()));
		System.err.println("所有的都已经注册了" + dateformat.format(new Date()));
		System.err.println("所有的都已经注册了" + dateformat.format(new Date()));
		System.err.println("所有的都已经注册了" + dateformat.format(new Date()));
		System.err.println("所有的都已经注册了" + dateformat.format(new Date()));
		System.err.println("所有的都已经注册了" + dateformat.format(new Date()));
		System.err.println("所有的都已经注册了" + dateformat.format(new Date()));
		end = Calendar.getInstance();
		System.err.println("一共用时：" + (end.getTimeInMillis() - start.getTimeInMillis()) + "（毫秒）");
		return false;
	}

	/**
	 * 传注册码
	 * 
	 * @param invcode
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public UrlEncodedFormEntity setPatams(String invcode) throws ClientProtocolException, IOException {
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("regname", "天地壹号"));
		nvps.add(new BasicNameValuePair("regpwd", "zhao5487102"));
		nvps.add(new BasicNameValuePair("regpwdrepeat", "zhao5487102"));
		nvps.add(new BasicNameValuePair("regemail", "zcc102@163.com"));
		nvps.add(new BasicNameValuePair("invcode", invcode)); // 邀请码
		nvps.add(new BasicNameValuePair("forward", "")); // 不变
		nvps.add(new BasicNameValuePair("step", "2")); // 不变
		return new UrlEncodedFormEntity(nvps);
	}

	/**
	 * 数字加某一个加some;
	 * 
	 * @param invcode
	 *            源字符
	 * @param some
	 *            要加的数字
	 */
	public List<String> numberAddsomeGetLists(String invcode, int some) {
		List<String> invcodelist = new ArrayList<String>();
		char[] charArray = invcode.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			try {
				int s = Integer.parseInt(charArray[i] + "");
				s += some;
				s %= 10;
				if (s < 0) {
					s += 10;
				}
				invcodelist.add(numberAddSome(invcode, i, s));
			} catch (Exception e) {
			}
		}
		return invcodelist;
	}

	/**
	 * 字符加某一个加some;
	 * 
	 * @param invcode
	 *            源字符
	 * @param some
	 *            要加的数字
	 * @return 注册码数组
	 */
	public List<String> charAddsomeGetLists(String invcode, int some) {
		List<String> invcodelist = new ArrayList<String>();
		char[] charArray = invcode.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			try {
				Integer.parseInt(charArray[i] + "");
			} catch (Exception e) {
				int s = charArray[i];
				s += some;
				if (s < 97) {
					s += 6;
				} else if (s > 102) {
					s -= 6;
				}
				invcodelist.add(numberAddSomeChar(invcode, i, (char) s));
			}
		}
		return invcodelist;
	}

	/**
	 * 数字加
	 * 
	 * @param invcode
	 * @param index
	 * @param value
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public String numberAddSome(String invcode, int index, int value) {
		StringBuffer invcodebuff = new StringBuffer();
		char[] charArray = invcode.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (i == index) {
				invcodebuff.append(value);
			} else {
				invcodebuff.append(charArray[i]);
			}
		}
		return invcodebuff.toString();
	}

	/**
	 * 字符加
	 * 
	 * @param invcode
	 * @param index
	 * @param value
	 */
	public String numberAddSomeChar(String invcode, int index, char value) {
		StringBuffer invcodebuff = new StringBuffer();
		char[] charArray = invcode.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (i == index) {
				invcodebuff.append(value);
			} else {
				invcodebuff.append(charArray[i]);
			}
		}
		return invcodebuff.toString();
	}

	/**
	 * 隐藏一个字母
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            源字符
	 * @return
	 */
	public List<String> hideOneChar(String invcode, String charValue) {
		List<String> invcodelists = new ArrayList<String>();
		for (int i = 0; i < chars.length; i++) {
			invcodelists.add(invcode.replaceFirst(charValue, chars[i]));
		}
		return invcodelists;
	}

	/**
	 * 隐藏一个数字
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            源字符
	 * @return
	 */
	public List<String> hideOneNumber(String invcode, String charValue) {
		List<String> invcodelists = new ArrayList<String>();
		for (int i = 0; i < numbers.length; i++) {
			invcodelists.add(invcode.replaceFirst(charValue, numbers[i]));
		}
		return invcodelists;
	}

	/**
	 * 隐藏一个字符
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            源字符
	 * @return
	 */
	public List<String> hideOneNumberOrChar(String invcode, String charValue) {
		List<String> invcodelists = new ArrayList<String>();
		for (int i = 0; i < allChars.length; i++) {
			invcodelists.add(invcode.replaceFirst(charValue, allChars[i]));
		}
		return invcodelists;
	}

	/**
	 * 隐藏两个数字，用一个charValue代替
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            源字符
	 * @return
	 */
	public List<String> hideTwoNumber(String invcode, String charValue) {
		List<String> invcodelists = new ArrayList<String>();
		for (int index = 0; index < numbers.length; index++) {
			for (int indextwo = 0; indextwo < numbers.length; indextwo++) {
				invcodelists.add(invcode.replaceFirst(charValue, numbers[index]).replaceFirst(charValue, numbers[indextwo]));
			}
		}
		return invcodelists;
	}

	/**
	 * 隐藏两个字母，用一个charValue代替
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            源字符
	 * @return
	 */
	public List<String> hideTwoChar(String invcode, String charValue) {
		List<String> invcodelists = new ArrayList<String>();
		for (int index = 0; index < chars.length; index++) {
			for (int indextwo = 0; indextwo < chars.length; indextwo++) {
				invcodelists.add(invcode.replaceFirst(charValue, chars[index]).replaceFirst(charValue, chars[indextwo]));
			}
		}
		return invcodelists;
	}

	/**
	 * 隐藏两个字符,数字或者字母,用一个charValue代替
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            源字符
	 * @return
	 */
	public List<String> hideTwoCharOrNumber(String invcode, String charValue) {
		List<String> invcodelists = new ArrayList<String>();
		for (int index = 0; index < allChars.length; index++) {
			for (int indextwo = 0; indextwo < allChars.length; indextwo++) {
				invcodelists.add(invcode.replaceFirst(charValue, allChars[index]).replaceFirst(charValue, allChars[indextwo]));
			}
		}
		return invcodelists;
	}

	/**
	 * 全排列
	 * 
	 * @param datas
	 * @param target
	 * @param targets
	 * @return
	 */
	public List<String> sort(List<String> datas, List<String> target, List<String> targets) {
		if (target.size() == 4) {
			String temp = "";
			for (Object obj : target) {
				temp += obj;
			}
			targets.add(temp);
			return targets;
		}
		for (int i = 0; i < datas.size(); i++) {
			List<String> newDatas = new ArrayList<String>(datas);
			List<String> newTarget = new ArrayList<String>(target);
			newTarget.add(newDatas.get(i));
			newDatas.remove(i);
			sort(newDatas, newTarget, targets);
		}
		return targets;
	}

	/**
	 * 全排列
	 * 
	 * @param invcode
	 * @return
	 */
	public List<String> sortInvcode(String invcode) {
		List<String> lists = new ArrayList<String>();
		String[] datas = invcode.split(" ");
		lists.addAll(sort(Arrays.asList(datas), new ArrayList<String>(), new ArrayList<String>()));
		return lists;
	}

	/**
	 * 隐藏一个字符并分成四组，打乱顺序
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            隐藏字符
	 * @return
	 */
	public List<String> sortAndHidOneString(String invcode, String charValue) {
		List<String> replacelist = new ArrayList<String>();
		List<String> alllists = new ArrayList<String>();
		replacelist = hideOneNumberOrChar(invcode, charValue);
		for (String list : replacelist) {
			String[] datas = list.split(" ");
			alllists.addAll(sort(Arrays.asList(datas), new ArrayList<String>(), new ArrayList<String>()));
		}
		return alllists;
	}

	/**
	 * 隐藏两个字符并分成四组，打乱顺序
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            隐藏字符
	 * @return
	 */
	public List<String> sortAndHidTwoString(String invcode, String charValue) {
		List<String> replacelist = new ArrayList<String>();
		List<String> alllists = new ArrayList<String>();
		replacelist = hideTwoCharOrNumber(invcode, charValue);
		for (String list : replacelist) {
			String[] datas = list.split(" ");
			alllists.addAll(sort(Arrays.asList(datas), new ArrayList<String>(), new ArrayList<String>()));
		}
		return alllists;
	}
}
