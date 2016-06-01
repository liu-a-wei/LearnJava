package com.liuawe.jpush;

import java.util.HashMap;

import cn.jpush.api.push.model.PushPayload;

public class JpushUtilTest {

	public static void main(String[] args) {
		HashMap<String, String> extras = new HashMap<>();
		extras.put("sessionId", "18");
		extras.put("sessionType", "2");
		PushPayload pushPayload = JpushUtil.build_ios_alias_message("U16627",
				"测试一下", extras);
		JpushUtil.push(pushPayload);
	}

}
