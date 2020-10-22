package ifi.com.model;

import java.time.LocalDate;



public class Bill {
	int bId;
	String bName;
	String bStatus;
	String bDestStart;
	String bDestFinish;
	LocalDate bInitDate;
	LocalDate bFinishDate;
	String bShipBrand;
	String bDesc;
	Double bWeight;
	int bShipPay;
	int bTotalPay;
	
	
	
	public Bill(int bId, String bName, String bStatus, String bDestStart, String bDestFinish, LocalDate bInitDate,
			LocalDate bFinishDate, String bShipBrand, String bDesc, Double bWeight, int bShipPay, int bTotalPay) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bStatus = bStatus;
		this.bDestStart = bDestStart;
		this.bDestFinish = bDestFinish;
		this.bInitDate = bInitDate;
		this.bFinishDate = bFinishDate;
		this.bShipBrand = bShipBrand;
		this.bDesc = bDesc;
		this.bWeight = bWeight;
		this.bShipPay = bShipPay;
		this.bTotalPay = bTotalPay;
	}



	public Bill(String bName, String bStatus, String bDestStart, String bDestFinish, LocalDate bInitDate,
			LocalDate bFinishDate, String bShipBrand, String bDesc, Double bWeight, int bShipPay, int bTotalPay) {
		this.bName = bName;
		this.bStatus = bStatus;
		this.bDestStart = bDestStart;
		this.bDestFinish = bDestFinish;
		this.bInitDate = bInitDate;
		this.bFinishDate = bFinishDate;
		this.bShipBrand = bShipBrand;
		this.bDesc = bDesc;
		this.bWeight = bWeight;
		this.bShipPay = bShipPay;
		this.bTotalPay = bTotalPay;
	}



	public int getbId() {
		return bId;
	}



	public void setbId(int bId) {
		this.bId = bId;
	}



	public String getbName() {
		return bName;
	}



	public void setbName(String bName) {
		this.bName = bName;
	}



	public String getbStatus() {
		return bStatus;
	}



	public void setbStatus(String bStatus) {
		this.bStatus = bStatus;
	}



	public String getbDestStart() {
		return bDestStart;
	}



	public void setbDestStart(String bDestStart) {
		this.bDestStart = bDestStart;
	}



	public String getbDestFinish() {
		return bDestFinish;
	}



	public void setbDestFinish(String bDestFinish) {
		this.bDestFinish = bDestFinish;
	}



	public LocalDate getbInitDate() {
		return bInitDate;
	}



	public void setbInitDate(LocalDate bInitDate) {
		this.bInitDate = bInitDate;
	}



	public LocalDate getbFinishDate() {
		return bFinishDate;
	}



	public void setbFinishDate(LocalDate bFinishDate) {
		this.bFinishDate = bFinishDate;
	}



	public String getbShipBrand() {
		return bShipBrand;
	}



	public void setbShipBrand(String bShipBrand) {
		this.bShipBrand = bShipBrand;
	}



	public String getbDesc() {
		return bDesc;
	}



	public void setbDesc(String bDesc) {
		this.bDesc = bDesc;
	}



	public Double getbWeight() {
		return bWeight;
	}



	public void setbWeight(Double bWeight) {
		this.bWeight = bWeight;
	}



	public int getbShipPay() {
		return bShipPay;
	}



	public void setbShipPay(int bShipPay) {
		this.bShipPay = bShipPay;
	}



	public int getbTotalPay() {
		return bTotalPay;
	}



	public void setbTotalPay(int bTotalPay) {
		this.bTotalPay = bTotalPay;
	}



	@Override
	public String toString() {
		return "Bill [bId=" + bId + ", bName=" + bName + ", bStatus=" + bStatus + ", bDestStart=" + bDestStart
				+ ", bDestFinish=" + bDestFinish + ", bInitDate=" + bInitDate + ", bFinishDate=" + bFinishDate
				+ ", bShipBrand=" + bShipBrand + ", bDesc=" + bDesc + ", bWeight=" + bWeight + ", bShipPay=" + bShipPay
				+ ", bTotalPay=" + bTotalPay + "]";
	}
	
	
	
	
}
