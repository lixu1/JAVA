import java.util.Scanner; 
public class reverseString 
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in); 
		//输入一个字符串 
		System.out.println("请输入字符串");
		String a =input.next(); 	
		System.out.print("翻转后为：");
		for(int i=a.length()-1;i>=0;i--)
		{
			   System.out.print(a.charAt(i));
		}
		input.close();

	}

}
