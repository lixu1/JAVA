import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class eightQueenFrame extends JFrame
{
	final JButton site[]=new JButton[64];
	
	//穷举法的变量
	private int everyjie[]=new int[100] ;
	private int f[]=new int [10];
	private int g[]=new int [9];
	private int s=0;//解的个数
	
	//回溯法的变量
	private int weizhi[]=new int [100];
	int s1=0;//解的个数
	
	
	//穷举法
	public void QiongjuMethod()
	{
		s=0;
		int k,i,j,t,x;
		int y;
		for(int a=12345678;a<=87654321;a=a+9)
		{
			y=a;
			k=0;
			for(i=1;i<=8;i++)
				f[i]=0;
			for(k=1;k<=8;k++)
			{
				x= (y%10);
				f[x]=f[x]+1;
				g[k]=x;
				y=y/10;
			}
			for(t=0,i=1;i<=8;i++)
			{
				if(f[i]!=1){t=1;break;}
			}
			if(t==1)continue;
			for(k=1;k<=7;k++)
			{
				for(j=k+1;j<=8;j++)
					if((g[j]-g[k]==j-k)||(g[j]-g[k]==k-j))
					{
						t=1;
						//k=7;
						break;
					}
			}
			if(t==1)continue;
			
			everyjie[s]=a;
			s++;
		}
	}
	
	//回溯法
	void huisuMethod()
	{
		for(int i=0;i<weizhi.length;i++)
			weizhi[i]=0;
		int i,g,k,j,x;
		int a[]=new int [10];
		i=1;s1=0;a[1]=1;
		while(true)
		{
			g=1;
			for(k=i-1;k>=1;k--)
			{
				x=a[i]-a[k];
				if(x<0)x=-x;
				if(x==0||x==i-k)g=0;
			}
			if(i==8 && g==1)
			{
				for(j=1;j<=8;j++)
					weizhi[s1]=weizhi[s1]*10+a[j];
				s1++;
			}
			if(i<8 && g==1)
			{
				i++;
				a[i]=1;
				continue;
			}
			while(a[i]==8&&i>1)i--;
			if(a[i]==8&&i==1)break;
			else a[i]=a[i]+1;
		}
	}
	
	//构造函数
	public eightQueenFrame()
	{
		super("八皇后");
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		final JPanel qipan=new JPanel();
		qipan.setLayout(new GridLayout(8,8));
		
		for(int i=0;i<64;i++)
		{
			site[i]=new JButton();
			if(((i/8)%2==1&&i%2==0)||((i/8)%2==0&&i%2==1))site[i].setBackground(Color.BLACK);
			qipan.add(site[i]);
		}
	
		c.add(qipan,BorderLayout.CENTER);
		
		JPanel control=new JPanel();
		control.setLayout(new BoxLayout(control,BoxLayout.Y_AXIS));
		
		JButton qongju=new JButton("穷举法求解");
		qongju.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Date start=new Date();
				QiongjuMethod();
				Date end=new Date();
				long t=end.getTime()-start.getTime();
				JOptionPane.showMessageDialog(null, "穷举法运行时间为"+t+"毫秒，解的个数为"+s+"个");
			}
		});
		control.add(qongju);
		
		JPanel SHOW=new JPanel();
		JButton show1=new JButton("穷举法展示各个解");
		QiongjuMethod();
		String []jieall=new String[s];
		for(int i=0;i<s;i++)
			jieall[i]=new String("解"+(i+1));
		final JComboBox jieno=new JComboBox(jieall);
		jieno.setEditable(false);
		jieno.setMaximumRowCount(10);
		jieno.setSelectedIndex(0);
		
		show1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int k1=jieno.getSelectedIndex();
				int k=everyjie[k1];
				for(int j=0;j<64;j++)
				{
					site[j].setIcon(null);
				}
				for(int j=0;j<8;j++)
				{
					int t=k%10;
					site[t+(7-j)*8-1].setIcon(new ImageIcon("huanghou.jpg"));
					k=k/10;
				}
			}
		});
		SHOW.add(show1);
		SHOW.add(jieno);
		control.add(SHOW);
		
		JButton huisu=new JButton("回溯法求解");
		huisu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				Date start=new Date();
				huisuMethod();
				Date end=new Date();
				long t=end.getTime()-start.getTime();
				JOptionPane.showMessageDialog(null, "回溯法运行时间为"+t+"毫秒，解的个数为"+s1+"个");
			}
		});
		control.add(huisu);
		
		JPanel SHOW2=new JPanel();
		JButton show2=new JButton("回溯法展示各个解");
		huisuMethod();
		String []jieall2=new String[s];
		for(int i=0;i<s1;i++)
			jieall2[i]=new String("解"+(i+1));
		final JComboBox jieno2=new JComboBox(jieall2);
		jieno2.setEditable(false);
		jieno2.setMaximumRowCount(10);
		jieno2.setSelectedIndex(0);
		show2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int k1=jieno2.getSelectedIndex();
				int k=weizhi[k1];
				for(int j=0;j<64;j++)
				{
					site[j].setIcon(null);
				}
				for(int j=0;j<8;j++)
				{
					int t=k%10;
					site[t+(7-j)*8-1].setIcon(new ImageIcon("huanghou.jpg"));
					k=k/10;
				}
			}
		});
		SHOW2.add(show2);
		SHOW2.add(jieno2);
		control.add(SHOW2);
		c.add(control,BorderLayout.EAST);
	}
}
