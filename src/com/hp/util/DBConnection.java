package com.hp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection()
	{
		Connection ct=null;
		String qu="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		try {
			Class.forName(qu);
			ct=DriverManager.getConnection("jdbc:sqlserver://localhost;database=fimlDB","sa","1");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ct;
	}
	
	public static void main(String[] args) {
		Connection ct=DBConnection.getConnection();
		if(ct!=null)
		{
			System.out.println("链接成功");
		}else
		{
			System.out.println("链接失败");
		}

	}

}
