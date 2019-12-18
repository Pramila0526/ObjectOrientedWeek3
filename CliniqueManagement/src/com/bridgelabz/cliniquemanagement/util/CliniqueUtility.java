package com.bridgelabz.cliniquemanagement.util;
import java.util.*;
/************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Utility For Clinique
 * Date		:11/12/2019
 * 
 *************************************************************************************/
public class CliniqueUtility {

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
}