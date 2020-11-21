package org.phonebook;

public class BookEntry {
	private String fullName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phone;
	Address Address;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "PhoneEntry [fullName=" + fullName + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", phone=" + phone + ", Address=" + Address + "]";
	}
}