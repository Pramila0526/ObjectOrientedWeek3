package com.bridgelabz.cliniquemanagement.model;
/************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Doctor Model
 * Date		:11/12/2019
 * 
 *************************************************************************************/
import java.util.List;
public class DoctorModel {
	public List<Doctor> doctor;

	public List<Doctor> getDoctor() {
		return doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "DoctorModel [doctor=" + doctor + "]";
	}
	

}
