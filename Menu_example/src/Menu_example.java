import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu_example 
{
	public static void main(String args[])
	{
		JFrame app=new JFrame("������");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		JMenuBar mBar =new JMenuBar();
		app.setJMenuBar(mBar);
		JMenu[] m={new JMenu("�ļ���F)"),new JMenu("�༭��E)")};
		
		char [][]mC={{'F','E'},{'O','S'},{'C','V'}};
		JMenuItem [][]mI=
			{
				{new JMenuItem("�򿪣�O)"),new JMenuItem("���棨S)")},
				{new JMenuItem("���ƣ�C)"),new JMenuItem("ճ����V)")}
			};
		for(int i=0;i<m.length;i++)
		{
			mBar.add(m[i]);
			m[i].setMnemonic(mC[0][i]);
			for(int j=0;j<mI[i].length;j++)
			{
				m[i].add(mI[i][j]);
				mI[i][j].setMnemonic(mC[i+1][j]);
				mI[i][j].setAccelerator(KeyStroke.getKeyStroke("ctrl"+mC[i+1][j]));
				mI[i][j].addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						JMenuItem mItem=(JMenuItem)e.getSource();
						System.out.println("���в˵��"+mItem.getText());
					}
				});
			}
		}
		
		app.setVisible(true);		
	}

}
