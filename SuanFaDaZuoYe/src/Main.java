import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class Main 
{
	public static void main(String[] args)
	{
		JFrame app=new JFrame("算法大作业");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(800,700);
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout(java.awt.FlowLayout.LEFT));
		
		JPanel first=new JPanel();
		JLabel title=new JLabel("国际象棋中的算法",new ImageIcon("qipan.jpg"),JLabel.RIGHT);
		JTextArea content=new JTextArea("算法大作业：" +
				"\n姓名：李旭，学号：11211126" +
				"\n这是关于国际象棋中一些算法问题的求解，如n皇后问题，骑士周游等，" +
				"\n运用了枚举法，回溯法，递归等算法" +
				"\n可点击相应按钮，使用一些有效算法解决" +
				"\n有的问题可以选择不同的棋盘大小，可以根据需要选择合适的" +
				"\n但是有的问题结果消耗时间较长，结果太大，期望谨慎选择" +
				"\n点击下列按钮开始各个问题，按钮旁边有相应的问题描述。");
		content.setEditable(false);
		JScrollPane Content=new JScrollPane(content);
		first.add(title);
		first.add(Content);
		c.add(first);
		
		JPanel second=new JPanel();
		JButton eightQueen=new JButton("八皇后");
		eightQueen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				eightQueenFrame app=new eightQueenFrame();
				app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				app.setSize(700,600);
				app.setVisible(true);
			}
		});
		JTextArea eightQueen_instruction=
				new JTextArea("八皇后问题，是一个古老而著名的问题，是回溯算法的典型例题。该问题是十九世纪著名的数学家高斯1850年提出："
						+"\n在8X8格的国际象棋上摆放八个皇后，使其不能互相攻击，" +
				"\n即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。");
		eightQueen_instruction.setEditable(false);
		JScrollPane EightQueen_Instruction=new JScrollPane(eightQueen_instruction);
		second.add(eightQueen);
		second.add(EightQueen_Instruction);
		c.add(second);
		
		JPanel third=new JPanel();
		JButton nQueen=new JButton("N皇后");
		String choose1[]=new String[97];
		for(int i=0;i<97;i++)
			choose1[i]=new String("n="+(i+4));
		final JComboBox choose1_ComBoBox=new JComboBox(choose1);
		choose1_ComBoBox.setEditable(false);
		choose1_ComBoBox.setMaximumRowCount(10);
		choose1_ComBoBox.setSelectedIndex(0);
		
		nQueen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int ch=choose1_ComBoBox.getSelectedIndex();
				if(ch<8)
				{
					nQueenFrame app=new nQueenFrame(ch+4);
					app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					app.setSize(600,600);
					app.setVisible(true);
				}
				else
				{
					nQueenBigFrame app=new nQueenBigFrame(ch+4);
					app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					app.setSize(600,400);
					app.setVisible(true);
				}
			}
		});
		JTextArea nQueen_instruction=new JTextArea("在n×n格的棋盘上放置彼此不受攻击的n个皇后。是八皇后问题的推广" +
				"\n按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。" +
				"\nn后问题等价于再n×n的棋盘上放置n个皇后，任何2个皇后不妨在同一行或同一列或同一斜线上。");
		nQueen_instruction.setEditable(false);
		JScrollPane nQueen_Instruction=new JScrollPane(nQueen_instruction);
		third.add(nQueen);
		third.add(choose1_ComBoBox);
		third.add(nQueen_Instruction);
		c.add(third);
		
		
		JPanel forth=new JPanel();
		
		//选择r
		String choose_r[]=new String[7];
		for(int i=0;i<7;i++)
			choose_r[i]=new String("r="+(i+3));
		final JComboBox choose_r_ComboBox=new JComboBox(choose_r);
		choose_r_ComboBox.setSelectedIndex(0);
		choose_r_ComboBox.setEditable(false);
		
		//选择n
		String choose_n[]=new String[6];
		for(int i=0;i<6;i++)
			choose_n[i]=new String("n="+(i+4));
		final JComboBox choose_n_ComboBox=new JComboBox(choose_n);
		choose_n_ComboBox.setSelectedIndex(0);
		choose_n_ComboBox.setEditable(false);
		
		
		JButton rControlN=new JButton("r皇后全控nXn棋盘");
		rControlN.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				int r=choose_r_ComboBox.getSelectedIndex();
				r=r+3;
				int n=choose_n_ComboBox.getSelectedIndex();
				n=n+4;
				if(r>n)
					JOptionPane.showMessageDialog(null,r+"比"+n+"大，肯定存在两个皇后相互攻击，这种情况下，" +
							r+"个皇后全控"+n+"X"+n+"棋盘是不可能的，请重新选择！");
				else
				{
					rControlNQueenFrame app=new rControlNQueenFrame(n,r);
					app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					app.setSize(600,600);
					app.setVisible(true);
				}
			}
		});
		JTextArea rControlN_instruction=new JTextArea("在nXn的棋盘上，放置r个皇后，可以控制棋盘的每一个格子，\n" +
				"而皇后之间不能相互攻击。");
		rControlN_instruction.setEditable(false);
		JScrollPane rControlN_Instruction=new JScrollPane(rControlN_instruction);
		forth.add(rControlN);
		forth.add(choose_r_ComboBox);
		forth.add(choose_n_ComboBox);
		forth.add(rControlN_Instruction);
		c.add(forth);
		
		
		//R皇后全控制NXM棋盘   面板设置
		
		JPanel fifth=new JPanel();
		
		//选择r 3-9
		String choose_r1[]=new String[7];
		for(int i=0;i<7;i++)
				choose_r1[i]=new String("r="+(i+3));
		final JComboBox choose_r_ComboBox1=new JComboBox(choose_r1);
		choose_r_ComboBox1.setSelectedIndex(0);
		choose_r_ComboBox1.setEditable(false);
		
		//选择n 4-10
		String choose_n1[]=new String[7];
		for(int i=0;i<7;i++)
			choose_n1[i]=new String("n="+(i+4));
		final JComboBox choose_n_ComboBox1=new JComboBox(choose_n1);
		choose_n_ComboBox1.setSelectedIndex(0);
		choose_n_ComboBox1.setEditable(false);
		
		//选择m 4-9
		String choose_m1[]=new String[6];
		for(int i=0;i<6;i++)
			choose_m1[i]=new String("m="+(i+4));
		final JComboBox choose_m1_ComboBox=new JComboBox(choose_m1);
		choose_m1_ComboBox.setSelectedIndex(0);
		choose_m1_ComboBox.setEditable(false);
				

		JButton rControlMN=new JButton("r皇后全控mXn棋盘");
		rControlMN.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int r_mn=choose_r_ComboBox1.getSelectedIndex();
				r_mn=r_mn+3;
				int n_mn=choose_n_ComboBox1.getSelectedIndex();
				n_mn=n_mn+4;
				int m_mn=choose_m1_ComboBox.getSelectedIndex();
				m_mn=m_mn+4;
				if(r_mn>m_mn)
					JOptionPane.showMessageDialog(null,"r="+ r_mn+"比 n="+m_mn+"大，故肯定存在两个皇后相互攻击，" +
							"这种情况下，解肯定为0,请重新选择。");
				else if(r_mn>n_mn)
					JOptionPane.showMessageDialog(null,"r="+r_mn+"比 n="+n_mn+"大，故肯定存在两个皇后相互攻击，" +
							"这种情况下，解肯定为0,请重新选择。");
				else
				{
					rControlNMQueenFrame app=new rControlNMQueenFrame(r_mn,n_mn,m_mn);
					app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					app.setSize(600,600);
					app.setVisible(true);
				}
				
			}
		});
		JTextArea rControlMN_instruction=new JTextArea("如果棋盘的行数n与列数m不等，该棋盘称为广义棋盘\n" +
				"在 nXm的棋盘上放r个皇后可以控制棋盘的每一个格子，\n" +
				"而皇后之间不能相互攻击。");
		rControlMN_instruction.setEditable(false);
		JScrollPane rControlMN_instruction1=new JScrollPane(rControlMN_instruction);
		fifth.add(rControlMN);
		fifth.add(choose_r_ComboBox1);
		fifth.add(choose_n_ComboBox1);
		fifth.add(choose_m1_ComboBox);
		fifth.add(rControlMN_instruction1);
		c.add(fifth);
		
		//骑士巡游
		JPanel sixth=new JPanel();
		
		//选择n 3-10
		String choose_n3[]=new String[8];
		for(int i=0;i<8;i++)
			choose_n3[i]=new String("n="+(i+3));
		final JComboBox choose_n_ComboBox3=new JComboBox(choose_n3);
		choose_n_ComboBox3.setSelectedIndex(0);
		choose_n_ComboBox3.setEditable(false);
				
		//选择m 4-10
		String choose_m3[]=new String[6];
		for(int i=0;i<6;i++)
			choose_m3[i]=new String("m="+(i+4));
		final JComboBox choose_m_ComboBox3=new JComboBox(choose_m3);
		choose_m_ComboBox3.setSelectedIndex(0);
		choose_m_ComboBox3.setEditable(false);
		
		//选择u 1-10
		String choose_u3[]=new String[10];
		for(int i=0;i<10;i++)
			choose_u3[i]=new String("u="+(i+1));
		final JComboBox choose_u_ComboBox3=new JComboBox(choose_u3);
		choose_u_ComboBox3.setSelectedIndex(0);
		choose_u_ComboBox3.setEditable(false);
		
		//选择v 1-10
		String choose_v3[]=new String[10];
		for(int i=0;i<10;i++)
			choose_v3[i]=new String("v="+(i+1));
		final JComboBox choose_v_ComboBox3=new JComboBox(choose_v3);
		choose_v_ComboBox3.setSelectedIndex(0);
		choose_v_ComboBox3.setEditable(false);
			
		
				
		JButton knightTravel=new JButton("骑士巡游");
		knightTravel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int n=choose_n_ComboBox3.getSelectedIndex();
				n=n+3;
				int m=choose_m_ComboBox3.getSelectedIndex();
				m=m+4;
				int u=choose_u_ComboBox3.getSelectedIndex();
				u=u+1;
				int v=choose_v_ComboBox3.getSelectedIndex();
				v=v+1;
				if(u>n)
					JOptionPane.showMessageDialog(null, "u="+u+"比 n="+n+"大，u是横坐标，不能比n大,错误");
				else if(v>m)
					JOptionPane.showMessageDialog(null, "v="+v+"比m="+m+"大，v是纵坐标，不能比m大，错误");
				else
				{
					knightTravelFrame app=new knightTravelFrame(n,m,u,v);
					app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					app.setSize(600,600);
					app.setVisible(true);
				}
			}
		});
		JTextArea knightTravel_instruction=
				new JTextArea("在给定的棋盘中，骑士从棋盘的某个起点出发,按照“马走日”的行走规则\n" +
				"经过棋盘中的每一个方格恰好一次。该问题成为又称为马步遍历问题，\n" +
				"经过棋盘的每一个方格恰好一次的线路称为马步遍历路径。\n" +
				"求解在n行m列的广义棋盘上，马从棋盘的某个指定点出发的马步遍历路径。\n" +
				"u是棋盘的横坐标，v是棋盘的纵坐标。");
		knightTravel_instruction.setEditable(false);
		JScrollPane knightTravel_Instruction=new JScrollPane(knightTravel_instruction);
		
		sixth.add(knightTravel);
		sixth.add(choose_n_ComboBox3);
		sixth.add(choose_m_ComboBox3);
		sixth.add(choose_u_ComboBox3);
		sixth.add(choose_v_ComboBox3);
		sixth.add(knightTravel_Instruction);
		c.add(sixth);
		
		
		app.setVisible(true);
	}

}
