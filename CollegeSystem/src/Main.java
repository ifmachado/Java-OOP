import java.util.ArrayList;
import java.util.Scanner;

public class Main

{
	public static void main(String[] args) {
		// creates new objects for each of the subject's classes
		Fashion fashion = new Fashion();
		Gastronomy gastronomy = new Gastronomy();
		Astronomy astronomy = new Astronomy();

		// created new arraylist object to store all students
		ArrayList<Student> allStudents = new ArrayList<Student>();

		while (true) {
			// calls mainMenu method to print menu options
			mainMenu();
			System.out.println("Enter your choice: ");

			// creates new scanner object
			Scanner scan = new Scanner(System.in);

			// gets user input
			String userInput = scan.nextLine();

			// validates user input by calling validateInput method with 0 as smallest
			// choice number and 7 as highest.
			int choice = validateInput(userInput, 0, 7);

			// case switch will use user's option (choice)
			switch (choice) {
			// leaves program
			case 0:
				System.out.println("Leaving the program...");
				System.exit(0);
				break;

			// asks for name input, creates a new student object, adds new object created to
			// arrayList allStudents.
			case 1:
				System.out.println("Enter a name: ");
				String name = scan.next();
				Student newStudent = new Student(name);
				System.out.println(newStudent.getName() + " was sucessfully added under id number: "
						+ String.valueOf(newStudent.getId()));
				allStudents.add(newStudent);
				break;

			// asks for student id and subject inputs, checks if id in arrayList allStudents
			// and registers student to specific subject.
			case 2:
				System.out.println("Enter a student id: ");

				// id input
				String id = scan.nextLine();

				// calls method to print menu options
				subjectMenu();

				// subjects input
				String input = scan.nextLine();

				// validates subject input. 1 is lowest number on options and 3 is highest.
				int subject = validateInput(input, 1, 3);

				// loops through allStudents array
				for (Student student : allStudents) {
					// checks if the Student object's id is equal to inputed id
					if (student.getId().equals(id)) {
						switch (subject) {
						// subject 1 is fashion, so it will call fashion class registerStudent method
						// with Student as its parameter.
						case 1:
							fashion.registerStudent(student);
							System.out.println(student.getName() + " was successfully enrolled to Fashion Design.");
							break;

						// subject 2 is gastronomy, so it will call gastronomy class registerStudent
						// method with Student as its parameter.
						case 2:
							gastronomy.registerStudent(student);
							System.out.println(student.getName() + " was sucessfully enrolled to Gastronomy.");
							break;

						// subject 3 is astronomy, so it will call astronomy class registerStudent
						// method with Student as its parameter.
						case 3:
							astronomy.registerStudent(student);
							System.out.println(student.getName() + " was sucessfully enrolled to Astronomy.");
							break;
						}
					}

				}
				break;

			// asks for student id and subject inputs, checks if id in arrayList allStudents
			// and check if student is enrolled to specific subject.
			case 3:
				System.out.println("Enter a student id: ");
				String studentId = scan.nextLine();
				subjectMenu();

				// subject input
				String secondInput = scan.nextLine();

				// subject input validation
				int checkSubject = validateInput(secondInput, 1, 3);

				// loops through allStudents array
				for (Student student : allStudents) {
					// checks if the Student object's id is equal to inputed id
					if (student.getId().equals(studentId)) {
						switch (checkSubject) {
						case 1:
							// subject 1 is fashion, so it will call fashion class checkStudent method
							// will return True if student in fashion's hashmap studentList, then print
							// enrolled.
							// if return if false, print not enrolled.
							boolean fashionCheck = fashion.checkStudent(student);
							if (fashionCheck == true) {
								System.out.println(student.getName() + " is enrolled to Fashion Design.");

							} else {
								System.out.println(student.getName() + " is not enrolled to Fashion Design.");

							}
							break;

						// same as case one, but using gastronomy's checkStudent method and hashmap
						// studentList.
						case 2:
							boolean gastronomyCheck = gastronomy.checkStudent(student);
							if (gastronomyCheck == true) {
								System.out.println(student.getName() + " is enrolled to Gastronomy.");

							} else {
								System.out.println(student.getName() + " is not enrolled to Gastronomy.");

							}
							break;

						// same as case one, but using astronomy's checkStudent method and hashmap
						// studentList.
						case 3:
							boolean astronomyCheck = astronomy.checkStudent(student);
							if (astronomyCheck == true) {
								System.out.println(student.getName() + " is enrolled to Astronomy.");

							} else {
								System.out.println(student.getName() + " is not enrolled to Astronomy.");

							}
							break;
						}
					}

				}
				break;

			// gets user input for subject they want to check and will call that subject's
			// class method printStudents to
			// print all student objects stored as a key in the class' hashmap studentList.
			case 4:
				subjectMenu();
				String thirdInput = scan.nextLine();
				int subjectsTwo = validateInput(thirdInput, 1, 3);
				switch (subjectsTwo) {
				case 1:
					System.out.println("The following students are enrolled to Fashion:");
					fashion.printStudents();
					break;

				case 2:
					System.out.println("The following students are enrolled to Gastronomy:");
					gastronomy.printStudents();
					break;

				case 3:
					System.out.println("The following students are enrolled to Astronomy:");
					astronomy.printStudents();
					break;
				}
				break;

			// check all students that are not keys in any of the hashmap's from fashion,
			// gastronomy and astronomy.
			case 5:
				// new arraylist to store students not enrolled in any classes
				ArrayList<Student> notEnrolled = new ArrayList<Student>();

				// loops through all Student objects in allStudents array
				for (Student student : allStudents) {
					// checks if studen is not a key in any of the studentList objects in fashion,
					// gastronomy and astronomy
					if (!fashion.studentList.containsKey(student) & !gastronomy.studentList.containsKey(student)
							& !astronomy.studentList.containsKey(student)) {
						// if not in any of those, add to array not enrolled.
						notEnrolled.add(student);
					}
				}
				System.out.println("These students are not enrolled to any classes:");

				// loops through all the Student objects in not enrolled and prints their name
				// attributes.
				for (Student student : notEnrolled) {
					System.out.println(student.getName() + ",");

				}
				break;

			// returns the names of all students failing a class (grade < 40)
			case 6:
				// new array objects will get the values returned by each class' failingStudents
				// method.
				ArrayList<Student> failingFashion = fashion.failingStudents();
				ArrayList<Student> failingGastronomy = gastronomy.failingStudents();
				ArrayList<Student> failingAstronomy = astronomy.failingStudents();

				// checks the array size. if 0, no students are failing.
				if (failingFashion.size() == 0) {
					System.out.println("No students are failing Fashion Design.");
				}
				// if array size is larger than 0, prints name attribute from each Student
				// objects stored in the failing arrayList.
				else {
					System.out.println("Students failing failing Fashion Design:");
					for (Student student : failingFashion) {

						System.out.println(student.getName() + ",");
					}
				}

				// checks the array size. if 0, no students are failing.
				if (failingGastronomy.size() == 0) {
					System.out.println("No students are failing Gastronomy.");
				}

				// if array size is larger than 0, prints name attribute from each Student
				// objects stored in the failing arrayList.
				else {
					System.out.println("Students failing failing Gastronomy:");

					for (Student student : failingGastronomy) {

						System.out.println(student.getName() + ",");
					}
				}

				// checks the array size. if 0, no students are failing.
				if (failingAstronomy.size() == 0) {
					System.out.println("No students are failing Astronomy.");
				}

				// if array size is larger than 0, prints name attribute from each Student
				// objects stored in the failing arrayList.
				else {
					System.out.println("Students failing failing Astronomy:");
					for (Student student : failingAstronomy) {

						System.out.println(student.getName() + ",");
					}
				}
				break;

			// gets average grade for each subjects by calling their average Grade methods.
			case 7:
				subjectMenu();
				String forthInput = scan.nextLine();
				int subjectsThree = validateInput(forthInput, 1, 3);
				switch (subjectsThree) {
				case 1:
					System.out.println("Average grade for Fashion: " + Integer.toString(fashion.averageGrade()));
					break;

				case 2:
					// in gastronomy, averageGrade method was overloaded so it required a weighting
					// parameter
					System.out
							.println("Average grade for Gastronomy: " + Integer.toString(gastronomy.averageGrade(60)));
					break;

				case 3:
					System.out.println("Average grade for Astronomy: " + Integer.toString(astronomy.averageGrade()));

					break;
				}
				break;
			}

		}

	}

