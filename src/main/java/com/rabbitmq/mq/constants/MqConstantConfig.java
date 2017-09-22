package com.rabbitmq.mq.constants;

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
	public static final String HEADERS_QUEUE_NAME = "mymq.headers.queue";
	public static final String HEADERS_ROUTING_KEY = "mymq.headers.routingKey";

	/*****************************
	 * topic(主题交换机)
	 *****************************************/
	public static final String TOPIC_EXCHANGE_NAME = "mymq.topic.exchange";
	public static final String TOPIC_QUEUE_NAME = "mymq.topic.queue";
	public static final String TOPIC_ROUTING_KEY = "mymq.topic.routingKey";
}
