package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable2 {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		String sql="create table Faculty2 (sid int , sname varchar(50))";
		Statement statement = con.createStatement();
		statement.execute(sql);
		statement.close();
		con.close();
		System.out.println("Done");
	}
	

}
