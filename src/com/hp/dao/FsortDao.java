package com.hp.dao;

import java.util.ArrayList;

import com.hp.Entity.FsortEntity;

public interface FsortDao {
	
	public ArrayList<FsortEntity> GetFsotrInfo();
	
	public FsortEntity FsortReverseSelection(FsortEntity fs);
	
	public int FsortModify(FsortEntity fs);
	
	public int FsorAddInfo(FsortEntity fs);

}
