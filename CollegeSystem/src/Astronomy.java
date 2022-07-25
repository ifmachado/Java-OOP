
//Astronomy class is a child class from Subjects. It inherits all attributes from parent class.
public class Astronomy extends Subjects

{
	// Astronomy constructor inheriting from superclass
	public Astronomy() {
		super();
	}

	// toString method will output student list, failing students and average grade.
	@Override
	public String toString() {
		return "Astronomy [studentList=" + studentList + ", failingStudents()=" + failingStudents()
				+ ", averageGrade()=" + averageGrade() + "]";
	}

}
