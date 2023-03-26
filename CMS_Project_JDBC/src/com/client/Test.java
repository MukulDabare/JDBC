package com.client;

import java.util.Scanner;

import com.service.Cjc;
import com.serviceImpl.Karvenagar;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Cjc c = new Karvenagar();
		
		while (true) {
			System.out.println("Enter choice " + "\n1.Add Course" + "\n2.View Courses" + "\n3.Add Faculty"
					+ "\n4.View Faculties" + "\n5.Add Batch" + "\n6.View Batches" + "\n7.Add Student"
					+ "\n8.View Students" + "\n9.To exit");
			int ch = sc.nextInt();
			try {
				switch (ch) {
				case (1):
					System.out.println("Enter Course Details");
				   c.addCourse();
					break;
				case (2):
					System.out.println("Course Details");
					c.viewCourse();
					break;
				case (3):
					System.out.println("Enter Faculty Details");
					c.addFaculty();
					break;
				case (4):
					System.out.println("Faculty Details");
					c.viewFaculty();
					break;
				case (5):
					System.out.println("Enter Batch Details");
					c.addBatch();
					break;
				case (6):
					System.out.println("Batch Details");
				c.viewBatch();
					break;
				case (7):
					System.out.println("Enter Student Details");
					c.addStudent();
					break;
				case (8):
					System.out.println("Student Details");
				    c.viewStudent();
					break;

				case (9):
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}
			}catch(Exception e)
				{
				System.out.println("ID already Exist");
				e.printStackTrace();
				}
			
	}
 }
}


