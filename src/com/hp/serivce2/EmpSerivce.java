package com.hp.serivce2;

import java.util.ArrayList;

import com.hp.Entity.EmpEntity;

public interface EmpSerivce {
	
	public ArrayList<EmpEntity> GetEmpInfo();
	
	public EmpEntity EmpReverseSelection(EmpEntity Empe);
	
	public int EmpModify(EmpEntity Empe);
	
	public int EmpAddInfo(EmpEntity Empe);

}
