package com.hp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hp.Entity.FimlEntity;
import com.hp.Entity.FsortEntity;

public class FimlPublic {
	static Connection ct=null;
	static PreparedStatement pt=null;
	static ResultSet rs=null;
	
	public static int FimlModify(String sql,Object [] obj)
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

	 
 //fiml表中修改的反选
		public static FimlEntity FimlReverseSelection(String sql,Object [] obj)
		{
			FimlEntity fi=new FimlEntity();
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
					int fid=rs.getInt("fid");
					String fname=rs.getString("fname");
					String fauto=rs.getString("fauto");
					String ontime=rs.getString("ontime");
					String fremark=rs.getString("fremark");
					int fflag=rs.getInt("fflag");
					String sname=rs.getString("sname");
					int sid=rs.getInt("sid");
					fi.setFid(fid);
					fi.setFname(fname);
					fi.setFauto(fauto);
					fi.setOntime(ontime);
					fi.setFremark(fremark);
					fi.setFflag(fflag);
					
					FsortEntity fs=new FsortEntity();
					fs.setSid(sid);
					fs.setSname(sname);
					fi.setFsort(fs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return fi;
		}
		
		public static FimlEntity FimlReverseSelection2(String sql)
		{
			FimlEntity fi=new FimlEntity();
			ct=DBConnection.getConnection();
			try {
				pt=ct.prepareStatement(sql);
				
				rs=pt.executeQuery();
				while(rs.next())
				{
					int fid=rs.getInt("fid");
					String fname=rs.getString("fname");
					String fauto=rs.getString("fauto");
					String ontime=rs.getString("ontime");
					String fremark=rs.getString("fremark");
					int fflag=rs.getInt("fflag");
					String sname=rs.getString("sname");
					int sid=rs.getInt("sid");
					fi.setFid(fid);
					fi.setFname(fname);
					fi.setFauto(fauto);
					fi.setOntime(ontime);
					fi.setFremark(fremark);
					fi.setFflag(fflag);
					
					FsortEntity fs=new FsortEntity();
					fs.setSid(sid);
					fs.setSname(sname);
					fi.setFsort(fs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return fi;
		}
		
		//fiml表中的新增
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
		
		//fiml表中的查询方法
				public static ArrayList<FimlEntity> GetStuInfo(String sql)
				{
					ArrayList<FimlEntity> FimlList=new ArrayList<FimlEntity>();
					
					ct=DBConnection.getConnection();
					try {
						pt=ct.prepareStatement(sql);
						rs=pt.executeQuery();
						while(rs.next())
						{
							FimlEntity fiml=new FimlEntity();	
							
						int sid=rs.getInt("sid");
						int fid=rs.getInt("fid");
						String fname=rs.getString("fname");
						String fauto=rs.getString("fauto");
						String ontime=rs.getString("ontime");
						String fremark=rs.getString("fremark");
						int fflag=rs.getInt("fflag");
						
						FsortEntity fs=new FsortEntity();
						fs.setSid(sid);			
						fiml.setFsort(fs);
						fiml.setFid(fid);
						fiml.setFname(fname);
						fiml.setFauto(fauto);
						fiml.setOntime(ontime);
						fiml.setFremark(fremark);
						fiml.setFflag(fflag);
						
						FimlList.add(fiml);
						
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					return FimlList;
				}
		
		public static ArrayList<FimlEntity> GetLowerFrame(String sql)
		{
         ArrayList<FimlEntity> FimlList=new ArrayList<FimlEntity>();
			
			ct=DBConnection.getConnection();
			try {
				pt=ct.prepareStatement(sql);
				rs=pt.executeQuery();
				while(rs.next())
				{
					FimlEntity fiml=new FimlEntity();	
					
				int sid=rs.getInt("sid");
				int fid=rs.getInt("fid");
				String fname=rs.getString("fname");
				String sname=rs.getString("sname");
				String fauto=rs.getString("fauto");
				String ontime=rs.getString("ontime");
				String fremark=rs.getString("fremark");
				
				FsortEntity fs=new FsortEntity();
				fs.setSid(sid);		
				fs.setSname(sname);
				fiml.setFsort(fs);
				fiml.setFid(fid);
				fiml.setFname(fname);
				fiml.setFauto(fauto);
				fiml.setOntime(ontime);
				fiml.setFremark(fremark);
				
				FimlList.add(fiml);
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return FimlList;
		}
}
