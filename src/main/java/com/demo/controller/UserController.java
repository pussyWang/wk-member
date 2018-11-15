package com.demo.controller;

import com.demo.annotation.OperationVerify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangkang04 on 2018/9/28
 **/
@Controller
@OperationVerify
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(SystemConfigController.class);

//	@Resource
//	CcsTokenService ccsTokenService;


	@RequestMapping("/userinfo")
	@ResponseBody
	public String userinfo(){
		logger.info("into userinfo");
		return "ok";
	}

	@RequestMapping("/userauth")
	@ResponseBody
	public String userauth(){
		logger.info("into userinfo");
		Integer appid = 3;

		//CommonVo commonVo = ccsTokenService.validateToKen(appid,);
		return "ok";
	}
}
