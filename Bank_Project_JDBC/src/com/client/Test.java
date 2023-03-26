package com.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.ServiceImpl.Sbi;
import com.service.Rbi;
import com.utility.JDBCConnectivity;



public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Rbi rbi = new Sbi();
        Connection con = JDBCConnectivity.getConnection();
		while (true) {

			System.out.println(
					"Enter choice:-\n1.Create new Account\n2.Check Account Details\n3.Check Account Balance\n4.Deposite Amount\n5.Withdraw Amount\n6.Exit");
			int choice = sc.nextInt();

			try {
				switch (choice) {
				case 1:

					rbi.createAccount();
					break;
				case 2:
					System.out.println("Enter your Account Number");
					int a = sc.nextInt();
					System.out.println("Enter your PIN");
					int apin = sc.nextInt();
					PreparedStatement ps1 = con.prepareStatement("select * from account where accountNumber= ?");
					ps1.setInt(1, a);
					ResultSet rs1 = ps1.executeQuery();
					if(rs1.next())
					{
						if(rs1.getInt(8)==apin)
						{
							rbi.displayAllDetails(a);
						}else {
							System.out.println("Invalid PIN");
						}
					}else {
						System.out.println("Account Not Found");
					}
					
					break;
				case 3:
					System.out.println("Enter your Account Number");
					int b = sc.nextInt();
					System.out.println("Enter your PIN");
					int bpin = sc.nextInt();
					PreparedStatement ps2 = con.prepareStatement("select * from account where accountNumber= ?");
					ps2.setInt(1, b);
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next())
					{
						if(rs2.getInt(8)==bpin)
						{
							rbi.balanceCheck(b);
						}else {
							System.out.println("Invalid PIN");
						}
					}else {
						System.out.println("Account Not Found");
					}
					break;
				case 4:
					System.out.println("Enter your Account Number");
					int c = sc.nextInt();
					System.out.println("Enter your PIN");
					int cpin = sc.nextInt();
					PreparedStatement ps3 = con.prepareStatement("select * from account where accountNumber= ?");
					ps3.setInt(1, c);
					ResultSet rs3 = ps3.executeQuery();
					if(rs3.next())
					{
						if(rs3.getInt(8)==cpin)
						{
							rbi.depositeMoney(c);
						}else {
							System.out.println("Invalid PIN");
						}
					}else {
						System.out.println("Account Not Found");
					}
					
					break;
				case 5:
					System.out.println("Enter your Account Number");
					int d = sc.nextInt();
					System.out.println("Enter your PIN");
					int dpin = sc.nextInt();
					PreparedStatement ps4 = con.prepareStatement("select * from account where accountNumber= ?");
					ps4.setInt(1, d);
					ResultSet rs4 = ps4.executeQuery();
					if(rs4.next())
					{
						if(rs4.getInt(8)==dpin)
						{
							rbi.withdrawn(d);
						}else {
							System.out.println("Invalid PIN");
						}
					}else {
						System.out.println("Account Not Found");
					}
					
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");

				}
			} 
			catch(Exception e4)
			{
				System.out.println("Invalid Entry");
				e4.printStackTrace();
			}

		}

	}

}


