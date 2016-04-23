package com.liuawei.http;

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
	 * 鍙戦�乬et璇锋眰
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
			//1:閫氳繃鍦� URL 涓婅皟鐢� openConnection 鏂规硶鍒涘缓杩炴帴瀵硅薄銆�
			HttpURLConnection connection = (HttpURLConnection) reqUrl.openConnection();
			//2:澶勭悊璁剧疆鍙傛暟鍜屼竴鑸姹傚睘鎬с��
			connection.setRequestMethod("GET");
			connection.setAllowUserInteraction(true);
			connection.setDoInput(true);
			connection.setConnectTimeout(5000);
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.setRequestProperty("User-Agent:", "Mozilla/5.0 (Windows NT 6.1; WOW64)");
			//3:浣跨敤 connect 鏂规硶寤虹珛鍒拌繙绋嬪璞＄殑瀹為檯杩炴帴銆�
			connection.connect();
			// 4锛氳幏鍙栫粨鏋�
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
	 * 鍙戦�丳OST璇锋眰
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
			//1:閫氳繃鍦� URL 涓婅皟鐢� openConnection 鏂规硶鍒涘缓杩炴帴瀵硅薄銆�
			HttpURLConnection connection = (HttpURLConnection) reqUrl.openConnection();
			//2:澶勭悊璁剧疆鍙傛暟鍜屼竴鑸姹傚睘鎬с��
			connection.setRequestMethod("POST");
			connection.setAllowUserInteraction(true);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setConnectTimeout(5000);
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.setRequestProperty("User-Agent:", "Mozilla/5.0 (Windows NT 6.1; WOW64)");
			//3:浣跨敤 connect 鏂规硶寤虹珛鍒拌繙绋嬪璞＄殑瀹為檯杩炴帴銆�
			connection.getOutputStream().write(paramers.getBytes());
			connection.connect();
			// 4锛氳幏鍙栫粨鏋�
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
	 * 鎷兼帴璇锋眰鍙傛暟
	 * @param str
	 * @param flag -- 鏄惁闇�瑕侊紵鍙�
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
	 * 杈撳嚭璇锋眰缁撴灉
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
