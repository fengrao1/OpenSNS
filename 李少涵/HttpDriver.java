

import java.io.IOException;

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
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;
//----------------------------------------------------------------------------------------------静态方法在同一个包内，不需要new一个新的对象，可以直接使用
public class HttpDriver {
	static String b_url = "http://127.0.0.1:9999";

	public static String doGet(String url, String para) throws ClientProtocolException, IOException {
		// 创建HTTPclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		// 创建带请求的HTTPget对象
		HttpGet httpget = new HttpGet(b_url + url + "?" + para);
		httpget.setHeader("Content-Type", "application/json");
		// 执行请求，获得响应
		CloseableHttpResponse response = client.execute(httpget);
		// 打印状态码
		System.out.println(response.getStatusLine());
		// 获取响应实体
		HttpEntity entity1 = response.getEntity();
		// 获取响应内容
		String result = EntityUtils.toString(entity1, "UTF-8");
		// 释放资源
		EntityUtils.consume(entity1);
		// 断开连接
		response.close();
		client.close();
		System.out.println(result);
		return result;

	}

	public static String cookieGet(String url, String para, CookieStore cookie)
			throws ClientProtocolException, IOException {
		RequestConfig gConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(gConfig).setDefaultCookieStore(cookie)
				.build();
		HttpGet httpget = new HttpGet(b_url + url + "?" + para);
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

	public static String doGet1(String url) throws ClientProtocolException, IOException {
		// 创建HTTPclient对象
		CloseableHttpClient client = HttpClients.createDefault();
		// 创建带请求的HTTPget对象
		HttpGet httpget = new HttpGet(b_url + url);
		httpget.setHeader("Content-Type", "application/json");
		// 执行请求，获得响应
		CloseableHttpResponse response = client.execute(httpget);
		// 打印状态码
		System.out.println(response.getStatusLine());
		// 获取响应实体
		HttpEntity entity1 = response.getEntity();
		// 获取响应内容
		String result1 = EntityUtils.toString(entity1, "UTF-8");
		System.out.println(result1);
		// 释放资源
		EntityUtils.consume(entity1);
		// 断开连接
		response.close();
		client.close();
		return result1;

	}

	public static String cookieGet1(String url, CookieStore cookie) throws ClientProtocolException, IOException {
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

	// 固定三个参数
	public static String doPost(String body, String url) throws ParseException, IOException {
		// 创建httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建带请求地址的httppost对象
		HttpPost httpPost = new HttpPost(b_url + url);
		// 设置httppost对象属性
		httpPost.setHeader("Content-Type", "application/json");
		// 设置httppost的内容，设置登录参数---请求体
		StringEntity entity = new StringEntity(body);
		httpPost.setEntity(entity);
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		// 打印状态码
		System.out.println(response2.getStatusLine());
		// 获取响应实体
		HttpEntity entity2 = response2.getEntity();
		// 获取响应内容
		String result = EntityUtils.toString(entity2);
		System.out.println(result);
		// 释放资源
		EntityUtils.consume(entity2);
		// 断开连接
		response2.close();
		httpclient.close();
		return result;
	}

	public static String cookiePost(String url, String body, CookieStore cookie) throws ParseException, IOException {
		//创建一个带cookie信息的client对象
		RequestConfig gConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(gConfig)
				.setDefaultCookieStore(cookie).build();
		
		HttpPost httpPost = new HttpPost(b_url + url);
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setHeader("csrfToken","csrfToken");//-------------------------------------------要注意这句话呀，很多时候没有它无法成功post
		StringEntity entity = new StringEntity(body,"UTF-8");
		httpPost.setEntity(entity);
		CloseableHttpResponse response = httpclient.execute(httpPost);
		System.out.println(response.getStatusLine());
		HttpEntity entity2 = response.getEntity();
		String result = EntityUtils.toString(entity2);
		System.out.println(result);
		EntityUtils.consume(entity2);
		response.close();
		httpclient.close();
		return result;
	}

}
