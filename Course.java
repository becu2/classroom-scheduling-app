public class Course {
	public String department;
	public int courseNumber;
	public String description;
	public int startingHour;
	public boolean requiredForMajor;
	public int creditHours;
	public char[] daysOfWeek;
	public String courseName;

	public Course(String department, int courseNumber, String description, int startingHour, boolean requiredForMajor,
			int creditHours, char[] daysOfWeek) {
		this.department = department;
		this.courseNumber = courseNumber;
		this.description = description;
		this.startingHour = startingHour;
		this.requiredForMajor = requiredForMajor;
		this.creditHours = creditHours;
		this.daysOfWeek = daysOfWeek;
		courseName = department + courseNumber;
	}

}
