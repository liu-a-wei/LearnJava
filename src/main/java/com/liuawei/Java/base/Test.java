package com.liuawei.Java.base;

public class Test {

	public static void main(String[] args) {

		String str1 = "普付宝微信";
		String str2 = "威富通微信";
		String str3 = "微信";
		
		if (str1.contains(str2)) {
			System.out.println(str1.contains(str2));
		}
		if (str3.contains(str2)) {
			System.out.println(str3.contains(str2));
		}
		if (str2.contains(str3)) {
			System.out.println("str2.contains(str3)");
		}
	}

}
