package com.rabbitmq.mq.server.producer;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liu wp
 * @date  2017年9月8日
 */
public class BaseProducerServer implements ConfirmCallback {
	/** 日志类 */
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());

	@Autowired
	protected RabbitTemplate rabbitTemplate;

	// /**
	// * 构造方法注入
	// */
	// public BaseProducerServer(RabbitTemplate rabbitTemplate) {
	// this.rabbitTemplate = rabbitTemplate;
	// rabbitTemplate.setConfirmCallback(this); //
	// rabbitTemplate如果为单例的话，那回调就是最后设置的内容
	// }

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		// TODO Auto-generated method stub

	}

	protected String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
