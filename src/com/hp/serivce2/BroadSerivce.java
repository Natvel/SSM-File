package com.hp.serivce2;

import java.util.ArrayList;

import com.hp.Entity.BroadEntity;

public interface BroadSerivce {
	
	public ArrayList<BroadEntity> GetBroadInfo();
	
	public BroadEntity brodReverseSelection(BroadEntity broade);
	
	public int BroadModify(BroadEntity broade);
	
	public int BroadAddInfo(BroadEntity broade);
	
	public int  BroadDelete(BroadEntity broade);

}
