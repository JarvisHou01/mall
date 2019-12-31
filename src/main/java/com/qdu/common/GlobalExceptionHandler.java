package com.qdu.common;

import com.qdu.exception.LoginException;
import com.qdu.exception.RegisterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 注解@ControllerAdvice在所有的Controller的方法上添加切面，<BR>
 * 当controller的方法有异常抛出的时候，<BR>
 * 会被GlobalExceptionHandler这个类中标注了@ExceptionHanlder注解的方法处理
 * 
 * @author lenovo
 *
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(LoginException.class)
	public ModelAndView handleLoginException(LoginException e) {
		log.error("登录异常信息", e);

		ModelAndView mv = new ModelAndView();
		// 这里的e.getMessage()获取的值就是创建LoginException传入构造方法中实际参数值
		mv.addObject("error", e.getMessage());
		mv.setViewName("login");
		return mv;
	}

	@ExceptionHandler(RegisterException.class)
	public ModelAndView handleRegisterException(RegisterException e){
		log.error("登录异常信息", e);
		ModelAndView mv = new ModelAndView();
		// 这里的e.getMessage()获取的值就是创建LoginException传入构造方法中实际参数值
		mv.addObject("error", e.getMessage());
		mv.setViewName("register");
		return mv;
	}

}
