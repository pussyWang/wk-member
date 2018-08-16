package com.demo.controller;

import com.demo.bean.ObjSet;
import com.demo.bean.ObjVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("system")
public class SystemConfigController{
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

	@RequestMapping(value = "sendObject",method = RequestMethod.GET)
	@ResponseBody
	public String sendObj(@RequestParam Object obj){
    	if (obj != null){
    		logger.info("sendObj-->{}",obj);
		}
		return obj.toString();
	}


	@RequestMapping(value = "sendVO",method = RequestMethod.GET)
	@ResponseBody
	public String sendVO(@ModelAttribute ObjVO objVO){
		if (objVO != null){
			logger.info("sendObj-->{}",objVO);
		}
		return objVO.show();
	}

	@RequestMapping(value = "send",method = RequestMethod.POST)
	@ResponseBody
	public String send(@ModelAttribute ObjSet objSet){
    	if (objSet != null && !objSet.getObjVOS().isEmpty()){
    		logger.info("send-->{}",objSet.getObjVOS().size());
		}
		for (ObjVO vo : objSet.getObjVOS()){
    		logger.info("vo:{}",vo);
		}
		return "ok";
	}


}