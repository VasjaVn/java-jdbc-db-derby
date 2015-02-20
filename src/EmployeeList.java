import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmployeeList {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement  stat = null;
		ResultSet  res  = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB");
			
			String sqlQuery = "SELECT * FROM EMPLOYEE";
			
			stat = conn.createStatement();
			
			res = stat.executeQuery(sqlQuery);
			
			while ( res.next() ) {
				
				int    empNo = res.getInt("EMPNO");
				String eName = res.getString("ENAME");
				String job   = res.getString("JOB_TITLE");
				
				System.out.println("" + empNo + " " + eName + " " + job);
			}
			
		} catch (SQLException e) {
			System.out.println( "SQLError: " + e.getMessage() + " code: " + e.getErrorCode() );
		
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			
			try {
				res.close();
				stat.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
