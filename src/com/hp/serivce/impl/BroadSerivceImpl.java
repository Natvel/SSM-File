package com.hp.serivce.impl;

import java.util.ArrayList;

import com.hp.Entity.BroadEntity;
import com.hp.dao.BroadDao;
import com.hp.dao.impl.BroadDaoImpl;
import com.hp.serivce2.BroadSerivce;

public class BroadSerivceImpl implements BroadSerivce{
	BroadDao broad=new BroadDaoImpl();
	
	public ArrayList<BroadEntity> GetBroadInfo()
	{
		return broad.GetBroadInfo();
	}

	
	public BroadEntity brodReverseSelection(BroadEntity broade)
	{
		return broad.brodReverseSelection(broade);
	}
	
	public int BroadModify(BroadEntity broade)
	{
		return broad.BroadModify(broade);
	}
	
	public int BroadAddInfo(BroadEntity broade)
	{
		return broad.BroadAddInfo(broade);
	}
	
	public int  BroadDelete(BroadEntity broade)
	{
		return broad.BroadDelete(broade);
	}
}
