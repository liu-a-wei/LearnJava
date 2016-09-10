package com.liuawei.util.json;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {
		String tradeDate = "9.01我试一下";
		int indexOf = tradeDate.lastIndexOf(".");
		String regEx="[^0-9]";   
		Pattern p = Pattern.compile(regEx);   
		Matcher m = p.matcher(tradeDate);   
		tradeDate = m.replaceAll("").trim();
		tradeDate = tradeDate.substring(0, indexOf)+"月"+tradeDate.substring(indexOf)+"日";
		System.out.println(tradeDate);
	}

}
