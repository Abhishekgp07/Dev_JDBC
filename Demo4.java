package quntnex_projects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args)throws Exception{ {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded Sucessfully.....");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root", "Abhi@1234");
		System.out.println("Connection Establish Sucessfully....");
		
		String s ="update school set name=? where id=?";
		
		PreparedStatement pstmt = con.prepareStatement(s);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the name");
		String name =sc.next();
		
		System.out.println("enter the id");
		int id = sc.nextInt();
		
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		
		int row=pstmt.executeUpdate();
		
		System.out.println(row);
	}
		

	}

}
