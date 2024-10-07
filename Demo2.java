
package quntnex_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver Registered....");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root", "Abhi@1234");
	    System.out.println("Connection Established.....");
	    
	    String s ="select * from school";
	    
	    PreparedStatement pstmt = con.prepareStatement(s);
	    
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter the id:");
	    int id = sc.nextInt();
	    
	    pstmt.setInt(1, id);
	    ResultSet res = pstmt.executeQuery();
	    if(res.next()) {
	    	id=res.getInt(1);
	    	String name=res.getString(2);
	    	int age=res.getInt(3);
	    	System.out.println(id+" "+name+" "+age);
	    }else {
	    	System.out.println("Invalid input");
	    }

	}

}
