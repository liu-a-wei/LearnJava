package com.liuawei.util.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import com.liuawei.util.httpclient.HTTPUtil;


public class TestHttPUtils {
	
	public static void main(String[] args){
		byte[] str = HTTPUtil.doGetStream("http://yp.image.imingyi.com/doctor/headpic/2014/10/10/D_20141010100119985_0.jpg");
		// response.setHeader("Pragma", "No-cache");
		// response.setHeader("Cache-Control", "no-cache");
		try{
			byte[] buffer = new byte[1024];
			int len = -1;
			FileOutputStream fos = new FileOutputStream(new File("E:\\1"+new Random().nextInt(1000)+".jpg"));
			
			fos.write(str);
			
			fos.flush();
			fos.close();
		}catch(Exception e){
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
