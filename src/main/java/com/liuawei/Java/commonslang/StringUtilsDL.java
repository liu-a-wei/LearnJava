package com.liuawei.Java.commonslang;

import org.apache.commons.lang3.StringUtils;

/**
 * Company: 深圳国康健康管理有限责任公司
 * 
 * @description ：
 * @author liuawei
 * @date 2017年4月17日 上午10:28:56
 */
public class StringUtilsDL {

	/*
	 * IsEmpty/IsBlank - 检查字符串是否有数据 
	 * Trim/Strip - 去掉字符串前面和后面的内容 
	 * Equals/Compare
	 * startsWith /endsWith 
	 * IndexOf/LastIndexOf/Contains
	 * IndexOfAny/LastIndexOfAny/IndexOfAnyBut/LastIndexOfAnyBut
	 * ContainsOnly/ContainsNone/ContainsAny
	 * Substring/Left/Right/Mid
	 * SubstringBefore/SubstringAfter/SubstringBetween Replace/Overlay -
	 * Split/Join
	 * Remove/Delete
	 * Replace/Overlay
	 * Chomp/Chop 
	 * AppendIfMissing 
	 * PrependIfMissing
	 * LeftPad/RightPad/Center/Repeat - 
	 * UpperCase/LowerCase/SwapCase/Capitalize/Uncapitalize - 
	 * CountMatches
	 * IsAlpha/IsNumeric/IsWhitespace/IsAsciiPrintable 
	 * DefaultString
	 * Rotate?
	 * Reverse/ReverseDelimited 
	 * Abbreviate
	 * Difference
	 * LevenshteinDistance
	 */

	public static void main(String[] args) {
		testIndexOf();
	}
	
	/**
	 * 截取字符串
	 */
	public static void testSubLeft(){
		System.out.println(StringUtils.substring("1234567", 2));
		System.out.println(StringUtils.left("1234567", 2));
		System.out.println(StringUtils.right("1234567", 2));
		System.out.println(StringUtils.mid("1234567", 2,4));



	}
	/**
	 * 分割，合并
	 */
	public static void testSplit(){
		System.out.println(StringUtils.split("123,456",",").length);
		System.out.println(StringUtils.join(StringUtils.split("123,456",",")));

	}
	
	/**
	 * 移除包含的字符
	 * 删除空格
	 */
	public static void testRemove(){
		System.out.println(StringUtils.remove("abcdefghj", "e"));
		System.out.println(StringUtils.remove("null", "e"));
		System.out.println(StringUtils.remove(null, "e"));
		System.out.println(StringUtils.deleteWhitespace("    liuawei    "));


	}
	public static void testAppendIfMissing(){
		System.out.println(StringUtils.appendIfMissing(null, null, null));
		System.out.println(StringUtils.appendIfMissing("123", "456", "789"));
		System.out.println(StringUtils.appendIfMissing("刘阿伟", "456", "789"));
		System.out.println(StringUtils.appendIfMissing("刘阿伟789", "456", "789"));
		System.out.println(StringUtils.appendIfMissing("789刘阿伟", "456", "789"));

	}
	
	
	/**
	 * 如果字符串没有后面的数据 在前面补充前面数据
	 */
	public static void testPrependIfMissing(){
		System.out.println(StringUtils.prependIfMissing(null, null, null));
		System.out.println(StringUtils.prependIfMissing("123", "456", "789"));
		System.out.println(StringUtils.prependIfMissing("刘阿伟", "456", "789"));
		System.out.println(StringUtils.prependIfMissing("刘阿伟789", "456", "789"));
		System.out.println(StringUtils.prependIfMissing("789刘阿伟", "456", "789"));
	}
	
