package com.liuawei.util.token;

import com.liuawei.util.token.TokenUtil.Token;

public class TokenUtilTest {
	public static void main(String[] args){
		String tokenStr = TokenUtil.createToken('U', 35);
		System.out.println(tokenStr.toString());
		Token token = TokenUtil.parseToken(tokenStr);
		System.out.println(token.toString());
	}
}
