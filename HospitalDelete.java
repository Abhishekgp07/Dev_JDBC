package quntnex_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class HospitalDelete {

	public static void main(String[] args)throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital", "root", "Abhi@1234");
		String s = "delete from hospital where id=?";
		
		PreparedStatement pstmt =con.prepareStatement(s);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the id");
		int id = sc.nextInt();
		
		pstmt.setInt(1, id);
		int row = pstmt.executeUpdate();
		
		System.out.println(row+"The delete has been happend...");
		
		
	}

}
