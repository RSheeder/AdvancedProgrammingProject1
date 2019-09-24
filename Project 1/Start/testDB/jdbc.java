import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
	static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	static final String JDBC_URL = "jdbc:derby:ConnectingCreatingJavaDB;create=true";
			
	Connection conn;
	
	public jdbc() {
		try {
			this.conn = DriverManager.getConnection(JDBC_URL);
			if(this.conn != null) {
				System.out.println("Connecting");
			}
		} catch(SQLException e) {
			System.out.println("Connection Failure");
		}
	
	}
}
