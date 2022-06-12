package epptec.Exception;

public class PersonAlreadyExistsException extends Exception {
	public PersonAlreadyExistsException() {
		super("Person with this birth number already exists in the database.");
	}
}
