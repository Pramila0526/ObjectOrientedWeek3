package com.bridgelabz.cliniquemanagement.service;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.io.IOException;
import com.bridgelabz.cliniquemanagement.model.Appointment;
import com.bridgelabz.cliniquemanagement.model.AppointmentModel;
import com.bridgelabz.cliniquemanagement.model.Availability;
import com.bridgelabz.cliniquemanagement.model.Doctor;
import com.bridgelabz.cliniquemanagement.model.DoctorModel;
import com.bridgelabz.cliniquemanagement.model.Patient;
import com.bridgelabz.cliniquemanagement.model.PatientModel;
import com.bridgelabz.cliniquemanagement.repository.JsonUtil;
import com.bridgelabz.cliniquemanagement.util.CliniqueUtility;

/************************************************************************************
 * @author :Pramila0526 Purpose :All Methods Of clinique Date :13/12/2019
 * 
 *************************************************************************************/
public class CliniqueDoctor implements CliniqueManagementForDoctor 
{
	
	private static List<Doctor> doctors = new ArrayList<>();
	private static List<Patient> patients = new ArrayList<>();
	private static List<Appointment> appointments = new ArrayList<>();
	private static int doctorId = 0;
	private static int patientId = 1000;
	private static int appointmentId = 10000;

	String doctorPath = "/home/admin94/Desktop/ObjectOrientedPrograms/CliniqueManagement/DoctorData.json";
	String patientPath = "/home/admin94/Desktop/ObjectOrientedPrograms/CliniqueManagement/PatientData.json";
	String appointmentPath = "/home/admin94/Desktop/ObjectOrientedPrograms/CliniqueManagement/Appointment.json";

	private DoctorModel modelOfDoctor = new DoctorModel();
	private PatientModel modelOfPatient = new PatientModel();
	private AppointmentModel modelOfAppointment = new AppointmentModel();

