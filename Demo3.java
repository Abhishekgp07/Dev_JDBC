
package quntnex_projects;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo3 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        System.out.println("The driver is connected..");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/emp_table","root","Abhi@1234");
        System.out.println("Connection Established....");
        
        // Update the SQL query to match your table structure
        String s = "INSERT INTO emp (empno, ename, job, mgr) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(s);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the empno:");
        int empno = sc.nextInt();
        
        System.out.println("Enter the ename:");
        String ename = sc.next();
        
        System.out.println("Enter the job:");
        String job = sc.next();
        
        System.out.println("Enter the mgr:");
        int mgr = sc.nextInt();
        
        pstmt.setInt(1, empno);
        pstmt.setString(2, ename);
        pstmt.setString(3, job);
        pstmt.setInt(4, mgr);
        
        int row = pstmt.executeUpdate();
        System.out.println(row + " row(s) inserted.");
    }
}
