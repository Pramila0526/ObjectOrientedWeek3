package com.bridgelabz.sj.model;

public class UserData {
	int id;
	String userName;
	String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String toString() {
		return "UserData [id=" + id + ", userName=" + userName + ", address=" + address + "]";
	}

	
	

}
