//皇后数 4 5 6 7 8 9 10 11 12 13 14 
//独立解 1 2 1 6 12 46 92 341 1787 9233 45752 
//全部解 2 10 4 40 92 352 724 2680 14200 73712 365596 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class nQueenFrame extends JFrame {
	
	private int n;
	private int a[] = new int[100];
	
	// 回溯法变量4<=n<=11
	private int[][] jie = new int[3000][12];
	private int s;
	
	//递归法变量4<=n<=11
	private int[][] jie2=new int [3000][12];
	private int s2=0;//解的个数

	// 构造函数
	public nQueenFrame(int m) {
		super("N皇后");
		this.n= m;
		final JButton site[] = new JButton[n * n];

		Container c = getContentPane();
		c.setLayout(new BorderLayout());

		final JPanel qipan = new JPanel();
		c.add(qipan, BorderLayout.CENTER);

		JPanel control = new JPanel();
		control.setLayout(new BoxLayout(control, BoxLayout.Y_AXIS));

		JButton huisu = new JButton("回溯法求解");
		huisu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date start = new Date();
				huisuMethod(n);
				Date end = new Date();
				long t = end.getTime() - start.getTime();
				JOptionPane.showMessageDialog(null, "回溯法运行时间为" + t + "毫秒，解的个数为"
						+ s + "个");
			}
		});
		control.add(huisu);

		JPanel SHOW1 = new JPanel();
		JButton show1 = new JButton("回溯法展示各个解");
		huisuMethod(n);
		String[] jieall = new String[s];
		for (int i = 0; i < s; i++)
			jieall[i] = new String("解" + (i + 1));
		final JComboBox jieno = new JComboBox(jieall);
		jieno.setEditable(false);
		jieno.setMaximumRowCount(10);
		jieno.setSelectedIndex(0);

		show1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					site[k + (j - 1) * n - 1].setIcon(new ImageIcon(
							"huanghou.jpg"));
				}
			}
		});
		SHOW1.add(show1);
		SHOW1.add(jieno);
		control.add(SHOW1);
		
		JButton digui=new JButton("递归法求解");
		digui.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				Date start=new Date();
				s2=0;
				diguiMethod(1);
				Date end=new Date();
				long t=end.getTime()-start.getTime();
				JOptionPane.showMessageDialog(null, "递归法运行时间为" + t + "毫秒，解的个数为"
						+ s2 + "个");
			}
		});
		control.add(digui);
		
		JPanel SHOW2=new JPanel();
		s2=0;
		diguiMethod(1);
		String jie[]=new String[s2];
		for(int i=0;i<s2;i++)
			jie[i]=new String("解"+(i+1));
		final JComboBox jieno2=new JComboBox(jie);
		jieno2.setEditable(false);
		jieno2.setMaximumRowCount(10);
		jieno2.setSelectedIndex(0);
		JButton show2=new JButton("递归法展示各个解");
		show2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int k=jieno2.getSelectedIndex();
				qipan.removeAll();
				qipan.setLayout(new GridLayout(n,n));
				for(int i=0;i<n*n;i++)
				{
					site[i]=new JButton();
					qipan.add(site[i]);
				}
				for(int j=1;j<=n;j++)
				{
					int t=jie2[k][j];
					site[t-1+(j-1)*n].setIcon(new ImageIcon("huanghou.jpg"));
				}
			}
		});
		SHOW2.add(show2);
		SHOW2.add(jieno2);
		control.add(SHOW2);

		c.add(control, BorderLayout.EAST);

	}

	// 回溯法
	void huisuMethod(int n) {
		int i, g, k, j, x;
		i = 1;
		s = 0;
		a[1] = 1;
		while (true) {
			g = 1;
			for (k = i - 1; k >= 1; k--) {
				x = a[i] - a[k];
				if (x < 0)
					x = -x;
				if (x == 0 || x == i - k)
					g = 0;
			}
			if (i == n && g == 1) {
				for (j = 1; j <= n; j++)
					jie[s][j] = a[j];
				s++;
			}
			if (i < n && g == 1) {
				i++;
				a[i] = 1;
				continue;
			}
			while (a[i] == n && i > 1)
				i--;
			if (a[i] == n && i == 1)
				break;
			else
				a[i] = a[i] + 1;
		}
	}
	
	//递归法
	void diguiMethod(int k)
	{
		int i,j,u;
		if(k<=n)
		{
			for(i=1;i<=n;i++)
			{
				a[k]=i;
				for(u=0,j=1;j<=k-1;j++)
				if(a[k]==a[j]||(a[k]-a[j])==(k-j)||(a[k]-a[j])==(j-k))
					u=1;
				if(u==0)
				{
					if(k==n)
					{
						for(j=1;j<=n;j++)
							jie2[s2][j]=a[j];
						s2++;
					}
					else diguiMethod(k+1);
				}
			}
		}
	}

}
