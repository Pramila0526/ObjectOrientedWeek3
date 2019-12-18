package com.bridgelabz.cliniquemanagement.model;

import java.util.List;

/************************************************************************************
 * @author 	:Pramila0526 
 * Purpose	:POJO Class Of AvailabilityModel 
 * Date	 	:11/12/2019
 *         
 * 
 *************************************************************************************/
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
