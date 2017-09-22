package com.rabbitmq.mq.app.consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.springframework.util.SerializationUtils;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.mq.app.EndPoint;

/**
 * @author liu wp
 * @date  2017年9月7日
 */
public class QueueConsumer extends EndPoint implements Runnable, Consumer {

	public QueueConsumer(String endpointName) throws IOException, TimeoutException {
		super(endpointName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handleCancel(String consumerTag) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleCancelOk(String consumerTag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleConsumeOk(String consumerTag) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("rawtypes")
	@Override
	public void handleDelivery(String consumerTag, Envelope env, BasicProperties props, byte[] body)
			throws IOException {
		Map map = (HashMap) SerializationUtils.deserialize(body);
		System.out.println("Message Number " + map.get("message number") + " received.");

	}

	@Override
	public void handleRecoverOk(String consumerTag) {
		System.out.println("Consumer " + consumerTag + " registered");

	}

	@Override
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		try {
			// start consuming messages. Auto acknowledge messages.
			channel.basicConsume(endPointName, true, this);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
