
import java.util.*;
import java.util.Map.Entry;

//Subjects is an abstract class, therefore it's not possible to create any objects from this class. 
//All classes that extend it will inherit all the attributes and methods below.
//And, as long as they are not abstract, will be able to create objects.
public abstract class Subjects {
	// studentlist attribute will constist of a hashmap with Student object as key
	// and Integer as value.
	protected HashMap<Student, Integer> studentList;

	// subjects constructor
	public Subjects() {
		// initializing studentList object.
		studentList = new HashMap<Student, Integer>();
	}

	// will register student passed as parameter by add it as key to studentList
	// hashmap object. As value, a new random int will be generated.
	public void registerStudent(Student myStudent) {
		int mark = markGenerator();
		studentList.put(myStudent, mark);
	}

	// generates a random int to attribute to each new student assigned to the
	// subject.
	public int markGenerator()

	{
		Random rand = new Random(); // instance of random class
		// generate random values from 0-100
		int random = rand.nextInt(100);
		return random;
	}

	// checks if studentList hashmap has a key that matches the Student object
	// passed as method parameter
	public boolean checkStudent(Student student) {
		if (studentList.containsKey(student)) {
			return true;
		} else {
			return false;
		}
	}

	// will print all students in subject by looping through all keys in studentList
	// hashmap and prints them out.
	public void printStudents() {
		for (Student i : studentList.keySet()) {
			System.out.println(i.getName());
		}
	}

	// returns arraylist of failing students by looping through all entries in
	// studentList hashmap and checking if the entry's value (mark) is less than 40.
	public ArrayList<Student> failingStudents() {

		ArrayList<Student> failing = new ArrayList<Student>();
		for (Entry<Student, Integer> entry : studentList.entrySet()) {
			if (entry.getValue() < 40) {
				failing.add(entry.getKey());
			}
		}
		return failing;
	}

	// gets subjects average grade by adding all values from studentList hashmap and
	// dividing it by arratList allGrades size.
	public int averageGrade() {
		int average = 0;
		ArrayList<Integer> allGrades = new ArrayList<Integer>();
		for (int mark : studentList.values()) {
			allGrades.add(mark);
			average += mark;
		}
		if (allGrades.size() > 0) {
			return average / allGrades.size();
		} else {
			return average;
		}

	}

	// overloads averageGrade by adding weighting parameter.
	public int averageGrade(int weighting) {
		return 0;
	}

	// toString method will return items in studentList.
	@Override
	public String toString() {
		return "Subjects [studentList=" + studentList + "]";
	}

}
