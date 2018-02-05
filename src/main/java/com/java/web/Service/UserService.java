package com.java.web.Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.web.Dao.DaoInterface;
import com.java.web.bean.DaoBean;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	DaoInterface di;
	
	private final String ns = "user";
	private HashMap<String, Object> result;
	private DaoBean bean;
	private boolean check;
	
	@Override
	public HashMap<String, Object> addUser(HashMap<String, Object> param) {
		result = new HashMap<String, Object>();
		
		bean = new DaoBean("SelectOne", ns+".chkId", param);
		/*result.put("chkId", di.dao(bean));*/
		HashMap<String,Object> Idchk = (HashMap<String,Object>) di.dao(bean);
		
		if(Idchk == null){
			bean = new DaoBean("Insert", ns+".addUser", param);
			result.put("status", di.dao(bean));
			return result;
		}else{
			result.put("status", 0);
			return result;
		}
		
	}
}
