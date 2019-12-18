package com.bridgelabz.addressbook.service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.AddressBookModel;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.JsonUtil;
import com.bridgelabz.addressbook.util.Utility2;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
/**************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Address Book Implementation
 *
****************************************************************************************/
public class ExecutionOfAddressBook implements UtilAddressBook 
{
	int indexOfPerson=0;
	String path="/home/admin94/Desktop/ObjectOrientedPrograms/AddressBook/AddressBook2.json";
	AddressBookModel model=new AddressBookModel();
	ArrayList<Person> personArrayList=new ArrayList<Person>();
	int counter=0;
	String stateName;
	
	// Method to print the details
	public static void printPersonDetails(ArrayList<Person> persons, String stateName) {
			String detail = "";
			detail += "Person detail\n";
			System.out.println(detail);
			persons.forEach(i -> 
			{
				if (!stateName.isEmpty() && stateName.equals(i.getAddressObj().getState())) 
				{
					System.out.println(i.getFirstName() + " " + i.getLastName() + " " + i.getAddressObj().getAddress()
							+ " " + i.getAddressObj().getCity() + " " + i.getAddressObj().getState() + " "
							+ i.getAddressObj().getZip() + " " + i.getMobile());
				}
			});
		}

	// Method to read Json File
	public void readJson() 
	{
		File file=new File(path);
		if(file.exists()&&file.length()!=0)
		{
			try
			{
				model=(AddressBookModel) JsonUtil.readMapper(path, model);// TODO Auto-generated method stub
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			personArrayList.addAll(model.getPerson());
			counter=personArrayList.size();
		}
	}

	// Method the create a new address Book
	public void createNewAddressBook() 
	{
			System.out.println("====New Address Book====");
			System.out.println("Enter the state name: ");
			stateName = Utility2.stringInput();
			boolean isFoundState = false;
			for (int i = 0; i < personArrayList.size(); i++)
			{
				if (personArrayList.get(i).getAddressObj().getState().equals(stateName)) 
				{
					isFoundState = true;
					break;
				}
			}
			if (!isFoundState) 
			{
				System.out.println("==State is added==");
				boolean close = false;
				while (!close) 
				{
					System.out.println("Options to select:-");
					System.out.println("1. Add a Person");
					System.out.println("2. Delete the Person");
					System.out.println("3. Edit Person");
					System.out.println("4. Sort by last name");
					System.out.println("5. Sortby Zip Code");
					System.out.println("6. Print");
					System.out.println("7. Close or Exit");
					int ch = Utility2.integerInput();
					switch (ch) {
					case 1:
						// add person
						addPerson();
						break;
					case 2:
						// edit person
						deletePerson();
						break;
					case 3:
						// delete person
						editPerson();
						break;
					case 4:
						// sort by last name
						sortByLastName();
						break;
					case 5:
						// sort by zip
						sortByZip();
						break;
					case 6:
						HashMap<String, String> map = new HashMap<>();
						HashMap<Long,Long> map1=new HashMap<Long, Long>();
						for (int i = 0; i < personArrayList.size(); i++) 
						{
							map.put(personArrayList.get(i).getFirstName(), personArrayList.get(i).getFirstName());
							map.put(personArrayList.get(i).getLastName(), personArrayList.get(i).getLastName());
							map.put(personArrayList.get(i).getAddressObj().getState(), personArrayList.get(i).getAddressObj().getState());
							map.put(personArrayList.get(i).getAddressObj().getCity(), personArrayList.get(i).getAddressObj().getCity());
							map1.put(personArrayList.get(i).getMobile(), personArrayList.get(i).getMobile());
						}
						System.out.println("Data" + map.keySet());
						System.out.println(map1.keySet());
						/*if (counter > 0) {
							ExecutionOfAddressBook.printPersonDetails(personArrayList, stateName);
						} else
							System.out.println("Less data to print");*/

						break;
					case 7:
						close = true;
						break;
					default:
						System.out.println("Invalid choice");
					}
				}
			} 
			else
				System.out.println("State doesnt exist please try again");
		}
	
	// Method to Open address bokk
	public void openAddressBook() 
	{
			System.out.println("=====Open Address Book=====\n");
			HashMap<String, String> map = new HashMap<>();
			HashMap<Long,Long> map1=new HashMap<Long, Long>();
			for (int i = 0; i < personArrayList.size(); i++) 
			{
				map.put(personArrayList.get(i).getFirstName(), personArrayList.get(i).getFirstName());
				map.put(personArrayList.get(i).getLastName(), personArrayList.get(i).getLastName());
				map.put(personArrayList.get(i).getAddressObj().getState(), personArrayList.get(i).getAddressObj().getState());
				map.put(personArrayList.get(i).getAddressObj().getCity(), personArrayList.get(i).getAddressObj().getCity());
				map1.put(personArrayList.get(i).getMobile(), personArrayList.get(i).getMobile());
			}
			System.out.println("Data" + map.keySet());
			System.out.println(map1.keySet());
			System.out.println("Enter state");
			stateName =Utility2.stringInput();
			boolean isFoundState = false;
			for (int i = 0; i < personArrayList.size(); i++) 
			{
				if (personArrayList.get(i).getAddressObj().getState().equals(stateName)) {
					isFoundState = true;
					break;
				}
			}
			if (isFoundState)
			{
				System.out.println("==State is found==");
				boolean close2 = false;
				while (!close2)
				{
					System.out.println("Options\n");
					System.out.println("1)Add");
					System.out.println("2)Edit");
					System.out.println("3)Delete");
					System.out.println("4)Sort by last Name");
					System.out.println("5)Sort By Zip"); 
					System.out.println("6)Print");
					System.out.println("7)Quit\n");
					switch (Utility2.integerInput()) 
					{
					case 1:
						addPerson(); // method to add the  person
						break;
					case 2:
						editPerson(); // method to edit person
						break;
					case 3:
						deletePerson(); // method to delete person
						break;
					case 4:
						sortByLastName(); // method to sort by last name
						break;
					case 5:
						sortByZip(); 	//method to sort by zip
						break;
					case 6:
						// printing the details
						if (counter > 0) {
							ExecutionOfAddressBook.printPersonDetails(personArrayList, stateName);
						} else
							System.out.println("There is no record to print...");
						break;
					case 7:
						// close
						close2 = true;
						System.out.println("Closing the details");
						break;
					default:
						System.out.println("Invalid option");
					}
				}

			} else
				System.out.println("Please create new state ");

			System.out.println("======Open Address Book======");

		}

	// Method tp Add the Person
	public void addPerson() 
	{
		System.out.println("Add Details of The Person");
		Person p=new Person();
		System.out.println("Enter the Mobile number ");
		Long mobileNumber=(long) Utility2.longInput();
		boolean isMobileTaken=false;
		for(int i=0;i<personArrayList.size();i++)
		{
			if(personArrayList.get(i).getMobile()==mobileNumber)
			{
				isMobileTaken=true;
				break;
			}
		}
		if(isMobileTaken)
		{
			System.out.println("This Mobile Number is already Taken");
		}
		else
		{
			p.setMobile(mobileNumber);
			System.out.println("Enter the First Name");
			p.setFirstName(Utility2.stringInput());
			
			System.out.println("Enter the Last Name");
			p.setLastName(Utility2.stringInput());
			
			System.out.println("Enter the Adress Details");
			
			Address ad=new Address();
			
			System.out.println("Enter address: ");
			ad.setAddress(Utility2.stringInput());
			
			System.out.println("Enter city: ");
			ad.setCity(Utility2.stringInput());
			
			System.out.println("Enter State: ");
			ad.setState(Utility2.stringInput());
			
			System.out.println("Enter zip: ");
			ad.setZip(Utility2.integerInput());
			
			p.setAddressObj(ad);

			personArrayList.add(p);

			System.out.println();
			System.out.println("New Person is added to the details");
			counter++;
		}
	}

	// Method to Edit Person
	public void editPerson() {
			if (counter > 0) 
			{
				System.out.println("Enter Persons mobile number you want to edit:");
				Long searchMobile = (long) Utility2.longInput();
				indexOfPerson = 0;
				boolean isFoundPerson = false;
				for (int i = 0; i < personArrayList.size(); i++) {
					if (searchMobile.equals(personArrayList.get(i).getMobile())) {
						isFoundPerson = true;
						indexOfPerson = i;
						break;
					}
				}
				if (isFoundPerson) {

					System.out.println("Enter the new address");
					personArrayList.get(indexOfPerson).getAddressObj().setAddress(Utility2.stringInput());
					System.out.println("enter new city name");
					personArrayList.get(indexOfPerson).getAddressObj().setCity(Utility2.stringInput());
					System.out.println("enter new zip");
					personArrayList.get(indexOfPerson).getAddressObj().setZip(Utility2.integerInput());

					personArrayList.get(indexOfPerson).setMobile(searchMobile);

					System.out.println();
					System.out.println("Editing the person's details completed");

				} else
					System.out.println("Person with " +searchMobile+ " number Doesn't exists in the address book");
			} else
				System.out.println("There is no record to edit the details");

		}
		
	//Method to delete the person
	public void deletePerson() {
		if (counter > 0) {
			System.out.println("Enter Persons mobile number you want to delete:");
			Long mobileNumberToSearch= (long) Utility2.longInput();
			indexOfPerson = 0;
			boolean isFoundPerson = false;
			
			for (int i = 0; i < personArrayList.size(); i++) 
			{
				if (mobileNumberToSearch.equals(personArrayList.get(i).getMobile())) {
					isFoundPerson = true;
					indexOfPerson = i;
					break;
				}
			}
			if (isFoundPerson) {
				personArrayList.remove(indexOfPerson);
				counter--;
				System.out.println();
				System.out.println("Delete completed");
			} else
				System.out.println("No person found with this number");
		} else
			System.out.println("No records to delete");
		
		
	}

	// Method to sort by last Name
	public void sortByLastName() {
		if (counter > 0) {
            System.out.println("Sorting the address book Details by last name");
            for(int i=0;i<personArrayList.size();i++) {
            	for(int j=0;j<personArrayList.size();i++)
            	{
            		if(personArrayList.get(j).getLastName().compareTo(personArrayList.get(j+1).getLastName())>0)
            		{
            			Object temp=personArrayList.get(j);
            			personArrayList.set(j,personArrayList.get(j));
            			personArrayList.set(j+1, (Person) temp);
            			
            		}
            	}
            }
            model.setPerson(personArrayList);
            System.out.println(model);
            System.out.println("Sorting of address book data by the laste name is done");
            
		}
		else
		{
			System.out.println("Please Enter more data to sort by the last name");
			
		}
		
	}
	
	// Method to sort by zip
	@SuppressWarnings("unused")
	public void sortByZip() {
			System.out.println("Sorting the Address Book Details by zip");
			for (int i = 0; i < personArrayList.size(); i++) {
				for (int j = 0; j < personArrayList.size() - i ; j++) {

					if (personArrayList.get(j).getAddressObj().getZip() > personArrayList.get(j + 1).getAddressObj().getZip()) {
					Object temp1=personArrayList.get(j);
					personArrayList.set(j,personArrayList.get(j+1));
					personArrayList.set(j+1, (Person) temp1);
				}
			}
				model.setPerson(personArrayList);
				System.out.println(model);
				System.out.println("Sorting of address book data by zip code is completed");
				break;
			}
	}
	
	// Method to save
	public void save() {
		System.out.println("-----------------------Save Address Book-----------------------");

		System.out.println("===Saving address book ===");
		model.setPerson(personArrayList);
		try {
			
			JsonUtil.writeMapper(path, model);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		System.out.println();
	}

	//Method to save the file as
	public void saveAs() throws JsonParseException, JsonMappingException, IOException 
	{
		System.out.println("Saving the Address Book as");
		
			String pathForSaving="/home/admin94/Desktop/ObjectOrientedPrograms"
					+ "/AddressBook/AddressBookForSaving.json";
			
			ObjectMapper mapper=new ObjectMapper();
			//personArrayList.addAll(model.lisOfperson);
			
			   model=mapper.readValue(new File(pathForSaving), AddressBookModel.class);
				System.out.println("Saving address book into the file AddressBookForSaving.json");
				model.setPerson(personArrayList);
				
					try {
						JsonUtil.writeMapper(pathForSaving, model);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				
				
			System.out.println();
			}
		}	