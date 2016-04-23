package com.liuawei.encrypt;

import java.security.MessageDigest;

public final class SHAUtil {
	
	public static String encrypt(String input){
		MessageDigest sha = null;
		try{
			sha  = MessageDigest.getInstance("SHA");
			byte [] b = sha.digest(input.getBytes());
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
