import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Date;

public class rControlNQueenFrame extends JFrame
{
	private int n;
	private int r;
	private int a[]=new int[30];
	private int [][]jie=new int [40000][10];
	private int s=0;
	
	public rControlNQueenFrame(int m,int r)
	{
		super("r皇后全控nXn棋盘");
		this.n=m;
		this.r=r;
		final JButton site[]=new JButton[n*n];
		
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		final JPanel qipan=new JPanel();
		c.add(qipan,BorderLayout.CENTER);
		
		JPanel control=new JPanel();
		control.setLayout(new BoxLayout(control,BoxLayout.Y_AXIS));
		JButton digui=new JButton("递归法求解");
		digui.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				s=0;
				Date start=new Date();
				diguiMethod(1);
				Date end=new Date();
				long t=end.getTime()-start.getTime();
				JOptionPane.showMessageDialog(null, "递归求解运行时间为:"+t+"毫秒，解的个数为："+s+"个");
			}
		});
		control.add(digui);
		JPanel SHOW=new JPanel();
		JButton show=new JButton("递归法展示各个解");
		diguiMethod(1);
		String []jieall=new String[s];
		for(int i=0;i<s;i++)
			jieall[i]=new String("解法"+(i+1));
		final JComboBox jieno = new JComboBox(jieall);
		jieno.setEditable(false);
		jieno.setMaximumRowCount(10);
		show.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				qipan.removeAll();
				qipan.setLayout(new GridLayout(n, n));

				for (int i = 0; i < n * n; i++) {
					site[i] = new JButton();
					qipan.add(site[i]);
				}

				int k1 = jieno.getSelectedIndex();
				for (int j = 0; j < n * n; j++) {
					site[j].setIcon(null);
				}
				for (int j = 1; j <= n; j++) {
					int k = jie[k1][j];
					if(k>0)
						site[k + (j - 1) * n - 1].setIcon(new ImageIcon(
							"huanghou.jpg"));
				}
			}
		});
		
		SHOW.add(show);
		SHOW.add(jieno);
		control.add(SHOW);
		c.add(control,BorderLayout.EAST);
	}
	
	int diguiMethod(int k)
	{
		int h,i,j,u;
		if(k<=n)
		{
			for(i=0;i<=n;i++)
			{
				a[k]=i;
				for(u=0,j=1;j<=k-1;j++)
					if( (a[j]!=0&&a[k]==a[j]) || (a[k]*a[j]>0&&((a[k]-a[j]==j-k)||(a[k]-a[j]==k-j))))
						u=1;
				if(u==0)
				{
					if(k==n)
					{
						for(h=0,j=1;j<=n;j++)
							if(a[j]==0)h++;
						if(h==n-r)//0的个数为n-r个
						{
							if(g()==0)
							{
								for(j=1;j<=n;j++)
									jie[s][j]=a[j];
								s++;
							}
						}
					}
					else diguiMethod(k+1);
				}
			}
		}
		return s;
	}
	int g()
	{
		int t = 0;
		int c,f,j;
		int [][]b=new int [20][20];
		for(c=1;c<=n;c++)
			for(j=1;j<=n;j++)
				b[c][j]=0;
		for(f=1;f<=n;f++)
		{
			if(a[f]!=0)
			{
				for(j=1;j<=n;j++)
				{
					b[f][j]=1;//控制同行
					b[j] [a[f]]=1;//控制同列
					if(f+abs(a[f]-j)<=n)
						b[f+abs(a[f]-j)] [j]=1;
					if(f-abs(a[f]-j)>=1)
						b[f-abs(a[f]-j)][j]=1;
				}
			}
		}
		for(c=1;c<=n;c++)
			for(j=1;j<=n;j++)
				if(b[c][j]==0){t=1;c=n;break;}
		return t;
	}
	int abs(int ab)
	{
		if(ab<0)
			return -ab;
		else 
			return ab;
	}

}
