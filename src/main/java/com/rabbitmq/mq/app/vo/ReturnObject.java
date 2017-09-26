package com.rabbitmq.mq.app.vo;

import java.io.Serializable;

import com.rabbitmq.mq.constants.SysConstantsConfig;

/**
 * 统一返回对象
 *
 * @author liu wp
 * @date 2017年9月26日
 */
public class ReturnObject implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 错误返回
	 *
	 * @param msg
	 * @param obj
	 * @return
	 */
	public static ReturnObject generateFailedObject(String msg, Object obj) {
		ReturnObject returnObject = new ReturnObject();
		returnObject.setCode(SysConstantsConfig.DEFAULT_RETURN_FAIL_CODE);
		returnObject.setMessage(msg);
		returnObject.setObj(obj);
		return returnObject;
	}
	/**
	 * 成功返回
	 *
	 * @param obj
	 * @return
	 */
	public static ReturnObject generateSuccessObject(Object obj) {
		ReturnObject returnObject = new ReturnObject();
		returnObject.setCode(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_CODE);
		returnObject.setMessage(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_MESSAGE);
		returnObject.setObj(obj);
		return returnObject;
	}
	public static ReturnObject getReturnMsg(String code, String message) {
		ReturnObject returnObject = new ReturnObject();
		returnObject.setCode(code);
		returnObject.setMessage(message);
		return returnObject;
	}

	public static ReturnObject respSuccess() {
		ReturnObject returnObject = new ReturnObject();
		returnObject.setCode(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_CODE);
		returnObject.setMessage(SysConstantsConfig.DEFAULT_RETURN_SUCCESS_MESSAGE);
		return returnObject;
	}

	// 返回状态
	private String code;


	// 返回提示信息
	private String message;

	// 返回结果对象
	private Object obj;

	public ReturnObject() {
		this.code = SysConstantsConfig.DEFAULT_RETURN_FAIL_CODE;
		this.message = SysConstantsConfig.DEFAULT_RETURN_FAIL_MESSAGE;
	}

	public ReturnObject(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getObj() {
		return obj;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}



}
