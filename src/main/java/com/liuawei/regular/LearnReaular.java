package com.liuawei.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 *  学习正则表达式
 *  @author liuawei
 *
 */
public class LearnReaular {
	public static void main(String[] args){
		
		boolean flag = false;
		// 第一种方式
		String reg = "";
		String str = "";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(str);
		flag =  m.matches();
		
		//第二张方式 --- 只是String对象对matches对象进行了封装
		flag = str.matches("");
		
		
		/*
		 * 
		 * 1：\ 转义字符   ---  将下一字符标记为特殊字符、文本、反向引用
		 * 
		 */
		reg = "\\n";
		str = "\n";
		System.out.println("1---------------"+str.matches(reg));
		/*
		 * 
		 * 2：^ 匹配输入字符串开始的位置
		 * 
		 */
		reg = "^\\n";
		str = "\n";
		System.out.println("2---------------"+str.matches(reg));
		/*
		 * 
		 * 3：$ 匹配输入字符串结束的位置
		 * 
		 */
		reg = "^\\n$";
		str = "\n";
		System.out.println("3---------------"+str.matches(reg));
		/*
		 * 
		 * 4： * 零次或多次匹配前面的字符或子表达式		* 等效于 {0,}
		 * 
		 */
		reg = "^liu*$";
		str = "liuuuuuuuuuuu";
		System.out.println("4---------------"+str.matches(reg));
		str = "li";
		System.out.println("4---------------"+str.matches(reg));
		/*
		 * 
		 * 5： + 一次或多次匹配前面的字符或子表达式		+ 等效于 {1,}
		 * 
		 */
		reg = "^liu+$";
		str = "liuuuuuuuuuuu";
		System.out.println("5---------------"+str.matches(reg));
		str = "li";
		System.out.println("5---------------"+str.matches(reg));
		/*
		 * 
		 * 6：?	零次或一次匹配前面的字符或子表达式			? 等效于 {0,1}。
		 * 
		 */
		reg = "^liu?$";
		str = "liuu";
		System.out.println("6---------------"+str.matches(reg));
		str = "liu";
		System.out.println("6---------------"+str.matches(reg));
		str = "li";
		System.out.println("6---------------"+str.matches(reg));
		/*
		 * 
		 * 7：{n}	n 是非负整数。正好匹配 n 次			
		 * 
		 */
		reg = "^liu{2}$";
		str = "liuu";
		System.out.println("7---------------"+str.matches(reg));
		str = "liu";
		System.out.println("7---------------"+str.matches(reg));
		str = "liuuu";
		System.out.println("7---------------"+str.matches(reg));
		/*
		 * 
		 * 8：{n,}	n 是非负整数。至少匹配 n 次。	
		 * 
		 */
		reg = "^liu{3,}$";
		str = "liuu";
		System.out.println("8---------------"+str.matches(reg));
		str = "liu";
		System.out.println("8---------------"+str.matches(reg));
		str = "liuuu";
		System.out.println("8---------------"+str.matches(reg));
		/*
		 * 
		 * 9：{n,m}	 m和 n是非负整数，其中 n <= m。匹配至少 n 次，至多 m 次
		 * 
		 */
		reg = "^liu{3,5}$";
		str = "liuu";
		System.out.println("9---------------"+str.matches(reg));
		str = "liuuuuuu";
		System.out.println("9---------------"+str.matches(reg));
		str = "liuuu";
		System.out.println("9---------------"+str.matches(reg));
		str = "liuuuuu";
		System.out.println("9---------------"+str.matches(reg));
		/*
		 * 
		 * 10：?   当此字符紧随任何其他限定符（*、+、?、{n}、{n,}、{n,m}）之后时，
		 * 		     匹配模式是"非贪心的"。"非贪心的"模式匹配搜索到的、尽可能短的字符串，
		 * 		     而默认的"贪心的"模式匹配搜索到的、尽可能长的字符串。
		 * 
		 */
		reg = "^o+?$";
		str = "o";
		System.out.println("10---------------"+str.matches(reg));
		str = "oo";
		System.out.println("10---------------"+str.matches(reg));
		str = "ooooo";
		System.out.println("10---------------"+str.matches(reg));
		/*
		 * 
		 * 11：.   匹配除"\r\n"之外的任何单个字符。若要匹配包括"\r\n"在内的任意字符，请使用诸如"[\s\S]"之类的模式。
		 * 
		 */
		reg = "^liu.wei$";
		str = "liuawei";
		System.out.println("11---------------"+str.matches(reg));
		str = "liuAwei";
		System.out.println("11---------------"+str.matches(reg));
		str = "liu.wei";
		System.out.println("11---------------"+str.matches(reg));
		str = "liuaawei";
		System.out.println("11---------------"+str.matches(reg));
		str = "liu\rwei";
		System.out.println("11---------------"+str.matches(reg));
		/*
		 * 
		 * 12：(pattern)   匹配 pattern 并捕获该匹配的子表达式。可以使用 $0…$9 属性从结果"匹配"集合中检索捕获的匹配。若要匹配括号字符 ( )，请使用"\("或者"\)"。
		 * 
		 */
		reg = "^liu(aa)$";
		str = "liua";
		System.out.println("12---------------"+str.matches(reg));
		str = "liuaa";
		System.out.println("12---------------"+str.matches(reg));
		str = "liuaaa";
		System.out.println("12---------------"+str.matches(reg));
		/*
		 * 
		 * 13：(?:pattern)   匹配 pattern 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。
		 * 	这对于用"or"字符 (|) 组合模式部件的情况很有用。例如，'industr(?:y|ies) 是比 'industry|industries' 更经济的表达式。
		 * 
		 */
		/*
		 * 
		 * 14：(?=pattern)	执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 pattern 的字符串的起始点的字符串。
		 * 	它是一个非捕获匹配，即不能捕获供以后使用的匹配。
		 *  error
		 */
		reg = "Windows (?=95|98|NT|2000)";
		str = "Windows 2000";
		System.out.println("14---------------"+str.matches(reg));
		str = "Windows 3.1";
		System.out.println("14---------------"+str.matches(reg));
		/*
		 * 
		 * 15: (?!pattern)	执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 pattern 的字符串的起始点的搜索字符串。
		 * 它是一个非捕获匹配，即不能捕获供以后使用的匹配。
		 * 例如，'Windows (?!95|98|NT|2000)' 匹配"Windows 3.1"中的 "Windows"，但不匹配"Windows 2000"中的"Windows"。 预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。
		 *  error
		 */
		reg = "Windows (?!95|98|NT|2000)";
		str = "Windows 2000";
		System.out.println("15---------------"+str.matches(reg));
		str = "Windows 3.1";
		System.out.println("15---------------"+str.matches(reg));
		/*
		 * 
		 * 16: x|y	匹配 x 或 y
		 * 
		 */
		reg = "^liua(wei|Wei)$";
		str = "liuawei";
		System.out.println("16---------------"+str.matches(reg));
		str = "liuaWei";
		System.out.println("16---------------"+str.matches(reg));
		str = "liuAWei";
		System.out.println("16---------------"+str.matches(reg));
		str = "liuAw";
		System.out.println("16---------------"+str.matches(reg));
		str = "liuaW";
		System.out.println("16---------------"+str.matches(reg));
		reg="1|2|3";
		System.out.println("16---------------"+"1".matches(reg));
		System.out.println("16---------------"+"2".matches(reg));
		System.out.println("16---------------"+"3".matches(reg));
		System.out.println("16---------------"+"4".matches(reg));
		/*
		 * 
		 * 17: [xyz]	字符集。匹配包含的任一字符。
		 * 
		 */
		reg = "liua[wW]";
		str = "liuaw";
		System.out.println("17---------------"+str.matches(reg));
		str = "liuaW";
		System.out.println("17---------------"+str.matches(reg));
		str = "liuaWei";
		System.out.println("17---------------"+str.matches(reg));
		/*
		 * 
		 * 18: [^xyz]	反向字符集。匹配未包含的任何字符
		 * 
		 */
		reg = "liua[^wW]";
		str = "liuaw";
		System.out.println("18---------------"+str.matches(reg));
		str = "liuaW";
		System.out.println("18---------------"+str.matches(reg));
		str = "liuaZ";
		System.out.println("18---------------"+str.matches(reg));
		/*
		 * 
		 * 19: 	[a-z]	字符范围
		 * 
		 */
		reg = "liua[a-z]";
		str = "liuaw";
		System.out.println("19---------------"+str.matches(reg));
		str = "liuab";
		System.out.println("19---------------"+str.matches(reg));
		str = "liuaW";
		System.out.println("19---------------"+str.matches(reg));
		str = "liuaZ";
		System.out.println("19---------------"+str.matches(reg));
		/*
		 * 
		 * 20: [^a-z] 字符范围
		 * 
		 */
		reg = "liua[^a-z]";
		str = "liuaw";
		System.out.println("20---------------" + str.matches(reg));
		str = "liuab";
		System.out.println("20---------------" + str.matches(reg));
		str = "liuaW";
		System.out.println("20---------------" + str.matches(reg));
		str = "liuaZ";
		System.out.println("20---------------" + str.matches(reg));
		/*
		 * 
		 * 21: \d 数字字符匹配。等效于 [0-9]。
		 * 
		 */
		reg = "liua\\d";
		str = "liua1";
		System.out.println("21---------------" + str.matches(reg));
		str = "liua9";
		System.out.println("21---------------" + str.matches(reg));
		str = "liua10";
		System.out.println("21---------------" + str.matches(reg));
		str = "liuaW";
		System.out.println("21---------------" + str.matches(reg));
		str = "liuaZ";
		System.out.println("21---------------" + str.matches(reg));
		reg = "liua[0-9]";
		str = "liua1";
		System.out.println("21---------------" + str.matches(reg));
		str = "liua9";
		System.out.println("21---------------" + str.matches(reg));
		/*
		 * 
		 * 22: \D 非数字字符匹配。等效于 [^0-9]。
		 * 
		 */
		reg = "liua\\D";
		str = "liuaw";
		System.out.println("22---------------" + str.matches(reg));
		str = "liua9";
		System.out.println("22---------------" + str.matches(reg));
		str = "liuaW";
		System.out.println("22---------------" + str.matches(reg));
		str = "liuaZ";
		System.out.println("22---------------" + str.matches(reg));
		/*
		 * 
		 * 23: \b 匹配一个字边界，即字与空格间的位置。例如，"er\b"匹配"never"中的"er"，但不匹配"verb"中的"er"。
		 * error
		 */
		reg = "er\\b";
		str = "never";
		System.out.println("23---------------" + str.matches(reg));
		str = "verb";
		System.out.println("23---------------" + str.matches(reg));
		/*
		 * 
		 * 24: \B 非字边界匹配
		 * error
		 */
		reg = "er\\B";
		str = "never";
		System.out.println("24---------------" + str.matches(reg));
		str = "verb";
		System.out.println("24---------------" + str.matches(reg));
		/*
		 * 
		 * 25: \cx 匹配 x 指示的控制字符。例如，\cM 匹配 Control-M 或回车符。x 的值必须在 A-Z 或 a-z 之间。如果不是这样，则假定 c 就是"c"字符本身
		 * error
		 */
		/*
		 * 
		 * 26: \f 换页符匹配。等效于 \x0c 和 \cL
		 * error
		 */
		/*
		 * 
		 * 27: \n  换行符匹配。等效于 \x0a 和 \cJ
		 * error
		 */
		/*
		 * 
		 * 28: \r 匹配一个回车符。等效于 \x0d 和 \cM
		 * error
		 */
		/*
		 * 
		 * 29: \s匹配任何空白字符，包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效
		 * error
		 */
		/*
		 * 
		 * 30: \S匹配任何非空白字符。与 [^ \f\n\r\t\v] 等效
		 * error
		 */
		/*
		 * 
		 * 31: \t 制表符匹配。与 \x09 和 \cI 等效。
		 * error
		 */
		/*
		 * 
		 * 32: \v 垂直制表符匹配。与 \x0b 和 \cK 等效。
		 * error
		 */
		/*
		 * 
		 * 33: \w 匹配任何字类字符，包括下划线。与"[A-Za-z0-9_]"等效。
		 * 
		 */
		reg = "\\w";
		str = "L";
		System.out.println("33---------------" + str.matches(reg));
		str = "l";
		System.out.println("33---------------" + str.matches(reg));
		str = "9";
		System.out.println("33---------------" + str.matches(reg));
		str = "_";
		System.out.println("33---------------" + str.matches(reg));
		str = "10";
		System.out.println("33---------------" + str.matches(reg));
		reg = "[A-Za-z0-9_]";
		str = "L";
		System.out.println("33---------------" + str.matches(reg));
		str = "l";
		System.out.println("33---------------" + str.matches(reg));
		str = "9";
		System.out.println("33---------------" + str.matches(reg));
		str = "_";
		System.out.println("33---------------" + str.matches(reg));
		str = "10";
		System.out.println("33---------------" + str.matches(reg));
		/*
		 * 
		 * 34: \W 与任何非单词字符匹配。与"[^A-Za-z0-9_]"等效。
		 * error
		 */
		reg = "\\W";
		str = "L";
		System.out.println("34---------------" + str.matches(reg));
		str = "l";
		System.out.println("34---------------" + str.matches(reg));
		str = "9";
		System.out.println("34---------------" + str.matches(reg));
		str = "_";
		System.out.println("34---------------" + str.matches(reg));
		str = "..*";
		System.out.println("34---------------" + str.matches(reg));
		reg = "[^A-Za-z0-9_]";
		str = "L";
		System.out.println("34---------------" + str.matches(reg));
		str = "l";
		System.out.println("34---------------" + str.matches(reg));
		str = "9";
		System.out.println("34---------------" + str.matches(reg));
		str = "_";
		System.out.println("34---------------" + str.matches(reg));
		str = "..*";
		System.out.println("34---------------" + str.matches(reg));
		/*
		 * 
		 * 35: \xn 匹配 n，此处的 n 是一个十六进制转义码。十六进制转义码必须正好是两位数长。例如，"\x41"匹配"A"。"\x041"与"\x04"&"1"等效。允许在正则表达式中使用 ASCII 代码。
		 * 
		 */
		reg = "\\x41";
		str = "A";
		System.out.println("35---------------" + str.matches(reg));
		str = "l";
		System.out.println("35---------------" + str.matches(reg));
		str = "9";
		System.out.println("35---------------" + str.matches(reg));
		/*
		 * 
		 * 36: \num 匹配 num，此处的 num 是一个正整数。到捕获匹配的反向引用。例如，"(.)\1"匹配两个连续的相同字符。
		 * error
		 */
		reg = "(.)\1";
		str = "22";
		System.out.println("36---------------" + str.matches(reg));
		str = "..";
		System.out.println("36---------------" + str.matches(reg));
		str = "11";
		System.out.println("36---------------" + str.matches(reg));
		/*
		 * 
		 * 37: \n 标识一个八进制转义码或反向引用。如果 \n 前面至少有 n 个捕获子表达式，那么 n 是反向引用。否则，如果 n 是八进制数 (0-7)，那么 n 是八进制转义码。
		 * error
		 */
		/*
		 * 
		 * 38: \nm 标识一个八进制转义码或反向引用。如果 \nm 前面至少有 nm 个捕获子表达式，那么 nm 是反向引用。如果 \nm 前面至少有 n 个捕获，则 n 是反向引用，后面跟有字符 m。如果两种前面的情况都不存在，则 \nm 匹配八进制值 nm，其中 n 和 m 是八进制数字 (0-7)。
		 * error
		 */
		/*
		 * 
		 * 39: \nml 当 n 是八进制数 (0-3)，m 和 l 是八进制数 (0-7) 时，匹配八进制转义码 nml。
		 * error
		 */
		/*
		 * 
		 * 40: "\\un" 匹配 n，其中 n 是以四位十六进制数表示的 Unicode 字符。例如，\u00A9 匹配版权符号 (©)。
		 * error
		 */
		reg = "\u00A9";
		str = "©";
		System.out.println("40---------------" + str.matches(reg));
	}
}
