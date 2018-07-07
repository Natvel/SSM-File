package com.hp.dao.impl;

import java.util.ArrayList;

import com.hp.Entity.BroadEntity;
import com.hp.Entity.FimlEntity;
import com.hp.Entity.HallEntity;
import com.hp.Entity.SaleEntity;
import com.hp.dao.SaleDao;
import com.hp.util.Broadpublic;
import com.hp.util.FimlPublic;
import com.hp.util.SalePublic;

public class SaleDaoImpl implements SaleDao {
	
	//sale表中的查询
		public ArrayList<SaleEntity> GetSalelInfo()
		{
			String sql="select sale.mid,fname,tname,begintime,endtime,xmoney,mzw from sale,fiml,hall,emp,broad where sale.xid=broad.xid and broad.fid=fiml.fid and broad.tid=hall.tid and broad.eid=emp.eid and fiml.fflag=1";
			return SalePublic.GetSaleInfo(sql);
		}
		
		//sale表中的新增
		public int SaleAddInfo(SaleEntity saleE)
		{
			String sql="insert into sale values(?,?)";
			Object [] obj=new Object[]{saleE.getBr().getXid(),saleE.getMzw()};
			return SalePublic.SaleAdd(sql, obj);
		}
		
     
		
		//根据电影编号查询信息
		public ArrayList<FimlEntity> GetMoveInfo()
		{
			String sql="select fname,fid from fiml";
			return SalePublic.GetMoveInfo(sql);
		}
		
		
		//获取当前电影的信息
		public ArrayList<SaleEntity> GetMoveInfo2(SaleEntity saleE)
		{
			String sql="select fid,begintime,broad.xid,tname from broad,hall where fid=? and fflag=1 and broad.tid=hall.tid";
			Object [] obj=new Object[]{saleE.getMid()};
			return SalePublic.GetMoveInfo2(sql,obj);
			
		}
		
		//获取座位
		public ArrayList<HallEntity> GetZuoWei(HallEntity h)
		{
			String sql="select fid,tname,hall.tid from broad,hall where hall.tid=broad.tid and xid=?";
			Object [] obj=new Object[]{h.getTid()};
			return SalePublic.GetZuoWei(sql, obj);
			
		}
		
		
		//修改broad中的大厅
		public int modifyhall(BroadEntity b)
		{
			String sql="update broad set tid=? where xid=?";
			Object [] obj=new Object[]{b.getHall().getTid(),b.getXid()};
			return SalePublic.SaleAdd(sql, obj);
		}
		
		//座位的反选
		public ArrayList<SaleEntity> ReverseSelectionZuoWei(SaleEntity s)
		{
			String sql="select * from sale where xid=?";
			Object [] obj=new Object[]{s.getBr().getXid()};
			return SalePublic.ReverseSelectionZuoWei(sql, obj);
			
			
		}
		
		
		

}
