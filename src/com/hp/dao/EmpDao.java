package com.hp.dao;

import java.util.ArrayList;

import com.hp.Entity.EmpEntity;

public interface EmpDao {
	
	public ArrayList<EmpEntity> GetEmpInfo();
	
	public EmpEntity EmpReverseSelection(EmpEntity Empe);
	
	public int EmpModify(EmpEntity Empe);
	
	public int EmpAddInfo(EmpEntity Empe);

}
