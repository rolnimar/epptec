package epptec.Service;

import epptec.Entity.Person;
import epptec.Exception.PersonAlreadyExistsException;
import epptec.Exception.PersonNotFoundException;
import epptec.Repository.PersonRepository;
import epptec.Repository.PersonRepositoryImpl;

import java.util.Collection;

public class PersonService {
	private static final PersonService instance = new PersonService();
	private static final PersonRepository personRepository = PersonRepositoryImpl.getInstance();
	private static final BirthNumberService birthNumberService = BirthNumberService.getInstance();

	public static PersonService getInstance() {
		return instance;
	}
	private PersonService(){
	}

	public void savePerson(Person person) throws PersonAlreadyExistsException {
		personRepository.savePerson(person);
	}


	public Person findPerson(String birthNumber) throws PersonNotFoundException {
		Person person = personRepository.fetchPersonByBirthNumber(birthNumber);
		person.setAge(birthNumberService.calculateAgeFromBirthNumber(birthNumber));
		return person;
	}

	public Collection<Person> getAllPersons() {
		Collection<Person> personCollection = personRepository.fetchAllPersons();
		for(Person person: personCollection){
			person.setAge(calculateAge(person));
		}
		return personCollection;
	}

	public void deletePersonByBirthNumber(String birthNumber) throws PersonNotFoundException {
		personRepository.deletePersonByBirthNumber(birthNumber);
	}

	private Integer calculateAge(Person person){
		return birthNumberService.calculateAgeFromBirthNumber(person.getBirthNumber());
	}
}
