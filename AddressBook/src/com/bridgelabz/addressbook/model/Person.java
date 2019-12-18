package com.bridgelabz.addressbook.model;
/***************************************************************************************
 * @author 	:Pramila0526
 * Purpose	:Person Pojo
 *
 ***************************************************************************************/
public class Person 
{
	private int personId;
	private String firstName;
	private String lastName;
	private Address addressObj;
	private Long mobile;
    
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddressObj() {
		return addressObj;
	}

	public void setAddressObj(Address addressObj) {
		this.addressObj = addressObj;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}


	
	

}
