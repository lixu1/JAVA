
public class DisplaysGrade 
{
	public static void main(String args[])
	{
		System.out.println("������Ŀ��Գɼ�");
		KeyBoardReader k=new KeyBoardReader();
		double grade=k.readDouble();
		System.out.println("���grade�ǣ�");
		if(grade>=90) System.out.println("A");
		else if(grade>=80) System.out.println("B");
		else if(grade>=70) System.out.println("C");
		else if(grade>=60) System.out.println("D");
		else System.out.println("F");
	}

}
