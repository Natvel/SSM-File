package com.hp.dao.impl;

import java.util.ArrayList;

import com.hp.Entity.FsortEntity;
import com.hp.dao.FsortDao;
import com.hp.util.FsortPublic;

public class FsortDaoImpl implements FsortDao {
	
	//��Ӱ�������еĲ�ѯ����=
	public ArrayList<FsortEntity> GetFsotrInfo()
	{
		String sql="select * from fsort";
		
		return FsortPublic.GetStuInfo(sql);
	}
	
	//��Ӱ���������޸ĵķ�ѡ��ѯ
	public FsortEntity FsortReverseSelection(FsortEntity fs)
	{
		String sql="select * from fsort where sid=?";
		Object [] obj=new Object[]{fs.getSid()};
		return FsortPublic.FsortReverseSelection(sql, obj);
		
	}
	
	//��Ӱ�������е��޸�
	public int FsortModify(FsortEntity fs)
	{
		String sql="update fsort set sname=?,sremark=? where sid=?";
		Object [] obj=new Object[]{fs.getSname(),fs.getSremark(),fs.getSid()};
		return FsortPublic.FsortModify(sql, obj);
	}
	
	//��Ӱ�������е�����
	public int FsorAddInfo(FsortEntity fs)
	{
		String sql="insert into  fsort values(?,?)";
		Object [] obj=new Object[]{fs.getSname(),fs.getSremark()};
		
		return FsortPublic.FsortAdd(sql, obj);
	}

}
