package com.demo.controller;

import com.demo.common.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("system")
public class SystemConfigController extends BaseAction {
    private static final Logger logger = LoggerFactory.getLogger(SystemConfigController.class);

    @RequestMapping("/checkServerHealth")
	@ResponseBody
	public String checkServerHealth(){
		return "ok";
	}

	@RequestMapping(value = "/sendSet",method = RequestMethod.GET)
	@ResponseBody
	public String send(@RequestParam Set<String> stringSet){
    	if (!stringSet.isEmpty()){
    		logger.info("send-->{}",stringSet.toString());
		}
    	return stringSet.toString();
	}

	@RequestMapping(value = "sendList",method = RequestMethod.GET)
	@ResponseBody
	public String sendList(@RequestParam List<String> stringList){
    	if (!stringList.isEmpty()){
    		logger.info("sendList-->{}",stringList);
		}
		return stringList.toString();
	}


	@RequestMapping(value = "sendMap",method = RequestMethod.GET)
	@ResponseBody
	public String sendMap(@RequestParam Map<String,String> map){
    	if (!map.isEmpty()){
    		logger.info("sendMap-->{}",map.toString());
		}
		return map.toString();
	}


}