package com.qhit.lh.g4.chx.t02;

import java.util.List;

import com.qhit.lh.g4.chx.t02.bean.UserInfo;
import com.qhit.lh.g4.chx.t02.dao.impl.BaseDaoImpl;
import com.qhit.lh.g4.chx.t02.service.BaseService;

public class UserText {
	private BaseService baseService=new BaseDaoImpl();
      public void login(){
    	  UserInfo user=new UserInfo();
    	  user.setUserName("sa");
    	  user.setPassword("123456");
    	  List<UserInfo> users=baseService.login(user);
    	  if (users!=null && users.size()>0) {
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
      }
}
