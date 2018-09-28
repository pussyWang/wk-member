package com.demo.filter;

/**
 * Created by Liang on 2017/3/27.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GlobalFilter extends HttpServlet implements Filter {

    private static final long serialVersionUID = -2142844424865103505L;

    private static final Logger logger = LoggerFactory.getLogger(GlobalFilter.class);
    /**
     * filter配置对象
     */
    private FilterConfig config;


    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        String uri = request.getRequestURI();
        logger.info("into globalfilter:dofilter-->{}",uri);
        try {
            filterChain.doFilter(request, response);
        } catch (Exception ex) {
            logger.error("filter error : {}", ex);
            filterChain.doFilter(request, response);
        }
    }


    /**
     * 初始化config对象
     */
    public void init(FilterConfig arg0) throws ServletException {
        config = arg0;
    }
}