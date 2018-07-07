package com.hp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hp.Entity.BroadEntity;
import com.hp.Entity.EmpEntity;
import com.hp.Entity.FimlEntity;
import com.hp.Entity.HallEntity;
import com.hp.Entity.SaleEntity;

public class SalePublic {
	static Connection ct=null;
	static PreparedStatement pt=null;
	static ResultSet rs=null;
	
	
	
	
	public static ArrayList<FimlEntity> GetMoveInfo(String sql)
	{
		ArrayList<FimlEntity> moveList=new ArrayList<FimlEntity>();
		
		ct=DBConnection.getConnection();
		try {
			pt=ct.prepareStatement(sql);
			rs=pt.executeQuery();
			while(rs.next())
			{
							
				FimlEntity fiml=new FimlEntity();			
				int fid=rs.getInt("fid");			
				String fname=rs.getString("fname");		
				
				fiml.setFid(fid);
				fiml.setFname(fname);
				
				moveList.add(fiml);			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return moveList;
	}
	
	public static ArrayList<SaleEntity> GetMoveInfo2(String sql,Object [] obj)
	{
		ArrayList<SaleEntity> moveList=new ArrayList<SaleEntity>();
		
		ct=DBConnection.getConnection();
		try {
			pt=ct.prepareStatement(sql);
			
			for(int i=0;i<obj.length;i++)
			{
				pt.setObject(i+1,obj[i]);
			}
			rs=pt.executeQuery();
			while(rs.next())
			{
				SaleEntity sale=new SaleEntity();			
				BroadEntity broade=new BroadEntity();
				HallEntity h=new HallEntity();
				FimlEntity f=new FimlEntity();
				int xid=rs.getInt("xid");
				int fid=rs.getInt("fid");
                 String tname=rs.getString("tname");
				 String begintime=rs.getString("begintime");	
			f.setFid(fid);
				h.setTname(tname);
				broade.setBegintime(begintime);
			broade.setFiml(f);
		       broade.setHall(h);
		       broade.setXid(xid);
				
				sale.setBr(broade);
				
				moveList.add(sale);
										
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return moveList;
	}
	
	public static ArrayList<HallEntity> GetZuoWei(String sql,Object [] obj)
	{
		
		ArrayList<HallEntity> List=new ArrayList<HallEntity>();
		
		ct=DBConnection.getConnection();
		try {
			pt=ct.prepareStatement(sql);
			
			for(int i=0;i<obj.length;i++)
			{
				pt.setObject(i+1,obj[i]);
			}
			rs=pt.executeQuery();
			while(rs.next())
			{
				HallEntity h=new HallEntity();
				String tname=rs.getString("tname");
				int tid=rs.getInt("tid");
				h.setTname(tname);
				h.setTid(tid);
				List.add(h);
										
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return List;
	}
	
	public static ArrayList<SaleEntity> GetSaleInfo(String sql)
	{
		ArrayList<SaleEntity> saleList=new ArrayList<SaleEntity>();
		
		ct=DBConnection.getConnection();
		try {
			pt=ct.prepareStatement(sql);
			rs=pt.executeQuery();
			while(rs.next())
			{
				
				BroadEntity br=new BroadEntity();
				FimlEntity fiml=new FimlEntity();
				EmpEntity emp=new EmpEntity();
				HallEntity hall=new HallEntity();
				
				int mid=rs.getInt("mid");
				String fname=rs.getString("fname");
				String tname=rs.getString("tname");
				String begintime=rs.getString("begintime");
				String endtime=rs.getString("endtime");
				float xmoney=rs.getFloat("xmoney");
				String mzw=rs.getString("mzw");
				
				SaleEntity sale=new SaleEntity();
				sale.setMid(mid);
				sale.setMzw(mzw);
				
				
				fiml.setFname(fname);
				hall.setTname(tname);
				
				br.setFiml(fiml);
				br.setHall(hall);
				
				br.setXmoney(xmoney);
               br.setBegintime(begintime);
               br.setEndtime(endtime);
				
				sale.setBr(br);
				
				
				saleList.add(sale);
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return saleList;
	}
	
	public static int SaleAdd(String sql,Object [] obj)
	{
		int a=0;
		ct=DBConnection.getConnection();
		try {
			pt=ct.prepareStatement(sql);
			for(int i=0;i<obj.length;i++)
			{
				pt.setObject(i+1,obj[i]);
			}
			a=pt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	
	public static ArrayList<SaleEntity> ReverseSelectionZuoWei(String sql,Object [] obj)
	{
		ArrayList<SaleEntity> slist=new ArrayList<SaleEntity>();
		ct=DBConnection.getConnection();
	
			try {
				pt=ct.prepareStatement(sql);
				for(int i=0;i<obj.length;i++)
				{
					pt.setObject(i+1,obj[i]);
				}
				rs=pt.executeQuery();
				
				while(rs.next())
				{
					SaleEntity sa=new SaleEntity();
					String mzw=rs.getString("mzw");
					int m=Integer.parseInt(mzw); 
					sa.setMZW(m);;
					slist.add(sa);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return slist;
			
	}

}
