
public class aCastExample 
{
	public static void main(String args[])
	{
		short a=100;
		long b=a;
		System.out.println("类型转换：短整数"+a+"变成长整数"+b);
		b=123456789l;
		a=(short)b;
		System.out.println("类型转换：长整数"+b+"变成短整数"+a);
	}

}
