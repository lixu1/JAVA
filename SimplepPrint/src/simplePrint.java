
public class simplePrint 
{
	public static void main(String arges[])
	{
		
		System.out.println("*\n**\n***\n****\n*****");
		
		
		int i,j=0;
		for(i=32;i<=255;i++)
		{	
			System.out.print((char)i);
			j++;
			if(j==10)
			{
				j=0;
				System.out.println();
			}
		}
		System.out.println();
		
		double z = Math.sqrt(4*4+7*7);
		System.out.println("直角边为4和7的三角形，斜边长为："+z);

	}

}
