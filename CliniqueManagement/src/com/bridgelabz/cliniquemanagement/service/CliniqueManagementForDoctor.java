package com.bridgelabz.cliniquemanagement.service;
import com.bridgelabz.cliniquemanagement.model.Appointment;
import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.Patient;
/************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Interface of Clinique
 * Date		:13/12/2019
 * 
 *************************************************************************************/
public interface CliniqueManagementForDoctor {

	public void readJson();

	Doctor getDoctor();

	void addDoctor(Doctor doctor);

	Patient getPatient();

	public void addPatient(Patient patient);

	public void searchDoctorById();

	public void searchDoctorByName();

	public String getDoctorName();

	public boolean searchDoctorBySpecialization(String str);

	public boolean searchDoctorByAvailability(String str, int time);

	public boolean searchPatientById(int num);

	public void searchPatientByName();

	public void searchPatientByMobile();

	public void addAppointment();

	void checkingForAppointmnet();

	public void save();

	public void showAllRecords();

	public void showPopularDoctor();

	void showDoctorList(int index, boolean hasSigleRecord);

	void showPatientList(int index, boolean hasSingleRecord);

	public void showDoctorList(int index, int num);

	Appointment getAppointment(int index, int patientId);

	int getPatientIndexById(int patientId);

	void savingAppointment(Appointment appointment);

	void sortDoctorList();

}

