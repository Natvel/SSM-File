package com.hp.serivce.impl;

import java.util.ArrayList;

import com.hp.Entity.FimlEntity;
import com.hp.dao.FimlDao;
import com.hp.dao.impl.FimlDaoImpl;
import com.hp.serivce2.FimlSerivce;

public class FimlSerivceImpl implements FimlSerivce {

	 FimlDao fiml=new FimlDaoImpl();
	
	public int FimlModify(FimlEntity fimle)
	{
          return  fiml.FimlModify(fimle);
	}
	
	public FimlEntity FimlReverseSelection(FimlEntity fimle)
	{
		return fiml.FimlReverseSelection(fimle);
	}
	
	public int FimlAddInfo(FimlEntity fimle)
	{
		return fiml.FimlAddInfo(fimle);
	}
	
	public ArrayList<FimlEntity> GetFimlInfo()
	{
		return fiml.GetFimlInfo();
	}
	
	public int LowerFrame(FimlEntity fimle)
	{
		return fiml.LowerFrame(fimle);
	}
	
	public ArrayList<FimlEntity> GetLowerFrame()
	{
		return fiml.GetLowerFrame();
	}
	
	public int OnTheShelf(FimlEntity fimle)
	{
		return fiml.OnTheShelf(fimle);
	}
}
