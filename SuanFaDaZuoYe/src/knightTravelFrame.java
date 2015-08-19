import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Date;

public class knightTravelFrame extends JFrame
{
	int x[]=new int [101];//第i步的行数
	int y[]=new int [101];//第i步的列数
	int d[][]=new int [11][11];//棋盘的u行v列所在格的整数值，即遍历路径上的步数
	int jie[][][]=new int [100000] [11][11];
	int z;//解的个数
	
	
	public knightTravelFrame(final int n,final int m,final int u,final int v)
	{
		super("骑士游历");
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		final JPanel qipan=new JPanel();
		
		final JButton site[]=new JButton[m*n];
		c.add(qipan,BorderLayout.CENTER);
		
		JPanel control=new JPanel();
		control.setLayout(new BoxLayout(control,BoxLayout.Y_AXIS));
		JButton huisu=new JButton("回溯法求解");
		huisu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Date start=new Date();
				huisuMethod(n,m,u,v);
				Date end=new Date();
				long t=end.getTime()-start.getTime();
				JOptionPane.showMessageDialog(null,"回溯法求解，运行时间为："+t+"毫秒，解的个数为:"+z);
				
			}
		});
		
		//回溯法展示各个解面板
		JPanel SHOW=new JPanel();
		
		huisuMethod(n,m,u,v);
		
		String []jieall=new String[z];
		for(int i=0;i<z;i++)
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
					for(int j=1;j<=m;j++)
					{
						int k1=jie[k][i][j];
						site[(i-1)*m+j-1].setLabel(""+k1);
					}
				}
			}
		});
		
		SHOW.add(show);
		SHOW.add(jieno);
		
		control.add(huisu);
		control.add(SHOW);
		c.add(control,BorderLayout.EAST);
		
	}
	
	void huisuMethod(int n,int m,int u,int v)
	{
		int a[]={0, 2, 1, -1, -2, -2, -1, 1,  2};
		int b[]={0, 1, 2, 2,  1,  -1, -2, -2, -1};
		int t[]=new int [101];//第i步到i+1步的方向
		int i,j,k,q;
		
		i=1;
		z=0;
		x[i]=u;
		y[i]=v;
		d[u][v]=1;
		while(i>0)
		{
			q=0;
			for(k=t[i]+1;k<=8;k++)
			{
				u=x[i]+a[k];
				v=y[i]+b[k];
				if(u>0&&u<=n&&v>0&&v<=m&&d[u][v]==0)
				{
					x[i+1]=u;
					y[i+1]=v;
					d[u][v]=i+1;
					t[i]=k;
					q=1;
					break;
				}
			}
			if(q==1&&i==m*n-1)
			{
				for(j=1;j<=n;j++)
				{
					for(k=1;k<=m;k++)
						jie[z][j][k]=d[j][k];
				}
				t[i]=0;
				d[x[i]][y[i]]=0;
				d[x[i+1]][y[i+1]]=0;
				i--;
				z++;
			}
			else if(q==1)
				i++;
			else
			{
				t[i]=0;
				d [x[i]] [y[i]]=0;
				i--;
			}
		}
	}
}
