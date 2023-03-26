package Practice;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class Practical_test {
	static int accno;
	public static void main(String[] args) {
		
		try {
			Connection con = JDBCConnectivity.getConnection();
			PreparedStatement ps = con.prepareStatement("select *from account ORDER BY accountNumber DESC LIMIT 1;");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				 int no = rs.getInt(1);
				 accno =no+1;
				 System.out.println(accno);
				 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
