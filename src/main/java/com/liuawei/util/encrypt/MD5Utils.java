package com.liuawei.util.encrypt;

import java.security.MessageDigest;

public final class MD5Utils {
	
	public static String encrypt(String input){
		MessageDigest md5 = null;
		try{
			md5 = MessageDigest.getInstance("MD5");
			byte [] b = md5.digest(input.getBytes());
			StringBuffer str = new StringBuffer();
			for(int i = 0; i < b.length; i++){
				int val = b[i] & 0xFF;
				if(val<16){
					str.append("0");
				}
				str.append(Integer.toHexString(val));
			}
			return str.toString();
		}catch(Exception e){
			// TODO: handle exception
		}
		return "";
	}
}
