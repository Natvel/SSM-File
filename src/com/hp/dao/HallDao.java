package com.hp.dao;

import java.util.ArrayList;

import com.hp.Entity.HallEntity;

public interface HallDao {
	public ArrayList<HallEntity> GetFimlInfo();
	
	public int FimlModify(HallEntity Halle);
	
	public int HallAddInfo(HallEntity Halle);
	
	public HallEntity HallReverseSelection(HallEntity fimle);
	
	public int getSeat(HallEntity Halle);

}
