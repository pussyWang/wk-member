package com.demo.interceptor;

import com.demo.annotation.OperationVerify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangkang04 on 2018/9/28
 **/
public class OperVerifyInterceptor implements HandlerInterceptor{
	private static final Logger logger = LoggerFactory.getLogger(OperVerifyInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (handler instanceof HandlerMethod){
			HandlerMethod h = (HandlerMethod)handler;
			if (h.hasMethodAnnotation(OperationVerify.class)){
				logger.info("has OperationVerify");
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
		String uri = request.getRequestURI();
		if (uri.endsWith("checkServerHealth")){
			logger.info("into postHandler");
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		String uri = request.getRequestURI();
		if (uri.endsWith("checkServerHealth")){
			logger.info("into afterHandler");
		}
	}
}
