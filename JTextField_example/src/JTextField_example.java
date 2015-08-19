import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JTextField_example 
{
	public static void main(String args[])
	{
		JFrame app=new JFrame("第四题");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(500,500);
		Container c=app.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
		final JTextField t=new JTextField("",10);
		app.add(t);
		
		JButton b1=new JButton("显示");
		app.add(b1);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				t.setText("Java 程序");
			}
		}
		);
		JButton b2=new JButton("清除");
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				t.setText("");
			}
		});
		c.add(b1);
		c.add(b2);
		
		app.setVisible(true);
	}

}
