package com.hp.dao.impl;

import java.util.ArrayList;

import com.hp.Entity.BroadEntity;
import com.hp.Entity.EmpEntity;
import com.hp.Entity.FimlEntity;
import com.hp.dao.BroadDao;
import com.hp.util.Broadpublic;
import com.hp.util.EmpPublic;
import com.hp.util.FimlPublic;

public class BroadDaoImpl implements BroadDao {
	        //broad表中的查询
			public ArrayList<BroadEntity> GetBroadInfo()
			{
				String sql="select fiml.fid,hall.tid,emp.eid,xid,begintime,endtime, xmoney,fname,tname,ename from broad,fiml,hall,emp where broad.fid=fiml.fid and broad.tid=hall.tid and broad.eid=emp.eid and broad.fflag=1 and fiml.fflag=1";
				
				return Broadpublic.BroadInfo(sql);
			}
			
			//broad表中修改的反选
			public BroadEntity brodReverseSelection(BroadEntity broade)
			{
				String sql="select fiml.fid,hall.tid,emp.eid,xid,begintime,endtime, xmoney,fname,tname,ename from broad,fiml,hall,emp where broad.fid=fiml.fid and broad.tid=hall.tid and broad.eid=emp.eid and xid=?";
				Object [] obj=new Object[]{broade.getXid()};
				return Broadpublic.brodReverseSelection(sql,obj);
			}
			
			 //broad表中的修改
			public int BroadModify(BroadEntity broade)
			{
				String sql="update broad set fid=?,tid=?,eid=?,begintime=?,endtime=?,xmoney=? where xid=?";
				Object [] obj=new Object[]{broade.getFiml().getFid(),broade.getHall().getTid(),broade.getEmp().getEid(),broade.getBegintime(),broade.getEndtime(),broade.getXmoney(),broade.getXid()};
		     	return	Broadpublic.BroadModify(sql, obj);
			}
			
			//broad表中的新增
			public int BroadAddInfo(BroadEntity broade)
			{
				String sql="insert into broad values(?,?,?,?,?,?,1)";
				Object [] obj=new Object[]{broade.getFiml().getFid(),broade.getHall().getTid(),broade.getEmp().getEid(),broade.getBegintime(),broade.getEndtime(),broade.getXmoney()};
				return Broadpublic.BroadAdd(sql, obj);
			}
			
			//broad表中的删除  --变成了修改
			public int  BroadDelete(BroadEntity broade)
			{
				String sql="update broad set fflag=? where xid=?";
				Object [] obj=new Object[]{broade.getFflag(),broade.getXid()};
				return Broadpublic.BroadDelete(sql, obj);
			}

}