	/**
	 * 计算匹配的字符、字符串数量
	 */
	public static void testCountMatches(){
		System.out.println(StringUtils.countMatches("liuawei", 'i'));
		System.out.println(StringUtils.countMatches("liuawei", 'z'));
		System.out.println(StringUtils.countMatches("liuawei", 'a'));
		System.out.println(StringUtils.countMatches(null, 'a'));
		System.out.println(StringUtils.countMatches("a", null));
		System.out.println(StringUtils.countMatches("liuawei", "uw"));

	}
	/**
	 * 是否是数组，字母，空格，ascii,大写，小写
	 */
	public static void testIsXxx(){
		System.out.println(StringUtils.isNumeric("123a"));
		System.out.println(StringUtils.isNumeric("456789"));
		System.out.println(StringUtils.isAlpha("abcdf"));//字母
		System.out.println(StringUtils.isAlpha("123"));
		System.out.println(StringUtils.isWhitespace("123  "));
		System.out.println(StringUtils.isWhitespace("    "));
		System.out.println(StringUtils.isAsciiPrintable("123%&*][][]liu刘卫军"));//ASCII
		System.out.println(StringUtils.isAllLowerCase("ABCDEFG"));
		System.out.println(StringUtils.isAllUpperCase("ABCDEFG"));
	}
	/**
	 * 字符串的默认值  null--""
	 */
	public static void testDefaultString(){
		System.out.println(StringUtils.defaultString(null));
		System.out.println(StringUtils.defaultString(""));
		System.out.println(StringUtils.defaultString("12"));
	}
	
	/**
	 * 字符串  省略号 最大长度是4
	 */
	public static void testAbbreviate(){
		System.out.println(StringUtils.abbreviate("liuaweizuishuai", 5));
		System.out.println(StringUtils.abbreviate("abcdefg", 4));
		System.out.println(StringUtils.abbreviate("l", 4));
		System.out.println(StringUtils.abbreviate("abcd", 4));
		System.out.println(StringUtils.abbreviate("", 4));;
		System.out.println(StringUtils.abbreviate(null, 4));;
		
		System.out.println(StringUtils.abbreviate("abcdefg", 2, 4));
		System.out.println(StringUtils.abbreviate("abcdefg", 3, 4));
		System.out.println(StringUtils.abbreviate("abcdefg23456789", 5, 10));

		System.out.println(StringUtils.abbreviateMiddle("abcdefghijklmnopqrstuvwxyz", "666", 12));
		System.out.println(StringUtils.abbreviateMiddle("abcdef", "6", 3));


	}
	/**
	 * 从左到右挨个字符比对
	 */
	public static void testDifference(){
		System.out.println(StringUtils.difference("aaaaaaaaaaaa", "zzzzzzzzzzzz"));
		System.out.println(StringUtils.difference("ab", "c"));
		System.out.println(StringUtils.difference("abcabc", "abc")+"--");
		System.out.println(StringUtils.difference("i am a machine", "iam a robot" ));
		System.out.println(StringUtils.difference("liuawei", "liuawe i" ));
		System.out.println(StringUtils.difference("liuawei", "zliuawe" ));
	}

	/**
	 * ?
	 */
	public static void testLevenshteinDistance(){
		System.out.println(StringUtils.getLevenshteinDistance("liuawe", "i"));
		System.out.println(StringUtils.getLevenshteinDistance("liuawe", "iu"));
		System.out.println(StringUtils.getLevenshteinDistance("liuawe", "ia"));

		System.out.println(StringUtils.getLevenshteinDistance("aaaaaaaaaaaaaaaaa", "zzzzzzzzzzzzz"));
	}
	/**
	 * 字符串反转   根据标识符反转
	 */
	public static void testReverse() {
		System.out.println(StringUtils.reverse("liuawei"));
		System.out.println(StringUtils.reverseDelimited("liu.a.wei", 'x'));
		System.out.println(StringUtils.reverseDelimited("liu.a.wei", '.'));
		System.out.println(StringUtils.reverseDelimited("abcd.ef", '.'));
	}
	
