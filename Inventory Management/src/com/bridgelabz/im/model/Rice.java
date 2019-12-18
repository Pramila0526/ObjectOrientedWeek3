package com.bridgelabz.im.model;

public class Rice {
	private String nameOfRice;
	private int pricePerKgForRice;
	private int weightForRice;
	private int totalPriceOfWeightForRice;

	
	public String getNameOfRice() {
		return nameOfRice;
	}


	public void setNameOfRice(String nameOfRice) {
		this.nameOfRice = nameOfRice;
	}


	public int getPricePerKgForRice() {
		return pricePerKgForRice;
	}


	public void setPricePerKgForRice(int pricePerKgForRice) {
		this.pricePerKgForRice = pricePerKgForRice;
	}


	public int getWeightForRice() {
		return weightForRice;
	}


	public void setWeightForRice(int weightForRice) {
		this.weightForRice = weightForRice;
	}


	public int getTotalPriceOfWeightForRice() {
		return totalPriceOfWeightForRice;
	}


	public void setTotalPriceOfWeightForRice(int totalPriceOfWeightForRice) {
		this.totalPriceOfWeightForRice = totalPriceOfWeightForRice;
	}


	public String toString() {
		return "Rice's [Name Of Rice=" + nameOfRice + ",Price$ Per KG for Rice=" + pricePerKgForRice + 
				", Weight Of Rice=" + weightForRice
				+ ", Total price of weight for Rice=" + totalPriceOfWeightForRice + "]";
	}

}
