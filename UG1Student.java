
public class UG1Student extends Student{
	//a)
	private char mainSchedule ;
	//b)
	public UG1Student(String name, String uun,char mainSchedule )
	{
		super(name,uun,1);
		this.mainSchedule=mainSchedule;
	}
	public UG1Student()
	{
		super("not set","not set",1);
	}
	//c)
	public boolean addCourse(Course course)
	{
		if(course.getLevel()==7 || course.getLevel()==8)
		{
			super.addCourse(course);
			return true;
		}
		else
		{
			return false;
		}
	}
	//d)
	public boolean addCourses(Course[] courses)
	{
		for(int i=0;i<courses.length;i++)
		{
			if((courses[i]!=null)  && (addCourse(courses[i])==false))
					{
						return false;
					}
		}
		return true;
	}
	//e)
	public String toString()
	{
		String string = null;
		string = super.toString()+"/n";
		string+="Main Schedule" + mainSchedule +"courses" +"/n";
		String courses = super.getCourses().toString();
		String [] c =courses.split(" ");
		for(int i=0;i<c.length;i++)
		{
			string+=c[i]+"/n";
		}
		return string;
	}
	public static void main(String[] args)
	{
		UG1Student u = new UG1Student("David Parnas", "s0000000", 'O');
	}

}
