package com.bridgelabz.im.model;

public class Pulses {

	private String nameOfPulses;
	private int pricePerKgForPulses;
	private int weightForPulses;
	private int totalPriceOfWeightForPulses;
	
	public String getNameOfPulses() {
		return nameOfPulses;
	}
	
	public void setNameOfPulses(String nameOfPulses) {
		this.nameOfPulses = nameOfPulses;
	}
	
	public int getPricePerKgForPulses() {
		return pricePerKgForPulses;
	}
	
	public void setPricePerKgForPulses(int pricePerKgForPulses) {
		this.pricePerKgForPulses = pricePerKgForPulses;
	}
	
	public int getWeightForPulses() {
		return weightForPulses;
	}
	
	public void setWeightForPulses(int weight) {
		this.weightForPulses = weight;
	}
	
	public int getTotalPriceOfWeightForPulses() {
		return totalPriceOfWeightForPulses;
	}
	
	public void setTotalPriceOfWeightForPulses(int totalPriceOfWeightForPulses) {
		this.totalPriceOfWeightForPulses = totalPriceOfWeightForPulses;
	}
	
	public String toString() {
		return "Pulses's [Name Of Pulses=" +nameOfPulses+ ",Price$ Per KG for Pulses=" 
	
				+ pricePerKgForPulses +", Weight Of Rice=" + weightForPulses + ", Total price of weight=" + totalPriceOfWeightForPulses +"]";
	}

	


	}
