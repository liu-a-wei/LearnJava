package com.liuawei.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HTTPUtil {
	/** 普通的连接方式*/
	public static int HTTP_CONNECTION_TYPE_COMMON = 1;
	/** SSL 方式*/
	public static int HTTP_CONNECTION_TYPE_SSL = 2;
	/** proxy 方式*/
	public static int HTTP_CONNECTION_TYPE_PROXY = 3;
	
	
	/** HTTP 状态码*/
	public static int HTTP_STATUS_OK = 200;
	
	/** 返回结果 --字符串*/
	public static int RESULT_STRING = 1;
	/** 返回结果 --文件流*/
	public static int RESULT_STREAM = 2;
	
	
	/**
	 * 获取HTTPClient 
	 * @param connectionType -- 连接方式
	 * @return
	 */
	public static HttpClient getHTTPClient(int connectionType){
		switch(connectionType){
		case 1:
			return HttpClients.createDefault();
		default:
			return null;
		}
	}

	/**
	 * 默认请求方式 ，不带参数
	 * @param url
	 * @return String
	 */
	public static String doGet(String url){
		return (String) doGet(url,HTTPUtil.HTTP_CONNECTION_TYPE_COMMON,new HashMap<String,Object>(),HTTPUtil.RESULT_STRING);
	}
	
	/**
	 * 默认请求方式 ，带参数
	 * @param url
	 * @return String
	 */
	public static String doGet(String url,Map<String, Object> params){
		return (String) doGet(url,HTTPUtil.HTTP_CONNECTION_TYPE_COMMON,params,HTTPUtil.RESULT_STRING);
	}
	
	/**
	 * 默认请求方式 ，带参数,获取流
	 * @param url
	 * @return String
	 */
	public static InputStream doGetStream(String url){
		return (InputStream) doGet(url,HTTPUtil.HTTP_CONNECTION_TYPE_COMMON,new HashMap<String,Object>(),HTTPUtil.RESULT_STREAM);
	}
	
	/**
	 * 默认请求方式 ，带参数,获取流
	 * @param url
	 * @return String
	 */
	public static InputStream doGetStream(String url,Map<String, Object> params){
		return (InputStream) doGet(url,HTTPUtil.HTTP_CONNECTION_TYPE_COMMON,params,HTTPUtil.RESULT_STREAM);
	}

	/**
	 * get请求
	 * @param url
	 * @param connectionType
	 * @param params
	 * @param resultForm
	 * @return
	 */
	public static Object doGet(String url,int connectionType,Map<String, Object> params,int resultForm){
		String apiUrl=url;
		StringBuffer param = new StringBuffer();
		int i = 0;
		for(String key : params.keySet()){
			if(i == 0)
				param.append("?");
			else
				param.append("&");
				param.append(key).append("=").append(params.get(key));
				i++;
		}
		apiUrl += param;  
		String result = "";
		CloseableHttpClient httpClient = (CloseableHttpClient) getHTTPClient(connectionType);
		try{
			HttpGet httpGet = new HttpGet(apiUrl);
			HttpResponse response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HTTP_STATUS_OK){
				HttpEntity httpEntity = response.getEntity();
				if(httpEntity != null){
					if(resultForm==HTTPUtil.RESULT_STREAM){
						return httpEntity.getContent();
					}else{
						result = IOUtils.toString(httpEntity.getContent(), "UTF-8");
					}
				}else{
					// 请求无返回值
				}
			}
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				httpClient.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * post 请求
	 * @param url
	 * @param connectionType
	 * @param params key-value 键值对
	 * @return
	 */
	public static String doPost(String url,int connectionType,Map<String, Object> params){
		String result = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = (CloseableHttpClient) getHTTPClient(connectionType); 
		HttpPost httpPost = new HttpPost(url);
		try{
			List<NameValuePair> paramList = new ArrayList<>();
			NameValuePair pair = null;
			for(Map.Entry<String, Object> entry : params.entrySet()){
				pair = new BasicNameValuePair(entry.getKey(), entry.getKey());
				paramList.add(pair);
			}
			httpPost.setEntity(new UrlEncodedFormEntity(paramList));
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HTTP_STATUS_OK){
				HttpEntity httpEntity = response.getEntity();
				if(httpEntity != null){
					result = EntityUtils.toString(httpEntity);
				}
			}
		}catch(Exception e){
			// TODO: handle exception
		}finally {
			try{
				response.close();
				httpClient.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * post 请求
	 * @param url
	 * @param connectionType
	 * @param params json值
	 * @return
	 */
	public static String doPost(String url,int connectionType,Object params){
		String result = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = (CloseableHttpClient) getHTTPClient(connectionType); 
		HttpPost httpPost = new HttpPost(url);
		try{
			StringEntity str  = new StringEntity(params.toString(), "UTF-8");
			str.setContentEncoding("UTF-8");
			str.setContentType("application/json");
			httpPost.setEntity(str);
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HTTP_STATUS_OK){
				HttpEntity httpEntity = response.getEntity();
				if(httpEntity != null){
					result = EntityUtils.toString(httpEntity);
				}
			}
		}catch(Exception e){
			
		}finally {
			try{
				response.close();
				httpClient.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * post 请求
	 * @param url
	 * @param connectionType
	 * @param params json值
	 * @return
	 */
	public static String doPost(String url,int connectionType,String xml){
		String result = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = (CloseableHttpClient) getHTTPClient(connectionType); 
		HttpPost httpPost = new HttpPost(url);
		try{
			StringEntity str  = new StringEntity(xml.toString(), "UTF-8");
			str.setContentEncoding("UTF-8");
			str.setContentType("application/json");
			httpPost.setEntity(str);
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HTTP_STATUS_OK){
				HttpEntity httpEntity = response.getEntity();
				if(httpEntity != null){
					result = EntityUtils.toString(httpEntity);
				}
			}
		}catch(Exception e){
			
		}finally {
			try{
				response.close();
				httpClient.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * post 文件请求
	 * @return 
	 */
	public static String doPostWithFile(String url,int connectionType,String paths){
		String result = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = (CloseableHttpClient) getHTTPClient(connectionType); 
		HttpPost httpPost = new HttpPost(url);
		try{
//			httpPost.
		}catch(Exception e){
			
		}finally {
			try{
				response.close();
				httpClient.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return result;
	}

}
