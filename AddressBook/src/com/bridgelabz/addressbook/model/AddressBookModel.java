package com.bridgelabz.addressbook.model;
import java.util.List;
/***************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:AddressBookModel Pojo
 *
 ***************************************************************************************/
public class AddressBookModel {

	public List<Person> lisOfperson;

	public List<Person> getPerson() {
		return lisOfperson;
	}

	public void setPerson(List<Person> lisOfperson) {
		this.lisOfperson = lisOfperson;
	}

}
