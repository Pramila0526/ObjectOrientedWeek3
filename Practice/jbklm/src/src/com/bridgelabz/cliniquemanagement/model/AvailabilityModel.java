package com.bridgelabz.cliniquemanagement.model;

import java.util.List;

public class AvailabilityModel {
private List<Availability> availability;

public List<Availability> getAvailability() {
	return availability;
}

public void setAvailability(List<Availability> availability) {
	this.availability = availability;
}

@Override
public String toString() {
	return "AvailabilityModel [availability=" + availability + "]";
}

}
