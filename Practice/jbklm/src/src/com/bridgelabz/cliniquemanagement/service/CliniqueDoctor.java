package com.bridgelabz.cliniquemanagement.service;

import java.util.ArrayList;
import java.util.List;



import java.io.IOException;
import java.util.*;

import com.bridgelabz.cliniquemanagement.model.Appointment;
import com.bridgelabz.cliniquemanagement.model.AppointmentModel;
import com.bridgelabz.cliniquemanagement.model.Availability;
import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.DoctorModel;
import com.bridgelabz.cliniquemanagement.model.Patient;
import com.bridgelabz.cliniquemanagement.model.PatientModel;
import com.bridgelabz.cliniquemanagement.repository.JsonUtil;
import com.bridgelabz.cliniquemanagement.util.CliniqueUtility;

public class CliniqueDoctor implements CliniqueManagementForDoctor
{
	Scanner sc=new Scanner(System.in);
	private static List<Doctor> doctors = new ArrayList<>();
	private static List<Patient> patients = new ArrayList<>();
	private static List<Appointment> appointments = new ArrayList<>();
	private static int doctorId = 0;
	private static int patientId = 1000;
	private static int appointmentId = 10000;
	
	String doctorPath="/home/admin94/Desktop/ObjectOrientedPrograms/CliniqueManagement/DoctorData.json";
	String patientPath="/home/admin94/Desktop/ObjectOrientedPrograms/CliniqueManagement/PatientData.json";
	String appointmentPath="/home/admin94/Desktop/ObjectOrientedPrograms/CliniqueManagement/Appointment.json";
	private DoctorModel modelOfDoctor = new DoctorModel();
	private PatientModel modelOfPatient = new PatientModel();
	private AppointmentModel modelOfAppointment = new AppointmentModel();
	public void readJson() {
		// TODO Auto-generated method stub
		
	}
	
	public Doctor getDoctor() {
		
		System.out.println("===Adding the new Doctor===");
		
		Doctor doctor = new Doctor();
		doctorId++;
		
		doctor.setDoctorId(doctorId);
		
		System.out.println("Enter Name of The New Doctor: ");
		doctor.setDoctorName("Dr. " + CliniqueUtility.stringInput());
		
		System.out.println("Enter doctor specialization: ");
		doctor.setDoctorSpecialization(CliniqueUtility.stringInput());
		
		System.out.println("Enter Availability");
		
		Availability availability = new Availability();
		System.out.println("Time format is of 24 hr");
		System.out.println("Date format is dd/MM/yyyy");
		System.out.println();
		System.out.println("Enter doctors Attending Time:- ");
		availability.setInTime(CliniqueUtility.integerInput());
		
		System.out.println("Enter doctors Leaving Time:- ");
		availability.setOutTime(CliniqueUtility.integerInput());
		
		System.out.println("Enter doctors Available date");
		availability.setDate(CliniqueUtility.stringInput());
		
		doctor.setDoctorAvailability(availability);
		
		doctor.setNumberOfPatients(0);
		return doctor;
	}
	
	public void addDoctor(Doctor doctor) {

		doctors.add(doctor);
		boolean close = false;;
		
		while (!close) {
   
			System.out.println("Select Options");
			System.out.println("1) Add Doctor");
			System.out.println("2) close");
			
			if (sc.nextInt() == 1) {
				close = false;
				doctors.add(getDoctor());
			} else {
				close = true;
				//System.out.println("Please remember to save to persist records");
				
			}

		}

	}
	                                  //Seraching Docotr by id
	
	public void searchDoctorById() {
		if (doctors.size() > 0) {
			
			System.out.println("Enter Id to Search the Doctor:- ");

			int id = sc.nextInt();
			doctors.forEach(i ->{
				if (id == i.getDoctorId()) {
					System.out.println(i);
				}

			});
		}

	}

									//Searching Docotr by name
	public void searchDoctorByName() {
		if (doctors.size() > 0) {
			System.out.println("Enter the name to Search the Doctor:- ");

			String str = sc.nextLine();
			doctors.forEach(i -> {
				if (str.equals(i.getDoctorName()))
					System.out.println(i);

			});
		}

	}

	 
									//method for getting doctor name from the user
	
	public String getDoctorName() {
		System.out.println("Enter doctor specialization to search: ");
		var str = sc.next();
		return str;
	}

	                               // method for searching doctor by specialization
	                               //returns true if doctor with speciality is found else return false
	 
