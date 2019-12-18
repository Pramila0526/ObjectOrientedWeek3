package com.bridgelabz.im.model;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.im.model.InventoryDetails;
import com.bridgelabz.im.model.Pulses;
import com.bridgelabz.im.model.Rice;
import com.bridgelabz.im.model.Wheat;
import com.bridgelabz.im.repositiory.JsonUtil;
import com.bridgelabz.im.utility.Utility1;

public class InventoryManager 
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException
	{
		String name;
		int weight;
		int price;
		int totalPriceOfWeight = 0;
		
		
		
		int inventoryGrandTotal=0;
		
		System.out.println("!!!Add New Stock in the Inventory!!!");

		System.out.println("How much Inventory You want to add");
		
		int addInventory = Utility1.integerInput();

		String path1 = "/home/admin94/Desktop/ObjectOrientedPrograms/Inventory Management/InventoryDetails.json";
        String path2="/home/admin94/Desktop/ObjectOrientedPrograms/Inventory Management/InventoryDetails2.json";
        
		InventoryDetails iDetails = new InventoryDetails();

		iDetails = (InventoryDetails) JsonUtil.readMapper(path1, iDetails);

		ArrayList<Rice> riceList = new ArrayList<Rice>();
		ArrayList<Pulses> pulsesList = new ArrayList<Pulses>();
		ArrayList<Wheat> wheatList = new ArrayList<Wheat>();

		iDetails.getRice().get(0).setTotalPriceOfWeightForRice(
	    iDetails.getRice().get(0).getWeightForRice()* iDetails.getRice().get(0).getTotalPriceOfWeightForRice());
		
		iDetails.getPulses().get(0).setTotalPriceOfWeightForPulses(
			    iDetails.getPulses().get(0).getWeightForPulses()* iDetails.getPulses().get(0).getTotalPriceOfWeightForPulses());
		
		iDetails.getWheat().get(0).setTotalPriceOfWeightForWheat(
			    iDetails.getWheat().get(0).getWeightForWheat()* iDetails.getWheat().get(0).getTotalPriceOfWeightForWheat());
		
		int riceSize=iDetails.getRice().size();
		int pulsesSize=iDetails.getPulses().size();
		int wheatSize=iDetails.getWheat().size();
		
		for(int i=0;i<riceSize-1;i++)
		{
			inventoryGrandTotal+=iDetails.getRice().get(riceSize-1).getTotalPriceOfWeightForRice();
			riceSize--;
		}
		
		for(int i=0;i<pulsesSize-1;i++)
		{
			inventoryGrandTotal+=iDetails.getPulses().get(pulsesSize-1).getTotalPriceOfWeightForPulses();	
			pulsesSize--;
		}

		
		for(int i=0;i<wheatSize-1;i++)
		{
			inventoryGrandTotal+=iDetails.getWheat().get(wheatSize-1).getTotalPriceOfWeightForWheat();
			wheatSize--;
		}
  
		riceList.addAll(iDetails.getRice());
		pulsesList.addAll(iDetails.getPulses());
		wheatList.addAll(iDetails.getWheat());
		
		int choice;
		
		for(int i=0;i<addInventory;i++)
		{
			System.out.println("==Opearations to perform with the Inventory==");
			System.out.println("1) Rice");
			System.out.println("2) Pulses");
			System.out.println("3) Wheat");
			System.out.println("4) Exit");
			System.out.println("Enter Your choice");
			choice=Utility1.integerInput();
			
			switch(choice)
			{
			case 1:
				
				Rice rice=new Rice();
				
				System.out.println("Enter the Rice Type");
				 name=Utility1.stringInput();
				
				System.out.println("Enter the Weight of Rice");
				 weight=Utility1.integerInput();
				
				System.out.println("Enter the Price per kg of Rice");
				 price=Utility1.integerInput();
				
				totalPriceOfWeight+=weight*price;
				
				inventoryGrandTotal+=totalPriceOfWeight;
				
				rice.setNameOfRice(name);
				rice.setWeightForRice(weight);
				rice.setPricePerKgForRice(price);
				rice.setTotalPriceOfWeightForRice(totalPriceOfWeight);
				
				riceList.add(rice);
				
				break;
				
			case 2:
				
				Pulses pulses=new Pulses();
				
				System.out.println("Enter the Pulses Type");
				 name=Utility1.stringInput();
				
				System.out.println("Enter the Weight of Pulses");
				 weight=Utility1.integerInput();
				
				System.out.println("Enter the Price per kg of Pulses");
				 price=Utility1.integerInput();
				
				totalPriceOfWeight+=weight*price;
				
				inventoryGrandTotal+=totalPriceOfWeight;
				
				pulses.setNameOfPulses(name);
				pulses.setWeightForPulses(weight);
				pulses.setPricePerKgForPulses(price);
				pulses.setTotalPriceOfWeightForPulses(totalPriceOfWeight);
				
				pulsesList.add(pulses);
				
				break;
				
			case 3:
				
				Wheat wheat=new Wheat();
				
				System.out.println("Enter the Wheat Type");
				 name=Utility1.stringInput();
				
				System.out.println("Enter the Weight of Wheat");
				 weight=Utility1.integerInput();
				
				System.out.println("Enter the Price per kg of Wheat");
				 price=Utility1.integerInput();
				
				totalPriceOfWeight+=weight*price;
				
				inventoryGrandTotal+=totalPriceOfWeight;
				
				wheat.setNameOfWheat(name);
				wheat.setWeightForWheat(weight);
				wheat.setPricePerKgForWheat(price);
				wheat.setTotalPriceOfWeightForWheat(totalPriceOfWeight);
				
				wheatList.add(wheat);
				
				break;
				
			case 4:
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid choice");
				continue;
			}

		}

		iDetails.setTotal(inventoryGrandTotal);
		iDetails.setRice(riceList);
		iDetails.setPulses(pulsesList);
		iDetails.setWheat(wheatList);

		System.out.println(JsonUtil.writeMapper(path2, iDetails));
		System.out.println("Inventory is added into new json File");
			}
		
		
	}
