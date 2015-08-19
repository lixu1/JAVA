import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Date;

public class rControlNMQueenFrame extends JFrame
{
	int n;
	int m;
	int r;
	//回溯法变量
	int jie[][]=new int [100000][11];
	int s;
	int a[]=new int [20];
	
	public rControlNMQueenFrame(final int r,final int n,final int m)
	{
		super("r个棋子全控nXm棋盘");
		this.n=n;
		this.m=m;
		this.r=r;
		final JButton site[]=new JButton[n*m];
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		final JPanel qipan=new JPanel();
		c.add(qipan,BorderLayout.CENTER);
		
		JPanel control=new JPanel();
		control.setLayout(new BoxLayout(control,BoxLayout.Y_AXIS));
		
		JButton huisu=new JButton("回溯法求解");
		huisu.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				Date start=new Date();
				huisuMethod(r,n,m);
				Date end=new Date();
				long t=end.getTime()-start.getTime();
				JOptionPane.showMessageDialog(null, "回溯法求解，运行时间为："+t+"毫秒，解的个数为:"+s);
			}
		});
		control.add(huisu);
		
		
		//回溯法展示各个解面板
		JPanel SHOW=new JPanel();
		
		huisuMethod(r,n,m);
		String []jieall=new String[s];
		for(int i=0;i<s;i++)
			jieall[i]=new String("解法"+(i+1));
		final JComboBox jieno = new JComboBox(jieall);
		jieno.setEditable(false);
		jieno.setMaximumRowCount(10);
		
		JButton show=new JButton("回溯法展示各个解");
		show.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				qipan.removeAll();
				qipan.setLayout(new GridLayout(n,m));
				
				for(int i=0;i<n*m;i++)
				{
					site[i]=new JButton();
					qipan.add(site[i]);
				}
				
				int k=jieno.getSelectedIndex();
				for(int i=1;i<=n;i++)
				{
					int k1=jie[k][i];
					if(k1>0)
					{
						site[(i-1)*m+k1-1].setIcon(new ImageIcon("huanghou.jpg"));
					}
				}
				
			}
		});
		SHOW.add(show);
		SHOW.add(jieno);
		control.add(SHOW);
		
		c.add(control,BorderLayout.EAST);
	}
	void huisuMethod(int r,int n,int m)
	{
		int i,h,k,d,j,x;
		i=1;
		s=0;
		a[1]=0;
		while(true)
		{
			d=1;
			for(k=i-1;k>=1;k--)
			{
				x=a[i]-a[k];
				if((a[k]!=0 && x==0)||(a[i]*a[k]>0&&abs(x)==i-k))
					d=0;
			}
			if(i==n&&d==1)
			{
				h=0;
				for(j=1;j<=n;j++)
					if(a[j]==0)h++;
				if(h==n-r)
				{
					if(g()==0)
					{
						for(j=1;j<=n;j++)
							jie[s][j]=a[j];
						s++;
					}
				}
			}
			if(i<n&&d==1)
			{
				i++;
				a[i]=0;
				continue;
			}
			while(a[i]==m&&i>1)
				i--;
			if(a[i]==m&&i==1)
				break;
			else
				a[i]=a[i]+1;
		}
	}
	
	//检测棋盘是否被全控
	int g()
	{
		int c,f,j,t;
		int b[][]=new int [20][20];
		t=0;
		for(c=1;c<=n;c++)
			for(j=1;j<=m;j++)
				b[c][j]=0;
		
		for(f=1;f<=n;f++)
			if(a[f]!=0)
			{
				for(c=1;c<=n;c++)
					b[c][a[f]]=1;
				for(j=1;j<=m;j++)
				{
					b[f][j]=1;
					if(f+abs(a[f]-j)<=n)
						b[f+abs(a[f]-j)][j]=1;
					if(f-abs(a[f]-j)>=1)
						b[f-abs(a[f]-j)][j]=1;
				}
			}
		for(c=1;c<=n;c++)
			for(j=1;j<=m;j++)
				if(b[c][j]==0)t=1;
		return t;
	}
	int abs(int number)
	{
		if(number>0)
			return number;
		else
			return -number;
	}

}
