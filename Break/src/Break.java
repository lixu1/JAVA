
public class Break 
{
	public static void main(String args[])
	{
		int i=0;
		aBreakBlock:
		{
			System.out.println("��break���֮ǰ");
			if(i<=0)
				break aBreakBlock;
			System.out.println("��break����");
		}
		System.out.println("��aBreakBlock�����");
	}

}
