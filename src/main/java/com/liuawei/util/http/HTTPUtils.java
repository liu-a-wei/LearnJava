package com.liuawei.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HTTPUtils {
	
	/**
	 * 发送get请求
	 * @param url
	 * @param paramers
	 * @return 
	 */
	public static  HashMap<String, Object> sendGet(String url,String paramers) {
		if(paramers!=null&&!paramers.equals("")){
			url += paramers;
		}
		try {
			URL reqUrl = new URL(url);
			//1:通过在 URL 上调用 openConnection 方法创建连接对象。
			HttpURLConnection connection = (HttpURLConnection) reqUrl.openConnection();
			//2:处理设置参数和一般请求属性。
			connection.setRequestMethod("GET");
			connection.setAllowUserInteraction(true);
			connection.setDoInput(true);
			connection.setConnectTimeout(5000);
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.setRequestProperty("User-Agent:", "Mozilla/5.0 (Windows NT 6.1; WOW64)");
			//3:使用 connect 方法建立到远程对象的实际连接。
			connection.connect();
			//4远程对象的头字段和内容变为
			return result(connection);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		return null;
	}
	/**
	 * 发送post请求
	 * @param url
	 * @param paramers
	 * @return
	 */
	public static HashMap<String, Object> sendPost(String url,String paramers) {
		if(paramers!=null&&!paramers.equals("")){
			url += paramers;
		}
		try {
			URL reqUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) reqUrl.openConnection();
			connection.setRequestMethod("POST");
			connection.setAllowUserInteraction(true);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setConnectTimeout(5000);
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.setRequestProperty("User-Agent:", "Mozilla/5.0 (Windows NT 6.1; WOW64)");
			connection.getOutputStream().write(paramers.getBytes());
			connection.connect();
			return result(connection);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
		}
		return null;
	}
	/**
	 * 构建请求参数
	 * @param str
	 * @param flag 
	 * @return
	 * @throws IOException
	 */
	public static String bulidParamers(HashMap<String, String> str,boolean flag) {
		StringBuffer paramers = new StringBuffer();
		if(str==null){
			return "";
		}
		for (String key : str.keySet()) {
			paramers.append("&"+key+"="+str.get(key));
		}
		return flag==true?"?"+paramers.toString():paramers.toString();
	}
	/**
	 * 构建返回结果
	 * @param connection
	 * @return
	 * @throws IOException
	 */
	private static HashMap<String, Object> result(HttpURLConnection connection) throws IOException {
		String result = "";
		BufferedReader in;
		HashMap<String, Object> map;
		map = new HashMap<String,Object>();
		int status =connection.getResponseCode();
		Map<String, List<String>>  headers  = connection.getHeaderFields();
		in = new BufferedReader(new InputStreamReader(
		        connection.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
		    result += line;
		}
		in.close();
		map.put("status", status);
		map.put("headers", headers);
		map.put("result", result);
		return map;
	}

}
