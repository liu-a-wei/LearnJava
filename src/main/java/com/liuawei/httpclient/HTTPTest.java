package com.liuawei.httpclient;

import java.util.HashMap;

public class HTTPTest {

	public static void main(String[] args) {
		//test get
		String string = HTTPUtil.doGet("http://10.10.1.38:9021/p?service=prvdocchat&operation=getSessionList&sessionType=1&isValid=1&token=D258146399105308308ddf27bc8c2fd1c356de0b1b5aa8", HTTPUtil.HTTP_CONNECTION_TYPE_COMMON, new HashMap<String,Object>());
		System.out.println(string);
	}

}
