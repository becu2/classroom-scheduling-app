public class CourseList {
	
	private class CourseListNode
	{
		public CourseListNode next;
		public CourseListNode prev;
		Course course;
		public CourseListNode(Course course) {
			this.course = course;
		}

	}
	
	CourseListNode head = null;
	CourseListNode tail = null;
	int size;
	
	public void insert(Course course)
	{
		size++;
		CourseListNode node = new CourseListNode(course);
		if(head == null)
		{
			head = node;
			tail = node;
			return;
		}
		if(head.next == null)
		{
			//if head comes before new node
			if(head.course.courseName.compareTo(course.courseName) < 0)
			{
				node.next = head;
				head.prev = node;
				head.next = null;
				tail = node;
			} //otherwise
			else
			{
				head.next = node;
				node.prev = head;
				tail = node;
			}

			return;
		}
				
		CourseListNode curr = head;
		while(curr != null)
		{
			System.out.println("I'm on " + curr.course.courseName);
			if(curr.course.courseName.compareTo(course.courseName)>0)
			{
				if(curr == head)
				{
					head.prev = node;
					node.next = head;
					head = node;
				}
				node.next = curr;
				node.prev = curr.prev;
				curr.prev = node;
				curr.prev.next = node;
				return;
			}
		}
		
		tail.next = node;
		node.prev = tail;
		tail = node;
	}
	
	public void remove(int index)
	{
		//TODO: Implement
	}
	
	public Course[] toArray()
	{
		Course[] courses = new Course[size];
		CourseListNode curr = head;

		for(int i = 0; i < size; i++)
		{
			System.out.println(curr.course.courseName);
			courses[i] = curr.course;
			curr = curr.next;
		}
		return courses;
	}
	
	public Course[] toArrayByHour()
	{
		Course[] courses = new Course[size];
		for(int i = 0; i < size; i ++)
		{
			for(int j = i; j < size; j++)
			{
				if(courses[j].startingHour < courses[i].startingHour)
				{
					Course temp = courses[j];
					courses[j] = courses[i];
					courses[i] = courses[j];
				}
			}
		}
		
		return courses;
	}

	public int getCreditHourTotal() {
		int total = 0;
		for(CourseListNode curr = head; curr != null; curr = curr.next)
		{
			total+= curr.course.creditHours;
		}
		return total;
	}
	
	
}
