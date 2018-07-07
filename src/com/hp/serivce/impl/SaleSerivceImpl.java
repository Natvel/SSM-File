package com.hp.serivce.impl;

import java.util.ArrayList;

import com.hp.Entity.BroadEntity;
import com.hp.Entity.FimlEntity;
import com.hp.Entity.HallEntity;
import com.hp.Entity.SaleEntity;
import com.hp.dao.SaleDao;
import com.hp.dao.impl.SaleDaoImpl;
import com.hp.serivce2.SaleSerivce;

public class SaleSerivceImpl implements SaleSerivce{
	SaleDao sale=new SaleDaoImpl();
	
	public ArrayList<SaleEntity> GetSalelInfo()
	{
		return sale.GetSalelInfo();
	}
	
	public int SaleAddInfo(SaleEntity saleE)
	{
		return sale.SaleAddInfo(saleE);
	}

	
	public ArrayList<FimlEntity> GetMoveInfo()
	{
		return sale.GetMoveInfo();
	}
	
	public ArrayList<SaleEntity> GetMoveInfo2(SaleEntity saleE)
	{
		return sale.GetMoveInfo2(saleE);
	}
	
	public ArrayList<HallEntity> GetZuoWei(HallEntity saleE)
	{
		return sale.GetZuoWei(saleE);
	}
	
	public int modifyhall(BroadEntity b)
	{
		return sale.modifyhall(b);
	}
	
	public ArrayList<SaleEntity> ReverseSelectionZuoWei(SaleEntity s)
	{
		return sale.ReverseSelectionZuoWei(s);
	}
}
