package com.rabbitmq.mq.server.producer;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabbitmq.mq.server.BaseService;

/**
 * 生产者基础服务
 *
 * @author liu wp
 * @date 2017年9月8日
 */
public abstract class BaseProducerService extends BaseService implements ConfirmCallback {
	// @Autowired
	// protected AsyncRabbitTemplate asyncRabbitTemplate;
	@Autowired
	protected RabbitTemplate rabbitTemplate;

	/**
	 * 构造方法注入
	 */
	// public BaseProducerService(RabbitTemplate rabbitTemplate) {
	// this.rabbitTemplate = rabbitTemplate;
	// // rabbitTemplate如果为单例的话，那回调就是最后设置的内容
	// rabbitTemplate.setConfirmCallback(this);
	// }

	/**
	 * @param correlationData
	 * @param ack
	 * @param cause
	 * @see org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback#confirm(org.springframework.amqp.rabbit.support.CorrelationData,
	 *      boolean, java.lang.String)
	 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		logger.info("发送消息Id：【{}】", correlationData);
		if (ack) {
			logger.info("【{}】消息发送确认成功！", new Date());
			this.confirmAfterSendSuccess(correlationData);
		} else {
			logger.info("【{}】消息发送确认失败：【{}】", new Date(), cause);
			this.confirmAfterSendFail(correlationData, cause);
		}
	}

	/**
	 * 消息发送成功后调用
	 *
	 * @param correlationData
	 * @param cause
	 */
	protected abstract void confirmAfterSendFail(CorrelationData correlationData, String cause);

	/**
	 * 消息发送失败后调用
	 *
	 * @param correlationData
	 */
	protected abstract void confirmAfterSendSuccess(CorrelationData correlationData);
}
