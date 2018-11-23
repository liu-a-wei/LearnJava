package com.liuawei.algorithm;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.zip.CRC32;

import org.apache.commons.lang3.StringUtils;

public class HashAlgorithm {

	private static List<String> encodeList = Arrays.asList("MD5", "SHA1", "SHA-256", "SHA-384", "SHA-512");

	/**
	 * 加密MD5
	 * 
	 * @param orginal
	 * @return
	 */
	public static String md5Encode(String orginal) {
		return hash(orginal, "MD5");
	}

	/**
	 * 加密MD5
	 * 
	 * @param orginal
	 * @return
	 */
	public static String md5SaltEncode(String orginal) {
		String salt = hash(generatRandom(15), "MD5");
		String hash = hash(orginal + salt, "MD5");
		return hash.concat(salt);
	}

	/**
	 * 加密 SHA1
	 * 
	 * @param orginal
	 * @return
	 */
	public static String sha1Encode(String orginal) {
		return hash(orginal, "SHA1");
	}

	/**
	 * 加密 SHA-256
	 * 
	 * @param orginal
	 * @return
	 */
	public static String sha256Encode(String orginal) {
		return hash(orginal, "SHA-256");
	}

	/**
	 * 加密 SHA-384
	 * 
	 * @param orginal
	 * @return
	 */
	public static String sha384Encode(String orginal) {
		return hash(orginal, "SHA-384");
	}

	/**
	 * 加密 SHA-512
	 * 
	 * @param orginal
	 * @return
	 */
	public static String sha512Encode(String orginal) {
		return hash(orginal, "SHA-512");
	}

	/**
	 * crc32 校验
	 * 
	 * @param orginal
	 * @return
	 */
	public static long crc32(String orginal) {
		CRC32 crc32 = new CRC32();
		crc32.update(orginal.getBytes());
		return crc32.getValue();
	}

	public static Integer BUFFER_SIZE = 1024;

	public static long crc32(InputStream data) {
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			int read = data.read(buffer, 0, BUFFER_SIZE);
			CRC32 crc32 = new CRC32();
			while (read > -1) {
				crc32.update(buffer, 0, read);
				read = data.read(buffer, 0, BUFFER_SIZE);
			}
			return crc32.getValue();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return BUFFER_SIZE;
	}

	/**
	 * hash算法
	 * 
	 * @param orginal
	 * @param encodeType
	 * @return
	 */
	private static String hash(String orginal, String encodeType) {
		if (StringUtils.isBlank(orginal)) {
			return null;
		}
		if (!encodeList.contains(encodeType)) {
			return null;
		}
		MessageDigest sha1;
		try {
			sha1 = MessageDigest.getInstance(encodeType);
			sha1.update(orginal.getBytes("UTF8"));
			byte[] digest = sha1.digest();
			return byte2hex(digest).toUpperCase();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 二进制转换为16进制
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		StringBuffer sb = new StringBuffer();
		String tmp = "";
		for (int i = 0; i < b.length; i++) {
			tmp = Integer.toHexString(b[i] & 0XFF);
			if (tmp.length() == 1) {
				sb.append("0" + tmp);
			} else {
				sb.append(tmp);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		System.out.println(md5Encode("456987321"));
		System.out.println(sha1Encode("456987321"));
		System.out.println(sha256Encode("456987321"));
		System.out.println(sha384Encode("456987321"));
		System.out.println(sha512Encode("456987321"));

	}

	/**
	 * 数字--字符
	 */
	private static final char[] NUMBER_CHAR = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
			'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	/**
	 * 得到随机数
	 * 
	 * @return
	 */
	public static String generatRandom(int codeLength) {
		StringBuffer codeStr = new StringBuffer();
		Random random = new Random();
		while (codeStr.length() < codeLength) {
			codeStr.append(NUMBER_CHAR[random.nextInt(NUMBER_CHAR.length)]);
		}
		return codeStr.toString();
	}

}
