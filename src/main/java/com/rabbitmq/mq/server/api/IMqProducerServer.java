package com.rabbitmq.mq.server.api;

import com.rabbitmq.mq.app.vo.MessageVo;
import com.rabbitmq.mq.app.vo.ReturnObject;

/**
 * @author liu wp
 * @date  2017年9月8日
 */
public interface IMqProducerServer {

	/**
	 * @param message
	 * @return
	 */
	ReturnObject send(MessageVo message);
}
