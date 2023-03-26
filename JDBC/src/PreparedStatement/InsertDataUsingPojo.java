package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDataUsingPojo {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		PojoStudent stu=new PojoStudent();
		System.out.println("Enter Id");
		stu.setSid(sc.nextInt());
		
		System.out.println("Enter Name");
		stu.setSname(sc.next());
	
		System.out.println("Enter Marks");
		stu.setSmarks(sc.nextFloat());
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");
			String sql= "insert into student values (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, stu.getSid());
			ps.setString(2, stu.getSname());
			ps.setFloat(3, stu.getSmarks());
			ps.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
