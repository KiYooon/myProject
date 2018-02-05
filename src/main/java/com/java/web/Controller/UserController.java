package com.java.web.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.web.Service.LoginServiceInterface;
import com.java.web.Service.UserServiceInterface;
import com.java.web.util.HttpUtil;

@Controller
public class UserController {
	@Autowired
	UserServiceInterface usi;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(HttpServletResponse resp, HttpServletRequest req){
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", id);
		map.put("pw", pw);
		map.put("name", name);
		map.put("email", email);
		
		map = usi.addUser(map);
		
		HttpUtil.sendResponceToJson(resp, map);
//		return HttpUtil.returnJson(usi.addUser(HttpUtil.paramMap(req)));
	}
	
}
