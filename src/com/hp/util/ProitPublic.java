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

public class ProitPublic {
	static Connection ct=null;
	static PreparedStatement pt=null;
	static ResultSet rs=null;
	
	
	public static ArrayList<SaleEntity> GetProitInfo2(String sql)
	{
		ArrayList<SaleEntity> moveList=new ArrayList<SaleEntity>();
		
		ct=DBConnection.getConnection();
		try {
			pt=ct.prepareStatement(sql);
		
			rs=pt.executeQuery();
			while(rs.next())
			{
				SaleEntity sale=new SaleEntity();			
				BroadEntity broade=new BroadEntity();
				HallEntity h=new HallEntity();
				FimlEntity f=new FimlEntity();
				EmpEntity e=new EmpEntity();
				int mid=rs.getInt("mid");
				int fid=rs.getInt("fid");
				int xid=rs.getInt("xid");
				String tname=rs.getString("tname");
                 String fname=rs.getString("fname");
                 String ename=rs.getString("ename");
				 String begintime=rs.getString("begintime");	
				 String endtime=rs.getString("endtime");
				 float xmoney=rs.getFloat("xmoney");
		         	f.setFid(fid);
		         	f.setFname(fname);
		         	e.setEname(ename);
			       	h.setTname(tname);
				
			       	broade.setXid(xid);
		      	broade.setFiml(f);
		       broade.setHall(h);
		       broade.setEmp(e);
		       broade.setXmoney(xmoney);
		       broade.setEndtime(endtime);
		       broade.setBegintime(begintime);
				
				sale.setBr(broade);
				sale.setMid(mid);
				
				moveList.add(sale);
										
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return moveList;
	}
	
	
	public static ArrayList<SaleEntity> GetProitInfo3(String sql,Object [] obj)
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
				float xmoney=rs.getFloat("xmoney");
				String mzw=rs.getString("mzw");
			
				broade.setXmoney(xmoney);
				
				sale.setMzw(mzw);
				sale.setBr(broade);
				
				moveList.add(sale);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return moveList;
	}
	
	public static float JiSuan(String sql,Object [] obj)
	{
        
		float number=0;
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
					float xmoney=rs.getFloat("xmoney");
					number+=xmoney;
					
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return number;
			
			
	}
	
	public static ArrayList<SaleEntity> TotalIncome(String sql)
	{
		ArrayList<SaleEntity> sList=new ArrayList<SaleEntity>();
 
	
		ct=DBConnection.getConnection();
		
			try {
				pt=ct.prepareStatement(sql);

				
				rs=pt.executeQuery();
				while(rs.next())
				{
					SaleEntity sale=new SaleEntity();			
					BroadEntity broade=new BroadEntity();
					HallEntity h=new HallEntity();
					FimlEntity f=new FimlEntity();
					
					String fname=rs.getString("fname");
					String tname=rs.getString("tname");
					String begintime=rs.getString("begintime");
				    String endtime=rs.getString("endtime");	
					float xmoney=rs.getFloat("xmoney");
					int number=rs.getInt("number");
					
			                
					
					f.setFname(fname);
					h.setTname(tname);
					
					broade.setFiml(f);
                    broade.setHall(h);
                    broade.setBegintime(begintime);
                    broade.setEndtime(endtime);
                    broade.setXmoney(xmoney);
					
                    
                    sale.setNumber(number);
                    sale.setBr(broade);
                    
                    sList.add(sale);
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return sList;
			
			
	}
	
	
	public static double a(String sql)
	{
	
         double i;
	     double num = 0;
		ct=DBConnection.getConnection();
		
			try {
				pt=ct.prepareStatement(sql);

				
				rs=pt.executeQuery();
				while(rs.next())
				{
					SaleEntity sale=new SaleEntity();			
					BroadEntity broade=new BroadEntity();
					HallEntity h=new HallEntity();
					FimlEntity f=new FimlEntity();
					
					String fname=rs.getString("fname");
					String tname=rs.getString("tname");
					String begintime=rs.getString("begintime");
				    String endtime=rs.getString("endtime");	
					float xmoney=rs.getFloat("xmoney");
					int number=rs.getInt("number");
					
			                i=xmoney*number;
			                num+=i;
					
					f.setFname(fname);
					h.setTname(tname);
					
					broade.setFiml(f);
                    broade.setHall(h);
                    broade.setBegintime(begintime);
                    broade.setEndtime(endtime);
                    broade.setXmoney(xmoney);
					
                    
                    sale.setNumber(number);
                    sale.setBr(broade);
                    
          
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
	}
			return num;
	
	}
}
