package com.rabbitmq.mq.server.producer;

import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

import com.rabbitmq.mq.constants.MqConstantConfig;
import com.rabbitmq.mq.server.api.IMqProducerServer;

/**
 * @author liu wp
 * @date  2017年9月8日
 */
@Service
public class DefaultProducerServer extends BaseProducerServer implements IMqProducerServer {



	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		logger.info("发送消息Id：{}", correlationData);
		if (ack) {
			logger.info("消息发送确认成功");
		} else {
			logger.info("消息发送确认失败：【{}】" + cause);
		}

	}

	@Override
	public void send(Object message) {
		CorrelationData correlationId = new CorrelationData(getUUID());
		rabbitTemplate.convertAndSend(MqConstantConfig.DIRECT_EXCHANGE_NAME, MqConstantConfig.DIRECT_ROUTING_KEY,
				message, correlationId);
	}


}
