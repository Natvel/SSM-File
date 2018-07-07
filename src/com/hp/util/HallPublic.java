package com.hp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hp.Entity.FimlEntity;
import com.hp.Entity.FsortEntity;
import com.hp.Entity.HallEntity;

public class HallPublic {
	
	static Connection ct=null;
	static PreparedStatement pt=null;
	static ResultSet rs=null;
	
	public static ArrayList<HallEntity> GetHallInfo(String sql)
	{
		ArrayList<HallEntity> hallList=new ArrayList<HallEntity>();
		
		ct=DBConnection.getConnection();
		try {
			pt=ct.prepareStatement(sql);
			rs=pt.executeQuery();
			while(rs.next())
			{
				HallEntity hall=new HallEntity();	
				int tid=rs.getInt("tid");
				String  tname=rs.getString("tname");
				int tcount=rs.getInt("tcount");
			
				hall.setTid(tid);
				hall.setTname(tname);
				hall.setTcount(tcount);
				
				hallList.add(hall);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return hallList;
	}
	
	//放映大厅信息表中的修改方法
		public static int HallModify(String sql,Object [] obj)
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
		
		//放映大厅表中的新增方法
				public static int HallAdd(String sql,Object [] obj)
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
				
				//Hall表中修改的反选
				public static HallEntity HallReverseSelection(String sql,Object [] obj)
				{
					HallEntity Hall=new HallEntity();
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
							int tid=rs.getInt("tid");
							String tname=rs.getString("tname");
							int tcount=rs.getInt("tcount");
							
							Hall.setTid(tid);
							Hall.setTname(tname);
							Hall.setTcount(tcount);
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return Hall;
				}
				
				public static int getSeat(String sql,Object [] obj)
				{
					
					int count = 0;
					HallEntity Hall=new HallEntity();
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
							
							String tcount=rs.getString("tcount");
							 count=Integer.parseInt(tcount);
			
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return count;
				}

}
