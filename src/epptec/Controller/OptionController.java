package epptec.Controller;

import epptec.Entity.Person;
import epptec.Exception.PersonAlreadyExistsException;
import epptec.Exception.PersonNotFoundException;
import epptec.Service.PersonService;

import java.util.Collection;

public class OptionController {
	private final IOController ioController;
	private final PersonService personService;
	private boolean exit = false;

	public OptionController(){
		this.ioController = new IOController();
		this.personService = PersonService.getInstance();
	}

	public void init() {

		do {
			ioController.printOptions();
			String option = ioController.scanString();
			switch (option) {
				case "1" -> handleFindPerson();
				case "2" -> handleCreatePerson();
				case "3" -> handleDeletePerson();
				case "4" -> exit = true;
				default -> ioController.printValid();
			}
		} while (!exit);
	}

	private void handleDeletePerson() {
		Collection<Person> personList = personService.getAllPersons();
		if(personList.isEmpty()){
			ioController.printLine("Database is empty.");
			handleNextAction();
			return;
		}
		ioController.printAllPersons(personList);
		ioController.printChoosePerson();
		String birthNumber = ioController.scanBirthNumber();
		try{
			personService.deletePersonByBirthNumber(birthNumber);
			ioController.printCurrentDatabaseState(personService.getAllPersons());
		} catch (PersonNotFoundException ex){
			ioController.printLine(ex.getMessage());
		}
		handleNextAction();
	}

	private void handleCreatePerson() {
		ioController.printCreatePerson();
		ioController.printBirthNumberPrompt();
		String birthNumber = ioController.scanBirthNumber();
		ioController.printNamePrompt();
		String name = ioController.scanString();
		ioController.printSurnamePrompt();
		String surname = ioController.scanString();
		try{
			Person person = new Person(name,surname,birthNumber);
			personService.savePerson(person);
			ioController.printCurrentDatabaseState(personService.getAllPersons());
		} catch (PersonAlreadyExistsException ex){
			ioController.printLine(ex.getMessage());
		}
		handleNextAction();
	}

	private void handleFindPerson() {
		ioController.printBirthNumberInput();
		String birthNumber = ioController.scanBirthNumber();
		try{
			Person person = personService.findPerson(birthNumber);
			ioController.printPerson(person);
		} catch(PersonNotFoundException ex){
			ioController.printLine(ex.getMessage());
		}
		handleNextAction();
	}

	private void handleNextAction() {
		ioController.printContinue();
		String input = ioController.scanString();
		while(!input.equals("n") && !input.equals("y")){
			ioController.wrongContinueInput();
			input = ioController.scanString();
		}
		if(input.equals("n")){
			exit = true;
		}

	}
}
