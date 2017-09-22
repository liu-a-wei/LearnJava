package com.liuawei.Java.commonslang;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringUtilsDL {
	public static void main(String[] args){
		System.out.println(RandomStringUtils.random(10).toString()); 
		System.out.println(RandomStringUtils.random(8, '6','8')); 
		System.out.println(RandomStringUtils.random(6, "我爱刘卫军哈哈")); 
		System.out.println(RandomStringUtils.random(6, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,./")); 
		System.out.println(RandomStringUtils.random(6, "walwjhh")); 
		System.out.println(RandomStringUtils.random(6, false, true));
		System.out.println(RandomStringUtils.random(6, true, false));
		System.out.println(RandomStringUtils.random(6, true, true));
		System.out.println(RandomStringUtils.random(6, 0, 5, false, true));
		System.out.println(RandomStringUtils.randomAlphabetic(6));
		System.out.println(RandomStringUtils.randomAscii(6));
		System.out.println(RandomStringUtils.randomNumeric(6));
	}
}
