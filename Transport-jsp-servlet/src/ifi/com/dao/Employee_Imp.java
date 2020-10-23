package ifi.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import ifi.com.model.Employee;

public class Employee_Imp extends JDBCConnection implements EmployeeDao {
	final static Logger logger = Logger.getLogger(Employee_Imp.class);
	@Override
	public void create(Employee emp) {
		try {
			Connection con = super.getConnection();
			String sql = "Insert into transport.employee values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, emp.geteId());
			ps.setString(2, emp.geteName());
			ps.setString(3, emp.getePassword());
			ps.execute();
			con.close();
		}
		catch (Exception e) {
			logger.error(e);
		}
	}

	@Override
	public void update(Employee emp) {
		try {
			Connection con = super.getConnection();
			String sql = "Update employee Set e_name = ?, e_password = ? WHERE e_id = ?";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, emp.geteName());
			ps.setString(2, emp.getePassword());
			ps.setInt(3, emp.geteId());
			ps.execute();
			con.close();
		}
		catch (Exception e) {
			logger.error(e);
		}

	}

	@Override
	public void delete(int id) {
		try {
			Connection con = super.getConnection();
			String sql = "DELETE FROM employee WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			ps.execute();
			con.close();
		}
		catch (Exception e ) {
			logger.error(e);
		}

	}

	@Override
	public Employee get(int id) {
		try {
			Connection con = super.getConnection();
			String sql = "SELEC * FROM employee WHERE id =?";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
				return emp;
			}
		}
		catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	public ResultSet getAll() {
		try {
			Connection con = super.getConnection();
			String sql = "Select * from employee";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		}catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	public boolean validateLogin(String uName, String uPassword) {
		ResultSet rs = getAll();
		try {
			while(rs.next()) {
				if (uName.equals(rs.getString(2)) && uPassword.equals(rs.getString(3))) {
					logger.fatal(rs.getString(2) + rs.getString(3));
					return true;
				}
				else {
					return false;
				}
			}
		}catch (Exception e) {
			logger.error(e);
		}
		return false;
	}
	
}
