package com.bridgelabz.addressbook.controller;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.JsonUtil;
import com.bridgelabz.addressbook.service.ExecutionOfAddressBook;
import com.bridgelabz.addressbook.util.Utility2;
/***************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Manager's Page
 *
 ****************************************************************************************/
public class AddressBookManager 
{
	public static void main(String args[])
			throws InterruptedException, JsonParseException, JsonMappingException, IOException {
		
		ExecutionOfAddressBook adbook = new ExecutionOfAddressBook();
		
		adbook.readJson();

		
		AddressBookModel model = new AddressBookModel();
		ObjectMapper mapper=new ObjectMapper();
		String path = "/home/admin94/Desktop/ObjectOrientedPrograms/AddressBook/AddressBook2.json";
		ArrayList<Person> persons= new ArrayList<Person>();

		
		
		//model=mapper.readValue(new File(path), AddressBookModel.class);
		
		//persons.addAll(model.lisOfperson);
		boolean isExitAddressBook = false;
		
		System.out.println("Address book Manager's Page");
		while (!isExitAddressBook) {

			System.out.println("Operataions to Perform");
			
			System.out.println("1. New Address Book");
			System.out.println("2. Open Address Book");
			System.out.println("3. Save Address Book");
			System.out.println("4. SaveAs Address Book");
			System.out.println("5. Quit");
			System.out.println("Select Your Choice");
			
			int choice = Utility2.integerInput();
			switch (choice) {
			case 1:
				
				adbook.createNewAddressBook();
				model.setPerson(persons);
				break;
			case 2:
				
				adbook.openAddressBook();
				model.setPerson(persons);

				break;
			case 3:
			
				adbook.save();
				model.setPerson(persons);
				break;
			case 4:
				adbook.saveAs();
				model.setPerson(persons);
				break;
			case 5:
				
				System.out.println("Exit Address Book");
				isExitAddressBook = true;
				

				break;
			default:
				System.out.println("Invalid choice");
				break;

			}
		}

		JsonUtil.writeMapper(path, model);
	}

}
