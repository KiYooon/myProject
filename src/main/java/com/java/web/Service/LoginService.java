package com.java.web.Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.web.Dao.DaoInterface;
import com.java.web.bean.DaoBean;

@Service
public class LoginService implements LoginServiceInterface {

	@Autowired
	DaoInterface di;
	
	private final String ns = "user";
	private HashMap<String, Object> result;
	private HashMap<String, Object> chk;
	private DaoBean bean;
	private boolean check;
	
	@Override
	public HashMap<String, Object> login(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();
		bean = new DaoBean("SelectOne", ns+".login", param);
		chk = (HashMap<String,Object>) di.dao(bean);
		
		if(!(chk==null)){
			result = (HashMap<String,Object>) di.dao(bean);
			result.put("status", 1);
			return result;
		}else{
			result.put("status", 0);
			return result;
		}
		
	}

}
