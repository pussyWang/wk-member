package com.demo.system.config.controller;

import com.demo.common.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("web20/system")
public class SystemConfigController extends BaseAction {
    private static final Logger logger = LoggerFactory.getLogger(SystemConfigController.class);

    @RequestMapping("/checkServerHealth")
	@ResponseBody
	public String checkServerHealth(){
		return "ok";
	}
}