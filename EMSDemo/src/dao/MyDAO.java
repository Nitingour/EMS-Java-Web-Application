package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import beans.EmpBean;

public class MyDAO {
// start method is used to establish connection from MYSQL DB
	public Connection start()
	{
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3307/emsdb","root","root");
     	}catch(Exception e)
     	{
		 System.out.println(e);
	    }
	  return con;
    }
	
	public int loginCheck(String uid,String pwd)
	{
		int x=0;
		try {
			Connection con=start();
			PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			 ResultSet rs= ps.executeQuery();
	    	 if(rs.next())
				 x=1;
	    	 con.close();
		}catch(SQLException w)
			{
			   System.out.println(w);
			}
		return x;
	}

	public int insertEmp(EmpBean e)
	{
		int x=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/emsdb","root","root");
			PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?,?)");
			ps.setInt(1,e.getEid());
			ps.setString(2,e.getEname());
			ps.setDouble(3, e.getSalary());
			ps.setString(4, e.getAddress());
			x= ps.executeUpdate();
	       con.close();
		}catch(ClassNotFoundException | SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
	
	public int updateEmp(EmpBean e)
	{
		int x=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/emsdb","root","root");
			PreparedStatement ps=con.prepareStatement("update Employee set ename=?,salary=?,address=? where eid=?");
			ps.setInt(4,e.getEid());
			ps.setString(1,e.getEname());
			ps.setDouble(2, e.getSalary());
			ps.setString(3, e.getAddress());
			x= ps.executeUpdate();
	       con.close();
		}catch(ClassNotFoundException | SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
	
	public int deleteEmp(int eid)
	{
		int x=0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/emsdb","root","root");
			PreparedStatement ps=con.prepareStatement("delete from Employee where eid=?");
			ps.setInt(1,eid);
			x= ps.executeUpdate();
	       con.close();
		}catch(ClassNotFoundException | SQLException w)
			{
			  System.out.println(w);
			}
		
		return x;
	}
	
	
	public ArrayList<EmpBean>  viewEmp()
	{
		ArrayList<EmpBean> list=new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/emsdb","root","root");
			PreparedStatement ps=con.prepareStatement("select * from Employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				EmpBean e=new EmpBean();
				e.setEid(rs.getInt("eid"));
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getDouble("salary"));
				e.setAddress(rs.getString("address"));
				list.add(e);
		     }
			con.close();
		}catch(ClassNotFoundException | SQLException w)
			{
			  System.out.println(w);
			}
	return list;
		
	}
	
	public  EmpBean getEmpDetailsByEid(int eid)
	{
		EmpBean e=new EmpBean();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/emsdb","root","root");
			PreparedStatement ps=con.prepareStatement("select * from Employee where eid=?");
			ps.setInt(1,eid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{ 
				
				e.setEid(rs.getInt("eid"));
				e.setEname(rs.getString("ename"));
				e.setSalary(rs.getDouble("salary"));
				e.setAddress(rs.getString("address"));
			
		     }
			con.close();
		}catch(ClassNotFoundException | SQLException w)
			{
			  System.out.println(w);
			}
		System.out.println(e);
	return e;
		
	}
	
}
