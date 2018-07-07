package com.hp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hp.Entity.FsortEntity;



public class FsortPublic {
	static Connection ct=null;
	static PreparedStatement pt=null;
	static ResultSet rs=null;
	
	//电影类别管理中的查询方法
	public static ArrayList<FsortEntity> GetStuInfo(String sql)
	{
		ArrayList<FsortEntity> FsortList=new ArrayList<FsortEntity>();
		
		ct=DBConnection.getConnection();
		try {
			pt=ct.prepareStatement(sql);
			rs=pt.executeQuery();
			while(rs.next())
			{
				FsortEntity fsort=new FsortEntity();
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");
				String sremark=rs.getString("sremark");
			
				fsort.setSid(sid);
				fsort.setSname(sname);
				fsort.setSremark(sremark);
				
				FsortList.add(fsort);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return FsortList;
	}
	
	//电影类别管理中修改的反选查询
	public static FsortEntity FsortReverseSelection(String sql,Object [] obj)
	{
		FsortEntity fs=new FsortEntity();
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
			
				int sid=rs.getInt("sid");
				String sname=rs.getString("sname");
				String sremark=rs.getString("sremark");
				
				fs.setSid(sid);
				fs.setSname(sname);
				fs.setSremark(sremark);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fs;
	}
	//电影管理系统中的修改方法
	public static int FsortModify(String sql,Object [] obj)
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
	//验证账号密码
	public static String Verification(String sql,Object [] obj)
	{
		String urealname=null;
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
				urealname=rs.getString("urealname");
				 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return urealname;
	}
	
	
	//电影管理中新增方法
	public static int FsortAdd(String sql,Object [] obj)
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
