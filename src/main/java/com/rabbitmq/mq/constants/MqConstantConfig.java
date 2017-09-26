package com.rabbitmq.mq.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu wp
 * @date 2017年9月11日
 */
public class MqConstantConfig {
	/*****************************
	 * direct(直连交换机)
	 *****************************************/
	public static final String DIRECT_EXCHANGE_NAME = "mymq.direct.exchange";
	public static final String DIRECT_QUEUE_NAME = "mymq.direct.queue";
	public static final String DIRECT_ROUTING_KEY = "mymq.direct.routingKey";

	/*****************************
	 * fanout(扇型交换机)
	 *****************************************/
	public static final String FANOUT_EXCHANGE_NAME = "mymq.fanout.exchange";
	public static final String FANOUT_QUEUE_NAME = "mymq.fanout.queue";
	public static final String FANOUT_ROUTING_KEY = "mymq.fanout.routingKey";

	/*****************************
	 * headers(头交换机)
	 *****************************************/
	public static final String HEADERS_EXCHANGE_NAME = "mymq.headers.exchange";
	public static  Map<String, Object> HEADERS_KEY_MAP;
	public static final String HEADERS_QUEUE_NAME = "mymq.headers.queue";

	/*****************************
	 * topic(主题交换机)
	 *****************************************/
	public static final String TOPIC_EXCHANGE_NAME = "mymq.topic.exchange";
	public static final String TOPIC_QUEUE_NAME = "mymq.topic.queue";
	public static final String TOPIC_ROUTING_KEY = "mymq.topic.routingKey";

	/**
	 * headers(头交换机) 匹配的Key-Value
	 */
	static {
		HEADERS_KEY_MAP = new HashMap<>();
		HEADERS_KEY_MAP.put("x-match", "all");// all any(只要有一个键值对匹配即可)
		HEADERS_KEY_MAP.put("header_map", "XXX");
	}
}
