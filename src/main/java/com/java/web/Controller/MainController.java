package com.java.web.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.web.util.HttpUtil;
import com.java.web.util.MailService;

@Controller
public class MainController {
	@RequestMapping("/")
	public String project(){
		return "/project";
	}
	
	@RequestMapping(value = "/mail", method = RequestMethod.POST)
	public ModelAndView mail(HttpServletRequest req){
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("status", MailService.sendMail(HttpUtil.paramMap(req)));
		return HttpUtil.returnJson(result);
	}
}
