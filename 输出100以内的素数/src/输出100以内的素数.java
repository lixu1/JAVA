
public class ���100���ڵ����� 
{
	public static void main(String args[])
	{
		System.out.println("�����ǣ�\n2\n3");
		for(int i=4;i<=100;i++)
		{
			int j=2;
			boolean a=true;
			while(j<=i/2)
			{
				if(i%j==0){a=false;break;}
				j++;
			}
			if(a==true) System.out.println(i);
		}
	}

}
