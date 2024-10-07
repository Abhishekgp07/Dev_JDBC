package quntnex_projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) throws Exception
	{
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver is loaded...");

		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/school","root","Abhi@1234");
		System.out.println("Connection Established....");
		
		String s = "select * from school ";
		Statement stmt =con.createStatement();
		ResultSet res =stmt.executeQuery(s);
		ResultSetMetaData rsmd = res.getMetaData();
		
		for(int i=1;i<=rsmd.getColumnCount();i++) {
			System.out.println(rsmd.getColumnName(i));
			System.out.println(rsmd.getColumnTypeName(i));
		}
		
	}

}
