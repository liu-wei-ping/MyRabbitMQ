package com.rabbitmq.mq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.mq.constants.MqConstantConfig;

/**
 * @author liu wp
 * @date  2017年9月12日
 */
@Configuration
public class RabbitMqExchange {
	/** 日志类 */
	private final Logger logger = LoggerFactory.getLogger(super.getClass());
	/**
	 * 将队列绑定到交换机
	 *
	 * @return
	 */
	@Bean
	public Binding directBinding() {
		return BindingBuilder.bind(directQueue()).to(directExchange()).with(MqConstantConfig.DIRECT_ROUTING_KEY);
	}

	/**
	 * 按照routingkey分发到指定队列
	 *
	 * @return
	 */
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(MqConstantConfig.DIRECT_EXCHANGE_NAME);
	}

	@Bean
	public Queue directQueue() {
		return new Queue(MqConstantConfig.DIRECT_QUEUE_NAME, true);// true:持久化
	}

	@Bean
	public Binding fanoutBinding() {
		return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
	}

	/**
	 * 将消息分发到所有的绑定队列，无routingkey的概念
	 *
	 * @return
	 */
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(MqConstantConfig.FANOUT_EXCHANGE_NAME);
	}
	@Bean
	public Queue fanoutQueue() {
		return new Queue(MqConstantConfig.FANOUT_QUEUE_NAME, true);// true:持久化
	}

	@Bean
	public Binding headersBinding() {
		return null;
	}

	/**
	 * 通过添加属性key-value匹配
	 *
	 * @return
	 */
	@Bean
	public HeadersExchange headersExchange(){
		return new HeadersExchange(MqConstantConfig.HEADERS_EXCHANGE_NAME);
	}

	@Bean
	public Queue headersQueue() {
		return new Queue(MqConstantConfig.HEADERS_QUEUE_NAME, true);// true:持久化
	}

	@Bean
	public Binding  topicBinding(){
		return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(MqConstantConfig.TOPIC_ROUTING_KEY);
	}

	/**
	 * 多关键字匹配
	 *
	 * @return
	 */
	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(MqConstantConfig.TOPIC_EXCHANGE_NAME);
	}

	@Bean
	public Queue topicQueue() {
		return new Queue(MqConstantConfig.TOPIC_QUEUE_NAME, true);
	}
}
