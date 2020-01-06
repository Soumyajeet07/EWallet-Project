package entities;

import java.util.*;

public class Customer {
	private String mobileNo;
	private String name;
	private int balance;
	private String password; 

	public Customer() {
	}

	public Customer(String mobileNo, String name, int balance, String password) {
		this.mobileNo = mobileNo;
		this.name = name;
		this.balance = balance;
		this.password=password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return  mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void transfer(Customer obj, int transferAmount) {
		obj.balance = obj.balance + transferAmount;
		this.balance = this.balance - transferAmount;
	}

	@Override
	public String toString() {
		String display = name + "mobileNo " + balance;
		return display;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || !(obj instanceof Customer)) {
			return false;
		}
		Customer c = (Customer) obj;
		return c.mobileNo.equals(this.mobileNo);
	}

	@Override
	public int hashCode() {
		return mobileNo.hashCode();
	}
}
