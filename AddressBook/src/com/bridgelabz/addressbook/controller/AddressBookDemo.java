package com.bridgelabz.addressbook.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.JsonUtil;
import com.bridgelabz.addressbook.util.Utility2;

/******************************************************************************************
 * @author :Pramila0526
 * Purpose :Address Book
 * Date    :06/12/2019
 *
 *******************************************************************************************/
public   class AddressBookDemo 
{
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
	{
		 public AddressBookModel model = new AddressBookModel();
		 ObjectMapper mapper=new ObjectMapper();
		 String path = "/home/admin94/Desktop/ObjectOrientedPrograms/AddressBook/AddressBook.json";
		 public ArrayList<Person> personArrayList = new ArrayList<Person>();

		 personArrayList.addAll(model.lisOfperson);
		
		model=mapper.readValue(new File(path), AddressBookModel.class);
		
	//	System.out.println(model.getPerson().get(0).getFirstName());
		{
			ArrayList<Person> personArrayList = new ArrayList<Person>();
		System.out.println("Enter the Number of Persons You want to Add");
		int numberOfPersons=Utility2.integerInput();
		
		for(int i=0;i<numberOfPersons;i++)
		{
		
		Person p1 = new Person();  //Object Of Person
       
		System.out.println("Enter Person Id");
		int id=Utility2.integerInput();
		p1.setPersonId(id);
		
		System.out.println("Enter Persons First Name");
		String firstName=Utility2.stringInput();
		p1.setFirstName(firstName);
		
		System.out.println("Enter Persons Last Name");
		String lastName=Utility2.stringInput();
		p1.setLastName(lastName);

		Address ad1 = new Address(); //Object Of Address
		System.out.println("Address--");
		System.out.println("Enter Persons City");
		String city=Utility2.stringInput();
		ad1.setCity(city);
		
		System.out.println("Enter Persons State");
		String state=Utility2.stringInput();
		ad1.setState(state);
		
		System.out.println("Enter Persons Zip");
		int zip=Utility2.integerInput();
		ad1.setZip(zip);

		p1.setAddressObj(ad1);
        
		System.out.println("Enter Persons Mobile");
		int mobile =Utility2.longInput();		
		p1.setPersonId(mobile);

		
       
		personArrayList.add(p1);
		
		}
		
		}	
		
		// Code to edit the data of person identified by id 
		public void editPerson()
		{
				System.out.println("Enter Persons Id you want to edit:");
				Long idToEdit = (long) Utility2.longInput();

				int indexOfPerson = 0;
				boolean isPersonFound = false;
				
				for (int i = 0; i < personArrayList.size(); i++) 
				{
					if (idToEdit.equals(personArrayList.get(i).getPersonId()))
					{
						isPersonFound = true;
						indexOfPerson = i;
						System.out.println("Person Found with the " + idToEdit + " Number");
						break;
					}
				}
		
		
		
		
		
		
		
		
		
		
	
		

		if (isPersonFound) 
		{
			System.out.println("Enter the City to Change");
			personArrayList.get(indexOfPerson).getAddressObj().setCity(Utility2.stringInput());
			
			System.out.println("Enter the State to Change");
			personArrayList.get(indexOfPerson).getAddressObj().setState(Utility2.stringInput());
			System.out.println("Enter the Zip to Change");
			personArrayList.get(indexOfPerson).getAddressObj().setZip(Utility2.integerInput());
			System.out.println("Enter Mobile Number to cahnge");
			personArrayList.get(indexOfPerson).setMobile((long) Utility2.longInput());

			System.out.println("Editing of data is completed");
		} 
		else if (!isPersonFound)
		{
			System.out.println("Person with " + idToEdit + " Number Doesn't exists");
		}
		}
		
		public void sortByName()
		{

		// code to sort by last name
		for (int i = 0; i < personArrayList.size() - 1; i++) 
		{
			for (int j = 0; j < personArrayList.size() - i - 1; j++)
			{
				if (personArrayList.get(j).getLastName().compareTo(personArrayList.get(j + 1).getLastName()) > 0) {
					Object temp = personArrayList.get(j);
					personArrayList.set(j, personArrayList.get(j + 1));
					personArrayList.set(j + 1, (Person) temp);
				}
			}
		}
		model.setPerson(personArrayList);
		}
		
		public void sortByZip()
		{
		// code to sort by zip number
		for (int i = 0; i < personArrayList.size() - 1; i++) {
			for (int j = 0; j < personArrayList.size() - i - 1; j++) {

				if (personArrayList.get(j).getAddressObj().getZip() > personArrayList.get(j + 1).getAddressObj().getZip()) {
					Object temp = personArrayList.get(j);
					personArrayList.set(j, personArrayList.get(j + 1));
					personArrayList.set(j + 1, (Person) temp);
				}
			}
		}
		model.setPerson(personArrayList);
		//mapper.writeValue(new File(path), model);
		JsonUtil.writeMapper(path, model);
		}
	}
	}
}