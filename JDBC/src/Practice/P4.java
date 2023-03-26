package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class P4 {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		     String sql="drop table tp";
		     Statement stm = con.createStatement();
		     stm.execute(sql);
		     stm.close();
		     con.close();
		     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
		
	}

}
