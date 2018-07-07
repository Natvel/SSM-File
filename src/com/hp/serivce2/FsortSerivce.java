package com.hp.serivce2;

import java.util.ArrayList;

import com.hp.Entity.FsortEntity;

public interface FsortSerivce {
	
	public ArrayList<FsortEntity> GetFsotrInfo();
	
	public FsortEntity FsortReverseSelection(FsortEntity fs);
	
	public int FsortModify(FsortEntity fs);
	
	public int FsorAddInfo(FsortEntity fs);

}
