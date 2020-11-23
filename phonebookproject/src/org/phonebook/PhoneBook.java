package org.phonebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
	List<BookEntry> entries;

	public PhoneBook() {
		entries = new ArrayList<>();
	}

	public PhoneBook(List<BookEntry> entries) {
		this.entries = entries;
	}

	public List<BookEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<BookEntry> entries) {
		this.entries = entries;
	}

	public void addEntry(BookEntry rec) {
		this.entries.add(rec);
	}

	public void addEntry() {
		System.out.println("Please enter the new record in the following format:");
		System.out.println("John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375");
		Scanner String = new Scanner(System.in);
		String record = String.nextLine();
		String[] newEntry = record.split(", ");
		String[] nameArray = breakdownFullName(newEntry[0]);
		String[] entryArray = new String[9];

		entryArray[0] = (newEntry[0]);
		entryArray[1] = (nameArray[1]);
		entryArray[2] = (nameArray[2]);
		entryArray[3] = (nameArray[3]);
		entryArray[4] = (newEntry[1]);
		entryArray[5] = (newEntry[1]);
		entryArray[6] = (newEntry[1]);
		entryArray[7] = (newEntry[1]);
		entryArray[8] = (newEntry[1]);

		createEntries(entryArray);
		System.out.println(entryArray[0] + " has been added to the directory.");
	}

	public String[] breakdownFullName(String record) {

		String[] nameArray = new String[4];
		String[] rs = record.split(" ");

		String firstName = rs[0];
		String middleName = rs[1];
		String lastName = rs[rs.length - 1];

		for (int j = 2; j < rs.length - 1; j++) {
			middleName = middleName + " " + rs[j];
		}
		if (middleName.equals(lastName)) {
			middleName = "";

		}
		nameArray[0] = record;
		nameArray[1] = firstName;
		nameArray[2] = middleName;
		nameArray[3] = lastName;

		return nameArray;
	}

	public void createEntries(String[] myArray) {

		BookEntry be1 = new BookEntry();
		be1.Address = new Address();

		entries = getEntries();

		String phn = myArray[8];
		String phone = ("(" + phn.substring(0, 3) + ")-" + phn.substring(3, 6) + "-" + phn.substring(6, 10));

		be1.setFullName(myArray[0]);
		be1.setFirstName(myArray[1]);
		be1.setMiddleName(myArray[2]);
		be1.setLastName(myArray[3]);
		be1.setPhone(phone);

		be1.getAddress().setStreet(myArray[4]);
		be1.getAddress().setCity(myArray[5]);
		be1.getAddress().setState(myArray[6]);
		be1.getAddress().setZipCode(myArray[7]);

		entries.add(be1);
	}

	public void updateEntry() {
		System.out.println("\nPlease enter the phone number of the record to be updated (eg: (123)-456-7890):");
		Scanner stringIn = new Scanner(System.in);
		String phoneIn = stringIn.nextLine();
		System.out.println("\nPlease choose which field you want to update:");
		System.out.println("1. Update name");
		System.out.println("2. Update phone number:");
		System.out.println("3. Update street");
		System.out.println("4. Update city:");
		System.out.println("5. Update state");
		System.out.println("6. Update zip code:");
		int function2 = 0;
		Scanner input = new Scanner(System.in);
		function2 = input.nextInt();
		switch (function2) {
		case 1:
			updateName(phoneIn);
			break;
		case 2:
			updatePhone(phoneIn);
			break;
		case 3:
			updateStreet(phoneIn);
			break;
		case 4:
			updateCity(phoneIn);
			break;
		case 5:
			updateState(phoneIn);
			break;
		case 6:
			updateZip(phoneIn);
			break;
		default:
			System.out.println("Invalid function");
			break;
		}
	}

	public void displayDirectory() {

		BookEntry be1 = new BookEntry();
		be1.Address = new Address();

		System.out.println("Directory List: ");

		if (entries.size() > 0) {
			entries.sort(Comparator.comparing(BookEntry::getLastName));
			System.out.println(this.entries);
		} else {
			System.out.println("No entries found.");
		}
	}

	public void removeEntry(String phone) {

		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (phone.equals(entries.get(i).getPhone())) {
				recordFound = 1;
				System.out.println(this.entries.get(i));
				entries.remove(entries.get(i));
				System.out.println("The above entry was removed from the directory.");
			}
		}
		if (recordFound == 0) {
			System.out.println("No records were found for that phone number.");
		}
	}

	public void updateName(String phone) {

		BookEntry be1 = new BookEntry();
		be1.Address = new Address();
		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (phone.equals(entries.get(i).getPhone())) {
				recordFound = 1;
				String[] curRec = new String[9];

				phoneList(phone);

				System.out.println("\nPlease enter the new first name:");
				Scanner nameIn = new Scanner(System.in);
				String firstName = nameIn.nextLine();
				System.out.println("\nPlease enter the new middle name:");
				nameIn = new Scanner(System.in);
				String middleName = nameIn.nextLine();
				System.out.println("\nPlease enter the new last name:");
				nameIn = new Scanner(System.in);
				String lastName = nameIn.nextLine();
				String fullName = (firstName + " " + middleName + " " + lastName);

				curRec[0] = fullName;
				curRec[1] = firstName;
				curRec[2] = middleName;
				curRec[3] = lastName;
				curRec[4] = entries.get(i).getAddress().getStreet();
				curRec[5] = entries.get(i).getAddress().getCity();
				curRec[6] = entries.get(i).getAddress().getState();
				curRec[7] = entries.get(i).getAddress().getZipCode();
				curRec[8] = phone;

				entries.remove(entries.get(i));

				be1.setFullName(curRec[0]);
				be1.setFirstName(curRec[1]);
				be1.setMiddleName(curRec[2]);
				be1.setLastName(curRec[3]);
				be1.getAddress().setStreet(curRec[4]);
				be1.getAddress().setCity(curRec[5]);
				be1.getAddress().setState(curRec[6]);
				be1.getAddress().setZipCode(curRec[7]);
				be1.setPhone(curRec[8]);

				entries.add(be1);
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for phone number entered.");
		}
	}

	public void updatePhone(String phone) {

		BookEntry be1 = new BookEntry();
		be1.Address = new Address();
		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (phone.equals(entries.get(i).getPhone())) {
				recordFound = 1;
				String[] curRec = new String[9];

				phoneList(phone);

				System.out.println("\nPlease enter the new phone number (eg. (618)-233-7246)");
				Scanner input = new Scanner(System.in);
				String newPhone = input.nextLine();

				/
				curRec[0] = entries.get(i).getFullName();
				curRec[1] = entries.get(i).getFirstName();
				curRec[2] = entries.get(i).getMiddleName();
				curRec[3] = entries.get(i).getLastName();
				curRec[4] = entries.get(i).getAddress().getStreet();
				curRec[5] = entries.get(i).getAddress().getCity();
				curRec[6] = entries.get(i).getAddress().getState();
				curRec[7] = entries.get(i).getAddress().getZipCode();
				curRec[8] = newPhone;

				
				entries.remove(entries.get(i));

				
				be1.setFullName(curRec[0]);
				be1.setFirstName(curRec[1]);
				be1.setMiddleName(curRec[2]);
				be1.setLastName(curRec[3]);
				be1.getAddress().setStreet(curRec[4]);
				be1.getAddress().setCity(curRec[5]);
				be1.getAddress().setState(curRec[6]);
				be1.getAddress().setZipCode(curRec[7]);
				be1.setPhone(curRec[8]);

				entries.add(be1);
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for phone number entered.");
		}
	}

	public void updateStreet(String phone) {
		BookEntry be1 = new BookEntry();
		be1.Address = new Address();
		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (phone.equals(entries.get(i).getPhone())) {
				recordFound = 1;
				String[] curRec = new String[9];

				phoneList(phone);

				System.out.println("\nPlease enter the new street address:");
				Scanner input = new Scanner(System.in);
				String newStreet = input.nextLine();

				curRec[0] = entries.get(i).getFullName();
				curRec[1] = entries.get(i).getFirstName();
				curRec[2] = entries.get(i).getMiddleName();
				curRec[3] = entries.get(i).getLastName();
				curRec[4] = newStreet;
				curRec[5] = entries.get(i).getAddress().getCity();
				curRec[6] = entries.get(i).getAddress().getState();
				curRec[7] = entries.get(i).getAddress().getZipCode();
				curRec[8] = phone;

				entries.remove(entries.get(i));

				be1.setFullName(curRec[0]);
				be1.setFirstName(curRec[1]);
				be1.setMiddleName(curRec[2]);
				be1.setLastName(curRec[3]);
				be1.getAddress().setStreet(curRec[4]);
				be1.getAddress().setCity(curRec[5]);
				be1.getAddress().setState(curRec[6]);
				be1.getAddress().setZipCode(curRec[7]);
				be1.setPhone(curRec[8]);

				entries.add(be1);
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for phone number entered.");
		}
	}

	public void updateCity(String phone) {
		BookEntry be1 = new BookEntry();
		be1.Address = new Address();
		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (phone.equals(entries.get(i).getPhone())) {
				recordFound = 1;
				String[] curRec = new String[9];

				phoneList(phone);

				System.out.println("\nPlease enter the new city:");
				Scanner input = new Scanner(System.in);
				String newCity = input.nextLine();

				curRec[0] = entries.get(i).getFullName();
				curRec[1] = entries.get(i).getFirstName();
				curRec[2] = entries.get(i).getMiddleName();
				curRec[3] = entries.get(i).getLastName();
				curRec[4] = entries.get(i).getAddress().getStreet();
				curRec[5] = newCity;
				curRec[6] = entries.get(i).getAddress().getState();
				curRec[7] = entries.get(i).getAddress().getZipCode();
				curRec[8] = phone;

				entries.remove(entries.get(i));

				be1.setFullName(curRec[0]);
				be1.setFirstName(curRec[1]);
				be1.setMiddleName(curRec[2]);
				be1.setLastName(curRec[3]);
				be1.getAddress().setStreet(curRec[4]);
				be1.getAddress().setCity(curRec[5]);
				be1.getAddress().setState(curRec[6]);
				be1.getAddress().setZipCode(curRec[7]);
				be1.setPhone(curRec[8]);

				entries.add(be1);
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for phone number entered.");
		}
	}

	public void updateState(String phone) {
		BookEntry be1 = new BookEntry();
		be1.Address = new Address();
		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (phone.equals(entries.get(i).getPhone())) {
				recordFound = 1;
				String[] curRec = new String[9];

				phoneList(phone);

				System.out.println("\nPlease enter the new state:");
				Scanner input = new Scanner(System.in);
				String newState = input.nextLine();

				curRec[0] = entries.get(i).getFullName();
				curRec[1] = entries.get(i).getFirstName();
				curRec[2] = entries.get(i).getMiddleName();
				curRec[3] = entries.get(i).getLastName();
				curRec[4] = entries.get(i).getAddress().getStreet();
				curRec[5] = entries.get(i).getAddress().getCity();
				curRec[6] = newState;
				curRec[7] = entries.get(i).getAddress().getZipCode();
				curRec[8] = phone;

				entries.remove(entries.get(i));

				be1.setFullName(curRec[0]);
				be1.setFirstName(curRec[1]);
				be1.setMiddleName(curRec[2]);
				be1.setLastName(curRec[3]);
				be1.getAddress().setStreet(curRec[4]);
				be1.getAddress().setCity(curRec[5]);
				be1.getAddress().setState(curRec[6]);
				be1.getAddress().setZipCode(curRec[7]);
				be1.setPhone(curRec[8]);

				entries.add(be1);
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for phone number entered.");
		}
	}

	public void updateZip(String phone) {
		BookEntry be1 = new BookEntry();
		be1.Address = new Address();
		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (phone.equals(entries.get(i).getPhone())) {
				recordFound = 1;
				String[] curRec = new String[9];

				phoneList(phone);

				System.out.println("\nPlease enter the new zip code:");
				Scanner input = new Scanner(System.in);
				String newZip = input.nextLine();

				curRec[0] = entries.get(i).getFullName();
				curRec[1] = entries.get(i).getFirstName();
				curRec[2] = entries.get(i).getMiddleName();
				curRec[3] = entries.get(i).getLastName();
				curRec[4] = entries.get(i).getAddress().getStreet();
				curRec[5] = entries.get(i).getAddress().getCity();
				curRec[6] = entries.get(i).getAddress().getState();
				curRec[7] = newZip;
				curRec[8] = phone;

				entries.remove(entries.get(i));

				be1.setFullName(curRec[0]);
				be1.setFirstName(curRec[1]);
				be1.setMiddleName(curRec[2]);
				be1.setLastName(curRec[3]);
				be1.getAddress().setStreet(curRec[4]);
				be1.getAddress().setCity(curRec[5]);
				be1.getAddress().setState(curRec[6]);
				be1.getAddress().setZipCode(curRec[7]);
				be1.setPhone(curRec[8]);

				entries.add(be1);
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for phone number entered.");
		}
	}

	public void firstNameList(String fName) {

		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (fName.equals(entries.get(i).getFirstName())) {
				recordFound = 1;
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for name entered.");
		}
	}

	public void lastNameList(String lName) {

		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (lName.equals(entries.get(i).getLastName())) {
				recordFound = 1;
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for name entered.");
		}
	}

	public void fullNameList(String flName) {

		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (flName.equals(entries.get(i).getFullName())) {
				recordFound = 1;
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for name entered.");
		}
	}

	public void phoneList(String phone) {

		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (phone.equals(entries.get(i).getPhone())) {
				recordFound = 1;
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for phone number entered.");
		}
	}

	public void cityList(String city) {

		// BookEntry be1 = new BookEntry();
		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (city.equals(entries.get(i).getAddress().getCity())) {
				recordFound = 1;
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for city entered.");
		}
	}

	public void stateList(String state) {

		entries = getEntries();

		int recordFound = 0;

		for (int i = 0; i < entries.size(); i++) {
			if (state.equals(entries.get(i).getAddress().getState())) {
				recordFound = 1;
				System.out.println(this.entries.get(i));
			}
		}
		if (recordFound == 0) {
			System.out.println("No records found for state entered.");
		}
	}
}