	/**
	 * 大写 小写  首字母大写  首字母小写
	 */
	public static void testCase() {
		System.out.println(StringUtils.upperCase("liuawei"));
		System.out.println(StringUtils.lowerCase("LiuAwei"));
		System.out.println(StringUtils.swapCase("LiuAwei"));
		System.out.println(StringUtils.capitalize("LiuAwei"));
		System.out.println(StringUtils.capitalize("liuAwei"));
		System.out.println(StringUtils.uncapitalize("liuawei"));
		System.out.println(StringUtils.uncapitalize("Liuawei"));
	}

	/**
	 * 左，右，中新增占位符   以及重复字符串
	 */
	public static void testPad() {
		System.out.println(StringUtils.left("liuawei", 2));
		System.out.println(StringUtils.leftPad("liuawei", 2));
		System.out.println(StringUtils.leftPad("liuawei", 10));
		System.out.println(StringUtils.leftPad("liuawei", 21, "woaizhoajuan"));
		System.out.println(StringUtils.right("liuawei", 2));
		System.out.println(StringUtils.rightPad("liuawei", 2));
		System.out.println(StringUtils.rightPad("liuawei", 10));
		System.out.println(StringUtils.rightPad("liuawei", 21, "woaizhoajuan"));	
		System.out.println(StringUtils.center("liuawei", 9));
		System.out.println(StringUtils.center("--liu--", 20));
		System.out.println(StringUtils.repeat("liua", 2));
		System.out.println(StringUtils.repeat("liuawei", 4));
		System.out.println(StringUtils.repeat("weialiu", 4));
	}

	/**
	 * 去掉\r\n
	 */
	public static void testChomp() {
		System.out.println(StringUtils.chomp("123\n\r"));
		System.out.println(StringUtils.chomp("123"));
		System.out.println(StringUtils.chomp("123\n"));
		System.out.println(StringUtils.chomp("123\r"));

		System.out.println(StringUtils.chomp("\r\t456\n\r"));
		System.out.println(StringUtils.chomp("78\n9\n\r"));
		System.out.println(StringUtils.chomp("01\n\r2"));

		System.out.println(StringUtils.chop("啊、人、\r\n\r\n"));
	}

	/**
	 * 替换
	 * 更换
	 */
	public static void testReplace() {
		System.out.println("liuawei".replaceAll("liua", "haha"));
		System.out.println(StringUtils.replace("liuawei", "liu", "赵阿伟"));
		System.out.println(StringUtils.replace(" null", " ", "赵阿伟"));
		System.out.println(StringUtils.replace(null, "liu", "赵阿伟"));

		System.out.println(StringUtils.overlay("2222222222222", "333", 2, 5));
		System.out.println(StringUtils.overlay("2222233333333", "333", 2, 5));
		System.out.println(StringUtils.overlay("4444444444444", "333", 2, 5));

	}

	/**
	 * 截取字符串
	 */
	public static void testSubStr() {

		System.out.println(StringUtils.substring(null, 2));
		System.out.println(StringUtils.substring("123", 2));
		System.out.println(StringUtils.substring("12345", 2, 7));

		System.out.println(StringUtils.substringAfter("nulla", "l"));
		System.out.println(StringUtils.substringAfter("nullla", "ll"));

		System.out.println(StringUtils.substringBefore("nulla", "l"));
		System.out.println(StringUtils.substringBefore("nullla", "ll"));

		System.out.println(StringUtils.substringBeforeLast("nulla", "l"));
		System.out.println(StringUtils.substringBeforeLast("nullla", "ll"));

		System.out.println(StringUtils.substringBetween("nullla", "nulla"));
		System.out.println(StringUtils.substringBetween("", null));
		System.out.println(StringUtils.substringBetween(null, null));
		System.out.println(StringUtils.substringBetween("", "*"));
		System.out.println(StringUtils.substringBetween("*******123*****", "*"));
		System.out.println(StringUtils.substringBetween("456123456", "456"));

		System.out.println(StringUtils.substringBetween("456123456", "4", "3"));

	}

