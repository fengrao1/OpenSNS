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
	//GeT����
    //����WebClient����
	WebClient client = new WebClient();
	// 2.����WebRequest����
	WebRequest get = new WebRequest(new URL(ReadPro.getPropValue("base_url") + url), HttpMethod.GET);
	// 3.ִ������
	Page page = client.getPage(get);
	// 4.�ȵ���Ӧ
	WebResponse response = page.getWebResponse();
	// 5.�ȵ���Ӧ����
	String result = response.getContentAsString();
	// 6.�ر�client����
	client.close();
	// System.out.println(result);
    return result;
	}

	public String htmlPost(String url) throws Exception{
		// 1.����client����
		WebClient client = new WebClient();
		// 2.��������
		WebRequest post = new WebRequest(new URL(url), HttpMethod.POST);
		// 3.����header
		client.addRequestHeader("Content-Type", "application/json");
		// 4.����������   ��¼
		post.setRequestBody("{\"phoneArea\":\"86\",\"phoneNumber\":\"20000000005\",\"password\":\"netease123\"}");
		// 5.ִ������
		Page page = client.getPage(post);
		// 6.�����Ӧ
		WebResponse response = page.getWebResponse();
		// 7.�����Ӧ����
		String result = response.getContentAsString();
		// System.out.println(result);
		// 8.�Ͽ�����
		client.close();
		return result;
	}
	
	public String htmlPostbypara(String url,JSONObject para) throws Exception{
		// 1.����client����
				WebClient client = new WebClient();
				// 2.��������
				WebRequest post = new WebRequest(new URL(url), HttpMethod.POST);
				// 3.����header
				client.addRequestHeader("Content-Type", "application/json");
				// 4.����������   ��¼
				
				post.setRequestBody(para);
				// 5.ִ������
				Page page = client.getPage(post);
				// 6.�����Ӧ
				WebResponse response = page.getWebResponse();
				// 7.�����Ӧ����
				String result = response.getContentAsString();
				// System.out.println(result);
				// 8.�Ͽ�����
				client.close();
				return result;
	}
}
