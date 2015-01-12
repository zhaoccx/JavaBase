package com.zcc.cn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Register {
	static HttpClient httpClient = new DefaultHttpClient();
	static HttpPost httpPost = new HttpPost("http://cl.org.ru/register.php");
	/**
	 * 注册单个邀请码
	 * 
	 * @param invcode
	 *            邀请码
	 * @return 是否成功
	 */
	public boolean registerSingle(String invcode) {

		
		
		return false;
	}
	
	
	
	
	
	
	public boolean registerList(List<String> list) throws ClientProtocolException, IOException {
		for (int i = 0; i < list.size(); i++) {
			String invcode = list.get(i); // 邀请码
			System.out.println(invcode);
			httpPost.setEntity(setPatams(invcode.toLowerCase()));
			HttpResponse httpResponse = null;
			try {
				httpResponse = httpClient.execute(httpPost);
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			HttpEntity entity = httpResponse.getEntity();
			String source = new String(EntityUtils.toString(entity).getBytes("iso-8859-1"), "gbk");
			if (source.contains("邀請碼錯誤") == false) {
				System.out.println(source);
				System.err.println("成功:" + invcode);
				System.exit(0);
			}
		}
		
		
		return false;
	}

	public static UrlEncodedFormEntity setPatams(String invcode) throws ClientProtocolException, IOException {

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
}
