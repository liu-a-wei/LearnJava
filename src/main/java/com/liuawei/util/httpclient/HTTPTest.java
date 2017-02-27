package com.liuawei.util.httpclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class HTTPTest {

	public static void main(String[] args) throws IOException {
		testGet();
		testGetParam();
	}

	/**
	 * 测试get请求--不带参数
	 */
	private static void testGet() {
		String test = HTTPUtil.doGet("http://127.0.0.1:8080/eachrent/user/login");
		System.out.println(test);
	}
	/**
	 * 测试get请求--带参数
	 */
	private static void testGetParam() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userName", "liuawei");
		param.put("password", "password");
		String test = HTTPUtil.doGet("http://127.0.0.1:8080/eachrent/user/login",param);
		System.out.println(test);
	}
	/**
	 * 测试get请求--获取文件流 -- 未测试通过
	 */
	private static void testGetStream() {
		InputStream in = HTTPUtil.doGetStream("http://127.0.0.1:8080/eachrent/user/stream");
		
		System.out.println(in);
	}
}
