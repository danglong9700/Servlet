package ifi.com.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
	
	
}
