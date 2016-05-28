package com.liuawei.token;

import java.util.Random;


import com.liuawei.encrypt.MD5Utils;

public final class TokenUtil {
	
	public static int USERTYPE_LENGTH=1;
	public static int MD5CODE_LENGTH=32;
	public static int TIMESTAMP_LENGTH=13;
	public static int RANDOMSTR_LENGTH=1; 
	
	public static Character USERTYPE_USER='U';
	public static Character USERTYPE_ADMIN='A';
	
	/**
	 * 生成用户 token 
	 * @return
	 */
	public static String createUserToken(long userId){
		return createToken(USERTYPE_USER,userId);
	}
	
	/**
	 * 生成后台运营人员 token 
	 * @return
	 */
	public static String createAdminToken(long userId){
		return createToken(USERTYPE_ADMIN,userId);
	}
	
	/**
	 * token 生成规则   
	 * 1：用户标识符 + 2:用户Id+ 3：时间戳 + 4：Md5(1+2+3)+5:随机数
	 * @param userType
	 * @param userId
	 * @return
	 */
	public static String createToken(Character userType,long userId){
		StringBuffer token = new StringBuffer();
		token.append(userType).append(userId).append(System.currentTimeMillis());
		token.append(MD5Utils.encrypt(token.toString()));
		token.append(new Random().nextInt(9));
		return token.toString();
	}
	
	/**
	 * 解析Token
	 * @param tokenStr
	 * @return
	 */
	public static Token parseToken(String tokenStr){
		Token token = new Token();
		token.setToken(false);
		try {
			//解密
			//用户类型
			String userType = tokenStr.substring(0, 1);
			token.setUserType(userType.toCharArray()[0]);
			//时间戳
			String expireTime = tokenStr.substring(tokenStr.length()-(RANDOMSTR_LENGTH+MD5CODE_LENGTH+TIMESTAMP_LENGTH),
					tokenStr.length()-(RANDOMSTR_LENGTH+MD5CODE_LENGTH));
			token.setExpireTime(Long.parseLong(expireTime));
			//用户Id
			String userId = tokenStr.substring(USERTYPE_LENGTH,tokenStr.length()-(RANDOMSTR_LENGTH+MD5CODE_LENGTH+TIMESTAMP_LENGTH));
			token.setUserId(Long.parseLong(userId));
			//用户类型一样
			if(USERTYPE_ADMIN.equals(userType)||USERTYPE_ADMIN.equals(userType)){
				if(token.getUserId()>0&&token.getExpireTime()>System.currentTimeMillis()){
					token.setToken(true);
				}
			}
		} catch (Exception e) {
			System.out.println("解析失败");
		}
		return token;
	}
	
	static class Token{
		boolean isToken;
		char userType;
		long userId;
		long expireTime;
		
		public Token() {

		}
		public boolean isToken() {
			return isToken;
		}
		public void setToken(boolean isToken) {
			this.isToken = isToken;
		}
		public char getUserType() {
			return userType;
		}
		public void setUserType(char userType) {
			this.userType = userType;
		}
		public long getUserId() {
			return userId;
		}
		public void setUserId(long userId) {
			this.userId = userId;
		}
		public long getExpireTime() {
			return expireTime;
		}
		public void setExpireTime(long expireTime) {
			this.expireTime = expireTime;
		}
		@Override
		public String toString() {
			return "Token [isToken=" + isToken + ", userType=" + userType + ", userId=" + userId + ", expireTime="
					+ expireTime + ", isToken()=" + isToken() + ", getUserType()=" + getUserType() + ", getUserId()="
					+ getUserId() + ", getExpireTime()=" + getExpireTime() + ", getClass()=" + getClass()
					+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
		}
		
		
	}
}
