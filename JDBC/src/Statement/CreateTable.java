package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			String sql="create table courses(cid int, cname varchar(50), foreign key (cid) references student (sid) )";
		   // String sql= "drop table student";
			Statement smt = con.createStatement();
			smt.execute(sql);
			smt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		System.out.println("Done");
		
	}

}
