package com.hp.serivce.impl;

import com.hp.Entity.UserEntity;
import com.hp.dao.UserinfoDao;
import com.hp.dao.impl.UserInfoDaoImpl;
import com.hp.serivce2.UserinfoSerivce;

public class UserinfoSerivceImpl implements UserinfoSerivce {
	
	UserinfoDao user=new UserInfoDaoImpl();
	
	public String Verification(UserEntity us)
	{
		return user.Verification(us);
	}

}
