package com.liuawei.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	
	/*
	 * 获取HTTPClient
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
	 * get 请求
	 * @return 
	 */
	public static String doGet(String url,int connectionType,Map<String, Object> params){
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
					System.out.println(httpEntity.getContent());
					System.out.println(response.getEntity().toString());
					result = IOUtils.toString(httpEntity.getContent(), "UTF-8");
				}else{
					// 请求失败
				}
			}else{
				// 请求失败
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
	
	/*
	 * get 文件请求
	 */
	public static InputStream doGetWithFile(String url,int connectionType,Map<String, Object> params){
		String apiUrl="";
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
		InputStream result = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = (CloseableHttpClient) getHTTPClient(connectionType);
		try{
			HttpGet httpGet = new HttpGet(apiUrl);
			response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HTTP_STATUS_OK){
				HttpEntity httpEntity = response.getEntity();
				if(httpEntity != null){
					result = httpEntity.getContent();
				}
			}
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
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
