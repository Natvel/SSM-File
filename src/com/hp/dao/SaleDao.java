package com.hp.dao;

import java.util.ArrayList;

import com.hp.Entity.BroadEntity;
import com.hp.Entity.FimlEntity;
import com.hp.Entity.HallEntity;
import com.hp.Entity.SaleEntity;

public interface SaleDao {
	
	public ArrayList<SaleEntity> GetSalelInfo();
	
	public int SaleAddInfo(SaleEntity saleE);
	
	public ArrayList<FimlEntity> GetMoveInfo();
	
	public ArrayList<SaleEntity> GetMoveInfo2(SaleEntity saleE);
	
	public ArrayList<HallEntity> GetZuoWei(HallEntity saleE);
	
	public int modifyhall(BroadEntity b);
	
	public ArrayList<SaleEntity> ReverseSelectionZuoWei(SaleEntity s);

}
