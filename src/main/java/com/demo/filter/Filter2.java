package com.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;

/**
 * Created by wangkang04 on 2018/9/28
 **/
public class Filter2 implements Filter {
	private static final Logger logger = LoggerFactory.getLogger(Filter2.class);

	@Override
	public void init(FilterConfig filterConfig) {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
		try {
			logger.info("into filter2");
			filterChain.doFilter(servletRequest,servletResponse);
		}catch (Exception e){
			logger.info("filter2 error:{}",e);
		}
	}

	@Override
	public void destroy() {

	}
}
