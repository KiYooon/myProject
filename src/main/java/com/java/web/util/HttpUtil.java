package com.java.web.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class HttpUtil {
	public static ModelAndView returnJson(final HashMap<String, Object> result) {
		
		ModelAndView mav = new ModelAndView();
		
		JSONObject jsonObject = new JSONObject();
		 jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(result));
		 mav.addObject("message", jsonObject.toString());	
		 mav.setViewName("json");
		 
		 return mav;
		
	}
//	public static HashMap<String, Object> paramMap(HttpServletRequest req) {
//		HashMap<String, Object> params = new HashMap<String, Object>();
//		
//		Enumeration<?> enums = req.getParameterNames();
//		
//		while(enums.hasMoreElements()){
//			String paramName = (String) enums.nextElement();
//			String[] parameters = req.getParameterValues(paramName);
//			
//			if(parameters.length > 1){
//				params.put(paramName, parameters);
//			}else{
//				//예외처리 할 경우에만 사용할 것
//			}
//		}
//		
//		return params;
//	}
	
	public static void sendResponceToJson(HttpServletResponse response, final HashMap<String, Object> map) {
		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(map));
		try {
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
   public static HashMap<String, Object> paramMap(HttpServletRequest req) {
	      HashMap<String, Object> params = new HashMap<String, Object>();
	      Enumeration<?> enums = req.getParameterNames();
	      while (enums.hasMoreElements()) {
	         String paramName = (String) enums.nextElement();
	         String[] parameters = req.getParameterValues(paramName);
	         if (parameters.length > 1) {
	            params.put(paramName, parameters);
	         } else {
	            try {
	               params.put(paramName, parameters[0]);

	            } catch (Exception e) {
	               e.printStackTrace();
	            }
	         }
	      }
	      return params;
	   }
}
