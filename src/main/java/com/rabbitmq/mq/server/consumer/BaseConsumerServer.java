package com.rabbitmq.mq.server.consumer;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author liu wp
 * @date  2017年9月12日
 */
public class BaseConsumerServer {
	/** 日志类 */
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());
	protected RabbitTemplate rabbitTemplate;

	protected String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
