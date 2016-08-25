package com.liuawei.Jpush;

import java.util.HashMap;

import cn.jpush.api.push.model.PushPayload;

public class JpushUtilTest {

	public static void main(String[] args) {
		HashMap<String, String> extras = new HashMap<>();
		extras.put("sessionId", "18");
		extras.put("sessionType", "2");
		extras.put("alert", "国康私人医生");
		extras.put("title", "你有一条新消息！");
		PushPayload pushPayload = JpushUtil.build_ios_alias_message("183519",
				"测试ios--alert", extras);
//		PushPayload androidpushPayload = JpushUtil.build_android_alias_message("U16615", 
//				"666","国康私人医生","22", extras);
		JpushUtil.push(pushPayload);
//		JpushUtil.push(androidpushPayload);
	}

}
