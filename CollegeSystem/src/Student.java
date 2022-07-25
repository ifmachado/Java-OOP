
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student extends Person {
	// private var id, won't be able to be accessed from other classes.
	private String id;

	// constructor inheriting from superclass and adding attribute id during object
	// creation.
	public Student(String name) {
		super(name);
		this.id = idGenerator(name);
	}

	// id getter - access point to getting variable id's value.
	public String getId() {
		return this.id;
	}

	// generates unique id by getting first letter of parameter name + String with
	// day, month, hours, minutes, seconds and millisecond of method calling.
	public static String idGenerator(String name) {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMHHmmssSS");
		String formattedTime = date.format(format);
		String id = Character.toString(name.charAt(0)) + formattedTime;
		return id;
	}

	// will return a string with id and name attributes.
	@Override
	public String toString() {
		return "Student [id=" + getId() + ", name=" + getName();
	}

}
