
public class StudentGPA 
{
	String name,identificationNumber;
	public StudentGPA()
	{
		
	}
	public StudentGPA(String name)
	{
		this.name=name;
	}
	
	public double Grade(char course)
	{
		if(course=='A') return 4;
		else if(course=='B') return 3;
		else if(course=='C') return 2;
		else if(course=='D') return 1;
		else return 0;
	}
	public double computeGPA(char course1,char course2)
	{
		double a1=Grade(course1);
		double a2=Grade(course2);
		return (a1+a2)/2;
	}
	public double computeGPA(char course1,char course2,char course3)
	{
		double a1=Grade(course1);
		double a2=Grade(course2);
		double a3=Grade(course3);
		return (a1+a2+a3)/3;
	}
	public double computeGPA(char course1,char course2,char course3,char course4)
	{
		double a1=Grade(course1);
		double a2=Grade(course2);
		double a3=Grade(course3);
		double a4=Grade(course4);
		return (a1+a2+a3+a4)/4;
	}
	public double computeGPA(char course1,char course2,char course3,char course4,char course5)
	{
		double a1=Grade(course1);
		double a2=Grade(course2);
		double a3=Grade(course3);
		double a4=Grade(course4);
		double a5=Grade(course5);
		return (a1+a2+a3+a4+a5)/5;
	}
	public void studentInfo()
	{
		System.out.println("the student name is" + name);
	}
	public void studentInfo(String name,String identificationNumber)
	{
		System.out.println("the student name is" + name+"his identification number is "+ identificationNumber);
	}
	public static void main(String args[])
	{
		StudentGPA s1=new StudentGPA();
		System.out.println("a student taking two courses and gets grades A and a B"
				+"his GPA = "+s1.computeGPA('A', 'B'));
		System.out.println("a student taking three courses and gets grades A, B, and a C"
				+"his GPA = "+s1.computeGPA('A', 'B','C'));
		System.out.println("a student taking four courses and gets grades, A, B, C, and an A"
				+"his GPA = "+s1.computeGPA('A', 'B','C','A'));
		System.out.println("a student taking five courses and gets grades A, B, C, A, and D"
				+"his GPA = "+s1.computeGPA('A', 'B','C','A','D'));
		System.out.println("Student s1£º");
		s1.studentInfo("Bob","1234567");
		
		StudentGPA s2=new StudentGPA("Todd");
		System.out.println("Student s2:");
		s2.studentInfo();
		
	}

}
