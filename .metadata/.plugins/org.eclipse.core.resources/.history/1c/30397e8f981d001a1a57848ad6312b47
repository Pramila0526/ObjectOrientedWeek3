package com.bridgelabz.fellowship.datastructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import com.bridgelabz.fellowship.utility.Utility;

public class UnOrderedSearch<T> {
	Node head;

	public class Node 
	{
		public T data;
		public Node next;

		public Node(T data2) {
			data = data2;
			next = null;
		}
	}

	/*** Inserting an Elements *****/

	public void insert(T data) {
		Node new_node = new Node(data);
		new_node.next = null;
		if (head == null) {
			head = new_node;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_node;
		}
	}

	/**** Deleting Elements *****/

	public void delete(T data) {
		Node temp = head;
		Node previous = null;

		if (temp != null && temp.data == data) {
			head = temp.next;
		} else {
			while (temp != null && temp.data != data) {
				previous = temp;
				temp = temp.next;
			}
			if (temp == null) {
				return;
			}
			previous.next = temp.next;
		}
	}

	/*****
	 * Search Operation*****/

	public String search(T data) {

		Node temp = head;
		
		boolean flag = false;
		if (temp != null && temp.data == data) {
			head = temp.next;
		} else {
			while (temp != null) {
				if (temp.data == data)
					flag = true;
				temp = temp.next;
			}
		}
		if (flag) {
			System.out.println("\n" + data + " is Present..so Deleting**");
			delete(data);
		} else {
			System.out.println("\n" + data + " is not in the File..So inserting!!");
			insert(data);
		}
		return null;
	}

	/**** Displaying Data *****/

	public void display() {
		if (head == null) {
			System.out.println("List is Empty");
		} else {
			Node temp = head;
			while (temp != null) {
				System.out.print(temp.data + "-->");
				temp = temp.next;
			}
		}
	}
	@SuppressWarnings("resource")
	public static String readFromFile(String file) {
		String text ="";
		try {
			Scanner sc = new Scanner(new File(file));
			while (sc.hasNextLine()) 
			{
				text=text+sc.next()+" ";
			}
		   } 
		catch (FileNotFoundException e) 
		{
			System.out.println("File doesn't Exists");
		}
		return text;

	}
public static String[] arrayToFile(String file) 
{
	int count = 0;
		try {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File(file));
			
			while (sc.hasNextLine()) {
				
				count++;
				sc.nextLine();

			}
			String[] fileA = new String[count];
			@SuppressWarnings("resource")
			Scanner sc1 = new Scanner(new File(file));
			for (int i = 0; i < count; i++) 
			{
				fileA[i] = sc1.nextLine();
			}
				return fileA;
		
			
		}
catch (FileNotFoundException e) {
			System.out.println("File NOt Found");
		}
		// return fileA;
		return null;

	}

	/*** Main Method ****/

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		UnOrderedSearch<String> uo = new UnOrderedSearch<String>();

		String text = readFromFile("/home/admin94/Desktop/DataStructure(FP)/DataStructurePrograms/UnOrdered.txt");
        String[] fileA =arrayToFile("/home/admin94/Desktop/DataStructure(FP)/DataStructurePrograms/UnOrdered.txt");
		
        for (int i = 0; i < fileA.length; i++)
		{
			System.out.println(fileA[i]);
		}
		System.out.println(Arrays.toString(fileA));	
			
	  
			
		for (int i = 0; i < fileA.length; i++)
		{
			System.out.println(fileA[i]);
			uo.insert(fileA[i]);
			
		}
		uo.display();

		System.out.println();
		System.out.println("\nEnter the String in which You want to perform search Operation");
		String searchKey = Utility.stringInput();

		for (int i = 0; i <= fileA.length; i++) 
		{
			if ((searchKey).equals(fileA[i])) // if ((fileA[i]).equals(searchKey))
	       {
				uo.delete(fileA[i]);
				break;
	       }
	       else
	       {
				uo.insert(searchKey);
				break;
				
		}
		}
		
		
		uo.display();
	}}
