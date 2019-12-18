package com.bridgelabz.cliniquemanagement.model;
/************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:POJO Class Of Doctor
 * Date		:11/12/2019
 * 
 *************************************************************************************/
public class Doctor {

	private String doctorName;
	
	private int doctorId;
	
    private String doctorSpecialization;
    
	private Availability doctorAvailability;
	
	private int numberOfPatients;
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getDoctorSpecialization() {
		return doctorSpecialization;
	}
	public void setDoctorSpecialization(String doctorSpecialization) {
		this.doctorSpecialization = doctorSpecialization;
	}
	public Availability getDoctorAvailability() {
		return doctorAvailability;
	}
	
	public void setDoctorAvailability(Availability doctorAvailability) {
		this.doctorAvailability = doctorAvailability;
	}
	public int getNumberOfPatients() {
		return numberOfPatients;
	}
	public void setNumberOfPatients(int numberOfPatients) {
		this.numberOfPatients = numberOfPatients;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorSpecialization="
				+ doctorSpecialization + ", doctorAvailability=" + doctorAvailability + ", numberOfPatients="
				+ numberOfPatients + "]";
	}

	
	}
	
	


