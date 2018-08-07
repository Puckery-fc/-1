package com;

import java.sql.*;
import java.util.ArrayList;

public class Database {
	
	// 定义全局参数
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement ps;
	
	//连接数据库(类初始化时)
	public Database()
	{
		try{
			//1. 加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=JavaWebTest2015";
			//2.连接数据库
			conn = DriverManager.getConnection(url,"ProDeveloper","123456");		
			if(conn != null)	
				stmt = conn.createStatement();
		}
		catch ( ClassNotFoundException e)
		{
			e.printStackTrace();
			}
		catch(SQLException e)
		{
			e.printStackTrace();		
			}
	}
	
	//关闭连接
	public void close() {
		try {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	//查询数据库
	public ResultSet query(String sql) {
		try {
			rs = stmt.executeQuery(sql);	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
		return rs;
		
	}
	public ResultSet queryPreparedStatement(String sql,ArrayList<String> list){
		try{
			ps=conn.prepareStatement(sql);
			if(list!=null||list.size()>0){
			for(int i=0;i<list.size();i++){
				ps.setString(i+1, list.get(i));
			}
		}
			rs=ps.executeQuery();
		}
		
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		return rs;
	}

	 //更新数据库
	public boolean insertUpdateDelete(String sql) {
		boolean result=false; 
		try{
			int i = stmt.executeUpdate(sql);	
			if(i!=0)
				result=true;	
		}catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		return result;
	}
}

