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
import com.hp.dao.BroadDao;
import com.hp.dao.FimlDao;
import com.hp.dao.impl.BroadDaoImpl;
import com.hp.dao.impl.FimlDaoImpl;
import com.hp.serivce.impl.FimlSerivceImpl;
import com.hp.serivce2.FimlSerivce;

public class Broadpublic {
	static Connection ct=null;
	static PreparedStatement pt=null;
	static ResultSet rs=null;
	
	public static ArrayList<BroadEntity> BroadInfo(String sql)
	{
		ArrayList<BroadEntity> BroList=new ArrayList<BroadEntity>();
		
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
				int fid=rs.getInt("fid");
			    int xid=rs.getInt("xid");
			    int eid=rs.getInt("eid");
			    int tid=rs.getInt("tid");
			
			String fname=rs.getString ("fname");
			String tname=rs.getString ("tname");
			String ename=rs.getString ("ename");
			String  begintime=rs.getString("begintime");
			String endtime=rs.getString("endtime");
			float xmoney=rs.getFloat("xmoney");
			br.setXid(xid);
			br.setBegintime(begintime);
			br.setEndtime(endtime);
			br.setXmoney(xmoney);
			
			fiml.setFname(fname);
			fiml.setFid(fid);
			emp.setEname(ename);
			emp.setEid(eid);
			hall.setTname(tname);
			hall.setTid(tid);
			
			br.setFiml(fiml);
			br.setHall(hall);
			br.setEmp(emp);
			
			BroList.add(br);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return BroList;
	}
	
	public static BroadEntity brodReverseSelection(String sql,Object [] obj)
	{
		BroadEntity br=new BroadEntity();
		
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
				
				
				FimlEntity fiml=new FimlEntity();
				EmpEntity emp=new EmpEntity();
				HallEntity hall=new HallEntity();
				int fid=rs.getInt("fid");
			    int xid=rs.getInt("xid");
			    int eid=rs.getInt("eid");
			    int tid=rs.getInt("tid");
			
			    
			String fname=rs.getString ("fname");
			String tname=rs.getString ("tname");
			String ename=rs.getString ("ename");
			String  begintime=rs.getString("begintime");
			String endtime=rs.getString("endtime");
			float xmoney=rs.getFloat("xmoney");
			br.setXid(xid);
			br.setBegintime(begintime);
			br.setEndtime(endtime);
			br.setXmoney(xmoney);
			
			fiml.setFname(fname);
			fiml.setFid(fid);
			emp.setEname(ename);
			emp.setEid(eid);
			hall.setTname(tname);
			hall.setTid(tid);
			
			br.setFiml(fiml);
			br.setHall(hall);
			br.setEmp(emp);
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return br;
	}
	
	//Broad表中的修改
	public static int BroadModify(String sql,Object [] obj)
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
	
	public static int BroadAdd(String sql,Object [] obj)
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
	
	public static int BroadDelete(String sql,Object [] obj)
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
}
