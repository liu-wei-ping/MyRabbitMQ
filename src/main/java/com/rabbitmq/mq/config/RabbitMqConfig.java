package com.rabbitmq.mq.config;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author liu wp
 * @date 2017年9月8日
 */
@Configuration
public class RabbitMqConfig {
	@Value("${spring.rabbitmq.host}")
	private String host;
	@Value("${spring.rabbitmq.password}")
	private String password;
	@Value("${spring.rabbitmq.port}")
	private int port;
	@Value("${spring.rabbitmq.publisherConfirms}")
	private boolean publisherConfirms;
	@Value("${spring.rabbitmq.username}")
	private String username;
	@Value("${spring.rabbitmq.virtualHost}")
	private String virtualHost;



	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		connectionFactory.setHost(host);
		connectionFactory.setPort(port);
		connectionFactory.setVirtualHost(virtualHost);
		// 如果要进行消息回调，则这里必须要设置为true
		connectionFactory.setPublisherConfirms(publisherConfirms);
		return connectionFactory;
	}


	// @Bean
	// public MessageListenerAdapter messageListenerAdapter() {
	// MessageListenerAdapter messageListenerAdapter = new
	// MessageListenerAdapter();
	// ReceiveMsgHandler receiveMsgHandler = new ReceiveMsgHandler();
	// messageListenerAdapter.setDelegate(receiveMsgHandler);
	// return messageListenerAdapter;
	// }

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setMessageConverter(new Jackson2JsonMessageConverter());
		return factory;
	}

	/**
	 * 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
	 *
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public RabbitTemplate rabbitTemplatenew() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setMessageConverter(new Jackson2JsonMessageConverter());
		// AsyncRabbitTemplate cc = new AsyncRabbitTemplate(template,
		// messageContainer());
		// template.setConfirmCallback(confirmCallback());
		return template;
	}
}
