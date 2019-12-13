package com.demo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.ws.WebServiceClient;

import org.apache.logging.log4j.core.appender.rolling.SizeBasedTriggeringPolicy;

import com.edu.utils.ReadPro;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;

import net.sf.json.JSONObject;

public class DemoTest {
	//String login_url="http://study-perf.qa.netease.com/common/fgadmin/login";
	
	public String htmlGet(String url) throws Exception{
	//GeT请求
    //创建WebClient对象
	WebClient client = new WebClient();
	// 2.创建WebRequest对象
	WebRequest get = new WebRequest(new URL(ReadPro.getPropValue("base_url") + url), HttpMethod.GET);
	// 3.执行请求
	Page page = client.getPage(get);
	// 4.等到响应
	WebResponse response = page.getWebResponse();
	// 5.等到响应正文
	String result = response.getContentAsString();
	// 6.关闭client对象
	client.close();
	// System.out.println(result);
    return result;
	}

	public String htmlPost(String url) throws Exception{
		// 1.创建client对象
		WebClient client = new WebClient();
		// 2.创建请求
		WebRequest post = new WebRequest(new URL(url), HttpMethod.POST);
		// 3.设置header
		client.addRequestHeader("Content-Type", "application/json");
		// 4.设置请求体   登录
		post.setRequestBody("{\"phoneArea\":\"86\",\"phoneNumber\":\"20000000005\",\"password\":\"netease123\"}");
		// 5.执行请求
		Page page = client.getPage(post);
		// 6.获得响应
		WebResponse response = page.getWebResponse();
		// 7.获得响应正文
		String result = response.getContentAsString();
		// System.out.println(result);
		// 8.断开连接
		client.close();
		return result;
	}
	
	public String htmlPostbypara(String url,JSONObject para) throws Exception{
		// 1.创建client对象
				WebClient client = new WebClient();
				// 2.创建请求
				WebRequest post = new WebRequest(new URL(url), HttpMethod.POST);
				// 3.设置header
				client.addRequestHeader("Content-Type", "application/json");
				// 4.设置请求体   登录
				
				post.setRequestBody(para);
				// 5.执行请求
				Page page = client.getPage(post);
				// 6.获得响应
				WebResponse response = page.getWebResponse();
				// 7.获得响应正文
				String result = response.getContentAsString();
				// System.out.println(result);
				// 8.断开连接
				client.close();
				return result;
	}
}
