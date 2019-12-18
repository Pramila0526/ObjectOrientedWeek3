package com.bridgelabz.cliniquemanagement.model;

import java.util.List;

public class PatientModel {
	private List<Patient> patient;

	public List<Patient> getPatient() {
		return patient;
	}

	public void setPatient(List<Patient> patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "PatientModel [patient=" + patient + "]";
	}
	
	

}
