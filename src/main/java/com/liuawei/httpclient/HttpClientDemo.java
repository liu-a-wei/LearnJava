package com.liuawei.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {
	
	public static void  main(String[] args) throws ClientProtocolException, IOException {
		//get 请求
		HttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet("https://www.baidu.com/");
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		if(entity!=null){
			System.out.println(entity.getContent());
		}
		System.out.println(response.toString());
//        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
//            @Override
//            public String handleResponse(
//                    final HttpResponse response) throws ClientProtocolException, IOException {
//                int status = response.getStatusLine().getStatusCode();
//                if (status >= 200 && status < 300) {
//                    HttpEntity entity = response.getEntity();
//                    return entity != null ? EntityUtils.toString(entity) : null;
//                } else {
//                    throw new ClientProtocolException("Unexpected response status: " + status);
//                }
//            }
//
//        };
//        String responseBody;
//		try{
//			responseBody = client.execute(get, responseHandler);
//	        System.out.println("----------------------------------------");
//	        System.out.println(responseBody);
//		}catch(IOException e){
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
