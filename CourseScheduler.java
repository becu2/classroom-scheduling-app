
public class CourseScheduler {
	
	private CourseList courses = new CourseList();
	
	
	
	public void add(String department, int courseNumber, String description, int startingHour, boolean requiredForMajor, int creditHours, char[] daysOfWeek)
	{
		Course course = new Course(department, courseNumber, description, startingHour, requiredForMajor, creditHours, daysOfWeek);
		courses.insert(course);
	}
	
	public void remove(int index)
	{
		courses.remove(index);
	}
	
	public void displayCoursesAlphabetically()
	{
		Course[] coursesArray = courses.toArray();
		for(int i = 0; i < coursesArray.length; i++)
		{
			Course course = coursesArray[i];
			String courseName = course.courseName;
			if(course.requiredForMajor)
				courseName+="*";
			
			String line = courseName + "|" + 
					course.courseNumber + "|" + course.description + "|" + 
					course.daysOfWeek.toString() + "|" + course.creditHours + "|" +
					course.startingHour;
			System.out.println(""+i+") " + line);
		}
		
	}
	
	public void displayCoursesInMajor()
	{
		Course[] coursesArray = courses.toArray();
		for(int i = 0; i < coursesArray.length; i++)
		{
			Course course = coursesArray[i];
			if(!course.requiredForMajor)
				continue;
			String line = course.courseName + "|" +
					course.courseNumber + "|" + course.description + "|" +
					course.daysOfWeek.toString() + "|" + course.creditHours + "|" +
					course.startingHour;
			System.out.println(""+i+") " + line);
	   	}
	}

	public void displayScheduleForDay(char day)
	{
		Course[] coursesArray = courses.toArray();
		for(int i = 0; i < coursesArray.length; i++)
		{
			Course course = coursesArray[i];
			String days = course.daysOfWeek.toString();
			if(!days.contains(""+day))
				continue;
			String line = course.courseName + "|" +
					course.courseNumber + "|" + course.description + "|" +
					course.daysOfWeek.toString() + "|" + course.creditHours + "|" +
					course.startingHour;
			System.out.println(""+i+") " + line);
		}		
	}
	
	public int totalNumberOfCreditHours()
	{
		return courses.getCreditHourTotal();
	}
	
}
