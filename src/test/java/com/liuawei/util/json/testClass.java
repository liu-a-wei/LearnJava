package com.liuawei.util.json;import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testClass {

	public static void main(String[] args) {
		String str = "user/doLogin,user/findPassword";
		System.out.println(Arrays.asList(str.split(",")));
		List<String> arrayList = Arrays.asList(str.split(","));
		System.out.println(Arrays.asList(arrayList.toString()));

	}

}
