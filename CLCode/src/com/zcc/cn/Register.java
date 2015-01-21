package com.zcc.cn;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

/**
 * 用于注册的类
 * 
 * @author Andy
 */
public class Register {
	/**
	 * 客气端对象
	 */
	private HttpClient httpClient = new DefaultHttpClient();
	/**
	 * 注册地址
	 */
	private HttpPost httpPost = new HttpPost("http://cl.org.ru/register.php");

	/**
	 * 时间格式化样式
	 */
	private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-DD-MM HH:mm:ss.S");
	/**
	 * 所有字符数组
	 */
	private final String[] allChars = new String[] { "8", "7", "9", "6", "a", "5", "b", "4", "c", "3", "d", "2", "e", "1", "f", "0" };
	/**
	 * 字母数组
	 */
	private final String[] chars = new String[] { "c", "d", "b", "e", "f", "a" };
	/**
	 * 数字数组
	 */
	private final String[] numbers = new String[] { "4", "5", "3", "6", "2", "7", "1", "8", "0", "9" };

	public static void main(String[] args) {
		// Register register = new Register();
		// register.findRegisterMainMethed();
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
			System.out.println(invcode + " 已经注册了，码长度为： " + invcode.length() + dateformat.format(new Date()));
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
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			try {
				String invcode = iterator.next();
				HttpResponse httpResponse = null;
				httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BEST_MATCH);
				httpPost.setEntity(setPatams(invcode.toLowerCase()));
				httpResponse = httpClient.execute(httpPost);
				HttpEntity entity = httpResponse.getEntity();
				String source = new String(EntityUtils.toString(entity).getBytes("iso-8859-1"), "gbk");
				if (!source.contains("邀請碼錯誤") && !source.contains("刷新不要快於 2 秒")) {
					System.out.println(source);
					System.err.println("成功注册,注册码为：" + invcode + dateformat.format(new Date()));
					System.err.println("成功注册,注册码为：" + invcode + dateformat.format(new Date()));
					System.err.println("成功注册,注册码为：" + invcode + dateformat.format(new Date()));
					System.err.println("成功注册,注册码为：" + invcode + dateformat.format(new Date()));
					System.err.println("成功注册,注册码为：" + invcode + dateformat.format(new Date()));
					System.err.println("成功注册,注册码为：" + invcode + dateformat.format(new Date()));
					end = Calendar.getInstance();
					System.err.println("一共用时：" + (end.getTimeInMillis() - start.getTimeInMillis()) + "（毫秒）");
					System.exit(0);
					return true;
				} else {
					System.out.println(invcode + " 已经注册了，码长度为： " + invcode.length() + dateformat.format(new Date()));
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
		end = Calendar.getInstance();
		System.err.println("一共用时：" + (end.getTimeInMillis() - start.getTimeInMillis()) + "（毫秒）");
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
	public String registerList(List<String> list, List<String> url, int index) {
		Calendar start = Calendar.getInstance();
		Calendar end = null;
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			try {
				httpPost.setURI(new URI(url.get(index)));
				String invcode = iterator.next();
				HttpResponse httpResponse = null;
				httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, CookiePolicy.BEST_MATCH);
				httpPost.setEntity(setPatams(invcode.toLowerCase()));
				httpResponse = httpClient.execute(httpPost);
				HttpEntity entity = httpResponse.getEntity();
				String source = new String(EntityUtils.toString(entity).getBytes("iso-8859-1"), "gbk");
				if (!source.contains("邀請碼錯誤") && !source.contains("刷新不要快於 2 秒")) {
					System.out.println(source);
					System.err.println("成功注册,注册码为：" + invcode + dateformat.format(new Date()));
					end = Calendar.getInstance();
					System.err.println("一共用时：" + (end.getTimeInMillis() - start.getTimeInMillis()) + "（毫秒）");
					return invcode;
				} else {
					System.out.println(invcode + " 已经注册了，码长度为： " + invcode.length() + " " + url.get(index) + "  " + dateformat.format(new Date()));
					list.remove(invcode);
				}
			} catch (ClientProtocolException cle) {
				System.out.println("客户端《----------》浏览器异常");
			} catch (IOException e) {
				System.out.println("IO有异常了。");
			} catch (URISyntaxException e) {
			}
		}
		System.err.println("所有的都已经注册了" + dateformat.format(new Date()));
		end = Calendar.getInstance();
		System.err.println("一共用时：" + (end.getTimeInMillis() - start.getTimeInMillis()) + "（毫秒）");
		return url.get(index);
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
		nvps.add(new BasicNameValuePair("regname", "天字壹号"));
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
		List<String> invcodeSet = new ArrayList<String>();
		char[] charArray = invcode.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			try {
				int s = Integer.parseInt(charArray[i] + "");
				s += some;
				s %= 10;
				if (s < 0) {
					s += 10;
				}
				invcodeSet.add(numberAddSome(invcode, i, s));
			} catch (Exception e) {
			}
		}
		return invcodeSet;
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
		List<String> invcodeSet = new ArrayList<String>();
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
				invcodeSet.add(numberAddSomeChar(invcode, i, (char) s));
			}
		}
		return invcodeSet;
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
		List<String> invcodeSet = new ArrayList<String>();
		for (int i = 0; i < chars.length; i++) {
			invcodeSet.add(invcode.replaceFirst(charValue, chars[i]));
		}
		return invcodeSet;
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
		List<String> invcodeSet = new ArrayList<String>();
		for (int i = 0; i < numbers.length; i++) {
			invcodeSet.add(invcode.replaceFirst(charValue, numbers[i]));
		}
		return invcodeSet;
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
		List<String> invcodeSet = new ArrayList<String>();
		for (int i = 0; i < allChars.length; i++) {
			invcodeSet.add(invcode.replaceFirst(charValue, allChars[i]));
		}
		return invcodeSet;
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
		List<String> invcodeSet = new ArrayList<String>();
		for (int index = 0; index < numbers.length; index++) {
			for (int indextwo = 0; indextwo < numbers.length; indextwo++) {
				invcodeSet.add(invcode.replaceFirst(charValue, numbers[index]).replaceFirst(charValue, numbers[indextwo]));
			}
		}
		return invcodeSet;
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
		List<String> invcodeSet = new ArrayList<String>();
		for (int index = 0; index < chars.length; index++) {
			for (int indextwo = 0; indextwo < chars.length; indextwo++) {
				invcodeSet.add(invcode.replaceFirst(charValue, chars[index]).replaceFirst(charValue, chars[indextwo]));
			}
		}
		return invcodeSet;
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
		List<String> invcodeSet = new ArrayList<String>();
		for (int index = 0; index < allChars.length; index++) {
			for (int indextwo = 0; indextwo < allChars.length; indextwo++) {
				invcodeSet.add(invcode.replaceFirst(charValue, allChars[index]).replaceFirst(charValue, allChars[indextwo]));
			}
		}
		return invcodeSet;
	}

	/**
	 * 隐藏两个字符,一个数字和一个字母,用一个charValue代替
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            源字符
	 * @return
	 */
	public List<String> hideTwoStringWithOneCharAndOneNumber(String invcode, String charValue) {
		String[] allChar = new String[] { "9", "0", "8", "1", "7", "2", "6", "3", "5", "4", "f", "a", "e", "b", "d", "c" };
		List<String> invcodelists = new ArrayList<String>();
		for (int index = 0; index < allChar.length; index++) {
			for (int indextwo = 0; indextwo < allChar.length; indextwo++) {
				if ((index < 10 && indextwo >= 10) || (index >= 10 && indextwo < 10))
					invcodelists.add(invcode.replaceFirst(charValue, allChar[index]).replaceFirst(charValue, allChar[indextwo]));
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
		List<String> sets = new ArrayList<String>();
		String[] datas = invcode.split(" ");
		sets.addAll(sort(Arrays.asList(datas), new ArrayList<String>(), new ArrayList<String>()));
		return sets;
	}

	/**
	 * 隐藏一个字母并分成四组，打乱顺序
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            隐藏字符
	 * @return
	 */
	public List<String> sortAndHidOneChar(String invcode, String charValue) {
		List<String> replacelist = new ArrayList<String>();
		List<String> allSet = new ArrayList<String>();
		replacelist = hideOneChar(invcode, charValue);
		for (String list : replacelist) {
			String[] datas = list.split(" ");
			allSet.addAll(sort(Arrays.asList(datas), new ArrayList<String>(), new ArrayList<String>()));
		}
		return allSet;
	}

	/**
	 * 隐藏一个数字并分成四组，打乱顺序
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            隐藏字符
	 * @return
	 */
	public List<String> sortAndHidOneNumber(String invcode, String charValue) {
		List<String> replaceSet = hideOneNumber(invcode, charValue);
		List<String> allSet = new ArrayList<String>();
		for (String list : replaceSet) {
			String[] datas = list.split(" ");
			allSet.addAll(sort(Arrays.asList(datas), new ArrayList<String>(), new ArrayList<String>()));
		}
		return allSet;
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
		List<String> replaceSet = new ArrayList<String>();
		List<String> allSet = new ArrayList<String>();
		replaceSet = hideOneNumberOrChar(invcode, charValue);
		for (String list : replaceSet) {
			String[] datas = list.split(" ");
			allSet.addAll(sort(Arrays.asList(datas), new ArrayList<String>(), new ArrayList<String>()));
		}
		return allSet;
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
		List<String> replaceSet = new ArrayList<String>();
		List<String> allSet = new ArrayList<String>();
		replaceSet = hideTwoCharOrNumber(invcode, charValue);
		for (String list : replaceSet) {
			String[] datas = list.split(" ");
			allSet.addAll(sort(Arrays.asList(datas), new ArrayList<String>(), new ArrayList<String>()));
		}
		return allSet;
	}

	/**
	 * 隐藏两个字符中一个数字一个字母并分成四组，打乱顺序
	 * 
	 * @param invcode
	 *            源邀请码
	 * @param charValue
	 *            隐藏字符
	 * @return
	 */
	public List<String> sortAndHidTwoStringWithOneCharAndOneNumber(String invcode, String charValue) {
		List<String> replacelist = new ArrayList<String>();
		List<String> alllists = new ArrayList<String>();
		replacelist = hideTwoStringWithOneCharAndOneNumber(invcode, charValue);
		for (String list : replacelist) {
			String[] datas = list.split(" ");
			alllists.addAll(sort(Arrays.asList(datas), new ArrayList<String>(), new ArrayList<String>()));
		}
		return alllists;
	}

	/**
	 * 自己要手动去试试
	 * 
	 * @return
	 */
	public List<String> getListTest() {
		List<String> list = new ArrayList<String>();
		list.add("http://" + "x.nh50.com         ".trim() + "/register.php");
		list.add("http://" + "wo.yao.cl          ".trim() + "/register.php");
		list.add("http://" + "clcl.ch            ".trim() + "/register.php");
		list.add("http://" + "bb.69.mu           ".trim() + "/register.php");
		list.add("http://" + "no.fzmov.com       ".trim() + "/register.php");
		list.add("http://" + "1024.ns02.biz      ".trim() + "/register.php");
		list.add("http://" + "cl.cf.gs           ".trim() + "/register.php");
		list.add("http://" + "5.yao.cl           ".trim() + "/register.php");
		list.add("http://" + "10240.tk           ".trim() + "/register.php");
		list.add("http://" + "cl.yyq.im          ".trim() + "/register.php");
		list.add("http://" + "cl.mooo.info       ".trim() + "/register.php");
		list.add("http://" + "ruai.lesile.net    ".trim() + "/register.php");
		list.add("http://" + "zlvc.net           ".trim() + "/register.php");
		list.add("http://" + "cl.gmf.cl          ".trim() + "/register.php");
		list.add("http://" + "1024.now.im        ".trim() + "/register.php");
		list.add("http://" + "re.aemxs.com       ".trim() + "/register.php");
		list.add("http://" + "wazh.uni.me        ".trim() + "/register.php");
		list.add("http://" + "cl.mooo.info       ".trim() + "/register.php");
		list.add("http://" + "www.gfw74.tk       ".trim() + "/register.php");
		list.add("http://" + "wo.clsq1024.pw     ".trim() + "/register.php");
		list.add("http://" + "www.xiaocao.in     ".trim() + "/register.php");
		list.add("http://" + "caoliuwang.info    ".trim() + "/register.php");
		list.add("http://" + "cl.591mn.com       ".trim() + "/register.php");
		list.add("http://" + "cl.org.ru          ".trim() + "/register.php");
		list.add("http://" + "1025.tv            ".trim() + "/register.php");
		list.add("http://" + "1025.la            ".trim() + "/register.php");
		list.add("http://" + "1025.me            ".trim() + "/register.php");
		list.add("http://" + "1025.xyz           ".trim() + "/register.php");
		list.add("http://" + "woge.xyz           ".trim() + "/register.php");
		list.add("http://" + "i.phonc.com        ".trim() + "/register.php");
		list.add("http://" + "zx0734.com         ".trim() + "/register.php");
		list.add("http://" + "ruai.lesile.net    ".trim() + "/register.php");
		for (String string : list) {
			System.out.println(string);
		}
		return list;
	}

	public void findRegisterMainMethed() {
		List<List<String>> arryLists = new ArrayList<List<String>>();
		List<String> childList = null;
		List<String> lists = this.getUrlList();
		List<String> List = this.sortAndHidTwoStringWithOneCharAndOneNumber("2@11 c@dc 62f7 0b2f", "@");
		System.out.println(List.size());
		int length = List.size() / lists.size();
		System.out.println(length);
		System.out.println(lists.size());
		for (int index = 0; index < lists.size(); index++) {
			childList = new ArrayList<String>();
			if (index < lists.size() - 1) {
				childList = List.subList(index * length, index * length + length);
			} else {
				childList = List.subList(index * length, List.size());
			}
			arryLists.add(childList);
		}

		int x = 0;
		for (int ins = 0; ins < arryLists.size(); ins++) {
			System.out.println(arryLists.get(ins));
			System.out.println(arryLists.get(ins).size());
			x += arryLists.get(ins).size();
			System.out.println(x);
		}

		ExecutorService pool = Executors.newFixedThreadPool(lists.size());

		List<Future<String>> fList = new ArrayList<Future<String>>();

		for (int inds = 0; inds < lists.size(); inds++) {
			fList.add(pool.submit(new Register.ReadRegister(lists, Integer.valueOf(inds), arryLists.get(inds))));
		}

		for (Future<String> future : fList) {
			System.out.println(future);
		}
	}

	class ReadRegister implements Callable<String> {
		private List<String> URLS = null;
		private Integer index = null;
		private List<String> registersList = null;
		private String retString = null;

		/**
		 * @param lists
		 * @param string
		 * @param arryLists
		 */
		public ReadRegister(List<String> lists, Integer index, List<String> arryLists) {
			this.URLS = lists;
			this.index = index;
			this.registersList = arryLists;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.concurrent.Callable#call()
		 */
		@Override
		public String call() throws Exception {
			Register register = new Register();
			this.retString = register.registerList(this.registersList, this.URLS, this.index);
			return this.retString;
		}

	}

	public List<String> getUrlList() {
		List<String> list = new ArrayList<String>();
		list.add("http://x.nh50.com/register.php");
		list.add("http://wo.yao.cl/register.php");
		list.add("http://clcl.ch/register.php");
		list.add("http://no.fzmov.com/register.php");
		list.add("http://10240.tk/register.php");
		list.add("http://cl.yyq.im/register.php");
		list.add("http://ruai.lesile.net/register.php");
		list.add("http://wazh.uni.me/register.php");
		list.add("http://www.gfw74.tk/register.php");
		list.add("http://wo.clsq1024.pw/register.php");
		list.add("http://www.xiaocao.in/register.php");
		list.add("http://cl.591mn.com/register.php");
		list.add("http://cl.org.ru/register.php");
		list.add("http://woge.xyz/register.php");
		list.add("http://ruai.lesile.net/register.php");
		return list;

	}

}