	/**
	 * 位置
	 */
	public static void testIndexOf() {
		System.out.println(StringUtils.indexOf(null, ""));
		System.out.println(StringUtils.indexOf(null, null));
		System.out.println(StringUtils.indexOf("", ""));
		System.out.println(StringUtils.indexOf("1223", "2"));
		
		System.out.println(StringUtils.indexOfAny(null, ""));
		System.out.println(StringUtils.indexOfAny("", ""));
		System.out.println(StringUtils.indexOfAny("1223", "2"));

		System.out.println(StringUtils.lastIndexOf(null, ""));
		System.out.println(StringUtils.lastIndexOf(null, null));
		System.out.println(StringUtils.lastIndexOf("", ""));
		System.out.println(StringUtils.lastIndexOf("1223", "2"));

		System.out.println(StringUtils.contains("123", "1"));
		System.out.println(StringUtils.contains("null", "1"));
		System.out.println(StringUtils.contains(null, "1"));
		
		

	}

	/**
	 * equals(str1,str2) 判断两个数据字符串是否相等 避免了NPE问题
	 */
	public static void testEquals() {
		System.out.println(StringUtils.equals("123", "456"));
		System.out.println(StringUtils.equals(null, "456"));
		System.out.println(StringUtils.equals(null, null));
		System.out.println(StringUtils.equals("456", "456"));
	}

	/**
	 * strip(str)==strip(str,null) 去掉前面字符串 最前面和最后面包括后面字符串的内容
	 */
	public static void testStrip() {
		System.out.println("123:" + StringUtils.strip("123"));
		System.out.println(" 123:" + StringUtils.strip(" 123"));
		System.out.println(" 123 :" + StringUtils.strip(" 123 "));
		System.out.println(" 1 2 3 :" + StringUtils.strip(" 1 2 3 "));
		System.out.println("  " + StringUtils.strip("  "));
		String str = null;
		System.out.println(StringUtils.strip(str));
		System.out.println(StringUtils.strip(str + "null"));
		System.out.println(StringUtils.strip("123456", "15"));
		System.out.println(StringUtils.strip("123456", "12"));
		System.out.println(StringUtils.strip("123456", "16"));
		System.out.println(StringUtils.strip("123456", "26"));
		System.out.println(StringUtils.strip("123456", "12356"));
		System.out.println(StringUtils.strip("24444444442", "4"));
	}

	/**
	 * trim(str)去掉字符串前面，后面的空格 null值返回null--避免NPE
	 */
	public static void testTrim() {
		System.out.println("123:" + StringUtils.trim("123"));
		System.out.println(" 123:" + StringUtils.trim(" 123"));
		System.out.println(" 123 :" + StringUtils.trim(" 123 "));
		System.out.println(" 1 2 3 :" + StringUtils.trim(" 1 2 3 "));
		System.out.println("  " + StringUtils.trim("  "));
		String str = null;
		System.out.println(StringUtils.trim(str));
		System.out.println(str.trim());
	}

	/**
	 * IsBlank 空字符串+null+只有空格的字符串 isNotBlank isAnyBlank isNoneBlank
	 */
	public static void testIsBlank() {
		System.out.println(" 123" + StringUtils.isBlank(" 123"));
		System.out.println(" " + StringUtils.isBlank(" "));
		System.out.println("" + StringUtils.isBlank(""));
		String str = null;
		System.out.println(str + StringUtils.isBlank(str));
	}

	/**
	 * isEmpty 空字符串+null isNotEmpty isAnyEmpty isNoneEmpty
	 */
	public static void testIsEmpty() {
		System.out.println(" 123" + StringUtils.isEmpty(" 123"));
		System.out.println(" " + StringUtils.isEmpty(" "));
		System.out.println("" + StringUtils.isEmpty(""));
		String str = null;
		System.out.println(str + StringUtils.isEmpty(str));
	}
}
