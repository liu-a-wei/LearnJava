package com.liuawei.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
	
	public static void main(String[] args) {
		try {
			String string = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&tn=94400354_hao_pg&wd=%E5%88%98%E5%AE%89%E6%85%B0&oq=URL%26gt%3Bncoder&rsv_pq=8cdd43a6000afe5a&rsv_t=7ba6UNgQ3PEINR8u8V2yIcS4NuTMpd%2FGomDdpQ4oL9biYXvGjmHpm9TsvyXPHQW64ZPNgR9E&rsv_enter=0&inputT=6985&rsv_sug3=20&rsv_sug1=26&rsv_sug7=100&rsv_sug2=0&rsv_sug4=8158";
			System.out.println(URLEncoder.encode(string,"UTF-8"));
			System.out.println(URLDecoder.decode(string,"UTF-8"));
			
			InetAddress[] inetAddresses = InetAddress.getAllByName("www.baidu.com");
			for (int i = 0; i < inetAddresses.length; i++) {
				InetAddress inetAddress = inetAddresses[i];
				System.out.println(""+inetAddress.getHostAddress());
				System.out.println(""+inetAddress.getHostName());
				System.out.println(""+inetAddress.getAddress().length);
				System.out.println(""+InetAddress.getLocalHost());
				
			}
			URL url1 = new URL("https://www.baidu.com/s?ie=UTF-8&tn=94400354_hao_pg&wd=66");
			System.out.println("协议："+url1.getProtocol());
			System.out.println(""+url1.toExternalForm());
			System.out.println(""+url1.toString());
			System.out.println("用户信息"+url1.getUserInfo());
			System.out.println("域名"+url1.getAuthority());
			System.out.println(""+url1.getContent());
			System.out.println("默认端口"+url1.getDefaultPort());
			System.out.println("文件路径"+url1.getFile());
			System.out.println("主机"+url1.getHost());
			System.out.println("端口"+url1.getPort());
			System.out.println("查询"+url1.getQuery());
			System.out.println("查询"+url1.getRef());
			System.out.println("端口"+url1.toURI());
			URL url2 = new URL("https","www.baidu.com",443,"/s?ie=UTF-8&tn=94400354_hao_pg&wd=66");
			System.out.println("端口"+url2.toURI());
			System.out.println(url1.sameFile(url2));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
