import java.util.Scanner; 
public class reverseString 
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in); 
		//����һ���ַ��� 
		System.out.println("�������ַ���");
		String a =input.next(); 	
		System.out.print("��ת��Ϊ��");
		for(int i=a.length()-1;i>=0;i--)
		{
			   System.out.print(a.charAt(i));
		}
		input.close();

	}

}
