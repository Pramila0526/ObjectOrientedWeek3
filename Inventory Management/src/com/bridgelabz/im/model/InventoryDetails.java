package com.bridgelabz.im.model;

import java.util.List;

public class InventoryDetails {
	
	private List<Rice> rice;
	private List<Wheat> wheat;
	private List<Pulses> pulses;
	
	private int total;

	public List<Rice> getRice() {
		return rice;
	}

	public void setRice(List<Rice> rice) {
		this.rice = rice;
	}

	public List<Wheat> getWheat() {
		return wheat;
	}

	public void setWheat(List<Wheat> wheat) {
		this.wheat = wheat;
	}

	public List<Pulses> getPulses() {
		return pulses;
	}

	public void setPulses(List<Pulses> pulses) {
		this.pulses = pulses;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public String toString() {
		return "Pulses's [Rice=" +rice+ ",Wheat=" + wheat +", Pulses=" + pulses + ", Total=" + total +"]";
	}

	

}
