package com.bridgelabz.cliniquemanagement.service;

import java.util.ArrayList;

import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.Patient;

public class ListsOfDoctorsPatients 
{
	
		public static void showDoctors(ArrayList<Doctor> doctors, int index, int number) {

			System.out.print(doctors.get(index).getDoctorId());
			System.out.println(doctors.get(index).getDoctorName());
			System.out.print(doctors.get(index).getDoctorSpecialization() );
			System.out.print(doctors.get(index).getDoctorAvailability().getDate());
			System.out.print(doctors.get(index).getDoctorAvailability().getInTime() );
			System.out.println(doctors.get(index).getDoctorAvailability().getOutTime());

		}

		
		public static void showPatients(ArrayList<Patient> patients, int index, boolean hasSigleRecord) {
			if (hasSigleRecord) {
				System.out.print("Patient Details\t\n");
				System.out.print(patients.get(index).getPatientId());
				System.out.print(patients.get(index).getPatientName());
				System.out.print(patients.get(index).getPatientAge());
				System.out.println(patients.get(index).getPatientMobile());
			} else {
				System.out.print(patients.get(index).getPatientId() );
				System.out.print(patients.get(index).getPatientName() );
				System.out.print(patients.get(index).getPatientAge() );
				System.out.println(patients.get(index).getPatientMobile());
			}
		}

	}


