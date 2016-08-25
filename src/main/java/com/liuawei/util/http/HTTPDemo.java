package com.liuawei.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HTTPDemo {
	public static void main(String[] args) throws IOException {
		String  str = "https://www.baidu.com/";
		URL url = new URL(str);
		/*
		 * 1:通过在 URL 上调用 openConnection 方法创建连接对象。
		 * 2:处理设置参数和一般请求属性。
		 * 3:使用 connect 方法建立到远程对象的实际连接。
		 * 4:远程对象变为可用。远程对象的头字段和内容变为
		 * 
		 */
		// step 1  创建连接对象
		URLConnection  connection = url.openConnection();
		// step 2 设置请求参数
		/*
		 *使用以下方法修改设置参数：
		 *setAllowUserInteraction
		 *setDoInput
		 *setDoOutput
		 *setIfModifiedSince  -- 把上次服务器告诉它的文件最后修改时间返回到服务器端了。
		 *setUseCaches  -- 缓存
		 *
		 *使用以下方法修改一般请求属性：
		 *setRequestProperty
		 *
		 *使用 setDefaultAllowUserInteraction 和 setDefaultUseCaches 
		 *可设置 AllowUserInteraction 和 UseCaches 参数的默认值。 
		 */
		connection.setAllowUserInteraction(true);
		connection.setDoInput(true);
		connection.setConnectTimeout(5000);
		connection.setRequestProperty("Accept", "*/*");
		connection.setRequestProperty("Connection", "keep-alive");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		connection.setRequestProperty("User-Agent:", "Mozilla/5.0 (Windows NT 6.1; WOW64)");		
		// step 3 连接
		connection.connect();
		// step 4 处理结果
		/*
		 * 在建立到远程对象的连接后，以下方法用于访问头字段和内容：
		 * getContent
		 * getHeaderField
		 * getInputStream
		 * getOutputStream
		 * 
		 * 某些头字段需要经常访问。：
		 * getContentEncoding
		 * getContentLength
		 * getContentType
		 * getDategetExpiration
		 * getLastModifed
		 */
		Map<String, List<String>> map = connection.getHeaderFields();
		System.out.println( connection.getURL());
		
		
		System.out.println("-------------------------");
        // 遍历所有的响应头字段
        for (String key : map.keySet()) {
            System.out.println(key + "--->" + map.get(key));
        }
        BufferedReader in = null;
        String result ="";
        in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        System.out.println(result);
	}
}
