package com.geowind.hunong.util;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JPushUtil {

	protected static final Logger LOG = LoggerFactory
			.getLogger(JPushUtil.class);
	public static final String TITLE = "通知";
	public static final String ALERT = "大家好";

	public static JPushClient jpushClient = new JPushClient(
			FinalString.MASTERSECRET, FinalString.APPKEY, 3);;

	public static void sendPush(String alias, String title,
			JsonObject jsonObject) {

		PushPayload payload = buildPushObject_android_and_iosByAlias(alias,
				title, jsonObject);
		try {
//			System.out.println(payload.toString());
			PushResult result = jpushClient.sendPush(payload);
//			System.out.println("result:  " + result);
			LOG.info("Got result - " + result);

		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);

		} catch (APIRequestException e) {
			LOG.error(
					"Error response from JPush server. Should review and fix it. ",
					e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
		}
	}

	public static PushPayload PushObjectAndroidWithoutTitle() {
		return PushPayload.newBuilder().setPlatform(Platform.all())// 设置接受的平台
				.setAudience(Audience.all())// Audience设置为all，说明采用广播方式推送，所有用户都可以接收到
				.setNotification(Notification.alert(ALERT)).build();
	}

	public static PushPayload PushObjectAndroidWithTitle() {
		return PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(Audience.alias("test"))
				.setNotification(Notification.android(ALERT, TITLE, null))
				.build();
	}

	public static PushPayload buildPushObject_android_and_iosByAlias(
			String alias, String title, JsonObject jsonObject) {

		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android())
				.setAudience(Audience.alias(alias))
				.setNotification(Notification
				.newBuilder()
				.setAlert("alert content")
				.addPlatformNotification(AndroidNotification
				.newBuilder()
				.setTitle(title)
				.addExtra("jsonExtra",jsonObject).build())
				.build())
				.build();
	}

}
