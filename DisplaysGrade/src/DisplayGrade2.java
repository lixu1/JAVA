
public class DisplayGrade2 
{
	public static void main(String args[])
	{
		System.out.println("输入你的考试成绩");
		KeyBoardReader k=new KeyBoardReader();
		double grade=k.readDouble();
		System.out.println("你的grade是：");
		int g=0;
		if(grade>=90) g=1;
		else if(grade>=80) g=2;
		else if(grade>=70) g=3;
		else if(grade>=60) g=4;
		else g=5;
		switch(g)
		{
		case 1:
			System.out.println("A");
			break;
		case 2:
			System.out.println("B");
			break;
		case 3:
			System.out.println("C");
			break;
		case 4:
			System.out.println("D");
			break;
		case 5:
			System.out.println("F");
			break;
		default:
			System.out.println("错误的成绩");
				
		}
	}

}