	public boolean searchDoctorBySpecialization(String str) {
		if (doctors.size() > 0) {
			int j = 1;
			for (int i = 0; i < doctors.size(); i++) {
				if (str.equals(doctors.get(i).getDoctorSpecialization())) {
					System.out.println(str + " Dr->");
					showDoctorList(i, j++);
					return true;
				}
			}

		}
		return false;

	}
	
	
	public boolean searchDoctorByAvailability(String str, int time) {
		if (doctors.size() > 0) {

			boolean isDoctorAvailable = false;
			for (int i = 0; i < doctors.size(); i++) {
				if (str.equals(doctors.get(i).getDoctorAvailability().getDate())
						&& (time >= doctors.get(i).getDoctorAvailability().getInTime()
								&& time <= doctors.get(i).getDoctorAvailability().getOutTime())) {
					System.out.println(str + " Dr->");
					showDoctorList(i, ++i);
					isDoctorAvailable = true;

				}
			}
			if (isDoctorAvailable)
				return true;
		}
		return false;

	}
	public boolean searchPatientById(int id) {
		if (patients.size() > 0) {

			for (int i = 0; i < patients.size(); i++) {
				if (id == patients.get(i).getPatientId()) {
					showPatientList(i, true);
					return true;
				}

			}
		}
		return false;

	}
	public void searchPatientByName() {
		if (patients.size() > 0) {
			System.out.println("Enter patient name to search: ");
			String str = sc.next();
			patients.forEach(i -> {
				if (str.equals(i.getPatientName()))
					System.out.println(i);
			});
		}

	}
	public void searchPatientByMobile() {
		if (patients.size() > 0) {
			System.out.println("Enter patient mobile to search: ");
			String mob = sc.next();
			patients.forEach(i -> {
				if (mob.equals(i.getPatientMobile()))
					System.out.println(i);
			});
		}

	}
	

	

	@Override
	public void checkingForAppointmnet() {
		System.out.println("Enter Specialization of Doctor: ");
		String str = sc.nextLine();
		
		boolean isDoctor = searchDoctorBySpecialization(str);
		
		if (!isDoctor) {
			
			System.out.println("No doctor found");
		} else {
			System.out.println("Enter doctor number");
			int index = sc.nextInt() - 1;
			System.out.println(doctors.get(index).getDoctorName());
			
			System.out.println("Doctors available on: " + doctors.get(index).getDoctorAvailability().getDate());
			System.out.println("Select y or n");
			
			String option = sc.next();
			if (option.equals("n"))
				
				System.out.println(" ");
			else if (option.equals("yes")) {
				System.out.println("Enter time to take the appoinment");
				
				int time = sc.nextInt();
				
				boolean timeIsAvailable = searchDoctorByAvailability(doctors.get(index).getDoctorAvailability().getDate(),
						time);
				if (!timeIsAvailable)
					System.out.println("Entered Time slots are not available/are not Free");
				else {
					System.out.println("Entered Time slot is available");
					
					if (doctors.get(index).getNumberOfPatients() > 5)
						System.out.println("Doctor exceed the limit of patient");
					else {
						System.out.println("Enter patient id:-");
						int patientId = sc.nextInt();
						if (!searchPatientById(patientId))
							System.out.println("No patient found with this id");
						else {
							System.out.println("Press b to book the appointmnet");
							if (sc.next().equals("b")) {
								Appointment appointment = getAppointment(index, patientId);
								savingAppointment(appointment);
							}
						}
					}
				}
			}
		}
		
		
	}
	public void addAppointment() {
		if (doctors.size() < 1) {
			System.out.println("Please add doctor first!");
		} else {
			if (patients.size() < 1) {
				System.out.println("Please add patient first!");
			} else {
				checkingForAppointmnet();
			}
		}
	}
	
	                             //Mothod to get an  Appointment
	public Appointment getAppointment(int index, int patientId) {
		Appointment appointment = new Appointment();
		appointmentId++;
		
		appointment.setAppointmentId(appointmentId);
		appointment.setDoctorId(doctors.get(index).getDoctorId());
		appointment.setDoctorName(doctors.get(index).getDoctorName());
		appointment.setDoctorAvailability(doctors.get(index).getDoctorAvailability().getDate());
		appointment.setPatientId(patientId);
		int i = getPatientIndexById(patientId);
		
		appointment.setAppointmentAssignedPatientName(patients.get(i).getPatientName());
		appointment.setAppointmentAssignedPatientMobileNumber(patients.get(i).getPatientMobile());
		int numberOfPatioents = doctors.get(index).getNumberOfPatients();
		
		numberOfPatioents = numberOfPatioents + 1;
		doctors.get(index).setNumberOfPatients(numberOfPatioents);
		modelOfDoctor.setDoctor(doctors);

		return appointment;
	}
	
