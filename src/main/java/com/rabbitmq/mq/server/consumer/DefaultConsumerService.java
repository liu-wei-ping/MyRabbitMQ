package com.rabbitmq.mq.server.consumer;

import org.springframework.stereotype.Service;

import com.rabbitmq.mq.server.api.IMqConsumerServer;

/**
 * @author liu wp
 * @date  2017年9月8日
 */
@Service
// @RabbitListener(queues = MqConstantConfig.DIRECT_QUEUE_NAME)
public class DefaultConsumerService extends BaseConsumerService implements IMqConsumerServer {


	/**
	 * @param request
	 */
	// @RabbitListener(queues = {
	// MqConstantConfig.DIRECT_QUEUE_NAME }, containerFactory =
	// "rabbitListenerContainerFactory")
	// // @SendTo("消息队列名称" + MqConstantConfig.DIRECT_QUEUE_NAME)
	// public void consumer(@Payload String request) {
	// logger.info("接收到的消息：" + request);
	// }

	// @RabbitHandler
	// public void consumer2(String request) {
	// logger.info("接收到的消息" + request);
	// }


}
