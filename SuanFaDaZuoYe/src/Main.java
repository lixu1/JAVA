import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class Main 
{
	public static void main(String[] args)
	{
		JFrame app=new JFrame("�㷨����ҵ");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(800,700);
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout(java.awt.FlowLayout.LEFT));
		
		JPanel first=new JPanel();
		JLabel title=new JLabel("���������е��㷨",new ImageIcon("qipan.jpg"),JLabel.RIGHT);
		JTextArea content=new JTextArea("�㷨����ҵ��" +
				"\n����������ѧ�ţ�11211126" +
				"\n���ǹ��ڹ���������һЩ�㷨�������⣬��n�ʺ����⣬��ʿ���εȣ�" +
				"\n������ö�ٷ������ݷ����ݹ���㷨" +
				"\n�ɵ����Ӧ��ť��ʹ��һЩ��Ч�㷨���" +
				"\n�е��������ѡ��ͬ�����̴�С�����Ը�����Ҫѡ����ʵ�" +
				"\n�����е�����������ʱ��ϳ������̫����������ѡ��" +
				"\n������а�ť��ʼ�������⣬��ť�Ա�����Ӧ������������");
		content.setEditable(false);
		JScrollPane Content=new JScrollPane(content);
		first.add(title);
		first.add(Content);
		c.add(first);
		
		JPanel second=new JPanel();
		JButton eightQueen=new JButton("�˻ʺ�");
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
				new JTextArea("�˻ʺ����⣬��һ�����϶����������⣬�ǻ����㷨�ĵ������⡣��������ʮ��������������ѧ�Ҹ�˹1850�������"
						+"\n��8X8��Ĺ��������ϰڷŰ˸��ʺ�ʹ�䲻�ܻ��๥����" +
				"\n�����������ʺ󶼲��ܴ���ͬһ�С�ͬһ�л�ͬһб���ϣ����ж����ְڷ���");
		eightQueen_instruction.setEditable(false);
		JScrollPane EightQueen_Instruction=new JScrollPane(eightQueen_instruction);
		second.add(eightQueen);
		second.add(EightQueen_Instruction);
		c.add(second);
		
		JPanel third=new JPanel();
		JButton nQueen=new JButton("N�ʺ�");
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
		JTextArea nQueen_instruction=new JTextArea("��n��n��������Ϸ��ñ˴˲��ܹ�����n���ʺ��ǰ˻ʺ�������ƹ�" +
				"\n���չ�������Ĺ��򣬻ʺ���Թ�����֮����ͬһ�л�ͬһ�л�ͬһб���ϵ����ӡ�" +
				"\nn������ȼ�����n��n�������Ϸ���n���ʺ��κ�2���ʺ󲻷���ͬһ�л�ͬһ�л�ͬһб���ϡ�");
		nQueen_instruction.setEditable(false);
		JScrollPane nQueen_Instruction=new JScrollPane(nQueen_instruction);
		third.add(nQueen);
		third.add(choose1_ComBoBox);
		third.add(nQueen_Instruction);
		c.add(third);
		
		
		JPanel forth=new JPanel();
		
		//ѡ��r
		String choose_r[]=new String[7];
		for(int i=0;i<7;i++)
			choose_r[i]=new String("r="+(i+3));
		final JComboBox choose_r_ComboBox=new JComboBox(choose_r);
		choose_r_ComboBox.setSelectedIndex(0);
		choose_r_ComboBox.setEditable(false);
		
		//ѡ��n
		String choose_n[]=new String[6];
		for(int i=0;i<6;i++)
			choose_n[i]=new String("n="+(i+4));
		final JComboBox choose_n_ComboBox=new JComboBox(choose_n);
		choose_n_ComboBox.setSelectedIndex(0);
		choose_n_ComboBox.setEditable(false);
		
		
		JButton rControlN=new JButton("r�ʺ�ȫ��nXn����");
		rControlN.addActionListener(new ActionListener ()
		{
			public void actionPerformed(ActionEvent e)
			{
				int r=choose_r_ComboBox.getSelectedIndex();
				r=r+3;
				int n=choose_n_ComboBox.getSelectedIndex();
				n=n+4;
				if(r>n)
					JOptionPane.showMessageDialog(null,r+"��"+n+"�󣬿϶����������ʺ��໥��������������£�" +
							r+"���ʺ�ȫ��"+n+"X"+n+"�����ǲ����ܵģ�������ѡ��");
				else
				{
					rControlNQueenFrame app=new rControlNQueenFrame(n,r);
					app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					app.setSize(600,600);
					app.setVisible(true);
				}
			}
		});
		JTextArea rControlN_instruction=new JTextArea("��nXn�������ϣ�����r���ʺ󣬿��Կ������̵�ÿһ�����ӣ�\n" +
				"���ʺ�֮�䲻���໥������");
		rControlN_instruction.setEditable(false);
		JScrollPane rControlN_Instruction=new JScrollPane(rControlN_instruction);
		forth.add(rControlN);
		forth.add(choose_r_ComboBox);
		forth.add(choose_n_ComboBox);
		forth.add(rControlN_Instruction);
		c.add(forth);
		
		
		//R�ʺ�ȫ����NXM����   �������
		
		JPanel fifth=new JPanel();
		
		//ѡ��r 3-9
		String choose_r1[]=new String[7];
		for(int i=0;i<7;i++)
				choose_r1[i]=new String("r="+(i+3));
		final JComboBox choose_r_ComboBox1=new JComboBox(choose_r1);
		choose_r_ComboBox1.setSelectedIndex(0);
		choose_r_ComboBox1.setEditable(false);
		
		//ѡ��n 4-10
		String choose_n1[]=new String[7];
		for(int i=0;i<7;i++)
			choose_n1[i]=new String("n="+(i+4));
		final JComboBox choose_n_ComboBox1=new JComboBox(choose_n1);
		choose_n_ComboBox1.setSelectedIndex(0);
		choose_n_ComboBox1.setEditable(false);
		
		//ѡ��m 4-9
		String choose_m1[]=new String[6];
		for(int i=0;i<6;i++)
			choose_m1[i]=new String("m="+(i+4));
		final JComboBox choose_m1_ComboBox=new JComboBox(choose_m1);
		choose_m1_ComboBox.setSelectedIndex(0);
		choose_m1_ComboBox.setEditable(false);
				

		JButton rControlMN=new JButton("r�ʺ�ȫ��mXn����");
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
					JOptionPane.showMessageDialog(null,"r="+ r_mn+"�� n="+m_mn+"�󣬹ʿ϶����������ʺ��໥������" +
							"��������£���϶�Ϊ0,������ѡ��");
				else if(r_mn>n_mn)
					JOptionPane.showMessageDialog(null,"r="+r_mn+"�� n="+n_mn+"�󣬹ʿ϶����������ʺ��໥������" +
							"��������£���϶�Ϊ0,������ѡ��");
				else
				{
					rControlNMQueenFrame app=new rControlNMQueenFrame(r_mn,n_mn,m_mn);
					app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					app.setSize(600,600);
					app.setVisible(true);
				}
				
			}
		});
		JTextArea rControlMN_instruction=new JTextArea("������̵�����n������m���ȣ������̳�Ϊ��������\n" +
				"�� nXm�������Ϸ�r���ʺ���Կ������̵�ÿһ�����ӣ�\n" +
				"���ʺ�֮�䲻���໥������");
		rControlMN_instruction.setEditable(false);
		JScrollPane rControlMN_instruction1=new JScrollPane(rControlMN_instruction);
		fifth.add(rControlMN);
		fifth.add(choose_r_ComboBox1);
		fifth.add(choose_n_ComboBox1);
		fifth.add(choose_m1_ComboBox);
		fifth.add(rControlMN_instruction1);
		c.add(fifth);
		
		//��ʿѲ��
		JPanel sixth=new JPanel();
		
		//ѡ��n 3-10
		String choose_n3[]=new String[8];
		for(int i=0;i<8;i++)
			choose_n3[i]=new String("n="+(i+3));
		final JComboBox choose_n_ComboBox3=new JComboBox(choose_n3);
		choose_n_ComboBox3.setSelectedIndex(0);
		choose_n_ComboBox3.setEditable(false);
				
		//ѡ��m 4-10
		String choose_m3[]=new String[6];
		for(int i=0;i<6;i++)
			choose_m3[i]=new String("m="+(i+4));
		final JComboBox choose_m_ComboBox3=new JComboBox(choose_m3);
		choose_m_ComboBox3.setSelectedIndex(0);
		choose_m_ComboBox3.setEditable(false);
		
		//ѡ��u 1-10
		String choose_u3[]=new String[10];
		for(int i=0;i<10;i++)
			choose_u3[i]=new String("u="+(i+1));
		final JComboBox choose_u_ComboBox3=new JComboBox(choose_u3);
		choose_u_ComboBox3.setSelectedIndex(0);
		choose_u_ComboBox3.setEditable(false);
		
		//ѡ��v 1-10
		String choose_v3[]=new String[10];
		for(int i=0;i<10;i++)
			choose_v3[i]=new String("v="+(i+1));
		final JComboBox choose_v_ComboBox3=new JComboBox(choose_v3);
		choose_v_ComboBox3.setSelectedIndex(0);
		choose_v_ComboBox3.setEditable(false);
			
		
				
		JButton knightTravel=new JButton("��ʿѲ��");
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
					JOptionPane.showMessageDialog(null, "u="+u+"�� n="+n+"��u�Ǻ����꣬���ܱ�n��,����");
				else if(v>m)
					JOptionPane.showMessageDialog(null, "v="+v+"��m="+m+"��v�������꣬���ܱ�m�󣬴���");
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
				new JTextArea("�ڸ����������У���ʿ�����̵�ĳ��������,���ա������ա������߹���\n" +
				"���������е�ÿһ������ǡ��һ�Ρ��������Ϊ�ֳ�Ϊ���������⣬\n" +
				"�������̵�ÿһ������ǡ��һ�ε���·��Ϊ������·����\n" +
				"�����n��m�еĹ��������ϣ�������̵�ĳ��ָ���������������·����\n" +
				"u�����̵ĺ����꣬v�����̵������ꡣ");
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
