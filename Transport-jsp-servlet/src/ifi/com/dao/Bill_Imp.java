package ifi.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

import org.apache.log4j.Logger;

import ifi.com.model.Bill;

public class Bill_Imp extends JDBCConnection implements BillDao {
	final static Logger logger = Logger.getLogger(Bill_Imp.class);
	
	public static void main(String args[]) {
		ArrayList<Bill> billList = new ArrayList();
		Bill_Imp bill_imp = new Bill_Imp();
		billList = bill_imp.getAllList();
	}
	
	@Override
	public void create(Bill bill) {
		try {
			Connection con = super.getConnection();
			String sql = "Insert into transport.transport_bill values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, bill.getbId());
			ps.setString(2, bill.getbName());
			ps.setString(3, bill.getbStatus());
			ps.setString(4, bill.getbDestStart());
			ps.setString(5, bill.getbDestFinish());
			ps.setDate(6, Date.valueOf(bill.getbInitDate()));
			ps.setDate(7, Date.valueOf(bill.getbFinishDate()));
			ps.setString(8, bill.getbShipBrand());
			ps.setString(9, bill.getbDesc());
			ps.setDouble(10, bill.getbWeight());
			ps.setInt(11, bill.getbShipPay());
			ps.setInt(12, bill.getbTotalPay());
			ps.execute();
			con.close();
		}
		catch (Exception e ) {
			logger.error(e);
		}

	}

	@Override
	public void update(Bill bill) {
		try {
			Connection con = super.getConnection();
			String sql = "UPDATE transport_bill SET name = ?, status = ?, dest_start = ?, dest_finish = ?, init_date = ?, finish_date = ?, ship_brand = ?, description = ?, weight = ?, ship_payment = ?, total_payment = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, bill.getbName());
			ps.setString(2, bill.getbStatus());
			ps.setString(3, bill.getbDestStart());
			ps.setString(4, bill.getbDestFinish());
			ps.setDate(5, Date.valueOf(bill.getbInitDate()));
			ps.setDate(6, Date.valueOf(bill.getbFinishDate()));
			ps.setString(7, bill.getbShipBrand());
			ps.setString(8, bill.getbDesc());
			ps.setDouble(9, bill.getbWeight());
			ps.setInt(10, bill.getbShipPay());
			ps.setInt(11, bill.getbTotalPay());
			ps.setInt(12, bill.getbId());
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
			String sql = "DELETE FROM transport_bill WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			ps.execute();
			con.close();
		}
		catch (Exception e) {
			logger.error(e);
		}

	}

	@Override
	public Bill get(int id) {
		try {
			Connection con = super.getConnection();
			logger.fatal(con);
			String sql = "SELECT * FROM transport_bill WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bill bill = new Bill(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						(rs.getDate(6)).toLocalDate(),
						(rs.getDate(7)).toLocalDate(),
						rs.getString(8),
						rs.getString(9),
						rs.getDouble(10),
						rs.getInt(11),
						rs.getInt(12)
						);
				return bill;
			}
			con.close();
		}
		catch (Exception e) {
			logger.error(e);
		}
		return null;

	}
	
	public ArrayList<Bill> getAllList() {
		ArrayList<Bill> billList = new ArrayList<Bill>();
		try {
			Connection con = super.getConnection();
			String sql = "Select * from transport_bill";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Bill bill = new Bill(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						(rs.getDate(6)).toLocalDate(),
						(rs.getDate(7)).toLocalDate(),
						rs.getString(8),
						rs.getString(9),
						rs.getDouble(10),
						rs.getInt(11),
						rs.getInt(12)
						);
				billList.add(bill);
			}
			con.close();
			return billList;
		}catch (Exception e) {
			logger.error(e);
		}
		return null;
	}
	/*
	public ArrayList<Bill> getList(){
		ArrayList<Bill> billList = new ArrayList<Bill>();
		try {
			ResultSet rs = getAll();
			logger.fatal(rs);
			while(rs.next()) {
				Bill bill = new Bill(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						(rs.getDate(6)).toLocalDate(),
						(rs.getDate(7)).toLocalDate(),
						rs.getString(8),
						rs.getString(9),
						rs.getDouble(10),
						rs.getInt(11),
						rs.getInt(12)
						);
				billList.add(bill);
			}
			return billList;
		}
		catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return null;
		
	}
	*/
}
