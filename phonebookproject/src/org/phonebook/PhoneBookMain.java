package org.phonebook;

import java.util.*;

public class PhoneBookMain {

	public static void main(String[] args) {

		BookEntry pe1 = new BookEntry();
		pe1.Address = new Address();

		displayMenu();

	}

	public static void displayMenu() {

		PhoneBook pb1 = new PhoneBook();

		int function = 0;

		while (function != 6) {
			System.out.println("\nYou are running the phone book application.");
			System.out.println("Available Functions:");
			System.out.println("1. Add new record");
			System.out.println("2. Remove a record");
			System.out.println("3. Update a record");
			System.out.println("4. Search for a record");
			System.out.println("5. Display all records in directory");
			System.out.println("6. Exit");
			System.out.println("Please select the number of the function you would like to perform.");
			Scanner input = new Scanner(System.in);
			function = input.nextInt();

			switch (function) {
			case 1:
				System.out.println("\nYou selected to add a record.");
				pb1.addEntry();
				break;
			case 2:
				System.out.println("\nYou selected to remove a record.");
				System.out.println("\nPlease enter the phone number (eg: (123)-456-7890) of the record to remove:");
				Scanner phoneDelete = new Scanner(System.in);
				String phone = phoneDelete.nextLine();
				
				pb1.removeEntry(phone);
				break;
			case 3:
				System.out.println("Function 3");
				pb1.updateEntry();
				break;
			case 4:
				System.out.println("\nPlease choose the number of the method you want to use to search:");
				System.out.println("1. Search by First name");
				System.out.println("2. Search by Last name");
				System.out.println("3. Search by Full name (First middle last)");
				System.out.println("4. Search by Phone number");
				System.out.println("5. Search by City");
				System.out.println("6. Search by State");
				int function2 = 0;
				Scanner input4 = new Scanner(System.in);
				function2 = input4.nextInt();
				if (function2 == 1) {
					System.out.println("\nPlease enter the person's first name:");
					Scanner fNameIn = new Scanner(System.in);
					String fname = fNameIn.nextLine();
					pb1.firstNameList(fname);
				} else if (function2 == 2) {
					System.out.println("\nPlease enter the person's last name:");
					Scanner lNameIn = new Scanner(System.in);
					String lname = lNameIn.nextLine();
					pb1.lastNameList(lname);
				} else if (function2 == 3) {
					System.out.println("\nPlease enter the person's full name (eg: first middle last):");
					Scanner flNameIn = new Scanner(System.in);
					String fullname = flNameIn.nextLine();
					pb1.fullNameList(fullname);
				} else if (function2 == 4) {
					System.out.println("\nPlease enter the person's phone number (eg: (123)-456-7890):");
					Scanner phoneIn = new Scanner(System.in);
					phone = phoneIn.nextLine();
					pb1.phoneList(phone);
				} else if (function2 == 5) {
					System.out.println("\nPlease enter the person's City:");
					Scanner cityIn = new Scanner(System.in);
					String city = cityIn.nextLine();
					pb1.cityList(city);
				} else if (function2 == 6) {
					System.out.println("\nPlease enter the person's State:");
					Scanner stateIn = new Scanner(System.in);
					String state = stateIn.nextLine();
					pb1.stateList(state);
				} else {
					System.out.println("Invalid function");
				}
				break;
			case 5:
				pb1.displayDirectory();
				break;
			case 6:
				System.out.println("You chose to exit the program.");
				break;
			default:
				System.out.println("Invalid function, please try again.");
				break;
			}
		}
		System.out.println("Exit program");
	}
}
