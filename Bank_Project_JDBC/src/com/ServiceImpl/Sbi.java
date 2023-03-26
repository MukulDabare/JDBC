package com.ServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import com.model.Account;
import com.service.Rbi;
import com.utility.JDBCConnectivity;

public class Sbi implements Rbi {
	
	static int  accno;
	Scanner sc = new Scanner(System.in);
	Connection con = JDBCConnectivity.getConnection();
	@Override
	public void createAccount() throws Exception {

		
		PreparedStatement ps = con.prepareStatement("select *from account ORDER BY accountNumber DESC LIMIT 1;");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			 int no = rs.getInt(1);
			 accno =no+1;
		}
		do {
			Account acc = new Account();
			acc.setAccountNumber(accno);
			System.out.println("Enter your name");
			acc.setAccountHolderName(sc.nextLine());
			System.out.println("Enter your Mobile Number");
			acc.setMobileNumber(sc.nextLong());
			System.out.println("Enter your Adhar Number");
			acc.setAdharNumber(sc.nextLong());
			System.out.println("Enter your Gender");
			acc.setGender(sc.next());
			System.out.println("Enter your age");
			acc.setAge(sc.nextInt());
			System.out.println("Enter city name/branch name to create Account");
			acc.setCityName(sc.next());
			System.out.println("Enter your choice of PIN and Remember for future transactions.");
			acc.setPin(sc.nextInt());
			System.out.println("Your Account Number is " + acc.getAccountNumber()
					+ ". Remember your Account Number and PIN for further details.");
			acc.setAccountBalance(0);
            String sql="insert into account values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setInt(1, acc.getAccountNumber());
			ps1.setString(2, acc.getAccountHolderName());
			ps1.setLong(3, acc.getMobileNumber());
			ps1.setLong(4, acc.getAdharNumber());
			ps1.setString(5, acc.getGender());
			ps1.setDouble(6, acc.getAccountBalance());
			ps1.setString(7, acc.getCityName());
			ps1.setInt(8, acc.getPin());
			ps1.setInt(9, acc.getAge());
			ps1.execute();
			System.out.println("Thank you, Your Zero Balance Account is created Successfully.");
		} while (false);

	}

	@Override
	public void displayAllDetails(int a)throws Exception {

	   PreparedStatement ps1 = con.prepareStatement("select * from account where accountNumber = ? ");
		 ps1.setInt(1, a);
		 ResultSet rs1 = ps1.executeQuery();
		 while (rs1.next()) {
			System.out.println("Account Number: "+ rs1.getInt(1));
			System.out.println("Name: "+ rs1.getString(2));
			System.out.println("Your Mob.No. : "+ rs1.getLong(3));
			System.out.println("Account linked Adhar No. : "+ rs1.getLong(4));
			System.out.println("Account Balance : "+ rs1.getDouble(6));
			System.out.println("Account Branch: "+ rs1.getString(7));
			
		}
		 
	}

	@Override
	public void depositeMoney(int c)throws Exception {
		 PreparedStatement ps1 = con.prepareStatement("select * from account where accountNumber = ? ");
		 ps1.setInt(1, c);
		 ResultSet rs1 = ps1.executeQuery();
		 while (rs1.next()) {
		  System.out.println("Enter Ammount for Deposite");
		  double temp=sc.nextDouble();
		  
		   double uptemp = temp+ rs1.getDouble(6);
           PreparedStatement ps2 = con.prepareStatement("update account set accountBalance= ? where accountNumber = ? ");
		   ps2.setDouble(1, uptemp);
           ps2.setInt(2, c);
		   ps2.execute();
		   balanceCheck(c);
		}  
	}

	@Override
	public void withdrawn(int d)throws Exception {
		
		PreparedStatement ps1 = con.prepareStatement("select * from account where accountNumber = ? ");
		 ps1.setInt(1, d);
		 ResultSet rs1 = ps1.executeQuery();
		 while (rs1.next()) {
			 System.out.println("Enter Ammount for Withdraw");
			 double temp=sc.nextDouble();
			 if(temp<=rs1.getDouble(6))
			 {
				 double uptemp = rs1.getDouble(6)-temp;
				 PreparedStatement ps2 = con.prepareStatement("update account set accountBalance= ? where accountNumber = ? ");
				   ps2.setDouble(1, uptemp);
		           ps2.setInt(2, d);
				   ps2.execute();
				   balanceCheck(d);
			 }else {
				 System.out.println("Insufficient Balance");
				 balanceCheck(d);
			 }
		}

	}

	@Override
	public void balanceCheck(int b)throws Exception {

		PreparedStatement ps1 = con.prepareStatement("select * from account where accountNumber = ? ");
		 ps1.setInt(1, b);
		 ResultSet rs1 = ps1.executeQuery();
		 while (rs1.next()) {
			 System.out.println("Balance Ammount: Rs."+rs1.getDouble(6));
		 }
		 System.out.println("Thank you.");
	}

}