	public void readJson() {
		ObjectMapper mapper = new ObjectMapper();
		// checking whether path file is exits or not if exist then add data into lists
		File fileDoctor = new File(doctorPath);
		File filePatient = new File(patientPath);
		File fileAppointment = new File(appointmentPath);
		// checking whether doctor file is empty or not
		if (fileDoctor.exists() && fileDoctor.length() > 0) {
			try {

				// modelOfDoctor = (DoctorModel) JsonUtil.readMapper(doctorPath, modelOfDoctor);
				modelOfDoctor = mapper.readValue(new File(doctorPath), DoctorModel.class);
				// doctors=(List<Doctor>) mapper.readValue(new
				// File(doctorPath),DoctorModel.class);
			} catch (IOException e) {
				e.printStackTrace();
			}

			doctors.addAll(modelOfDoctor.getDoctor());
			doctorId = doctors.get(doctors.size() - 1).getDoctorId();
		}

		// checking whether patient file is empty or not
		if (filePatient.exists() && filePatient.length() > 0) {
			try {
				modelOfPatient = mapper.readValue(new File(patientPath), PatientModel.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			patients.addAll(modelOfPatient.getPatient());
			patientId = patients.get(patients.size() - 1).getPatientId();
		}

		// checking whether appointment file is empty or not
		if (fileAppointment.exists() && fileAppointment.length() > 0) {
			try {
				modelOfAppointment = mapper.readValue(new File(appointmentPath), AppointmentModel.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			appointments.addAll(modelOfAppointment.getAppointments());
			appointmentId = appointments.get(appointments.size() - 1).getAppointmentId();
		}
	}

	// Method to get the Doctor
	public Doctor getDoctor() 
	{
		System.out.println("===Adding the new Doctor===");

		Doctor doctor = new Doctor();
		doctorId++;
		doctor.setDoctorId(doctorId);
		System.out.println("Enter Name of The New Doctor: ");
		doctor.setDoctorName("Doctor. " + CliniqueUtility.stringInput());

		System.out.println("Enter doctor specialization: ");
		doctor.setDoctorSpecialization(CliniqueUtility.stringInput());

		System.out.println("Enter Availability");
		Availability availability = new Availability();
		
		System.out.println("Time format is of 24 hr");
		System.out.println("Date format is dd/MM/yyyy\n");
	
		System.out.println("Enter doctors Attending Time-");
		availability.setInTime(CliniqueUtility.integerInput());

		System.out.println("Enter doctors Leaving Time- ");
		availability.setOutTime(CliniqueUtility.integerInput());

		System.out.println("Enter doctors Available date");
		availability.setDate(CliniqueUtility.stringInput());

		doctor.setDoctorAvailability(availability);
		doctor.setNumberOfPatients(0);
		return doctor;
	}

	// Method to Add the doctor
	public void addDoctor(Doctor doctor) 
	{
		doctors.add(doctor);
		boolean close = false;
		while (!close) 
		{
			System.out.println("Select Options");
			System.out.println("1) Add Doctor");
			System.out.println("2) close");

			if (CliniqueUtility.integerInput()== 1) 
			{
				close = false;
				doctors.add(getDoctor());
			} 
			else 
			{
				close = true;
			}
		}
	}
	
	// Method To get Patient
	public Patient getPatient() 
	{
		System.out.println("=====Adding Patients=====\n");
		Patient patient = new Patient();
		patientId++;
		patient.setPatientId(patientId);
		
		System.out.println("Enter patient name: ");
		patient.setPatientName(CliniqueUtility.stringInput());
		
		System.out.println("Enter patient age: ");
		patient.setPatientAge(CliniqueUtility.integerInput());
		
		System.out.println("Enter patient mobile: ");
		patient.setPatientMobile(CliniqueUtility.stringInput());

		return patient;
	}

	// Method to Add Patient
	public void addPatient(Patient patient)
	{
		boolean close = false;
		patients.add(patient);
		while (!close) 
		{
			System.out.println("1. Add another patient");
			System.out.println("2. Close");
			if (CliniqueUtility.integerInput() == 1) 
			{
				close = false;
				patients.add(getPatient());
			}
			else 
			{
				close = true;
			}
		}
	}

	//Method to search doctor By Id
	public void searchDoctorById() 
	{
		if (doctors.size() > 0) 
		{
			System.out.println("Enter doctor's id to search: ");
			int num = CliniqueUtility.integerInput();
			doctors.forEach(i -> 
			{
				if (num == i.getDoctorId()) 
				{
					System.out.println(i);
				}
			});
		}
	}

	 
	// Method for searching doctor by name
	public void searchDoctorByName() 
	{
		if (doctors.size() > 0) 
		{
			System.out.println("Enter doctor name to search: ");
			String str = CliniqueUtility.stringInput();
			doctors.forEach(i -> 
			{
				if (str.equals(i.getDoctorName()))
					System.out.println(i);
			});
		}
	}

	// Method for getting doctor name
	public String getDoctorName() 
	{
		System.out.println("Enter doctor specialization to search: ");
		String str = CliniqueUtility.stringInput();
		return str;
	}

	// Method for searching doctor by specialization
	public boolean searchDoctorBySpecialization(String str)
	{
		if (doctors.size() > 0) 
		{
			int j = 1;
			for (int i = 0; i < doctors.size(); i++) 
			{
				if (str.equals(doctors.get(i).getDoctorSpecialization())) 
				{
					System.out.println(str + " Doctor=");
					showDoctorList(i, j++);
					return true;
				}
			}
		}
		return false;
	}

	// Method for searching doctor by Availability
	public boolean searchDoctorByAvailability(String avaTime, int time) 
	{
		if (doctors.size() > 0) 
		{
			boolean isDoctorAvailable = false;
			for (int i = 0; i < doctors.size(); i++) 
			{
				if (avaTime.equals(doctors.get(i).getDoctorAvailability().getDate())
						&& (time >= doctors.get(i).getDoctorAvailability().getInTime()
								&& time <= doctors.get(i).getDoctorAvailability().getOutTime()))
				{
					System.out.println(avaTime + " Dr->");
					showDoctorList(i, ++i);
					isDoctorAvailable = true;
				}
			}
			if (isDoctorAvailable)
				return true;
		}
		return false;
	}

	// Method for searching patient by id
	public boolean searchPatientById(int id) 
	{
		if (patients.size() > 0) 
		{
			for (int i = 0; i < patients.size(); i++) 
			{
				if (id == patients.get(i).getPatientId())
				{
					showPatientList(i, true);
					return true;
				}
			}
		}
		return false;
	}

	// Method for showing patient list
	public void showPatientList(int index, boolean hasSigleRecord) 
	{
		if (hasSigleRecord) 
		{
			System.out.print("Patient Details\t\n");
			System.out.print(patients.get(index).getPatientId() + "\t");
			System.out.print(patients.get(index).getPatientName() + "\t");
			System.out.print(patients.get(index).getPatientAge() + "\t");
			System.out.println(patients.get(index).getPatientMobile() + "\t");
		} else 
		{
			System.out.print(patients.get(index).getPatientId() + "\t");
			System.out.print(patients.get(index).getPatientName() + "\t");
			System.out.print(patients.get(index).getPatientAge() + "\t");
			System.out.println(patients.get(index).getPatientMobile() + "\t");
		}
	}

	// Method for searching patient by name
	public void searchPatientByName() 
	{
		if (patients.size() > 0) 
		{
			System.out.println("Enter the Patient Name");
			String str = CliniqueUtility.stringInput();
			patients.forEach(i -> 
			{
				if (str.equals(i.getPatientName()))
					System.out.println(i);
			});
		}
	}

	// Method for searching patient by mobile number
	public void searchPatientByMobile() 
	{
		if (patients.size() > 0) 
		{
			System.out.println("Enter Patient Mobile Number");
			String str = CliniqueUtility.stringInput();
			patients.forEach(i -> 
			{
				if (str.equals(i.getPatientMobile()))
					System.out.println(i);
			});
		}
	}

	// Method for adding appointment
	public void addAppointment() 
	{
		if (doctors.size() < 1) 
		{
			System.out.println("First Add the Doctor");
		} 
		else 
		{
			if (patients.size() < 1) {
				System.out.println("First Add the Patient");
			} 
			else 
			{
				checkingForAppointmnet();
			}
		}
	}

	// Method for Checking Availability of Doctor for booking appointment
	public void checkingForAppointmnet() 
	{
		System.out.println("Enter Specialization of Doctor to search ");
		String spec = CliniqueUtility.stringInput();
		boolean isDoctorFind = searchDoctorBySpecialization(spec);
		if (!isDoctorFind) 
		{
			System.out.println("Doesn't Exists with" +spec);
		}
		else 
		{
			System.out.println("Enter Doctor Number");
			int index = CliniqueUtility.integerInput() - 1;
			System.out.println(doctors.get(index).getDoctorName());
			System.out.println("Dr. available on: " + doctors.get(index).getDoctorAvailability().getDate());
			System.out.println("proceed (yes/no)");
			String yesOrNo = CliniqueUtility.stringInput().toLowerCase();
			if (yesOrNo.equals("no"))
				System.out.println("----");
			else if (yesOrNo.equals("yes"))
			{
				System.out.println("Enter the time");
				int time = CliniqueUtility.integerInput();
				boolean timeIsAvailable = searchDoctorByAvailability(
						doctors.get(index).getDoctorAvailability().getDate(), time);
				if (!timeIsAvailable)
					System.out.println("Time is not available");
				else
				{
					System.out.println("Time is available");
					if (doctors.get(index).getNumberOfPatients() > 5)
						System.out.println("Doctor's list exceeded the limit of patient");
					else 
					{
						System.out.println("Enter Patient Id");
						int patientId = CliniqueUtility.integerInput();
						if (!searchPatientById(patientId))
							System.out.println("Patient id doesnt exists with "+patientId);
						else 
						{
							System.out.println("To book the Appointment select (yes/no)");
							if (CliniqueUtility.stringInput().toLowerCase().equals("yes")) 
							{
								Appointment appointment = getAppointment(index, patientId);
								savingAppointment(appointment);
							}
						}
					}
				}
			}
		}
	}

	// Method to save an appointment
	public void savingAppointment(Appointment appointment) 
	{
		appointments.add(appointment);
		modelOfAppointment.setAppointments(appointments);
		try 
		{
			JsonUtil.writeMapper(doctorPath, modelOfDoctor);
			JsonUtil.writeMapper(appointmentPath, modelOfAppointment);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		System.out.println("Appointment Successfully booked");
	}

	// Method to get an Appointment
	public Appointment getAppointment(int index, int patientId) 
	{
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
		int nopt = doctors.get(index).getNumberOfPatients();
		nopt = nopt + 1;
		doctors.get(index).setNumberOfPatients(nopt);
		modelOfDoctor.setDoctor(doctors);

		return appointment;
	}

	// Method to get the Patient
	public int getPatientIndexById(int patientId) 
	{
		for (int i = 0; i < patients.size(); i++) 
		{
			if (patientId == patients.get(i).getPatientId()) 
			{
				return i;
			}
		}
		return -1;
	}

	// Method for saving into json file
	public void save() 
	{
		if (doctors.size() > 0) 
		{
			modelOfDoctor.setDoctor(doctors);
			try 
			{
				JsonUtil.writeMapper(doctorPath, modelOfDoctor);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		// code for saving patient
		if (patients.size() > 0) 
		{
			modelOfPatient.setPatient(patients);
			try 
			{
				JsonUtil.writeMapper(patientPath, modelOfPatient);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}

		// code for saving appointment
		if (appointments.size() > 0) 
		{
			modelOfAppointment.setAppointments(appointments);
			try 
			{
				JsonUtil.writeMapper(appointmentPath, modelOfAppointment);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	// Method For showing All Records
	public void showAllRecords() 
	{
		if (doctors.size() > 0) 
		{
			System.out.println("NoOfPatient\tDoctor record");
			for (int i = 0; i < doctors.size(); i++) 
			{
				System.out.print(doctors.get(i).getNumberOfPatients() + "\t\t");
				System.out.print(doctors.get(i).getDoctorId() + "\t");
				showDoctorList(i, false);
			}
		}
		if (patients.size() > 0) 
		{
			System.out.println("Patient records");
			for (int i = 0; i < patients.size(); i++) 
			{
				showPatientList(i, false);
			}
		}

		if (appointments.size() > 0)
		{
			System.out.println("Appointment records");
			appointments.forEach(i -> 
			{
				System.out.println(i.getAppointmentId() + " " + i.getDoctorId() + " " + i.getDoctorName() + " "
						+ i.getDoctorAvailability() + " " + i.getPatientId() + " "
						+ i.getAppointmentAssignedPatientName() + " " + i.getAppointmentAssignedPatientMobileNumber());
			});
		}
	}

	// Method for showing list od doctors
	public void showDoctorList(int index, boolean hasSigleRecord) 
	{
		if (hasSigleRecord) 
		{
			System.out.println("Dr details");
			System.out.print(doctors.get(index).getDoctorName() + "\t");
			System.out.print(doctors.get(index).getDoctorSpecialization() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getDate() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getInTime() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getOutTime() + "\t");
		}
		else
		{
			System.out.print(doctors.get(index).getDoctorName() + "\t");
			System.out.print(doctors.get(index).getDoctorSpecialization() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getDate() + "\t");
			System.out.print(doctors.get(index).getDoctorAvailability().getInTime() + "\t");
			System.out.println(doctors.get(index).getDoctorAvailability().getOutTime() + "\t");
		}
	}

	// Method for showing list for particular index
	 public void showPopularDoctor() 
	 {
		sortDoctorList();
		if (doctors.get(0).getNumberOfPatients() > 0) 
		{
			System.out.println("Hospital specialization: " + doctors.get(0).getDoctorSpecialization());
			System.out.println("Popular Doctor ");
			showDoctorList(0, false);
		} 
		else
			System.out.println("No appointments assign to doctor try again later");
	}

	// Method for sorting doctor list 
	public void sortDoctorList() 
	{
		for (int i = 0; i < doctors.size() - 1; i++) 
		{
			for (int j = 0; j < doctors.size() - i - 1; j++) 
			{
				if (doctors.get(j).getNumberOfPatients() < doctors.get(j + 1).getNumberOfPatients()) 
				{
					Object temp = doctors.get(j);
					doctors.set(j, doctors.get(j + 1));
					doctors.set(j + 1, (Doctor) temp);
				}
			}
		}
	}

	// Method for showing the list with associated numbers
	public void showDoctorList(int index, int num) 
	{

		System.out.print(doctors.get(index).getDoctorId() + ". " + doctors.get(index).getDoctorName() + "\t");
		System.out.print(doctors.get(index).getDoctorSpecialization() + "\t");
		System.out.print(doctors.get(index).getDoctorAvailability().getDate() + "\t");
		System.out.print(doctors.get(index).getDoctorAvailability().getInTime() + "\t");
		System.out.print(doctors.get(index).getDoctorAvailability().getOutTime() + "\t");

	}

}
