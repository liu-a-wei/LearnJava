package com.liuawei.util.json;

import java.util.Random;

public class test {

	public static void main(String[] args) {
//		Integer a = -129;
//		Integer b = -129;
//		System.out.println("值相等："+(a.intValue()==b.intValue()));
//		System.out.println("引用相等："+(a==b));
//		Integer c = 220;
//		Integer d = 220;
//		System.out.println("值相等："+(c.intValue()==d.intValue()));
//		System.out.println("引用相等："+(c==d));
		
		for(int i = 0; i < 50; i++){
			System.out.println(new Random().nextInt(100));
		}
	}

}
