package ifi.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ifi.com.properties.Constant;
import ifi.com.utils.PropertiesGetter;

public class JDBCConnection {
	final static Logger logger = Logger.getLogger(JDBCConnection.class);
	
	public static void main(String[] args) {
		PropertiesGetter pg = new PropertiesGetter();
		ArrayList<String> a = pg.getDBValues();
		System.out.println(a);
		//System.out.println(username + password + url);
		
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(Constant.DB_DRIVER);
			con = DriverManager.getConnection(Constant.DB_URL,Constant.DB_USER,Constant.DB_PASSWORD);
			logger.info("Connection successful");
		}
		catch(Exception e) {
			logger.error(e);
		}
		
		return con;
	}
}
