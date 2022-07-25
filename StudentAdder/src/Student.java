
//this class implements the comparable interface
public class Student implements Comparable<Student> {
	// global variables for student name, id and module
	private String name = "";
	private int id = 0;
	private String module = "";

	// Studen constructor
	public Student(String mName, int mID, String mModule) {
		name = mName;
		id = mID;
		module = mModule;
	}

	// name setter
	public void setName(String mName) {
		name = mName;
	}

	// name getter
	public String getName() {
		return name;
	}

	// id setter
	public void setID(int mID) {
		id = mID;
	}

	// id getter
	public int getID() {
		return id;
	}

	// module setter
	public void setModule(String mModule) {
		module = mModule;
	}

	// module getter
	public String getModule() {
		return module;
	}

	// compares id values between objects
	@Override
	public int compareTo(Student st) {

		// if value is the same, return 0
		if (st.id == this.id) {
			return 0;
		}
		// if value is less than, return -1

		else if (st.id < this.id) {
			return -1;
		}

		// if value is greater than, return 1
		else {
			return 1;
		}
	}

}
