package com.demo.common;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class BaseAction {

	
	public Map<String, Object> getSuccessResult() {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("success", true);
		return result;
	}

	public Map<String, Object> getSuccessResult(String msg) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", msg);
		result.put("success", true);
		return result;
	}

	public Map<String, Object> getErrorResult(String errorMsg) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 1);
		result.put("msg", errorMsg);
		result.put("success", false);
		return result;
	}

	public Map<String, Object> getErrorResult(int code, String errorMsg) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", code);
		result.put("msg", errorMsg);
		result.put("success", false);
		return result;
	}

	public Map<String, Object> getSuccessResult(String msg, Map data) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", msg);
		result.put("data", data);
		return result;
	}

	/**
	 * 对map进行深拷贝,否则去除冗余参数的时候会发生异常: No modifications are allowed to a locked ParameterMap
	 * @param request
	 * @return
	 */
	public static Map getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map properties = request.getParameterMap();
		// 返回值Map
		Map returnMap = new HashMap();
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "", value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}
}
