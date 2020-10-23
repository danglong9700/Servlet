package ifi.com.dao;

import ifi.com.model.Employee;

public interface EmployeeDao {
	public void create(Employee emp);
	public void update(Employee emp);
	public void delete(int id);
	public Employee get(int id);
}