	public void savingAppointment(Appointment appointment) {
		appointments.add(appointment);
		modelOfAppointment.setAppointments(appointments);
		try {
			JsonUtil.writeMapper(doctorPath, modelOfDoctor);
			JsonUtil.writeMapper(appointmentPath, modelOfAppointment);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("Got Appointment");

	}

	
	public void save() {
		if (doctors.size() > 0) {
			modelOfDoctor.setDoctor(doctors);
			try {
				JsonUtil.writeMapper(doctorPath, modelOfDoctor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// saving patient
		if (patients.size() > 0) {
			modelOfPatient.setPatient(patients);
			try {
				JsonUtil.writeMapper(patientPath, modelOfPatient);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// saving appointment
		if (appointments.size() > 0) {
			modelOfAppointment.setAppointments(appointments);
			
				try {
					JsonUtil.writeMapper(appointmentPath, modelOfAppointment);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}

	@Override
	public void showAllRecords() {
		{
			if (doctors.size() > 0) {
				System.out.println("NoOfPatient\tDoctor record");
				for (int i = 0; i < doctors.size(); i++) {
					System.out.print(doctors.get(i).getNumberOfPatients() + "\t\t");
					System.out.print(doctors.get(i).getDoctorId() + "\t");
					showDoctorList(i, false);
				}
			}
			if (patients.size() > 0) {
				System.out.println("Patient records");
				for (int i = 0; i < patients.size(); i++) {
					showPatientList(i, false);
				}
			}

			if (appointments.size() > 0) {
				System.out.println("Appointment records");

				appointments.forEach(i -> {
					System.out.println(i.getAppointmentId() + " " + i.getDoctorId() + " " + i.getDoctorName() + " " + i.getDoctorAvailability()
							+ " " + i.getPatientId() + " " + i.getAppointmentAssignedPatientName()+ " " + i.getAppointmentAssignedPatientMobileNumber());
				});
			}
		}
	}

	@Override
	public void showPopularDoctor() {
		{
			sortDoctorList();
			if (doctors.get(0).getNumberOfPatients() > 0) 
			{
				System.out.println("Hospital specialization: " + doctors.get(0).getDoctorSpecialization());
				System.out.println("Dr name is: ");
				showDoctorList(0, false);

			} else
			{
				System.out.println("No appointments assign to doctor try again later");
		}
		}
		}
	

	public void sortDoctorList() {
		for (int i = 0; i < doctors.size() - 1; i++) {
			for (int j = 0; j < doctors.size() - i - 1; j++) {
				if (doctors.get(j).getNumberOfPatients() < doctors.get(j + 1).getNumberOfPatients()) {
					Object temp = doctors.get(j);
					doctors.set(j, doctors.get(j + 1));
					doctors.set(j + 1, (Doctor) temp);
				}
			}
		}
	}

	public void showDoctorList(int index, int num) {

		System.out.print(doctors.get(index).getDoctorId() + ". " + doctors.get(index).getDoctorName() + "\t");
		System.out.print(doctors.get(index).getDoctorSpecialization() + "\t");
		System.out.print(doctors.get(index).getDoctorAvailability().getDate() + "\t");
		System.out.print(doctors.get(index).getDoctorAvailability().getInTime() + "\t");
		System.out.println(doctors.get(index).getDoctorAvailability().getOutTime() + "\t");

	}


	
	public Patient getPatient() {
		System.out.println("->adding patient<-");
		Patient patient = new Patient();
		patientId++;
		patient.setPatientId(patientId);
		System.out.println("Enter patient name: ");
		patient.setPatientName(sc.next());
		System.out.println("Enter patient age: ");
		patient.setPatientAge(sc.nextInt());
		System.out.println("Enter patient mobile: ");
		patient.setPatientMobile(sc.next());

		return patient;
	}

	public void addPatient(Patient patient) {
		boolean close = false;
		patients.add(patient);
		while (!close) {

			System.out.println("Patient added...");
			System.out.println("Enter 1. to add another patient 2. close");
			if (sc.nextInt() == 1) {
				close = false;
				patients.add(getPatient());
			} else {
				close = true;
				System.out.println("Please remember to save to persist records");
				System.out.println("closing...");
			}

		}
	}

	

	

	public void showPatientList(int index, boolean hasSigleRecord) {
		if (hasSigleRecord) {
			System.out.print("Patient Details\t\n");
			System.out.print(patients.get(index).getPatientId() + "\t");
			System.out.print(patients.get(index).getPatientName() + "\t");
			System.out.print(patients.get(index).getPatientAge() + "\t");
			System.out.println(patients.get(index).getPatientMobile() + "\t");
		} else {
			System.out.print(patients.get(index).getPatientId() + "\t");
			System.out.print(patients.get(index).getPatientName() + "\t");
			System.out.print(patients.get(index).getPatientAge() + "\t");
			System.out.println(patients.get(index).getPatientMobile() + "\t");
		}
	}

	

	public int getPatientIndexById(int patientId) {
		for (int i = 0; i < patients.size(); i++) {
			if (patientId == patients.get(i).getPatientId()) {
				return i;
			}
		}
		return -1;
	}
	public void showDoctorList(int index, boolean hasSigleRecord) {
		if (hasSigleRecord) {
			System.out.println("Dr details");
			System.out.print(doctors.get(index).getDoctorName() + "\t");
			System.out.print(doctors.get(index).getDoctorSpecialization() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getDate() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getInTime() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getOutTime() + "\t");
		} else {
			System.out.print(doctors.get(index).getDoctorName() + "\t");
			System.out.print(doctors.get(index).getDoctorSpecialization() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getDate() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getInTime() + "\t");
			System.out.println(doctors.get(index).getDoctorAvailability().getOutTime() + "\t");
		}

	}
}
