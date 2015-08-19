
public class ContinueLoopNested 
{
	public static void main(String args[])
	{
		aContinueBlock:
			for(int i=0;i<4;i++)
			{
				for(int j=0;j<2;j++)
				{
					if(i>0&&i<3)
						continue aContinueBlock;
					System.out.println("i="+i+",j="+j);
				}
			}
	}

}
