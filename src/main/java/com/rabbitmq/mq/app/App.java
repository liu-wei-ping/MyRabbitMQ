package com.rabbitmq.mq.app;

import java.util.HashMap;

import com.rabbitmq.mq.app.consumer.QueueConsumer;
import com.rabbitmq.mq.app.producer.Producer;

/**
 * @author liu wp
 * @date 2017年9月7日
 */
public class App {
	public static void main(String[] args) {
		try {
			new App();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public App() throws Exception {

		QueueConsumer consumer = new QueueConsumer("queue");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();

		Producer producer = new Producer("queue");

		for (int i = 0; i < 100000; i++) {
			HashMap message = new HashMap();
			message.put("message number", i);
			producer.sendMessage(message);
			System.out.println("Message Number " + i + " sent.");
		}
	}
}
