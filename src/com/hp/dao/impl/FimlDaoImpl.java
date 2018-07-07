package com.hp.dao.impl;


import java.util.ArrayList;

import com.hp.Entity.FimlEntity;
import com.hp.dao.FimlDao;
import com.hp.util.FimlPublic;

public class FimlDaoImpl implements FimlDao{
	 //fiml���е��޸�
	public int FimlModify(FimlEntity fimle)
	{
		String sql="update fiml set sid=?,fname=?,fauto=?,ontime=?,fremark=? where fid=?";
		Object [] obj=new Object[]{fimle.getFsort().getSid(),fimle.getFname(),fimle.getFauto(),fimle.getOntime(),fimle.getFremark(),fimle.getFid()};
     	return	FimlPublic.FimlModify(sql, obj);
	}
	
	//fiml�����޸ĵķ�ѡ
	public FimlEntity FimlReverseSelection(FimlEntity fimle)
	{
		String sql="select  sname,fid,fname,fauto,ontime,fremark,fflag,fsort.sid from fsort,fiml where  fid=? and fsort.sid=fiml.sid";
		Object [] obj=new Object[]{fimle.getFid()};
		return FimlPublic.FimlReverseSelection(sql, obj);
	}
	
	
	//fiml��������
	public int FimlAddInfo(FimlEntity fimle)
	{
		String sql="insert into fiml values(?,?,?,?,?,1)";
		Object [] obj=new Object[]{fimle.getFsort().getSid(),fimle.getFname(),fimle.getFauto(),fimle.getOntime(),fimle.getFremark()};
		return FimlPublic.FsortAdd(sql, obj);
	}
	
	//fiml���еĲ�ѯ
	public ArrayList<FimlEntity> GetFimlInfo()
	{
		String sql="select * from fiml where fflag=1";
		return FimlPublic.GetStuInfo(sql);
	}
	
	//fiml���е��¼�
	public int LowerFrame(FimlEntity fimle)
	{
		String sql="update fiml set fflag=0 where fid=?";
		Object [] obj=new Object[]{fimle.getFid()};
		return FimlPublic.FimlModify(sql, obj);
		
	}
	
	//fiml���в鿴�¼�
	public ArrayList<FimlEntity> GetLowerFrame()
	{
		String sql="select sname,fid,fname,fauto,ontime,fremark,fsort.sid from fsort,fiml where fsort.sid=fiml.sid and fflag=0";
		return FimlPublic.GetLowerFrame(sql);
	}
	
	//fiml���е��ϼ�
	public int OnTheShelf(FimlEntity fimle)
	{
		String sql="update fiml set fflag=1 where fid=?";
		Object [] obj=new Object[]{fimle.getFid()};
		return FimlPublic.FimlModify(sql, obj);
	}


}
