package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
//			int rollno=19;
//			String name="Abc";
//		    String sql="insert into courses values ("+rollno+", ' "+name+"')";
		    String sql="insert into courses values (5,'python')";
		    //String sql= "delete from student where sid=0";
			Statement smt = con.createStatement();
			smt.execute(sql);
			smt.close();
			con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("Done");
		
	}

}
