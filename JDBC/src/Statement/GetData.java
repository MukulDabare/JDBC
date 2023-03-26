package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetData {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	    PreparedStatement cs = con.prepareStatement("select * from student");
	   ResultSet rs = cs.executeQuery();
	   
	    while(rs.next())
	    {
	    	System.out.println(rs.getInt(1));
	    	System.out.println(rs.getString(2));
	    	
	    }
	    cs.close();
	    con.close();
	
	
	
	}
}
