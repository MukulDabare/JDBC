package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class InsertData {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		   CallableStatement cs = con.prepareCall("{call insertdata (?,?,?,?,?)}");
		   cs.setInt(1, 14);
		   cs.setString(2, "Jim");
		   cs.setFloat(3, 45.365f);
		   cs.setString(4, "D");
		   cs.setString(5, "USA");
		   cs.execute();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
