package com.java.web.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.web.Service.LoginServiceInterface;
import com.java.web.util.HttpUtil;

@Controller
public class LoginController {
	@Autowired
	LoginServiceInterface lsi;
	
	@RequestMapping(value = "/LoginCheck", method = RequestMethod.POST)
	public void LoginCheck(HttpServletResponse resp, HttpSession session) {
		HashMap<String, Object> user = (HashMap<String, Object>)session.getAttribute("user");
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if (user == null) {
			map.put("status", 0);
		} else {
			map.put("status", 1);
		}
		HttpUtil.sendResponceToJson(resp, map);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, HttpSession session){
	  	HashMap<String, Object> user = new HashMap<String,Object>(); 
	  	user=lsi.login(HttpUtil.paramMap(req));
	  	System.out.println("Controller" + user);

	  	session.setAttribute("user", user);
	  	return HttpUtil.returnJson(user);
	}

	   @RequestMapping("/logout")
	   public String logout(HttpSession session){
	      session.invalidate();      
	      return "project";
	   }
}
