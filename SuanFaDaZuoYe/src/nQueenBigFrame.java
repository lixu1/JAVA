//n�ϴ�ʱʱ��n�ʺ�

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;


public class nQueenBigFrame extends JFrame
{
	private int n;
	private long s;
	int a[]=new int [101];
	
	public nQueenBigFrame(int m)
	{
		super("N�ʺ�N�ϴ�");
		this.n=m;
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		JLabel help=new JLabel("��ʱN��ֵ�ϴ󣬽�϶࣬����Ҳ̫��\n������ͼ����ʽ���������⣬\n��������һЩ��Ч�㷨���");
		c.add(help);
		JButton huisu=new JButton("���ݷ����");
		huisu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Date start=new Date();
				long k=huisuMethod(n);
				Date end=new Date();
				long t=end.getTime()-start.getTime();
				JOptionPane.showMessageDialog(null, "���ݷ�����ʱ��Ϊ��"+t+"���룬��ĸ�����"+k+"��");
			}
		});
		c.add(huisu);
		
		JButton digui=new JButton("�ݹ鷨���");
		digui.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Date start=new Date();
				s=0;
				long k=diguiMethod(1);
				Date end=new Date();
				long t=end.getTime()-start.getTime();
				JOptionPane.showMessageDialog(null,"�ݹ鷨����ʱ��Ϊ��"+t+"���룬��ĸ�����"+k+"��");
			}
		});
		c.add(digui);
		
	}
	long huisuMethod(int n)
	{
		int i,g,k,j,x;
		long s;
		int a[]=new int [101];
		i=1;
		s=0;
		a[1]=1;
		while(true)
		{
			g=1;
			for(k=i-1;k>=1;k--)
			{
				x=a[i]-a[k];
				if(x<0)
					x=-x;
				if(x==0||x==i-k)
					g=0;
			}
			if(i==n&&g==1)
			{
				s++;
			}
			if(i<n&&g==1)
			{
				i++;
				a[i]=1;
				continue;
			}
			while(a[i]==n&&i>1)i--;
			if(a[i]==n&&i==1)break;
			else a[i]=a[i]+1;
		}
		return s;
	}
	long diguiMethod(int k)
	{
		int i,j,u;
		if(k<=n)
		{
			for(i=1;i<=n;i++)
			{
				a[k]=i;
				for(u=0,j=1;j<=k-1;j++)
					if(a[k]==a[j]||(a[k]-a[j])==k-j||(a[k]-a[j]==j-k))
						u=1;
				if(u==0)
				{
					if(k==n)
					{
						s++;
					}
					else 
						diguiMethod(k+1);
				}
			}
		}
		return s;
	}

}