	// method to print main menu's options

	public static void mainMenu() {
		System.out.println("_________________________________________________________________________");
		System.out.println("Select an option below:");
		System.out.println("    0: Leave program.");
		System.out.println("    1: Add a new student.");
		System.out.println("    2: Register student to a class.");
		System.out.println("    3: Check if student is enrolled to a class.");
		System.out.println("    4: Get names for all students registered to a class.");
		System.out.println("    5: Check students not enrolled to any class.");
		System.out.println("    6: Check students failing a class.");
		System.out.println("    7: Check average mark for a class.");
		System.out.println("_________________________________________________________________________");

	}

	// method to print subject's menu options
	public static void subjectMenu() {
		System.out.println("Select a Subject:");
		System.out.println("    1: Fashion Design");
		System.out.println("    2: Gastronomy");
		System.out.println("    3: Astronomy");

	}

	public static int validateInput(String userOption, int min, int max) {
		Scanner myScan = new Scanner(System.in);
		// REGEX - check if a string only contains numbers
		if (userOption.matches("^[0-9]+$")) {
			// converting userOption from String to int
			int userinput = Integer.parseInt(userOption);

			// checking if in Menu range
			if (userinput < min || userinput > max) {
				System.out.println("This is not a valid input.Please re-enter:");
				String next = myScan.next();
				return validateInput(next, min, max);
			}

			return userinput;
		}
		// if doesn't contain numbers, ask for new input
		else {
			System.out.println("This is not a valid input.Please re-enter:");
			String next = myScan.next();
			return validateInput(next, min, max);
		}
	}
}
