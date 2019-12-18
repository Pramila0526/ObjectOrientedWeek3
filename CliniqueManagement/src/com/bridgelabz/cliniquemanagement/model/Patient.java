package com.bridgelabz.cliniquemanagement.model;
/************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:POJO Class Of Patient
 * Date		:11/12/2019
 * 
 *************************************************************************************/
public class Patient {
	private String patientName;
	
	private int patientId;
	
	private int patientAge;
	
	private String patientMobile;

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientMobile=" + patientMobile + "]";
	}

}
