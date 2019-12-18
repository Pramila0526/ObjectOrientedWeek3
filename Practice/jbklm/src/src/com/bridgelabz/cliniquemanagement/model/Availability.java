package com.bridgelabz.cliniquemanagement.model;


public class Availability 
{

	private int inTime;
	private int outTime;
	private String date;

	public int getInTime() {
		return inTime;
	}

	public void setInTime(int inTime) {
		this.inTime = inTime;
	}

	public int getOutTime() {
		return outTime;
	}

	public void setOutTime(int outTime) {
		this.outTime = outTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Availability [inTime=" + inTime + ", outTime=" + outTime + ", date=" + date + "]";
	}

}
