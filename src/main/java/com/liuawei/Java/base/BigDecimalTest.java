package com.liuawei.Java.base;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args){
		BigDecimal bigDecimal = new BigDecimal("1000").subtract(new BigDecimal("6")).divide(new BigDecimal("1000"));
		System.out.println(bigDecimal.toString());
		System.out.println(100f-2.5f);
	}
}
