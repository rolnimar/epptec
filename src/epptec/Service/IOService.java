package epptec.Service;

import epptec.Entity.Person;
import epptec.Util.BirthNumberUtil;

import java.util.Collection;
import java.util.Scanner;

public class IOService {
	private final Scanner scanner;
	private static final IOService instance = new IOService();

	public static IOService getInstance(){
		return instance;
	}
	private IOService(){
		scanner = new Scanner(System.in);
	}

	public void printOptions(){
		printLine("Write a number of an action you want to perform:");
		printLine("1 - Find a person.");
		printLine("2 - Create new person.");
		printLine("3 - Delete a person.");
		printLine("4 - Exit the program.");
	}


	public String scanString(){
		String input = scanner.nextLine();
		while(input.equals("")){
			printLine("Try entering non empty input.");
			input = scanner.nextLine();
		}
		return input.trim();
	}

	public void printBirthNumberInput() {
		printLine("Enter birth number of a person.");
	}

	public void printWrongBirthNumberFormat() {
		printLine("Format of a birth number is YYMMDDXXXX or YYMMDD/XXXX. Try again.");
	}

	public void printPerson(Person person) {
		if(person == null){
			printLine("Person could not be found.");
		} else {
			printLine(person);
		}

	}

	public String scanBirthNumber() {
		String birthNumber = scanString();
		while(!BirthNumberUtil.isRightFormat(birthNumber)){
			printWrongBirthNumberFormat();
			birthNumber = scanString();
		}
		return BirthNumberUtil.normalizeBirthNumber(birthNumber);
	}

	public void printAllPersons(Collection<Person> personList) {
		printLine("------------------------------------");
		for(Person person : personList){
			printPerson(person);
		}
		printLine("------------------------------------");
	}

	public void printChoosePerson() {
		printLine("Choose a person to delete by writing its birth number.");
	}

	public void printCreatePerson() {
		printLine("Some parameters are needed to create a person.");
	}

	public void printBirthNumberPrompt() {
		printLine("Please enter the birth number of a person you want to create:");
	}

	public void printNamePrompt() {
		printLine("Please enter the name of a person you want to create:");
	}

	public void printSurnamePrompt() {
		printLine("Please enter the surname of a person you want to create:");
	}

	public <T> void printLine(T message){
		System.out.println(message);
	}


	public void printInvalid() {
		printLine("Write a valid option please.");
	}

	public void printContinue() {
		printLine("If you want to continue, write y. If you want to exit the program, write n.");
	}

	public void wrongContinueInput() {
		printLine("Wrong input. Try writing n or y.");
	}

	public void printCurrentDatabaseState(Collection<Person> allPersons) {
		printLine("Current database state: ");
		printAllPersons(allPersons);
	}
}
