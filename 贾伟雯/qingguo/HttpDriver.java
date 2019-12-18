package com.edu.qingguo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.gargoylesoftware.htmlunit.util.Cookie;

import java.util.Set;
public class HttpDriver {
	static String b_url="http://study-perf.qa.netease.com";
	public static String doGet(String url,String para) throws ClientProtocolException, IOException{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url+"?"+para);
		CloseableHttpResponse response = client.execute(get);
		HttpEntity result_entity = response.getEntity();
		String result=EntityUtils.toString(result_entity,"utf-8");
		EntityUtils.consume(result_entity);
		response.close();
		client.close();
		return result;
	}
	
	public static String doGet1(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse response = client.execute(get);
		HttpEntity result_entity = response.getEntity();
		String result=EntityUtils.toString(result_entity,"utf-8");
		EntityUtils.consume(result_entity);
		response.close();
		client.close();
		return result;
	}
			
	
	private static String mapToString(Map<String, Object> para) {
		// TODO Auto-generated method stub
		StringBuilder  sBuilder =new StringBuilder(); 
		int size=para.size(); 
		for(Entry<String, Object> entry:para.entrySet()) { 
			sBuilder.append(entry.getKey()+"="+entry.getValue()); 
			size--; 
			if (size>=1) { 
				sBuilder.append("&"); 
 			} 
		}
		return sBuilder.toString();
	}


	public static String doPost(String url,String body) throws ClientProtocolException, IOException{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Content-Type", "application/json");
		StringEntity request_entity=new StringEntity(body);
		httpPost.setEntity(request_entity);
		CloseableHttpResponse response= client.execute(httpPost);
		System.out.println(response.getStatusLine());
		HttpEntity result_entity = response.getEntity();
		String result=EntityUtils.toString(request_entity);
		System.out.print(EntityUtils.toString(result_entity, "UTF-8"));
		EntityUtils.consume(result_entity);
	    response.close();
		client.close();
		return result;
	}


	public static String cookiePost(String url,String body,CookieStore cookie) throws ParseException, IOException {
		RequestConfig gConfig =RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		CloseableHttpClient httpclient=HttpClients.custom().
		setDefaultRequestConfig(gConfig).setDefaultCookieStore(cookie).build();
		HttpPost httpPost=new HttpPost(url);
		httpPost.setHeader("Content-Type","application/json");
		StringEntity entity=new StringEntity(body);
		httpPost.setEntity(entity);
		CloseableHttpResponse response=httpclient.execute(httpPost);
		System.out.println(response.getStatusLine());
		HttpEntity entity2 = response.getEntity();
		String result=EntityUtils.toString(entity2);
		System.out.println(result);
		EntityUtils.consume(entity2);
		response.close();
		httpclient.close();
		return result;
	}


	public static String doGet(String url, CookieStore cookie) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		RequestConfig gConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(gConfig).setDefaultCookieStore(cookie)
				.build();
		HttpGet httpget = new HttpGet(b_url + url);
		httpget.setHeader("Content-Type", "application/json");
		CloseableHttpResponse response = client.execute(httpget);
		System.out.println(response.getStatusLine());
		HttpEntity entity1 = response.getEntity();
		String result = EntityUtils.toString(entity1, "UTF-8");
		EntityUtils.consume(entity1);
		response.close();
		client.close();
		return result;
	}
	
	
	
	
	
//	public static String doGet(String url,Set<Cookie> cookie){
//		WebClient client=new WebClient();
//		
//		Iterator<Cookie> iterator=cookie.iterator();
//		while(Iterator.hasNext()){
//			client.getCookieManager().addCookie(iterator.next());
//		}
//		
//		WebRequest get=new WebRequest(new URL(url),);
//		Page page=client.getPage(get);
//		WebResponse response=page.getWebResponse();
//		String result=response.getContentAsString();
//		client.close();
//		return result;
//	}
}