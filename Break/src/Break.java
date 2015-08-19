
public class Break 
{
	public static void main(String args[])
	{
		int i=0;
		aBreakBlock:
		{
			System.out.println("在break语句之前");
			if(i<=0)
				break aBreakBlock;
			System.out.println("在break语句后");
		}
		System.out.println("在aBreakBlock语句块后");
	}

}
