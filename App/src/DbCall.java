import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbCall {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/myapp_test";
	static final String USER = "root";
   	static final String PASS = "verizon1";
	static Connection conn = null;
	static Statement stmt = null;
	public static void main(String[] args) {
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      System.out.println("Creating statement.......");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "select * from employee";
		      System.out.println("SQL QUERY = " + sql);
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()){
		    	  System.out.println(rs.getInt(1));
		    	  System.out.println(rs.getString(2));
		    	  System.out.println(rs.getString(3));
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

	}

}
