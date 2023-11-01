import java.sql.DriverManager;
import java.sql.Connection;
public class Myconnection {
	//เชื่อมกับฐานข้อมูล 
public static Connection getConection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/employee","root","airsmith");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
}
