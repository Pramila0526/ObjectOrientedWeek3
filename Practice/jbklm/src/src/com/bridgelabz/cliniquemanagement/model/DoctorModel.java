package com.bridgelabz.cliniquemanagement.model;

import java.util.List;

public class DoctorModel {
	private List<Doctor> doctor;

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
