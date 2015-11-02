import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Parser {
	
	private static List<String> list = null;
	static Connection conn = null;
	static Statement stmt = null;
	public void main(String[] args) throws ClassNotFoundException, SQLException{
		try{
			list = new ArrayList<String>();
			ClassLoader classLoader = getClass().getClassLoader();
			File input = new File(classLoader.getResource("Test.html").getFile());
			Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
			Element content = doc.getElementsByClass("details").get(0);
			Element trTag = content.select("tr").get(1);
			for(Element s : trTag.select("td")){
				list.add(s.text());
			}
			}catch(Exception excep){
				System.out.println("EXCEPTION OCCURRED WHILE PARSING THE DATA !!! ");
			}
		
		dbCall(list);
	}
	
	
	
	public static void dbCall(List<String> list) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/myapp_test","travis","");
	      System.out.println("Creating statement.......");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "insert into report values('"+list.get(0)+"', '"+list.get(1)+"','"+list.get(2)+"','"+list.get(3)+"','"+list.get(4)+"','"+list.get(5)+"')";
	      System.out.println("SQL QUERY = " + sql);
	      ResultSet rs = stmt.executeQuery(sql);
	      while(rs.next()){
	    	  System.out.println(rs.getInt(1));
	    	  System.out.println(rs.getString(2));
	    	  System.out.println(rs.getString(3));
	      }
	}
	
}
