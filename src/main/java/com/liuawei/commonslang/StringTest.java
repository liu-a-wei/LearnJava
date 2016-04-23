package com.liuawei.commonslang;

import org.apache.commons.lang3.StringUtils;

public class StringTest {
	public static final String SPACE = " ";
	public static final String EMPTY = "";
	public static final String LF = "\n";
	public static final String CR = "\r";
	private static final int PAD_LIMIT = 8192;
	public static final int INDEX_NOT_FOUND = -1;

	public static void main(String[] args) {
		String str1 = null;
		String str2 = "";
		String str3 = " ";
		String str4 = "null";
		String str5 = "         ";
		String str6 = "123";
		String str7 = " 4456";
		/*
		 * trimToEmpty null转换为“”
		 */
		System.out.println(StringUtils.trimToEmpty(str1));
		System.out.println(StringUtils.trimToEmpty(str2));
		System.out.println(StringUtils.trimToEmpty(str3));
		System.out.println(StringUtils.trimToEmpty(str4));
		System.out.println(StringUtils.trimToEmpty(str6));
		System.out.println(StringUtils.trimToEmpty(str7));
		System.out.println("trimToEmpty()");
		/*
		 * 去掉空格
		 */
		System.out.println(StringUtils.trim(str1));
		System.out.println(StringUtils.trim(str2));
		System.out.println(StringUtils.trim(str3));
		System.out.println(StringUtils.trim(str4));
		System.out.println(StringUtils.trim(str5));
		System.out.println("trim()");
		/*
		 * isBlank null 空字符串 空格
		 */
		System.out.println(StringUtils.isBlank(str1));
		System.out.println(StringUtils.isBlank(str2));
		System.out.println(StringUtils.isBlank(str3));
		System.out.println(StringUtils.isBlank(str4));
		System.out.println(StringUtils.isBlank(str5));
		System.out.println("isBlank()");
		/*
		 * isEmpty 是null或者是空字符串
		 */
		System.out.println(StringUtils.isEmpty(str1));
		System.out.println(StringUtils.isEmpty(str2));
		System.out.println(StringUtils.isEmpty(str3));
		System.out.println(StringUtils.isEmpty(str4));
		System.out.println("isEmpty()");
	}

	public static boolean isEmpty(final CharSequence cs) {
		return cs == null || cs.length() == 0;
	}

	public static boolean isBlank(final CharSequence cs) {
		int strLen = cs.length();
		if (cs == null || strLen == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(cs.charAt(i)) == false) {
				return false;
			}
		}
		return true;
	}
	public static String trim(final String str) {
		return str == null? null :str.trim();
	}
	public static String trimToEmpty(final String str) {
		return str == null ? EMPTY : str.trim();
	}

}
