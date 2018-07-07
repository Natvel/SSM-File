package com.hp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hp.Entity.EmpEntity;
import com.hp.Entity.FimlEntity;
import com.hp.Entity.FsortEntity;

public class EmpPublic {
	static Connection ct=null;
	static PreparedStatement pt=null;
	static ResultSet rs=null;
	
	   //emp表中的查询方法
			public static ArrayList<EmpEntity> GetEmpInfo(String sql)
			{
				ArrayList<EmpEntity> EmpList=new ArrayList<EmpEntity>();
				
				ct=DBConnection.getConnection();
				try {
					pt=ct.prepareStatement(sql);
					rs=pt.executeQuery();
					while(rs.next())
					{
						EmpEntity Emp=new EmpEntity();	
						int eid=rs.getInt("eid");
						String ename=rs.getString("ename");
						int esex=rs.getInt("esex");
						String egw=rs.getString("egw");
						
					    Emp.setEid(eid);
					    Emp.setEname(ename);
					    Emp.setEsex(esex);
					    Emp.setEgw(egw);
					    
					    EmpList.add(Emp);
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				return EmpList;
			}
			
			
			//Emp表中修改的反选
			public static EmpEntity EmpReverseSelection(String sql,Object [] obj)
			{
				EmpEntity Emp=new EmpEntity();
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
						
						int eid=rs.getInt("eid");
						String ename=rs.getString("ename");
						int esex=rs.getInt("esex");
						String egw=rs.getString("egw");
						
						Emp.setEid(eid);
						Emp.setEname(ename);
						Emp.setEsex(esex);
						Emp.setEgw(egw);
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return Emp;
			}
			
			//Emp表中的修改
			public static int EmpModify(String sql,Object [] obj)
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
