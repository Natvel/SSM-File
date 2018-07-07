package com.hp.dao.impl;


import java.util.ArrayList;

import com.hp.Entity.FimlEntity;
import com.hp.dao.FimlDao;
import com.hp.util.FimlPublic;

public class FimlDaoImpl implements FimlDao{
	 //fiml表中的修改
	public int FimlModify(FimlEntity fimle)
	{
		String sql="update fiml set sid=?,fname=?,fauto=?,ontime=?,fremark=? where fid=?";
		Object [] obj=new Object[]{fimle.getFsort().getSid(),fimle.getFname(),fimle.getFauto(),fimle.getOntime(),fimle.getFremark(),fimle.getFid()};
     	return	FimlPublic.FimlModify(sql, obj);
	}
	
	//fiml表中修改的反选
	public FimlEntity FimlReverseSelection(FimlEntity fimle)
	{
		String sql="select  sname,fid,fname,fauto,ontime,fremark,fflag,fsort.sid from fsort,fiml where  fid=? and fsort.sid=fiml.sid";
		Object [] obj=new Object[]{fimle.getFid()};
		return FimlPublic.FimlReverseSelection(sql, obj);
	}
	
	
	//fiml表中新增
	public int FimlAddInfo(FimlEntity fimle)
	{
		String sql="insert into fiml values(?,?,?,?,?,1)";
		Object [] obj=new Object[]{fimle.getFsort().getSid(),fimle.getFname(),fimle.getFauto(),fimle.getOntime(),fimle.getFremark()};
		return FimlPublic.FsortAdd(sql, obj);
	}
	
	//fiml表中的查询
	public ArrayList<FimlEntity> GetFimlInfo()
	{
		String sql="select * from fiml where fflag=1";
		return FimlPublic.GetStuInfo(sql);
	}
	
	//fiml表中的下架
	public int LowerFrame(FimlEntity fimle)
	{
		String sql="update fiml set fflag=0 where fid=?";
		Object [] obj=new Object[]{fimle.getFid()};
		return FimlPublic.FimlModify(sql, obj);
		
	}
	
	//fiml表中查看下架
	public ArrayList<FimlEntity> GetLowerFrame()
	{
		String sql="select sname,fid,fname,fauto,ontime,fremark,fsort.sid from fsort,fiml where fsort.sid=fiml.sid and fflag=0";
		return FimlPublic.GetLowerFrame(sql);
	}
	
	//fiml表中的上架
	public int OnTheShelf(FimlEntity fimle)
	{
		String sql="update fiml set fflag=1 where fid=?";
		Object [] obj=new Object[]{fimle.getFid()};
		return FimlPublic.FimlModify(sql, obj);
	}


}
