package com.rabbitmq.mq.app.vo;

import java.io.Serializable;

/**
 * @author liu wp
 * @date  2017年9月26日
 */
public class MessageVo implements Serializable {
	/*** */
	private static final long serialVersionUID = 1L;


	/*** 消息信息 */
	private Object msgObj;
	/*** 消息发送者 */
	private String msgSender;

	/**
	 * @return the msgObj
	 */
	public Object getMsgObj() {
		return msgObj;
	}


	/**
	 * @return the msgSender
	 */
	public String getMsgSender() {
		return msgSender;
	}

	/**
	 * @param msgObj
	 *            the msgObj to set
	 */
	public void setMsgObj(Object msgObj) {
		this.msgObj = msgObj;
	}


	/**
	 * @param msgSender the msgSender to set
	 */
	public void setMsgSender(String msgSender) {
		this.msgSender = msgSender;
	}


	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageVo [msgObj=" + msgObj + ", msgSender=" + msgSender + ", getMsgObj()=" + getMsgObj()
				+ ", getMsgSender()=" + getMsgSender() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
