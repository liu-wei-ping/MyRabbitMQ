package com.rabbitmq.mq.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * rabbitma 交换机类型
 * 
 * @author liu wp
 * @date 2017年9月8日
 */
public enum MqTypeEnum {
	/*** */
	DEFAULT(""),
	/*** */
	DIRECT("direct"),
	/*** */
	FANOUT("fanout"),
	/*** */
	HEADERS("headers"),
	/*** */
	TOPIC("topic");

	public final static Map<String, String> map = new HashMap<>();

	static{
		for (MqTypeEnum mq : values()) {
			map.put(mq.name(), mq.getType());
		}
	}

	public static String getMqType(String type){
		return map.get(type);
	}

	private String type;

	private MqTypeEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
