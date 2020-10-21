package ifi.com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ifi.com.model.Employee;

public class EmployeeDao extends JDBCConnection {
	final static Logger logger = Logger.getLogger(EmployeeDao.class);

	public List<Employee> selectAllEmployee() {

		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			Connection con = super.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");
			logger.debug("Employee Select all query successful");
			while (rs.next()) {
				int eId = rs.getInt(1);
				logger.debug(rs.getInt(1));
				String eName = rs.getString(2);
				logger.debug(rs.getString(2));
				String ePassword = rs.getString(3);
				logger.debug(rs.getString(3));
				Employee emp = new Employee(eId, eName, ePassword);
				employeeList.add(emp);
				return employeeList;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.debug(e);
		}
		return null;

	}

	public boolean validateLogin(String uName, String uPassword) {
		List<Employee> employeeList = selectAllEmployee();
		for (int i = 0; i < employeeList.size(); i++) {
			if (uName.equals(employeeList.get(i).geteName()) && uPassword.equals(employeeList.get(i).getePassword())) {
				logger.debug(uName + " / " + employeeList.get(i).geteName());
				logger.debug(uPassword + " /" + employeeList.get(i).getePassword());
				return true;
			}
		}
		return false;
	}
}
