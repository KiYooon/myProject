package com.java.web.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.web.Service.BoardServiceInterface;
import com.java.web.util.HttpUtil;

@Controller
public class BoardController {
	
	@Autowired
	BoardServiceInterface bsi;

//	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
//	public ModelAndView addBoard(HttpServletRequest req){
//		return HttpUtil.returnJson(bsi.addBoard(HttpUtil.paramMap(req)));
//	}
	
	@RequestMapping(value = "/listBoard", method = RequestMethod.POST)
	public ModelAndView listBoard(HttpServletRequest req, HttpSession session){
		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("user");
		return HttpUtil.returnJson(bsi.listBoard(HttpUtil.paramMap(req)));
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.POST)
	public ModelAndView review(HttpServletRequest req, HttpSession session){
		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("user");
		
		System.out.println(req.getParameter("content"));
		System.out.println("controller : "+HttpUtil.paramMap(req));
		
		HashMap<String, Object> param = new HashMap<String,Object>();
//		param = (HashMap<String, Object>)user.get("login");
//		System.out.println("controller : " +param);
		
		param.put("content", req.getParameter("content"));
		param.put("no", req.getParameter("no"));
		param.put("name", user.get("name"));
		
		return HttpUtil.returnJson(bsi.review(param));
	}

	@RequestMapping(value = "/oneBoard", method = RequestMethod.POST)
	public ModelAndView oneBoard(HttpServletRequest req, HttpSession session){
		HashMap<String, Object> user = (HashMap<String, Object>) session.getAttribute("user");
		System.out.println(req.getParameter("no"));
		return HttpUtil.returnJson(bsi.oneBoard(HttpUtil.paramMap(req)));
	}
	

}