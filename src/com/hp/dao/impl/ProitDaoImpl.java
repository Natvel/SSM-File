package com.hp.dao.impl;

import java.util.ArrayList;

import com.hp.Entity.SaleEntity;
import com.hp.dao.ProitDao;
import com.hp.util.ProitPublic;
import com.hp.util.SalePublic;

public class ProitDaoImpl implements ProitDao{
	
    //收益表中的查询
	public ArrayList<SaleEntity> GetSalelInfo()
	{
		String sql="select sale.xid,sale.mid,fname,tname,ename,begintime,endtime,xmoney,fiml.fid from sale,broad,emp,hall,fiml where sale.mid in(Select min(sale.mid) FROM sale group by sale.xid) and sale.xid=broad.xid and broad.fid=fiml.fid and broad.tid=hall.tid and broad.eid=emp.eid and fiml.fflag=1";
		return ProitPublic.GetProitInfo2(sql);
   }
	
	
	//查看卖出多少座位
	public ArrayList<SaleEntity> GetSalelInfo2(SaleEntity sa)
	{
		String sql="select mzw,xmoney from sale,broad where sale.xid=broad.xid and sale.xid=?";
		Object [] obj=new Object[]{sa.getMid()};
		return ProitPublic.GetProitInfo3(sql, obj);
   }
	
	//计算收益
	public float JiSuanOne(SaleEntity sa)
	{
		String sql="select mzw,xmoney from sale,broad where sale.xid=broad.xid and sale.xid=?";
		Object [] obj=new Object[]{sa.getMid()};
		return ProitPublic.JiSuan(sql, obj);
	}
	
	//总收益
	public ArrayList<SaleEntity> TotalIncome()
	{
		String sql="select fname,tname,begintime,endtime,xmoney,number from fiml,hall,broad,sale,(select sale.xid,count(*) as number from sale group by sale.xid) number where broad.fid=fiml.fid and broad.tid=hall.tid and sale.xid=broad.xid and  number.xid=sale.xid and sale.mid in(Select min(sale.mid) FROM sale group by sale.xid)";
		
		return ProitPublic.TotalIncome(sql);
	}
	
	//总收益
	public double a()
	{
		String sql="select fname,tname,begintime,endtime,xmoney,number from fiml,hall,broad,sale,(select sale.xid,count(*) as number from sale group by sale.xid) number where broad.fid=fiml.fid and broad.tid=hall.tid and sale.xid=broad.xid and  number.xid=sale.xid and sale.mid in(Select min(sale.mid) FROM sale group by sale.xid)";
		
		return ProitPublic.a(sql);
	}	

}
