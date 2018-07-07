package com.hp.serivce.impl;

import java.util.ArrayList;

import com.hp.Entity.HallEntity;
import com.hp.dao.HallDao;
import com.hp.dao.impl.HallDaoImpl;
import com.hp.serivce2.HallSerivce;

public class HallSerivceImpl implements HallSerivce{
	HallDao hall=new HallDaoImpl();
	
	public ArrayList<HallEntity> GetFimlInfo()
	{
		return hall.GetFimlInfo();
	}

	public int FimlModify(HallEntity Halle)
	{
		return hall.FimlModify(Halle);
	}
	
	public int HallAddInfo(HallEntity Halle)
	{
		return hall.HallAddInfo(Halle);
	}
	
	public HallEntity HallReverseSelection(HallEntity fimle)
	{
		return hall.HallReverseSelection(fimle);
	}
	
	public int getSeat(HallEntity Halle)
	{
		return hall.getSeat(Halle);
	}
}
