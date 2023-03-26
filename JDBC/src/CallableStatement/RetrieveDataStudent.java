package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RetrieveDataStudent {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			CallableStatement cs = con.prepareCall("{call getdata()}");
			ResultSet rs = cs.executeQuery();
			while(rs.next())
			{
				System.out.println("Id: "+rs.getInt(1));
				System.out.println("Name: "+rs.getString(2));
				System.out.println("Marks: "+rs.getFloat(3));
				System.out.println("Grade: "+rs.getString(4));
				System.out.println("Address: "+rs.getString(5));
				System.out.println("-------------");
			}
			
			System.out.println("Done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
