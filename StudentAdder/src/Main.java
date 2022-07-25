
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static <T> void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// HashMap will store Integer ID and Student objects added.
		ArrayList<Student> students = new ArrayList<Student>();

		// new student objects
		Student jack = new Student("jack", 2001465, "OOP");
		Student jane = new Student("jane", 2001466, "Computer Networks");
		Student anna = new Student("anna", 2001467, "System Analysis");

		// add student objects to ArrayList
		students.add(jack);
		students.add(jane);
		students.add(anna);

		// print students in Arraylist
		printStudents(students);

		// sort students by ID through overridden compareTo method
		Collections.sort(students);

		// initialize comparator object to sort by name
		Comparator<Student> comp = Comparator.comparing(Student::getName);

		// sort students by name using comparator
		Collections.sort(students, comp);

		// print students in Arraylist

		printStudents(students);

		System.out.println(" ");

		while (true) {
			// get user input for ID to be checked
			System.out.println("Enter the ID you want to check or type 0 to leave the program:");
			Integer inputTwo = scan.nextInt();

			// check if input equals to exit code
			if (inputTwo == 0) {
				System.out.println("Leaving ID checker...");

				break;
			}

			else {
				String result = "This ID hasn't been registered yet.";

				// loop through student array
				for (Student student : students) {
					// gets student id from Student objects in the list and compares it with name
					// inputed by user.
					if (student.getID() == inputTwo) {
						// uses getName method in that Student object.
						result = "This ID belongs to " + student.getName() + ".";
						break;
					}

				}
				System.out.println(result);
			}

		}
	}

	// method to print student objects in arrayList. output will be name + ID +
	// module
	public static void printStudents(ArrayList<Student> list) {
		for (Student item : list) {
			System.out.println(item.getName() + " " + item.getID() + " " + item.getModule());
		}

	}

}
