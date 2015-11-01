package com.verizon.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/employeeSearch")
public class EmployeeService {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/Unicornz";
	static final String USER = "root";
   	static final String PASS = "verizon1";

   	@Path("{id}")
	@GET
	@Produces("application/xml")
	   public String restServiceMethod(@PathParam("id") String id) {
		   Connection conn = null;
		   Statement stmt = null;
		   Integer empId = 0;
		   String empName =  null;
		   String portfolio = null;
		   String project = null;
		   Integer ssn = 0;
		   Integer experience = 0;
		   try{
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM employee where emp_id = "+ id;
		      System.out.println("SQL QUERY = " + sql);
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		         empId = rs.getInt("emp_id");
		         System.out.println("EMP NAME = " + empId);
		         empName = rs.getString("emp_name");
		         System.out.println("EMP NAME = " + empName);
		         portfolio = rs.getString("portfolio");
		         System.out.println("EMP PORTFOLIO = " + portfolio);
		         project = rs.getString("project");
		         System.out.println("EMP PROJECT = "+ project);
		         ssn = rs.getInt("ssn");
		         System.out.println("EMP SSN = " + ssn);
		         experience = rs.getInt("experience");
		         System.out.println("EMP EXPERIENCE = " + experience);
		      }
		      rs.close();
		      stmt.close();
		      conn.close();
		   }catch(SQLException se){
		      se.printStackTrace();
		   }catch(Exception e){
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		   return "<employeeSearch>" + "<empId>" + empId + "</empId>" + "<empName>" + empName + "</empName>" + "<portfolio>" + portfolio + "</portfolio>" +  "<project>" + project + "</project>"  +  "<ssn>" + ssn + "</ssn>"+ "<experience>" + experience + "</experience>" + "</employeeSearch>";
	}
}