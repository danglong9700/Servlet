package ifi.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class JDBCConnection {
	final static Logger logger = Logger.getLogger(JDBCConnection.class);
	
	final String user ="root";
	final String password ="123456";
	final String url ="jdbc:mysql://localhost:3306/transport";
	final String driver = "com.mysql.cj.jdbc.Driver";
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			logger.info("Connection successful");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
}
