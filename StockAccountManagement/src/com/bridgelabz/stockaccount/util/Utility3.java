package com.bridgelabz.stockaccount.util;

import java.util.*;

public class Utility3{

	 static Scanner sc;

	public static int integerInput() {
		sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static double doubleInput() {
		sc = new Scanner(System.in);
		return sc.nextDouble();
	}

	public static String stringInput() {
		sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public static int longInput() {
		sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public static int calculateTotalValueOfStock(int numberOfShares, int sharePrice) {
		return numberOfShares * sharePrice;
	}

}