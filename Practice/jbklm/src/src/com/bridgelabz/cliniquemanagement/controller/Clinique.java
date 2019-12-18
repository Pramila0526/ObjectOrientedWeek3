package com.bridgelabz.cliniquemanagement.controller;



import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.Patient;
import com.bridgelabz.cliniquemanagement.service.CliniqueDoctor;


public class Clinique {

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {

		
		CliniqueDoctor service = new CliniqueDoctor();

		// reading json

		service.readJson();

		// creating menu list

		boolean exit = false;

		Scanner sc = new Scanner(System.in);

		while (!exit) {
			
			System.out.println("=========Clinique Management Records========");
			System.out.println();
			System.out.println("1) Add a new Doctor");
			System.out.println("2) Search Doctor By Id");
			System.out.println("3) Search Doctor By Name");
			System.out.println("4) Search Doctor By Specialization");
			System.out.println("5) Search Doctor By Availability");
			
			System.out.println("6) Add a Patient");
			System.out.println("7) Search Patient By Id");
			System.out.println("8) Search Patient By Name");
			System.out.println("9) Search Patient By Number");
			System.out.println("10) Add Appointment");
			System.out.println("11) Display Details ");
			System.out.println("12) Save Details");
			System.out.println("13) Print Popular Doctors");
			System.out.println();
			
			
			System.out.println("Enter Your Choice");
			
			int ch=sc.nextInt();
			
			switch (ch) {
			case 1:
				                     //switch case to add a doctor
				
				System.out.println("Add doctor");
				System.out.println();

				Doctor doctor = service.getDoctor();
				service.addDoctor(doctor);
				System.out.println();
				break;
				
			
			case 2:
				// search doctor by id
				System.out.println();
				System.out.println("=====Search the doctor by id=====");
				
				service.searchDoctorById();

				System.out.println("=====Search doctor by id=====");
				System.out.println();
				break;
			case 3:
				// search doctor by name
				System.out.println();
				System.out.println("=====Search doctor by name=====");
				
				service.searchDoctorByName();
				System.out.println();
				break;
			case 4:
				// search doctor by specialization
				System.out.println();
				System.out.println("=====Search doctor by specialization=====");

				String drname = service.getDoctorName();
				service.searchDoctorBySpecialization(drname);
				System.out.println();
				
				break;
			case 5:
				// search doctor by availability
				System.out.println();
				System.out.println("=====Search doctor by availability=====");
				System.out.println();

				System.out.println("Enter doctor date: ");
				var str = sc.next();
				System.out.println("Enter time from");
				int time = sc.nextInt();

				service.searchDoctorByAvailability(str, time);

				System.out.println();
				System.out.println("=====Search doctor by availability=====");
				System.out.println();
				break;
			case 6:
				// add patient
				System.out.println();
				System.out.println("=====Add patient=====");
				System.out.println();

				Patient patient = service.getPatient();

				service.addPatient(patient);
				System.out.println();
				break;
			case 7:
				// search patient by id
				System.out.println();
				System.out.println("-------------------------search patient by id-----------------------");
				System.out.println();

				System.out.println("Instruction->Patient id starts from 1000 range");
				System.out.println("Enter patient id to search: ");
				var num = sc.nextInt();

				service.searchPatientById(num);

				System.out.println();
				System.out.println("=====Search patient by id=====");
				System.out.println();
				break;
			case 8:
				// search patient by name
				System.out.println();
				System.out.println("=====Search patient by name=====");
				System.out.println();

				service.searchPatientByName();

				System.out.println();
				System.out.println("=====Search patient by name=====");
				System.out.println();
				break;
			case 9:
				// search patient by mobile
				System.out.println("=====Search patient by mobile=====");
				System.out.println();

				service.searchPatientByMobile();
				System.out.println();
				break;
			case 10:
				// add appointment
				System.out.println();
				System.out.println("=====Add appointment=====");
				System.out.println();

				service.addAppointment();
				System.out.println();
				break;
			case 11:
				// show records
				service.showAllRecords();
				break;
			case 12:
				// save all objects into json
				System.out.println("=====Save Details=====");
				System.out.println();
				// saving doctor

				service.save();
				System.out.println();
				break;

			case 13:
				service.showPopularDoctor();
				break;
				
			case 14:
				System.exit(0);
				break;
			default:
				System.out.println("Please Select valid option");
			}
		}

		

	}

}
