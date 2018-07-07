package com.hp.dao;

import java.util.ArrayList;

import com.hp.Entity.SaleEntity;

public interface ProitDao {

	
	public ArrayList<SaleEntity> GetSalelInfo();
	
	public ArrayList<SaleEntity> GetSalelInfo2(SaleEntity sa);
	
	public float JiSuanOne(SaleEntity sa);
	
	public ArrayList<SaleEntity> TotalIncome();
	
	public double a();
}
