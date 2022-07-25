
public class Gastronomy extends Subjects {
	// private var practicalGrade, won't be able to be accessed from other classes.
	private int practicalGrade;

	// Gastronomy constructor inheriting from superclass
	public Gastronomy() {
		super();
	}

	// COMMENTED BECAUSE MIGHT NOT BE WORKING
	// Overrides parent method to add weighting to grade in Gastronomy, as this
	// subject has practical assessment as part of the final grade
//	public int averageGrade(int weighting) {
//		this.practicalGrade = markGenerator();
//		int finalGrade = ((practicalGrade * ((100-weighting)/100)) + (super.averageGrade() * (weighting/100)));
//		return finalGrade;
//	}

	// Overrides parent method by adding a new return syntax. Grade in Gastronomy
	// will be 60% marks, 40% work placement.
	@Override
	public int averageGrade(int weighting) {

		return super.averageGrade() * (weighting / 100);
	}

	// practicalGrade getter - access point to getting variable praticalGrade's
	// value.

	public int getPracticalGrade() {
		return practicalGrade;
	}

	// practicalGrade getter - access point to setting variable praticalGrade's
	// value.
	public void setPracticalGrasee(int practicalGrade) {
		this.practicalGrade = practicalGrade;
	}

	// toString method will output student list, failing students and average grade.
	@Override
	public String toString() {
		return "Gastronomy [studentList=" + studentList + ", failingStudents()=" + failingStudents()
				+ ", averageGrade()=" + averageGrade();
	}

}
