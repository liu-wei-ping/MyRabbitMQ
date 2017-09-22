package com.rabbitmq.mq.app.producer;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

import org.springframework.util.SerializationUtils;

import com.rabbitmq.mq.app.EndPoint;

/**
 * @author liu wp
 * @date  2017年9月7日
 */
public class Producer extends EndPoint {

	public Producer(String endpointName) throws IOException, TimeoutException {
		super(endpointName);
		// TODO Auto-generated constructor stub
	}

	public void sendMessage(Serializable object) throws IOException {
		channel.basicPublish("", endPointName, null, SerializationUtils.serialize(object));
	}
}
