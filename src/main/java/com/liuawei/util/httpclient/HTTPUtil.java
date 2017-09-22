package com.liuawei.util.httpclient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
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
	
	/** 参数类型--xml*/
	public static int PARAMTYPE_XML = 1;
	/** 参数类型 --json*/
	public static int PARAMTYPE_JSON = 2;
	/** 参数类型 --map*/
	public static int PARAMTYPE_MAP = 3;
	/** 参数类型 --file*/
	public static int PARAMTYPE_FILE = 4;
	
	
	public static String DEFAULT_HEADER ="text/html; charset=UTF-8";
	
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
		return (String) doGet(url,HTTPUtil.HTTP_CONNECTION_TYPE_COMMON,new HashMap<String,Object>(),HTTPUtil.RESULT_STRING,DEFAULT_HEADER);
	}
	
	/**
	 * 默认请求方式 ，带参数
	 * @param url
	 * @return String
	 */
	public static String doGet(String url,Map<String, Object> params){
		return (String) doGet(url,HTTPUtil.HTTP_CONNECTION_TYPE_COMMON,params,HTTPUtil.RESULT_STRING,DEFAULT_HEADER);
	}
	
	/**
	 * 默认请求方式 ，带参数,获取流
	 * @param url
	 * @return String
	 */
	public static byte[] doGetStream(String url){
		return (byte[]) doGet(url,HTTPUtil.HTTP_CONNECTION_TYPE_COMMON,new HashMap<String,Object>(),HTTPUtil.RESULT_STREAM,DEFAULT_HEADER);
	}
	
	/**
	 * 默认请求方式 ，带参数,获取流
	 * @param url
	 * @return String
	 */
	public static InputStream doGetStream(String url,Map<String, Object> params){
		return (InputStream) doGet(url,HTTPUtil.HTTP_CONNECTION_TYPE_COMMON,params,HTTPUtil.RESULT_STREAM,DEFAULT_HEADER);
	}

	/**
	 * get请求
	 * @param url
	 * @param connectionType
	 * @param params
	 * @param resultForm
	 * @return
	 */
	public static Object doGet(String url,int connectionType,Map<String, Object> params,int resultForm,String headers){
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
			httpGet.setHeader( "Content-Type", headers);
			HttpResponse response = httpClient.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HTTP_STATUS_OK){
				HttpEntity httpEntity = response.getEntity();
				if(httpEntity != null){
					if(resultForm==HTTPUtil.RESULT_STREAM){
						InputStream in = httpEntity.getContent();
						byte[] buffer = new byte[1024];
						int len = -1;
						ByteArrayOutputStream fos = new ByteArrayOutputStream();
						while((len = in.read(buffer)) != -1){
							fos.write(buffer, 0, len);
						}
						fos.flush();
						fos.close();
						return fos.toByteArray();
					}else{
						result = EntityUtils.toString(httpEntity,"UTF-8");
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
	 * 默认请求方式 ，提交json数据
	 * @param url
	 * @param json
	 * @return
	 */
	public static String doPostJson(String url,Object json) {
		return doPost(url, HTTPUtil.HTTP_CONNECTION_TYPE_COMMON, json,HTTPUtil.PARAMTYPE_JSON);
	}
	/**
	 * 默认请求方式 ，提交xml数据
	 * @param url
	 * @param xml
	 * @return
	 */
	public static String doPostXML(String url,String xml) {
		return doPost(url, HTTPUtil.HTTP_CONNECTION_TYPE_COMMON, xml,HTTPUtil.PARAMTYPE_XML);
	}
	
	/**
	 * 默认请求方式 ，数据以key-value键值对存储
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url,Map<String, Object> params) {
		return doPost(url, HTTPUtil.HTTP_CONNECTION_TYPE_COMMON, params,HTTPUtil.PARAMTYPE_MAP);
	}
	/**
	 * 默认请求方式 ，数据以key-value键值对存储
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPostStream(String url,Map<String, Object> params) {
		return doPost(url, HTTPUtil.HTTP_CONNECTION_TYPE_COMMON, params,HTTPUtil.PARAMTYPE_FILE);
	}
	
	/**
	 * 默认请求方式 ，上传Multipart
	 * @param url
	 * @param params -- text
	 * @param fileParams -- file
	 * @return
	 */
	public static String doPostMultipart(String url,Map<String, String> params,Map<String, String> fileParams) {
		return doPostMultipart(url, HTTPUtil.HTTP_CONNECTION_TYPE_COMMON, params,fileParams);
	}
	/**
	 * post 请求
	 * @param url
	 * @param connectionType
	 * @param params key-value 键值对
	 * @param paramType 参数类型
	 * @return
	 */
	public static String doPost(String url,int connectionType,Map<String, Object> params,int paramType){
		String result = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = (CloseableHttpClient) getHTTPClient(connectionType); 
		HttpPost httpPost = new HttpPost(url);
		try{
			if(paramType==HTTPUtil.PARAMTYPE_MAP){
				List<NameValuePair> paramList = new ArrayList<>();
				NameValuePair pair = null;
				for(Map.Entry<String, Object> entry : params.entrySet()){
					pair = new BasicNameValuePair(entry.getKey(),  entry.getValue().toString());
					paramList.add(pair);
				}
				httpPost.setEntity(new UrlEncodedFormEntity(paramList,"UTF-8"));
			}else if(paramType==HTTPUtil.PARAMTYPE_FILE) {
				MultipartEntityBuilder  meb = MultipartEntityBuilder.create();
				for(Map.Entry<String, Object> entry : params.entrySet()){
					meb.addBinaryBody(entry.getKey(), new File((String)entry.getValue()));
				}
				meb.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
				HttpEntity entity = meb.build();
				httpPost.setEntity(entity);
			}else{
				// 无效的参数
			}
//			httpPost.setHeader("Content-Type", "text/html; charset=UTF-8");
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
	 * @param params 
	 * @param paramType 参数类型
	 * @return
	 */
	public static String doPost(String url,int connectionType,Object params,int paramType){
		String result = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = (CloseableHttpClient) getHTTPClient(connectionType); 
		HttpPost httpPost = new HttpPost(url);
		try{
			StringEntity str  = new StringEntity(params.toString(), "UTF-8");
			str.setContentEncoding("UTF-8");
			if(paramType==HTTPUtil.PARAMTYPE_XML){
				str.setContentType("application/json");
			}else if(paramType==HTTPUtil.PARAMTYPE_JSON){
				str.setContentType("application/json");
			}
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
	 * @param params key-value 键值对
	 * @param paramType 参数类型
	 * @return
	 */
	public static String doPostMultipart(String url,int connectionType,Map<String, String> params,Map<String, String> fileParams){
		String result = null;
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = (CloseableHttpClient) getHTTPClient(connectionType); 
		HttpPost httpPost = new HttpPost(url);
		try {
			MultipartEntityBuilder meb = MultipartEntityBuilder.create();
			//text 参数拼接
			for (Map.Entry<String, String> entry : params.entrySet()) {
				meb.addTextBody(entry.getKey(), entry.getValue(), ContentType.DEFAULT_TEXT);
			}
			//binaray 参数拼接
			for (Map.Entry<String, String> entry : fileParams.entrySet()) {
				meb.addBinaryBody(entry.getKey(), new File(entry.getValue()));
			}
			meb.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			HttpEntity entity = meb.build();
			httpPost.setEntity(entity);
			response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HTTP_STATUS_OK) {
				HttpEntity httpEntity = response.getEntity();
				if (httpEntity != null) {
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
}
