package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Addtwonumber {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			CallableStatement cs = con.prepareCall("{call addtwonumber (?,?,?)}");
			cs.setInt(1, 14);
			cs.setInt(2, 15);
			cs.registerOutParameter(3, Types.INTEGER);
			cs.execute();
			int c= cs.getInt(3);
			System.out.println(c);
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Done");
	}
}
