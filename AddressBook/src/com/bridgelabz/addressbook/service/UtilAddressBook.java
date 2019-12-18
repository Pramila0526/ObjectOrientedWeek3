package com.bridgelabz.addressbook.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;


public interface UtilAddressBook {
	void readJson();

	void createNewAddressBook();

	void addPerson();

	void editPerson();

	void deletePerson();

	void sortByLastName();

	void sortByZip();

	void openAddressBook();

	void save();

	void saveAs() throws FileNotFoundException, JsonParseException, JsonMappingException, IOException;

	
}
