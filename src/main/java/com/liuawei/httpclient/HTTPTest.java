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

import com.mysql.jdbc.Buffer;

public class HTTPTest {

	public static void main(String[] args) throws IOException {
		//test get
		String str1 = HTTPUtil.doGet("http://10.10.1.38:9021/p?service=prvdocchat&operation=sessionMemberList&sessionId=13");
		System.out.println(str1);
		Map<String, Object> params = new HashMap<>();
		params.put("service", "prvdocchat");
		params.put("operation", "sessionMemberList");
		params.put("sessionId", 13);
		params.put("token", "U166151463996963a052d61bcabc6416a215d403ed30790b");
		String str2 = HTTPUtil.doGet("http://10.10.1.38:9021/p", params);
		System.out.println(str2);
		
//		InputStream in = HTTPUtil.doGetStream("http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=XaGbzU_p6h5Erq5mpqGfLey-tSDuhO2wlBff5ua7UXKrbmeMNZQkPGaQK-X5ggU6LO5EWWVXJrfIc4SNvzs1uW6nkMbipoomFGeG8mbsRbXiBJBzjLuoor6R5S6bdCXnDRCcAEAZNY&media_id=us6I_CBRsDD9_-FJhrc6q9LN4LyaiKEDMi-B6eCHX0ziz4Rb3CN8hZ2nrUgKSqpX");
//		byte[]  buffer = new byte[1024];
//		File file = new File("D:\\data\\yipeng");
//		if(!file.exists()){
//			file.mkdirs();
//		}
//		FileOutputStream  os  = new FileOutputStream(file.getPath()+"\\"+"\\test.jpeg");
//		int readLine = 0;
//		while((readLine=in.read(buffer))!=-1){
//			os.write(buffer,0,readLine);
//		}
//		os.close();
//		in.close();
		/*
		 * String isWexin = request.getParameter("isWexin");
			if(isWexin.equals("1")){
				// 微信端获取post参数
				sessionId = request.getParameter("sessionId");
				String sessionType = request.getParameter("sessionType");
				if(StringUtil.isBlank(sessionId)&&sessionType.equals("1")){
					sessionId = (String) JsonUtil.toMap((String)JsonUtil.toMap(createFreeConsultSession(clientId)).get("data")).get("sessionId");
				}
				text = request.getParameter("text");
				String image = request.getParameter("images");
				if(!StringUtil.isBlank(image)){
					images = WeiXinHelperUtil.uploadPicture(image, clientId, 4, Constants.PREFIX_CHAT);
				}
			}
		 */
		HashMap<String, Object> params2 = new HashMap<>();
		params2.put("isWexin", 1);
		params2.put("sessionId", 15);
		params2.put("sessionType", 2);
		params2.put("text", 2);
		params.put("token", "U166151463996963a052d61bcabc6416a215d403ed30790b");
		String str4 = HTTPUtil.doPost("http://10.10.1.38:9021/p?service=prvdocchat&operation=sendSessionMessage", HTTPUtil.HTTP_CONNECTION_TYPE_COMMON, params2);
		System.out.println(str4);
	}

}
