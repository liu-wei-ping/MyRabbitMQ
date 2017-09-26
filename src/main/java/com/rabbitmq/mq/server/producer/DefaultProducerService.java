package com.rabbitmq.mq.server.producer;

import org.springframework.amqp.rabbit.listener.exception.ListenerExecutionFailedException;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

import com.rabbitmq.mq.app.vo.MessageVo;
import com.rabbitmq.mq.app.vo.ReturnObject;
import com.rabbitmq.mq.constants.MqConstantConfig;
import com.rabbitmq.mq.server.api.IMqProducerServer;

/**
 * @author liu wp
 * @date 2017年9月8日
 */
@Service
public class DefaultProducerService extends BaseProducerService
		implements IMqProducerServer {

	/**
	 * @param message
	 * @return
	 */
	@Override
	public ReturnObject send(MessageVo message) {
		try {
			logger.info("发送消息中... ...");
			CorrelationData correlationId = new CorrelationData(getUUID());
			// asyncRabbitTemplate.convertSendAndReceive(MqConstantConfig.DIRECT_EXCHANGE_NAME,
			// MqConstantConfig.DIRECT_ROUTING_KEY, message.getMsgObj());
			rabbitTemplate.convertAndSend(MqConstantConfig.DIRECT_EXCHANGE_NAME, MqConstantConfig.DIRECT_ROUTING_KEY,
					message.getMsgObj(), correlationId);
		} catch (ListenerExecutionFailedException e) {
			String error = this.getStackTrace(e);
			return ReturnObject.generateFailedObject(error, message);
		}
		return ReturnObject.generateSuccessObject(message);
	}

	@Override
	protected void confirmAfterSendFail(CorrelationData correlationData, String cause) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void confirmAfterSendSuccess(CorrelationData correlationData) {
		// TODO Auto-generated method stub

	}

}
