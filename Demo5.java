package quntnex_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo5 {

	public static void main(String[] args)throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("The driver Loaded...");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root", "Abhi@1234");
		System.out.println("Connection Establish Sucessfully....");

		String s ="delete from school where id=?";
		PreparedStatement pstmt = con.prepareStatement(s);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id");
		int id=sc.nextInt();
		
		pstmt.setInt(1, id);
		
		int rows = pstmt.executeUpdate();
		System.out.println(rows);
	}

}
