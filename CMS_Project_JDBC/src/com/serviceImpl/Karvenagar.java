package com.serviceImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;
import com.service.Cjc;
import com.utility.JDBCConnectivity;

public class Karvenagar implements Cjc {
	Scanner sc = new Scanner(System.in);
	Connection con = JDBCConnectivity.getConnection();
	
	@Override
	public void addCourse() throws Exception {
		Course c = new Course();
		System.out.println("Enter Course ID");
		c.setCid(sc.nextInt());
		System.out.println("Enter Course Name");
		c.setCname(sc.next());
		
		PreparedStatement ps = con.prepareStatement("select * from course where cid= ?");
		ps.setInt(1, c.getCid());
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			System.out.println("ID already Exist");
		}
		else {
			PreparedStatement ps1 = con.prepareStatement("insert into course values (?, ?)");
			ps1.setInt(1, c.getCid());
			ps1.setString(2, c.getCname());
			ps1.execute();
			System.out.println("Course Added Successfully");
		}

	}

	@Override
	public void viewCourse() throws Exception {
		
		CallableStatement ps2 = con.prepareCall("select * from course");
		ResultSet rs = ps2.executeQuery();
		while (rs.next())
		{
			System.out.println("\nCourse Id:- "+rs.getInt(1));
			System.out.println("Course Name:- "+rs.getString(2));
			System.out.println("---------------------");
		}

	}

	@Override
	public void addFaculty() throws Exception {
		Faculty f=new Faculty();
		System.out.println("Enter Faculty ID");
		f.setFid(sc.nextInt());
		System.out.println("Enter Faculty Name");
		f.setFname(sc.next());
		System.out.println("Enter course ID to assign to the faculty");
		viewCourse();
		System.out.println("Enter Course Id from above choice:");
		int aid=sc.nextInt();
		PreparedStatement ps3 = con.prepareStatement("select * from course where cid= ?");
		ps3.setInt(1, aid);
		ResultSet rs = ps3.executeQuery();
		if(rs.next())
		{
			Course c= new Course();
			c.setCid(rs.getInt(1));
			c.setCname(rs.getString(2));
			f.setCourse(c);
			PreparedStatement ps4 = con.prepareStatement("insert into faculty values(?, ?, ?, ?)");
			ps4.setInt(1, f.getFid());
			ps4.setString(2, f.getFname());
			ps4.setInt(3, f.getCourse().getCid());
			ps4.setString(4, f.getCourse().getCname());
			ps4.execute();
			System.out.println("Faculty Added Successfully");
			
		}else {
			System.out.println("Enter Valid Id");
		}
	}

	@Override
	public void viewFaculty() throws Exception {
	  PreparedStatement ps5 = con.prepareStatement("select * from faculty");
	  ResultSet rs = ps5.executeQuery();
	  while (rs.next())
		{
			System.out.println("\nFaculty Id:- "+rs.getInt(1));
			System.out.println("Faculty Name:- "+rs.getString(2));
			System.out.println("Course Assign: "+rs.getInt(3));
			System.out.println("Course Name:- "+rs.getString(4));
			System.out.println("---------------------");
		}
		
	}

	@Override
	public void addBatch() throws Exception {
		Batch b=new Batch();
		System.out.println("Enter Batch Id");
		b.setBid(sc.nextInt());
		System.out.println("Enter Batch Name");
		b.setBname(sc.next());
		System.out.println("Enter Faculty Id to assign to the Batch");
		viewFaculty();
		System.out.println("Enter Faculty Id from above choice: ");
		int aid=sc.nextInt();
		PreparedStatement ps6 = con.prepareStatement("select * from faculty where fid= ?");
		ps6.setInt(1, aid);
		ResultSet rs = ps6.executeQuery();
		if(rs.next())
		{
			Course c=new Course();
			c.setCid(rs.getInt(3));
			c.setCname(rs.getString(4));
            Faculty f=new Faculty();
			f.setFid(rs.getInt(1));
			f.setFname(rs.getString(2));
			f.setCourse(c);
			b.setFaculty(f);
	     PreparedStatement ps7 = con.prepareStatement("insert into batch values (?,?,?,?,?,?)");
		    ps7.setInt(1, b.getBid());
		    ps7.setString(2, b.getBname());
		    ps7.setInt(3, b.getFaculty().getFid());
		    ps7.setString(4, b.getFaculty().getFname());
		    ps7.setInt(5, b.getFaculty().getCourse().getCid());
		    ps7.setString(6, b.getFaculty().getCourse().getCname());
		    ps7.execute();
		    System.out.println("Batch Added Successfully");
		
		}else {
			System.out.println("Enter Valid Id");
		}
		
		
	}

	@Override
	public void viewBatch() throws Exception {
		PreparedStatement ps8 = con.prepareStatement("select * from batch");
		ResultSet rs = ps8.executeQuery();
		while(rs.next()) {
			System.out.println("Batch Id: "+rs.getInt(1));
			System.out.println("Batch Name: "+rs.getString(2));
			System.out.println("---------------------");
		}
		
		
		
	}

	@Override
	public void addStudent() throws Exception {
		Student s=new Student();
		System.out.println("Enter Student Id");
		s.setSid(sc.nextInt());
		System.out.println("Enter Student Name");
		s.setSname(sc.next());
		System.out.println("Enter Batch Id to which Student will be assigned");
		viewBatch();
		System.out.println("Enter Batch Id");
		int aid=sc.nextInt();
		PreparedStatement ps9 = con.prepareStatement("select * from batch where bid= ?");
		ps9.setInt(1, aid);
		ResultSet rs = ps9.executeQuery();
		if(rs.next())
		{
			Course c=new Course();
			c.setCid(rs.getInt(5));
			c.setCname(rs.getString(6));
			Faculty f=new Faculty();
			f.setFid(rs.getInt(3));
			f.setFname(rs.getString(4));
			f.setCourse(c);
			Batch b= new Batch();
			b.setBid(rs.getInt(1));
			b.setBname(rs.getString(2));
			b.setFaculty(f);
			s.setBatch(b);
			PreparedStatement ps10 = con.prepareStatement("insert into student values (?,?,?,?,?,?,?,?)");
			ps10.setInt(1, s.getSid());
			ps10.setString(2, s.getSname());
			ps10.setInt(3, s.getBatch().getBid());
			ps10.setString(4, s.getBatch().getBname());
			ps10.setInt(5, s.getBatch().getFaculty().getFid());
			ps10.setString(6, s.getBatch().getFaculty().getFname());
			ps10.setInt(7, s.getBatch().getFaculty().getCourse().getCid());
			ps10.setString(8, s.getBatch().getFaculty().getCourse().getCname());
			ps10.execute();
			System.out.println("Student Added Successfully");
		}else {
			System.out.println("Enter Valid Id");
		}
		
	}

	@Override
	public void viewStudent() throws Exception {
		PreparedStatement ps11 = con.prepareStatement("Select * from Student");
		ResultSet rs = ps11.executeQuery();
		while(rs.next())
		{
			System.out.println("Student Id: "+rs.getInt(1));
			System.out.println("Student Name: "+rs.getString(2));
			System.out.println("---------------------------");
		}
		
	}

}
