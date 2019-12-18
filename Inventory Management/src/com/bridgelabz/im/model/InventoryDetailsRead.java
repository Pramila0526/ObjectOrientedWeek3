package com.bridgelabz.im.model;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.im.model.InventoryDetails;
public class InventoryDetailsRead 
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
	@SuppressWarnings("unused")
	String path1="/home/admin94/Desktop/ObjectOrientedPrograms/Inventory Management/InventoryDetails.json";
	String path2="/home/admin94/Desktop/ObjectOrientedPrograms/Inventory Management/InventoryDetails2.json";
	
	ObjectMapper mapper=new ObjectMapper();
	
	int total=0;
	
	InventoryDetails iDetails = new InventoryDetails();
	
	 iDetails=mapper.readValue(new File("/home/admin94/Desktop/ObjectOrientedPrograms/Inventory Management/InventoryDetails.json"),iDetails.getClass()); 
	
	System.out.println("Rice " +iDetails.getRice().get(0).getNameOfRice());
	System.out.println("Price of Wheat" +iDetails.getRice().get(0).getPricePerKgForRice());
	total+=iDetails.getRice().get(0).getPricePerKgForRice();
	
	System.out.println("Pulses " +iDetails.getPulses().get(0).getNameOfPulses());
	System.out.println("Price of Pulses" +iDetails.getPulses().get(0).getPricePerKgForPulses());
	total+=iDetails.getPulses().get(0).getPricePerKgForPulses();
	
	System.out.println("Rice " +iDetails.getWheat().get(0).getNameOfWheat());
	System.out.println("Price of Wheat" +iDetails.getWheat().get(0).getPricePerKgForWheat());
	total+=iDetails.getWheat().get(0).getPricePerKgForWheat();
	
	System.out.println("Total Of all" +total);
	
	iDetails.setTotal(total);
	
	mapper.writeValue(new File(path2), iDetails);
	System.out.println("Writing into file completed");
	
	
}
}
