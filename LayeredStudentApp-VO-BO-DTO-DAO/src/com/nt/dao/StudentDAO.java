package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.nt.bo.StudentBO;

public class StudentDAO {
	private static final String INSERT_STUDENT_QUERY="INSERT INTO STUDENT_TAB VALUES(?,?,?,?,?)";
	
	
	public int insert(StudentBO bo)throws Exception{
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		 //register jdbc driver s/w
		  // Class.forName("oracle.jdbc.driver.OracleDriver");
		   //Establish the connection
		   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		//create PreparedStatement obj
		ps=con.prepareStatement(INSERT_STUDENT_QUERY);
		//set values to Query params
		ps.setInt(1,bo.getSno());
		ps.setString(2,bo.getSname());
		ps.setInt(3,bo.getTotal());
		ps.setFloat(4,bo.getAvg());
		ps.setString(5,bo.getResult());
		//execute the Query
		count=ps.executeUpdate();
		return count;
	}//method
	}//class
