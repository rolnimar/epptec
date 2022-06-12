package epptec.Repository;

import epptec.Entity.Person;
import epptec.Exception.PersonAlreadyExistsException;
import epptec.Exception.PersonNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class PersonRepositoryImpl implements PersonRepository {
	private static final PersonRepositoryImpl instance = new PersonRepositoryImpl();

	private final HashMap<String, Person> personDatabase = new HashMap<>();

	public static PersonRepositoryImpl getInstance(){
		return instance;
	}

	private PersonRepositoryImpl(){

	}

	@Override
	public Person fetchPersonByBirthNumber(String birthId) throws PersonNotFoundException {
		Person person = personDatabase.get(birthId);
		if(person == null){
			throw new PersonNotFoundException();
		} else {
			return person;
		}
	}

	@Override
	public void savePerson(Person person) throws PersonAlreadyExistsException {
		if(personDatabase.get(person.getBirthNumber()) != null){
			throw new PersonAlreadyExistsException();
		} else {
			personDatabase.put(person.getBirthNumber(),person);
		}
	}

	@Override
	public void deletePersonByBirthNumber(String birthId) throws PersonNotFoundException {
		if(personDatabase.remove(birthId) == null){
			throw new PersonNotFoundException();
		}
	}

	@Override
	public Collection<Person> fetchAllPersons() {
		return personDatabase.values();
	}
}
