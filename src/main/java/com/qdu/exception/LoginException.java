package com.qdu.exception;

/**
 * 定制登录异常
 * 
 * @author lenovo
 *
 */
public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginException(String message) {
		super(message);
	}

}
