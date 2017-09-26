package com.rabbitmq.mq.server;

import java.util.UUID;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liu wp
 * @date  2017年9月26日
 */
public class BaseService {
	/** 日志类 */
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());

	/**
	 * 获取异常的堆栈信息
	 *
	 * @param t
	 * @return
	 */
	protected String getStackTrace(Throwable ex) {
		return ExceptionUtils.getMessage(ex);
	}

	protected String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
