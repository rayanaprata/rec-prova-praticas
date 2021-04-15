package prova;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	private String url = "jdbc:mysql://localhost/ifsc_prova?useSSL=false";
	private String user = "root";
	private String password = "root";
	Connection connection = null;

	public Connection getConnection() {
		try {
			if (connection == null)
				connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}
}

