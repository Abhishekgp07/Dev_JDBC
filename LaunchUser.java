package quntnex_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LaunchUser {
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Register");
		System.out.println("2. Login");
		System.out.println("enter your choice:");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:register();
		break;
		case 2: login();
		break;
		default:System.out.println("Invalid Choice...");
		break;
		}
		
	}



	static void register()throws Exception{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root","Abhi@1234");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name");
		String name = sc.next();
		
		System.out.println("enter the username:");
		String username = sc.next();
		
		while(true) {
			String s ="select * from user where username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res =pstmt.executeQuery();
			
			if(res.next()) {
				System.out.println("Username already exit.. Please enter the another Username");
				username =sc.next();
			}else {
				break;	
			}
		}
			System.out.println("enter the password:");
			String password=sc.next();
		
			System.out.println("enter the confirm password:");
			String confirm_password =sc.next();
			 
			if(password.equals(confirm_password)) {
				System.out.println("The password is matching");
			}else {
				System.out.println("enter the valid passowrd");
			}
		
			System.out.println("Enter the email:");
			String Email =sc.next();
			
			String Query="Insert into user value(?,?,?,?)";
			PreparedStatement pstmt1 =con.prepareStatement(Query);
			pstmt1.setString(1, name);
			pstmt1.setString(2, username);
			pstmt1.setString(3, password);
			pstmt1.setString(4, Email);
			pstmt1.executeUpdate();
	}
			
			static void login() throws Exception {
				Scanner sc = new Scanner(System.in);
				System.out.println("enter the username:");
				 String username = sc.next();
				 System.out.println("enter the password:");
				 String password=sc.next();
				 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root","Abhi@1234");
				 String str="select * from user where username=? and password=?";
				 PreparedStatement pstmt2=con.prepareStatement(str);
				 pstmt2.setString(1,username); 
				 pstmt2.setString(2,password);
				 ResultSet res = pstmt2.executeQuery();
				 if(res.next()) {
					String name=res.getString(1);
					 username=res.getString(2);
					 password=res.getString(3);
					String email=res.getString(4);
					System.out.println(name+" "+username+" "+password+" "+email);
					
				 }else {
					 System.out.println("Enter the valid data:");
				 }
				
			}
			
		
			
	
	}

	

