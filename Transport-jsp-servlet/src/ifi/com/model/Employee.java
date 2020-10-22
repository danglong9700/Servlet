package ifi.com.model;

public class Employee {
	int eId;
	String eName;
	String ePassword;
	
	public Employee(int eId, String eName, String ePassword) {
		this.eId = eId;
		this.eName = eName;
		this.ePassword = ePassword;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getePassword() {
		return ePassword;
	}

	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}
	
	
}
