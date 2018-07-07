package com.hp.serivce.impl;

import java.util.ArrayList;

import com.hp.Entity.SaleEntity;
import com.hp.dao.ProitDao;
import com.hp.dao.impl.ProitDaoImpl;
import com.hp.serivce2.ProitSerivce;

public class ProitSerivceImpl implements ProitSerivce{
	
	ProitDao pro=new ProitDaoImpl();
	
	public ArrayList<SaleEntity> GetSalelInfo()
	{
		return pro.GetSalelInfo();
	}
	
	public ArrayList<SaleEntity> GetSalelInfo2(SaleEntity sa)
	{
		return pro.GetSalelInfo2(sa);
	}
	
	public float JiSuanOne(SaleEntity sa)
	{
		return pro.JiSuanOne(sa);
	}
	
	public ArrayList<SaleEntity> TotalIncome()
	{
		return pro.TotalIncome();
	}
	
	public double a()
	{
		return pro.a();
	}

}
