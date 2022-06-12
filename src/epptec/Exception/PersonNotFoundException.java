package epptec.Exception;

public class PersonNotFoundException extends Exception{
	public PersonNotFoundException(){
		super("Person was not found in the database.");
	}
}
