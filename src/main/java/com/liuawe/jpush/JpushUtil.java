package com.liuawe.jpush;



import java.util.HashMap;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.ClientConfig;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JpushUtil {
	public static final String masterSecret = "7db45b757bdeaf9c512c3231";
	public static final String appKey = "d27132f8f158972a5f462d26";
	public static final boolean JPUSH_APNSPRODUCTION = false;
	public static final long timeToLive = 60*60*24;
	public static final int maxRetryTimes = 3;
	public static JPushClient client = null;
	/*
	 * 类加载的时候初始化 JPushClient
	 */
	static{
		ClientConfig config = ClientConfig.getInstance();
		config.setApnsProduction(JPUSH_APNSPRODUCTION);
		config.setTimeToLive(timeToLive);
		config.setMaxRetryTimes(maxRetryTimes);
		//创建jpush
		client = new JPushClient(masterSecret, appKey, null, config);
	}
	public static void push(PushPayload pushPayload){
		try{
			PushResult result = client.sendPush(pushPayload);
			System.out.println(result);
		}catch(APIConnectionException | APIRequestException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据别名--推送消息给--Android
	 * @param alias
	 * @param title
	 * @param msgContent
	 * @return
	 */
	public static PushPayload build_android_alias_message(String alias, String title, HashMap< String, String> extras) {
		return PushPayload.newBuilder().
				setPlatform(Platform.android()).
				setAudience(Audience.alias(alias)).
				setNotification(Notification.newBuilder().
						addPlatformNotification(AndroidNotification.newBuilder().
								setTitle(title).build()).build())
				.setMessage(Message.newBuilder().addExtras(extras).build()).build();
	}
	
	/**
	 * 根据别名--推送消息给--ios
	 * @param alias
	 * @param title
	 * @param badge
	 * @param msgContent
	 * @return
	 */
	//	角标默认+1 setBadge(badge) 
	public static PushPayload build_ios_alias_message(String alias, String title,HashMap< String, String> extras) {
		return PushPayload.newBuilder().
				setPlatform(Platform.ios()).
				setAudience(Audience.alias(alias)).
				setNotification(Notification.newBuilder().
						addPlatformNotification(IosNotification.newBuilder().
								setAlert(title)
							   .setSound("default").build()).build())
				.setMessage(Message.newBuilder().setMsgContent("测试一下")
						.addExtras(extras).build()).build();
	}
}
