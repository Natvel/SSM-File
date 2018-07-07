package com.hp.dao.impl;

import com.hp.Entity.UserEntity;
import com.hp.dao.UserinfoDao;
import com.hp.util.FsortPublic;

public class UserInfoDaoImpl implements UserinfoDao {
	
	public String Verification(UserEntity us)
	{
		String sql="select * from userinfo where uname=? and upsw=?";
		Object [] obj=new Object[]{us.getUname(),us.getUpsw()};
	    return FsortPublic.Verification(sql, obj);
	}

}
