package com.hp.dao.impl;

import java.util.ArrayList;

import com.hp.Entity.FsortEntity;
import com.hp.dao.FsortDao;
import com.hp.util.FsortPublic;

public class FsortDaoImpl implements FsortDao {
	
	//电影类别管理中的查询方法=
	public ArrayList<FsortEntity> GetFsotrInfo()
	{
		String sql="select * from fsort";
		
		return FsortPublic.GetStuInfo(sql);
	}
	
	//电影类别管理中修改的反选查询
	public FsortEntity FsortReverseSelection(FsortEntity fs)
	{
		String sql="select * from fsort where sid=?";
		Object [] obj=new Object[]{fs.getSid()};
		return FsortPublic.FsortReverseSelection(sql, obj);
		
	}
	
	//电影类别管理中的修改
	public int FsortModify(FsortEntity fs)
	{
		String sql="update fsort set sname=?,sremark=? where sid=?";
		Object [] obj=new Object[]{fs.getSname(),fs.getSremark(),fs.getSid()};
		return FsortPublic.FsortModify(sql, obj);
	}
	
	//电影类别管理中的新增
	public int FsorAddInfo(FsortEntity fs)
	{
		String sql="insert into  fsort values(?,?)";
		Object [] obj=new Object[]{fs.getSname(),fs.getSremark()};
		
		return FsortPublic.FsortAdd(sql, obj);
	}

}
