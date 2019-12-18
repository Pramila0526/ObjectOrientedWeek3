package com.bridgelabz.cliniquemanagement.controller;

import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.Patient;
import com.bridgelabz.cliniquemanagement.service.CliniqueDoctor;
import com.bridgelabz.cliniquemanagement.util.CliniqueUtility;

/***************************************************************************************
 * @author :Pramila0526 Purpose :Clinique Amnagement Program Date :13/12/2019
 *
 ****************************************************************************************/
public class Clinique 
{
	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, IOException, InterruptedException {
		// Object of the Main Operations Class
		CliniqueDoctor cliniqueService = new CliniqueDoctor();
		// reading json
		cliniqueService.readJson();
		// creating Options list
		boolean exit = false;

		while (!exit) 
		{
			System.out.println("\nSelect Your choice from the Given Options\n");
			System.out.println("===Doctor's Data Opeartion===");
			System.out.println("1) Add New Doctor");
			System.out.println("2) Search Docotor By Id");
			System.out.println("3) Search Doctor By Name");
			System.out.println("4) Search Doctor By Specialization");
			System.out.println("5) Seach Doctor By Availability\n");
			System.out.println("===Patient's Data Opeartion===");
			System.out.println("6) Add a new Patient");
			System.out.println("7) Search Patient By Id");
			System.out.println("8) Search Patient By Name");
			System.out.println("9) Search Patient By Number");
			System.out.println("10) Add Appointment\n");
			System.out.println("===Details Storing===");
			System.out.println("11) Save");
			System.out.println("12) Show the Updated Details");
			System.out.println("13) See Popular Doctor");
			System.out.println("14) Exit");

		switch (CliniqueUtility.integerInput()) 
			{
			case 1:
				// Add doctor
				System.out.println("\n=========Add doctor========\n");
				Doctor doctor = cliniqueService.getDoctor();
				cliniqueService.addDoctor(doctor);
				break;
			case 2:
				// Search Doctor by Id
				System.out.println("\n==========Search doctor by Id===========\n");
				cliniqueService.searchDoctorById();
				break;
			case 3:
				// Search doctor by Name
				System.out.println("\n==========Search doctor by Name==========\n");
				cliniqueService.searchDoctorByName();
				break;
			case 4:
				// Search doctor by specialization
				System.out.println("\n==========Search doctor by Specialization==========\n");
				String drname = cliniqueService.getDoctorName();
				cliniqueService.searchDoctorBySpecialization(drname);
				break;
			case 5:
				// Search doctor by availability
				System.out.println("\n==========Search doctor by Availability==========\n");

				System.out.println("Enter the Available Date of Doctor: ");
				String adate = CliniqueUtility.stringInput();
				System.out.println("Enter time from");
				int time = CliniqueUtility.integerInput();
				cliniqueService.searchDoctorByAvailability(adate, time);
				break;
			case 6:
				// Add patient
				System.out.println("\n==========Add a New Patient==========\n");
				Patient patient = cliniqueService.getPatient();
				cliniqueService.addPatient(patient);
				break;
			case 7:
				// Search patient by id
				System.out.println("\n==========Search Ptient by Id==========\n");
				System.out.println("Enter patient id to search: ");
				int id = CliniqueUtility.integerInput();
				cliniqueService.searchPatientById(id);

				break;
			case 8:
				// search patient by name
				System.out.println("\n==========Search Ptient by Name==========\n");
				cliniqueService.searchPatientByName();
				break;
			case 9:
				// Search patient by mobile
				System.out.println("\n==========Search Ptient by Mobile Number==========\n");
				cliniqueService.searchPatientByMobile();
				break;
			case 10:
				// Add appointment
				System.out.println("\n==========Add Appintment==========\n");
				cliniqueService.addAppointment();
				break;
			case 11:
				// save all objects into json
				System.out.println("\n==========Save==========\n");
				// saving doctor
				cliniqueService.save();
				break;
			case 12:
				// show records
				cliniqueService.showAllRecords();
				break;
			case 13:
				// 
				cliniqueService.showPopularDoctor();
				break;
			case 14:
				// search patient by id
				exit = true;
				break;
			default:
				System.out.println("***Please select valid option***");
			}
		}
	}
}
