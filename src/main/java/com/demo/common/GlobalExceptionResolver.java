package com.demo.common;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GlobalExceptionResolver implements HandlerExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);
    // 被过滤的异常集合
    private Class<?>[] excludedExceptions;


    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        // 1.判断属于被过滤的异常？
        if (excludedExceptions != null&&excludedExceptions.length>0) {
            for (Class<?> excludedEx : excludedExceptions) {
                if (excludedEx.equals(exception.getClass())) {
                    return new ModelAndView();
                }
            }
        }
        JSONObject json = new JSONObject();
        json.put("code", 1);
        String msg = "商城太火爆啦,请稍后再试";
        //在没有指定http码的情况下,默认500,服务端异常
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        json.put("msg", msg);
        makeReturnJson(response, json, httpStatus);
        return new ModelAndView();
    }

    private void makeReturnJson(HttpServletResponse response, JSONObject json,HttpStatus httpStatus) {
        response.setStatus(httpStatus.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write(json.toJSONString());
        } catch (IOException e) {
            logger.error("与客户端通讯异常:" + e.getMessage(), e);
        }

    }
}