package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserInsertDataStudent {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while (true) {
			System.out.println("Press \n1.Data Entry\n2.Exit ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter Id");
				int id = sc.nextInt();
				System.out.println("Enter Name");
				String name = sc.next();
				System.out.println("Enter Marks");
				float marks = sc.nextFloat();
				System.out.println("Enter grade");
				String grade = sc.next();
				System.out.println("Enter Address");
				String addr = sc.next();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
					String sql = "insert into student values (?, ?, ?, ?, ?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setFloat(3, marks);
					ps.setString(4, grade);
					ps.setString(5, addr);
					ps.execute();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Done");
				break;
			case 2:
				System.exit(0);

			}
			System.out.println("Done");
		}
		
		
	}

}
