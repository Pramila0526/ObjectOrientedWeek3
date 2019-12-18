package com.bridgelabz.stockaccount.controller;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.stockaccount.model.StockModel;
import com.bridgelabz.stockaccount.util.Utility3;


public class Stock {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		String path = "/home/admin94/Desktop/ObjectOrientedPrograms/StockAccount/Stock.json";
		String outputPath = "/home/admin94/Desktop/ObjectOrientedPrograms/StockAccount/Stock2.json";

		ObjectMapper mapper = new ObjectMapper();

		StockModel data = mapper.readValue(new File(path), StockModel.class);
		
		System.out.println("=====Stock Report=====");
		
		//Report details for NoteBook
		System.out.println("Stock Name:- " + data.getNoteBook().get(0).getStockName());
		System.out.println("Stock Price:-" + data.getNoteBook().get(0).getSharePrice());
		System.out.println("Stock Number of Shares:- " + data.getNoteBook().get(0).getNumberOfShares());
		System.out.println();
		
		int totalValueOfParle = Utility3.calculateTotalValueOfStock(data.getNoteBook().get(0).getNumberOfShares(),
				data.getNoteBook().get(0).getSharePrice());
		System.out.println("===Total value of Stock NoteBook===" + totalValueOfParle);

		data.getNoteBook().get(0).setTotalValueOfStock(totalValueOfParle);
		System.out.println();
		
		
		//Report details for Pen
		
		System.out.println("Stock Name:- " + data.getPen().get(0).getStockName());
		System.out.println("Stock Price:- " + data.getPen().get(0).getSharePrice());
		System.out.println("Stock Number of Shares:- " + data.getPen().get(0).getNumberOfShares());
		System.out.println();
		
		int totalValueOfMarie = Utility3.calculateTotalValueOfStock(data.getPen().get(0).getNumberOfShares(),
				data.getPen().get(0).getSharePrice());
		System.out.println("===Total value of Stock Pen===" + totalValueOfMarie);
		data.getPen().get(0).setTotalValueOfStock(totalValueOfMarie);
		System.out.println();
		
		
		//Report details for Watch
		System.out.println("Stock Name:- " + data.getWatch().get(0).getStockName());
		System.out.println("Stock Price:- " + data.getWatch().get(0).getSharePrice());
		System.out.println("Stock Number of Shares:- " + data.getWatch().get(0).getNumberOfShares());
		System.out.println();
		
		int totalValueOfOreo = Utility3.calculateTotalValueOfStock(data.getWatch().get(0).getNumberOfShares(),
				data.getWatch().get(0).getSharePrice());
		System.out.println("===Total value of Stock Watch===" + totalValueOfOreo);
		data.getWatch().get(0).setTotalValueOfStock(totalValueOfOreo);
		System.out.println();
		
		
		//Report details for Bottles
		System.out.println("Stock Name:- " + data.getBottles().get(0).getStockName());
		System.out.println("Stock Price:- " + data.getBottles().get(0).getSharePrice());
		System.out.println("Stock Number of Shares:- " + data.getBottles().get(0).getNumberOfShares());
		System.out.println();
		
		int totalValueOfTiger = Utility3.calculateTotalValueOfStock(data.getBottles().get(0).getNumberOfShares(),
				data.getBottles().get(0).getSharePrice());
		System.out.println("===Total value of Stock Bottles===" + totalValueOfTiger);
		data.getBottles().get(0).setTotalValueOfStock(totalValueOfTiger);

		int totalValueOfAllStock = totalValueOfParle + totalValueOfMarie + totalValueOfOreo + totalValueOfTiger;

		data.setTotalValueOfAllStock(totalValueOfAllStock);
		System.out.println();
		System.out.println("===Total count of stocks is===" + totalValueOfAllStock);
		System.out.println();
		System.out.println("=====Stock Report=====");
		// code for writing all details into new file
		
		mapper.writeValue(new File(outputPath), data);
		
		System.out.println("\nWrite into file is completed!!!");
	}

}
