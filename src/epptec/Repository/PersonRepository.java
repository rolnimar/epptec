package epptec.Repository;

import epptec.Entity.Person;
import epptec.Exception.PersonAlreadyExistsException;
import epptec.Exception.PersonNotFoundException;

import java.util.Collection;

public interface PersonRepository {
	Person fetchPersonByBirthNumber(String birthId) throws PersonNotFoundException;
	void savePerson(Person person) throws PersonAlreadyExistsException;
	void deletePersonByBirthNumber(String birthId) throws PersonNotFoundException;
	Collection<Person> fetchAllPersons();
}
