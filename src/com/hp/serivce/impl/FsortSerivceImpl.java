package com.hp.serivce.impl;

import java.util.ArrayList;

import com.hp.Entity.FsortEntity;
import com.hp.dao.FsortDao;
import com.hp.dao.impl.FsortDaoImpl;
import com.hp.serivce2.FsortSerivce;

public class FsortSerivceImpl implements FsortSerivce {
	FsortDao fsort=new FsortDaoImpl();
	
	public ArrayList<FsortEntity> GetFsotrInfo()
	{
		return fsort.GetFsotrInfo();
	}
	
	public FsortEntity FsortReverseSelection(FsortEntity fs)
	{
	return	fsort.FsortReverseSelection(fs);
	}
	
	public int FsortModify(FsortEntity fs)
	{
		return fsort.FsortModify(fs);
	}

	
	public int FsorAddInfo(FsortEntity fs)
	{
		return fsort.FsorAddInfo(fs);
	}
}
