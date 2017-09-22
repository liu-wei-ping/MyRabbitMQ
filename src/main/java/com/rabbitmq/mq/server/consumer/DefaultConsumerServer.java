package com.rabbitmq.mq.server.consumer;

import org.springframework.stereotype.Component;

import com.rabbitmq.mq.server.api.IMqConsumerServer;

/**
 * @author liu wp
 * @date  2017年9月8日
 */
@Component
public class DefaultConsumerServer extends BaseConsumerServer implements IMqConsumerServer {

	/**
	 * @param request
	 */
	// @RabbitListener(queues = {
	// MqConstantConfig.DEFAULT_QUEUE_NAME }, containerFactory =
	// "rabbitListenerContainerFactory")
	// @SendTo("消息队列名称" + MqConstantConfig.DEFAULT_QUEUE_NAME)
	// public void consumer(@Payload String request) {
	// logger.info("接收到的消息" + request);
	// }


}
