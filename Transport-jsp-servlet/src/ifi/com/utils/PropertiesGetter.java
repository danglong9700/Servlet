package ifi.com.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import ifi.com.properties.Constant;

public class PropertiesGetter {
	final static Logger logger = Logger.getLogger(PropertiesGetter.class);
	
	public ArrayList<String> getDBValues() {
		ArrayList<String> rs = new ArrayList<String>();
		try {
			Properties prop = new Properties();
			InputStream input = getClass().getClassLoader().getResourceAsStream(Constant.PROP_DB_PATH);
			logger.debug("check!");
			if (input != null) {
				prop.load(input);
				logger.info(input);
			}
			else {
				logger.error("Database Properties not found");
			}
			String username = prop.getProperty("username");
			rs.add(username);
			logger.info(rs);
			input.close();
			return rs;
		}
		catch(Exception e) {
			logger.error(e);
		}
		return null;
	}
}
