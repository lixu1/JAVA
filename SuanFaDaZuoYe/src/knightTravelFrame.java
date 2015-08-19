import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Date;

public class knightTravelFrame extends JFrame
{
	int x[]=new int [101];//��i��������
	int y[]=new int [101];//��i��������
	int d[][]=new int [11][11];//���̵�u��v�����ڸ������ֵ��������·���ϵĲ���
	int jie[][][]=new int [100000] [11][11];
	int z;//��ĸ���
	
	
	public knightTravelFrame(final int n,final int m,final int u,final int v)
	{
		super("��ʿ����");
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		final JPanel qipan=new JPanel();
		
		final JButton site[]=new JButton[m*n];
		c.add(qipan,BorderLayout.CENTER);
		
		JPanel control=new JPanel();
		control.setLayout(new BoxLayout(control,BoxLayout.Y_AXIS));
		JButton huisu=new JButton("���ݷ����");
		huisu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Date start=new Date();
				huisuMethod(n,m,u,v);
				Date end=new Date();
				long t=end.getTime()-start.getTime();
				JOptionPane.showMessageDialog(null,"���ݷ���⣬����ʱ��Ϊ��"+t+"���룬��ĸ���Ϊ:"+z);
				
			}
		});
		
		//���ݷ�չʾ���������
		JPanel SHOW=new JPanel();
		
		huisuMethod(n,m,u,v);
		
		String []jieall=new String[z];
		for(int i=0;i<z;i++)
			jieall[i]=new String("�ⷨ"+(i+1));
		final JComboBox jieno = new JComboBox(jieall);
		jieno.setEditable(false);
		jieno.setMaximumRowCount(10);
		
		JButton show=new JButton("���ݷ�չʾ������");
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
		int t[]=new int [101];//��i����i+1���ķ���
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
