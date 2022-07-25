
public class Person {
	// variables storing name and age values
	protected String name = "";

	// person constructor
	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Person [name=" + getName();
	}

}
