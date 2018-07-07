package com.hp.dao.impl;

import java.util.ArrayList;

import com.hp.Entity.EmpEntity;
import com.hp.Entity.FimlEntity;
import com.hp.dao.EmpDao;
import com.hp.util.EmpPublic;
import com.hp.util.FimlPublic;

public class EmpDaoImpl implements EmpDao{
	
        //emp���еĲ�ѯ
		public ArrayList<EmpEntity> GetEmpInfo()
		{
			String sql="select * from emp";
			return EmpPublic.GetEmpInfo(sql);
			
		}
		
		//emp�����޸ĵķ�ѡ
		public EmpEntity EmpReverseSelection(EmpEntity Empe)
		{
			String sql="select * from emp where eid=?";
			Object [] obj=new Object[]{Empe.getEid()};
			return EmpPublic.EmpReverseSelection(sql, obj);
		}

		
		 //Emp���е��޸�
		public int EmpModify(EmpEntity Empe)
		{
			String sql="update emp set ename=?,esex=?,egw=? where eid=?";
			Object [] obj=new Object[]{Empe.getEname(),Empe.getEsex(),Empe.getEgw(),Empe.getEid()};
	     	return	EmpPublic.EmpModify(sql, obj);
		}
		
		//Emp���е�����
		public int EmpAddInfo(EmpEntity Empe)
		{
			String sql="insert into emp  values(?,?,?)";
			Object [] obj=new Object[]{Empe.getEname(),Empe.getEsex(),Empe.getEgw()};
			return FimlPublic.FsortAdd(sql, obj);
		}
		
		
}
