package com.bridgelabz.cliniquemanagement.service;

import com.bridgelabz.cliniquemanagement.model.Appointment;
import com.bridgelabz.cliniquemanagement.model.Patient;

public interface CliniqueManagementForPatient {
	
	Patient getPatient();

	public void addPatient(Patient patient);

	public boolean searchPatientById(int num);

	public void searchPatientByName();

	public void searchPatientByMobile();

	public void addAppointment();

	void showPatientList(int index, boolean hasSingleRecord);
	Appointment getAppointment(int index, int patientId);

	int getPatientIndexById(int patientId);

}
