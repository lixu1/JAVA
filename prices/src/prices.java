import java.util.Scanner;

public class prices 
{
	private double[] price=new double[30];
	private double average;
	public prices()
	{
		System.out.println("����30���۸�");
		Scanner input =new Scanner(System.in);
		for(int i=0;i<30;i++)
			price[i]=input.nextDouble();
		input.close();
	}
	public void Display()
	{
		System.out.println("С��20�ļ۸�Ϊ��");
		for(int i=0;i<30;i++)
			if(price[i]<20) System.out.print(price[i]+"\t");
		 System.out.println();
	}
	public void average()
	{
		double sum=0;
		for(int i=0;i<30;i++)
			sum+=price[i];
		average=sum/30;		
	}
	public void Display2()
	{
		System.out.println("����average�ļ۸�Ϊ��");
		for(int i=0;i<30;i++)
			if(price[i]>average) System.out.print(price[i]+"\t");
		System.out.println();
	}
	public void sort()
	{
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<29;j++)
			{
				double temp;
				if(price[j+1]<price[j])
				{
					temp=price[j+1];
					price[j+1]=price[j];
					price[j]=temp;
				}
			}
		}
		System.out.println("�۸�����");
	}
	public void Display3()
	{
		System.out.println("�۸��ǰ����Ϊ��");
		for(int i=0;i<30;i++)
			System.out.print(price[i]+"\t");
		System.out.println();
	}
	public static void main(String args[])
	{
		prices p=new prices();
		p.Display();
		p.average();
		p.Display2();
		p.sort();
		p.Display3();
	}

}
