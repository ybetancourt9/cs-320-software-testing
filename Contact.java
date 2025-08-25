package com.yaumel.ContactsApp;

public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private static final String ERROR_MESSAGE = "value is invalid";
	private static final byte MAX_LEN_10 = 10;
	private static final byte MAX_LEN_30 = 30;
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param address
	 * @param id
	 */
	public Contact(String firstName, String lastName, String phone, String address, String id) {
	    setId(id); // the setter is private so that id can not be changed after it has been created
	    setFirstName(firstName);
	    setLastName(lastName);
	    setPhone(phone);
	    setAddress(address);
	}
	
	/**
	 * 
	 * @return the contact ID
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Sets the contact ID.
	 * 
	 * @param id
	 */
	private void setId(String id) {
		if (id == null || id.length() > MAX_LEN_10) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		this.id = id;	
	}
	
	/**
	 * 
	 * @return the contact first name
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Sets the contact first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > MAX_LEN_10) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		this.firstName = firstName;
	}
	
	/**
	 * 
	 * @return the contact last name
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Sets the contact last name.
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > MAX_LEN_10) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		this.lastName = lastName;
	}
	
	/**
	 * 
	 * @return the contact phone number
	 */
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Sets the contact phone number.
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		if (phone == null || phone.length() != MAX_LEN_10) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		this.phone = phone;
	}
	
	/**
	 * 
	 * @return the contact address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Sets the contact address.
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		if (address == null || address.length() > MAX_LEN_30) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		this.address = address;
	}
}
