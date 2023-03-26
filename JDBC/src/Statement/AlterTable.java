package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AlterTable {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String sql= "alter table student add column grade varchar(3) default 'U'";
			//String sql="alter table student drop column grade";
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
