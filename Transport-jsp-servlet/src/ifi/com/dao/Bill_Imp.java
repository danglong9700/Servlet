package ifi.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Date;

import org.apache.log4j.Logger;

import ifi.com.model.Bill;

public class Bill_Imp extends JDBCConnection implements BillDao {
	final static Logger logger = Logger.getLogger(Bill_Imp.class);
	
	public static void main(String args[]) {
		Bill_Imp bill_imp = new Bill_Imp();
		LocalDate lc1 = LocalDate.of(2020, 10, 19);
		LocalDate lc2 = LocalDate.of(2020, 10, 22);
		//Bill bill = new Bill(14,"Test 2", "On Road", "1A NTT", "21 IFI", lc1 , lc2 ,
				//"Nguyen Van A", "LMAO", 1.4, 20000, 40000);
		Bill bill = bill_imp.get(1);
		logger.info(bill.toString());
		
	}
	
	@Override
	public void create(Bill bill) {
		try {
			Connection con = super.getConnection();
			String sql = "Insert into transport.transport_bill values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, bill.getBId());
			ps.setString(2, bill.getBName());
			ps.setString(3, bill.getBStatus());
			ps.setString(4, bill.getBDestStart());
			ps.setString(5, bill.getBDestFinish());
			ps.setDate(6, Date.valueOf(bill.getBInitDate()));
			ps.setDate(7, Date.valueOf(bill.getBFinishDate()));
			ps.setString(8, bill.getBShipBrand());
			ps.setString(9, bill.getBDesc());
			ps.setDouble(10, bill.getBWeight());
			ps.setInt(11, bill.getBShipPay());
			ps.setInt(12, bill.getBTotalPay());
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
			ps.setString(1, bill.getBName());
			ps.setString(2, bill.getBStatus());
			ps.setString(3, bill.getBDestStart());
			ps.setString(4, bill.getBDestFinish());
			ps.setDate(5, Date.valueOf(bill.getBInitDate()));
			ps.setDate(6, Date.valueOf(bill.getBFinishDate()));
			ps.setString(7, bill.getBShipBrand());
			ps.setString(8, bill.getBDesc());
			ps.setDouble(9, bill.getBWeight());
			ps.setInt(10, bill.getBShipPay());
			ps.setInt(11, bill.getBTotalPay());
			ps.setInt(12, bill.getBId());
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
	
	

}
