package com.hp.dao;

import java.util.ArrayList;

import com.hp.Entity.BroadEntity;

public interface BroadDao {
	
	public ArrayList<BroadEntity> GetBroadInfo();
	
	public BroadEntity brodReverseSelection(BroadEntity broade);
	
	public int BroadModify(BroadEntity broade);
	
	public int BroadAddInfo(BroadEntity broade);
	
	public int  BroadDelete(BroadEntity broade);

}
