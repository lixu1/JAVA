
public class aCastExample 
{
	public static void main(String args[])
	{
		short a=100;
		long b=a;
		System.out.println("����ת����������"+a+"��ɳ�����"+b);
		b=123456789l;
		a=(short)b;
		System.out.println("����ת����������"+b+"��ɶ�����"+a);
	}

}
