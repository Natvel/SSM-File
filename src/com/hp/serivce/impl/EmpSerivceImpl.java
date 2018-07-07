package com.hp.serivce.impl;

import java.util.ArrayList;

import com.hp.Entity.EmpEntity;
import com.hp.dao.EmpDao;
import com.hp.dao.impl.EmpDaoImpl;
import com.hp.serivce2.EmpSerivce;

public class EmpSerivceImpl implements EmpSerivce{
	EmpDao emp=new EmpDaoImpl();
	
	public ArrayList<EmpEntity> GetEmpInfo()
	{
		return emp.GetEmpInfo();
	}
	
	public EmpEntity EmpReverseSelection(EmpEntity Empe)
	{
		return emp.EmpReverseSelection(Empe);
	}
	
	public int EmpModify(EmpEntity Empe)
	{
		return emp.EmpModify(Empe);
	}
	
	public int EmpAddInfo(EmpEntity Empe)
	{
		return emp.EmpAddInfo(Empe);
	}

}
