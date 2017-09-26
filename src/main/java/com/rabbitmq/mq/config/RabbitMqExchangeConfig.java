package com.rabbitmq.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.mq.constants.MqConstantConfig;

/**
 *
 * 1.定义消息队列 xxxQueue<br>
 * 2.定义交换机 xxxExchange <br>
 * 3.将消息队列绑定到交换机 xxxBinding
 *
 * @author liu wp
 * @date 2017年9月25日
 */
@Configuration
@AutoConfigureAfter(RabbitMqConfig.class)
public class RabbitMqExchangeConfig {

	/***
	 * 是否持久化 <br>
	 * true:是 false:否
	 */
	final static boolean IS_PERSISTED = true;

	/********************************
	 * direct(直连交换机) <br>
	 * 按照routingkey分发到指定队列
	 *****************************************/
	@Bean
	public Binding directBinding() {
		return BindingBuilder.bind(directQueue()).to(directExchange()).with(MqConstantConfig.DIRECT_ROUTING_KEY);
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(MqConstantConfig.DIRECT_EXCHANGE_NAME);
	}

	@Bean
	public Queue directQueue() {
		return new Queue(MqConstantConfig.DIRECT_QUEUE_NAME, IS_PERSISTED);
	}

	/********************************
	 * fanout(扇型交换机) <br>
	 * 将消息分发到所有的绑定队列，无routingkey的概念
	 *****************************************/
	@Bean
	public Binding fanoutBinding() {
		return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
	}

	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(MqConstantConfig.FANOUT_EXCHANGE_NAME);
	}

	@Bean
	public Queue fanoutQueue() {
		return new Queue(MqConstantConfig.FANOUT_QUEUE_NAME, IS_PERSISTED);
	}

	/*****************************
	 * headers(头交换机) <br>
	 * 通过添加属性key-value匹配
	 *****************************************/
	@Bean
	public Binding headersBinding() {
		return BindingBuilder.bind(headersQueue()).to(headersExchange()).whereAll(MqConstantConfig.HEADERS_KEY_MAP)
				.match();
	}

	@Bean
	public HeadersExchange headersExchange(){
		return new HeadersExchange(MqConstantConfig.HEADERS_EXCHANGE_NAME);
	}

	@Bean
	public Queue headersQueue() {
		return new Queue(MqConstantConfig.HEADERS_QUEUE_NAME, IS_PERSISTED);
	}

	/********************************
	 * topic(主题交换机)<br>
	 * 多关键字匹配
	 *****************************************/
	@Bean
	public Binding topicBinding() {
		return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(MqConstantConfig.TOPIC_ROUTING_KEY);
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(MqConstantConfig.TOPIC_EXCHANGE_NAME);
	}

	@Bean
	public Queue topicQueue() {
		return new Queue(MqConstantConfig.TOPIC_QUEUE_NAME, IS_PERSISTED);
	}
}
