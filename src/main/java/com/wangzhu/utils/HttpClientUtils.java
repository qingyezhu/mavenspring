package com.wangzhu.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtils {

	private static final Logger logger = LoggerFactory
			.getLogger(HttpClientUtils.class);
	public static final int HTTP_CON_TIME_OUT = 5000;
	public static final int HTTP_SO_TIME_OUT = 5000;
	public static final int HTTP_MAX_CONNECTIONS = 1000;

	/**
	 * 每个路由最大连接数
	 */
	public static final int MAX_ROUTE_CONNECTIONS = 100;
	public static PoolingClientConnectionManager cm = new PoolingClientConnectionManager();
	public static HttpParams params = new BasicHttpParams();
	public static HttpClient httpClient;
	static {
		HttpConnectionParams.setSoTimeout(HttpClientUtils.params,
				HttpClientUtils.HTTP_SO_TIME_OUT);
		HttpConnectionParams.setConnectionTimeout(HttpClientUtils.params,
				HttpClientUtils.HTTP_CON_TIME_OUT);

		HttpClientUtils.cm
				.setDefaultMaxPerRoute(HttpClientUtils.MAX_ROUTE_CONNECTIONS);
		HttpClientUtils.cm.setMaxTotal(HttpClientUtils.MAX_ROUTE_CONNECTIONS);

		HttpClientUtils.httpClient = new DefaultHttpClient(HttpClientUtils.cm,
				HttpClientUtils.params);
	}

	public static String getHttpResult(String url) {
		StopWatch clock = new StopWatch();
		clock.start();
		HttpClientUtils.logger
				.info("HttpClientUtils getHttpResult url={}", url);
		HttpGet httpGet = new HttpGet(url);
		String result = null;
		try {
			HttpResponse response = HttpClientUtils.httpClient.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				result = EntityUtils.toString(httpEntity, "UTF-8");
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpGet.abort();
		}
		clock.stop();
		long executeTime = clock.getTime();
		HttpClientUtils.logger.debug(
				"HttpClientUtils getHttpResult url={},result={}", new Object[] {
						url, result });
		HttpClientUtils.logger.debug(
				"HttpClientUtils getHttpResult url={},executeTime={}ms",
				new Object[] { url, executeTime });
		return result;
	}

	public static String postData(String url, String input) {
		return HttpClientUtils.postData(url, input, "UTF-8");
	}

	public static String postData(String url, String input, String encoding) {
		return HttpClientUtils.postData(url, input, encoding, true);
	}

	public static String postData(String url, String input, String encoding,
			boolean isSetHeader) {
		StopWatch clock = new StopWatch();
		clock.start();
		HttpClientUtils.logger.info(
				"HttpClientUtils postData url={},inputData={},encode={}",
				new Object[] { url, input, encoding });

		HttpPost httpPost = new HttpPost(url);
		if (isSetHeader) {
			// 当接收第三方POST的参数时，若不设置，则不成功
			httpPost.setHeader("Content-Type",
					"application/x-www-form-urlencoded");
		}
		String result = null;
		try {
			StringEntity stringEntity = new StringEntity(input);
			stringEntity.setContentEncoding(encoding);
			httpPost.setEntity(stringEntity);
			HttpResponse response = HttpClientUtils.httpClient
					.execute(httpPost);
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				result = EntityUtils.toString(httpEntity, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpPost.abort();
		}
		clock.stop();
		long executeTime = clock.getTime();
		HttpClientUtils.logger.info(
				"HttpClientUtils postData url={},executeTime={}ms",
				new Object[] { url, executeTime });
		HttpClientUtils.logger.info(
				"HttpClientUtils postData url={},executeTime={}ms,result={}",
				new Object[] { url, executeTime, result });
		return result;
	}
}
