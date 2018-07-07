package com.hp.serivce2;

import java.util.ArrayList;

import com.hp.Entity.FimlEntity;

public interface FimlSerivce {
	
	public int FimlModify(FimlEntity fimle);
	
	public FimlEntity FimlReverseSelection(FimlEntity fimle);
	
	public int FimlAddInfo(FimlEntity fimle);
	
	public ArrayList<FimlEntity> GetFimlInfo();
	
	public int LowerFrame(FimlEntity fimle);
	
	public ArrayList<FimlEntity> GetLowerFrame();
	
	public int OnTheShelf(FimlEntity fimle);

}
