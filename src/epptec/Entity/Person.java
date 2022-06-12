package epptec.Entity;


public class Person {
	private final String name;
	private final String surname;
	private final String birthNumber;
	private Integer age;

	public Person(String name, String surname, String birthNumber) {
		this.name = name;
		this.surname = surname;
		this.birthNumber = birthNumber;
	}

	@Override
	public String toString() {
		return "Birth number: ".concat(birthNumber)
						.concat(", Surname: ")
						.concat(surname)
						.concat(", Name: ")
						.concat(name)
						.concat(", Age: ")
						.concat(age.toString());
	}

	public String getBirthNumber() {
		return birthNumber;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


}
