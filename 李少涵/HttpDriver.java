

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
//----------------------------------------------------------------------------------------------��̬������ͬһ�����ڣ�����Ҫnewһ���µĶ��󣬿���ֱ��ʹ��
public class HttpDriver {
	static String b_url = "http://127.0.0.1:9999";

	public static String doGet(String url, String para) throws ClientProtocolException, IOException {
		// ����HTTPclient����
		CloseableHttpClient client = HttpClients.createDefault();
		// �����������HTTPget����
		HttpGet httpget = new HttpGet(b_url + url + "?" + para);
		httpget.setHeader("Content-Type", "application/json");
		// ִ�����󣬻����Ӧ
		CloseableHttpResponse response = client.execute(httpget);
		// ��ӡ״̬��
		System.out.println(response.getStatusLine());
		// ��ȡ��Ӧʵ��
		HttpEntity entity1 = response.getEntity();
		// ��ȡ��Ӧ����
		String result = EntityUtils.toString(entity1, "UTF-8");
		// �ͷ���Դ
		EntityUtils.consume(entity1);
		// �Ͽ�����
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
		// ����HTTPclient����
		CloseableHttpClient client = HttpClients.createDefault();
		// �����������HTTPget����
		HttpGet httpget = new HttpGet(b_url + url);
		httpget.setHeader("Content-Type", "application/json");
		// ִ�����󣬻����Ӧ
		CloseableHttpResponse response = client.execute(httpget);
		// ��ӡ״̬��
		System.out.println(response.getStatusLine());
		// ��ȡ��Ӧʵ��
		HttpEntity entity1 = response.getEntity();
		// ��ȡ��Ӧ����
		String result1 = EntityUtils.toString(entity1, "UTF-8");
		System.out.println(result1);
		// �ͷ���Դ
		EntityUtils.consume(entity1);
		// �Ͽ�����
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

	// �̶���������
	public static String doPost(String body, String url) throws ParseException, IOException {
		// ����httpclient����
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// �����������ַ��httppost����
		HttpPost httpPost = new HttpPost(b_url + url);
		// ����httppost��������
		httpPost.setHeader("Content-Type", "application/json");
		// ����httppost�����ݣ����õ�¼����---������
		StringEntity entity = new StringEntity(body);
		httpPost.setEntity(entity);
		CloseableHttpResponse response2 = httpclient.execute(httpPost);
		// ��ӡ״̬��
		System.out.println(response2.getStatusLine());
		// ��ȡ��Ӧʵ��
		HttpEntity entity2 = response2.getEntity();
		// ��ȡ��Ӧ����
		String result = EntityUtils.toString(entity2);
		System.out.println(result);
		// �ͷ���Դ
		EntityUtils.consume(entity2);
		// �Ͽ�����
		response2.close();
		httpclient.close();
		return result;
	}

	public static String cookiePost(String url, String body, CookieStore cookie) throws ParseException, IOException {
		//����һ����cookie��Ϣ��client����
		RequestConfig gConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(gConfig)
				.setDefaultCookieStore(cookie).build();
		
		HttpPost httpPost = new HttpPost(b_url + url);
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setHeader("csrfToken","csrfToken");//-------------------------------------------Ҫע����仰ѽ���ܶ�ʱ��û�����޷��ɹ�post
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
