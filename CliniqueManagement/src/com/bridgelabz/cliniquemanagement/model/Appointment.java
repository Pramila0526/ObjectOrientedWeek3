package com.bridgelabz.cliniquemanagement.model;
/************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:POJO Class Of Appointment
 * Date		:11/12/2019
 * 
 *************************************************************************************/
public class Appointment {
	private int patientId;
	
	private String appointmentAssignedPatientName;
	
	private String appointmentAssignedPatientMobileNumber;
	
	private int appointmentId;
	
	private int doctorId;
	
	private String doctorName;
	
	private String doctorAvailability;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getAppointmentAssignedPatientName() {
		return appointmentAssignedPatientName;
	}
	public void setAppointmentAssignedPatientName(String appointmentAssignedPatientName) {
		this.appointmentAssignedPatientName = appointmentAssignedPatientName;
	}
	public String getAppointmentAssignedPatientMobileNumber() {
		return appointmentAssignedPatientMobileNumber;
	}
	public void setAppointmentAssignedPatientMobileNumber(String appointmentAssignedPatientMobileNumber) {
		this.appointmentAssignedPatientMobileNumber = appointmentAssignedPatientMobileNumber;
	}
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
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
	public String getDoctorAvailability() {
		return doctorAvailability;
	}
	public void setDoctorAvailability(String doctorAvailability) {
		this.doctorAvailability = doctorAvailability;
	}
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", doctorId=" + doctorId + ", doctorName=" + doctorName
				+ ", doctorAvailability=" + doctorAvailability + ", patientId=" + patientId
				+ ", appointmentAssignedPatientName=" + appointmentAssignedPatientName
				+ ", appointmentAssignedPatientMobileNumber=" + appointmentAssignedPatientMobileNumber + "]";
	}

	
}
