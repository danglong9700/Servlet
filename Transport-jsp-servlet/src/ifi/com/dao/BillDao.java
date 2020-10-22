package ifi.com.dao;

import ifi.com.model.Bill;

public interface BillDao {
	public void create(Bill bill);
	public void update(Bill bill);
	public void delete(int id);
	public Bill get(int id);
}
