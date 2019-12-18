package com.bridgelabz.cliniquemanagement.model;

import java.util.List;

public class AppointmentModel {
private List<Appointment> appointments;

public List<Appointment> getAppointments() {
	return appointments;
}

public void setAppointments(List<Appointment> appointments) {
	this.appointments = appointments;
}

@Override
public String toString() {
	return "AppointmentModel [appointments=" + appointments + "]";
}


}
