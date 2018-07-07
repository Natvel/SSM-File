package com.hp.dao.impl;

import java.util.ArrayList;

import com.hp.Entity.FimlEntity;
import com.hp.Entity.HallEntity;
import com.hp.dao.HallDao;
import com.hp.util.FimlPublic;
import com.hp.util.HallPublic;

public class HallDaoImpl implements HallDao{
	
	  //Hall表中的查询
	public ArrayList<HallEntity> GetFimlInfo()
	{
		String sql="select * from hall";
		
		return HallPublic.GetHallInfo(sql);
	}
	
	     //Hall表中的修改
	public int FimlModify(HallEntity Halle)
	{
			String sql="update hall set tname=?,tcount=? where tid=?";
			Object [] obj=new Object[]{Halle.getTname(),Halle.getTcount(),Halle.getTid()};
	     	return	HallPublic.HallModify(sql, obj);
	}
	
     	//Hall表中修改的反选
		public HallEntity HallReverseSelection(HallEntity fimle)
		{
			String sql="select * from hall where tid=?";
			Object [] obj=new Object[]{fimle.getTid()};
			return HallPublic.HallReverseSelection(sql, obj);
		}
	
	
	//Hall表中新增
		public int HallAddInfo(HallEntity Halle)
		{
			String sql="insert into hall values(?,?)";
			Object [] obj=new Object[]{Halle.getTname(),Halle.getTcount()};
			return HallPublic.HallAdd(sql, obj);
		}
		
	     //获取座位
		public int getSeat(HallEntity Halle)
		{
			String sql="select tcount from hall where tid=?";
			Object [] obj=new Object[]{Halle.getTid()};
			return HallPublic.getSeat(sql, obj);
		}
	

}
