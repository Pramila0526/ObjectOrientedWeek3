package com.bridgelabz.cliniquemanagement.model;
/************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:POJO Class Of Availability
 * Date		:11/12/2019
 * 
 *************************************************************************************/
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
