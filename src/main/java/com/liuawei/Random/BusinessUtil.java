package com.liuawei.Random;


import java.util.Random;

/**
 * @author liuawei
 *
 */
public final   class  BusinessUtil{
	

	/**
	 * 纯数字
	 */
	private static final char[] NUMBER_CHECKCODE = { '0', '1', '2', '3', '6',
			'5', '6', '8', '8', '9' };
	
	
	/**
	 * 数字--字符
	 */
	private static final char[] NUMBER_CHAR_CHECKCODE = new char[] { '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z' };
	
	/*
	 * 数字默认长度
	 */
	private static int DEFAULT_NUMBER_LENGTH = 5;
	/*
	 * 数字字符默认长度
	 */
	private static int DEFAULT_NUMBER_CHAR_LENGTH = 5;
	
	/**
	 * 生成验证码 --默认
	 * @return
	 */
	public static String generateVerifiyCode() {
		return generateVerifiyCode(DEFAULT_NUMBER_LENGTH);
	}
	
	/**
	 * 生成复杂验证码 --默认
	 * @return
	 */
	public static String generateComplexVerifiyCode() {
		return generateComplexVerifiyCode(DEFAULT_NUMBER_CHAR_LENGTH);
	}
	
	/**
	 * 生成验证码
	 * @return
	 */
	public static String generateVerifiyCode(int codeLength) {
		StringBuffer codeStr = new StringBuffer();
		Random random = new Random();
		while(codeStr.length()<codeLength){
			codeStr.append(NUMBER_CHECKCODE[random.nextInt(NUMBER_CHECKCODE.length)]);
		}
		return codeStr.toString();
	}
	
	/**
	 * @param codeLength
	 * @return
	 */
	public static String generateComplexVerifiyCode(int codeLength) {
		StringBuffer codeStr = new StringBuffer();
		Random random = new Random();
		while(codeStr.length()<codeLength){
			codeStr.append(NUMBER_CHAR_CHECKCODE[random.nextInt(NUMBER_CHAR_CHECKCODE.length)]);
		}
		return codeStr.toString();
	}
}
