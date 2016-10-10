import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		CourseScheduler cs = new CourseScheduler();
		while (true) {
			String menu = "Welcome to Course Scheduler\n" + 
		"Please select an option\n" + 
					"1) Add\n" + 
		"2) Remove\n" + 
					"3) Display Courses Alphabetically\n" + 
		"4) Display Course in Major\n" + 
					"5) Display Schedule for Day\n" + 
		"6) Display Total Number of Credit Hours\n" + 
					"7) Quit\n";
			System.out.println(menu);
			int option = -1;
			try {
				option = TextIO.getlnInt();
				if (option < 1 || option > 7)
					throw new InputMismatchException();
			} catch (InputMismatchException ex) {
				System.out.println("Please input a valid number between 1 and 7.");
			}
			
			switch(option)
			{
			case 1:
				System.out.println("Please enter the following information");
				System.out.println("Department: ");
				String department = TextIO.getln();
				System.out.println("Course Number: "); //TODO
				int courseNumber = TextIO.getlnInt();
				System.out.println("Description: ");
				String description = TextIO.getln();
				System.out.println("Starting Hour: ");
				int startingHour = TextIO.getlnInt();
				System.out.println("Required For Major (true/false): ");
				boolean requiredForMajor = TextIO.getlnBoolean();
				System.out.println("Credit Hours: ");
				int creditHours = TextIO.getlnInt();
				System.out.println("Days of the Week (MTWRF): ");
				char[] daysOfWeek = TextIO.getln().toCharArray();
				cs.add(department, courseNumber, description, startingHour, requiredForMajor, creditHours, daysOfWeek);
				System.out.println("Course has been sucessfully added!");
				break;
			case 2:
				cs.displayCoursesAlphabetically();
				System.out.println("Type the number next to the Course you'd like to remove:");
				int index = TextIO.getlnInt();
				cs.remove(index);
				break;
			case 3:
				cs.displayCoursesAlphabetically();
				break;
			case 4:
				cs.displayCoursesInMajor();
				break;
			case 5:
				System.out.println("Which day would you like to see?");
				char day = TextIO.getlnChar(); //get the first character
				cs.displayScheduleForDay(day);
				break;
			case 6:
				System.out.println("Total number of credit hours: " + cs.totalNumberOfCreditHours());
				break;
			case 7:
				System.out.println("Are you sure you want to quit? - all your data will be lost.");
				String response = TextIO.getln();
				if(response == "yes")
					System.exit(0);
				break;
			}
			System.out.println("Hit enter to continue...");
			TextIO.getln();
		}

	}

}
