package quntnex_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Hospital_insert {

	public static void main(String[] args)throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital","root", "Abhi@1234");
		
		String s = "insert into Hospital values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(s);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the id:");
		int id = sc.nextInt();
		
		System.out.println("enter the name of the patient");
		String name = sc.next();
		
		System.out.println("enter the age:");
		int age =sc.nextInt();
		
		System.out.println("enter the place :");
		String place = sc.next();
		
		System.out.println("enter the Doctor name:");
		String doctor=sc.next();
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, age);
		pstmt.setString(4, place);
	    pstmt.setString(5, doctor);
	   int row = pstmt.executeUpdate();
	   
	   System.out.println(row+"The row has been Inserted...");
	    
	    
		
		
		

	}

}
