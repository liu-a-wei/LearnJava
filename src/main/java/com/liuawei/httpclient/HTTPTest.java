package com.liuawei.httpclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.mysql.jdbc.Buffer;

public class HTTPTest {

	public static void main(String[] args) throws IOException {
		//test get
		/*
		 * get 请求
		 */
		String str1 = HTTPUtil.doGet("http://10.10.1.38:9021/p?service=prvdocchat&operation=sessionMemberList&sessionId=13");
		System.out.println(str1);
		/*
		 * get 请求  -- 带参数
		 */
		Map<String, Object> params = new HashMap<>();
		params.put("service", "prvdocchat");
		params.put("operation", "sessionMemberList");
		params.put("sessionId", 13);
		params.put("token", "U166151463996963a052d61bcabc6416a215d403ed30790b");
		String str2 = HTTPUtil.doGet("http://10.10.1.38:9021/p", params);
		System.out.println(str2);

		/*
		 * post 请求 参数
		 */
		HashMap<String, Object> params2 = new HashMap<>();
		params2.put("sessionId", 1);
		params2.put("msgType", 15);
		// content:{"text":} 
		params2.put("content", new JSONObject().put("text", "测试一下").toString());
//		params.put("token", "");
		String str3 = HTTPUtil.doPost("http://10.10.1.38:9021/p?service=prvdocchat&operation=sendSessionMessage&token=U166151463996963a052d61bcabc6416a215d403ed30790b", params2);
		System.out.println(str3);
		/*
		 * post 请求 文件
		 */
	}

}
