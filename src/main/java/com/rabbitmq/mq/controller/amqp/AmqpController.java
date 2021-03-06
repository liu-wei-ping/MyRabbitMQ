package com.rabbitmq.mq.controller.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rabbitmq.mq.app.vo.MessageVo;
import com.rabbitmq.mq.app.vo.ReturnObject;
import com.rabbitmq.mq.controller.BaseController;
import com.rabbitmq.mq.server.api.IMqProducerServer;

/**
 * @author liu wp
 * @date  2017年9月11日
 */
@Controller
public class AmqpController extends BaseController {
	@Autowired
	private IMqProducerServer iMqProducerServer;

	@ResponseBody
	@RequestMapping(value = "/sendDefault", method = RequestMethod.GET)
	public ReturnObject sendDefaultMsg(String msg) throws InterruptedException {
		// for (int i = 1; i <= 100; i++) {
		// }
		MessageVo vo = new MessageVo();
		vo.setMsgObj(msg);
		return iMqProducerServer.send(vo);
	}
}
