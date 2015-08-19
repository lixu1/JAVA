
public class DisplaysGrade 
{
	public static void main(String args[])
	{
		System.out.println("输入你的考试成绩");
		KeyBoardReader k=new KeyBoardReader();
		double grade=k.readDouble();
		System.out.println("你的grade是：");
		if(grade>=90) System.out.println("A");
		else if(grade>=80) System.out.println("B");
		else if(grade>=70) System.out.println("C");
		else if(grade>=60) System.out.println("D");
		else System.out.println("F");
	}

}
