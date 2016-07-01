package com.liuawei.string;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "-,-";
		String [] strArr =  str1.split(",");
		System.out.println(strArr.length);
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
	}

}
