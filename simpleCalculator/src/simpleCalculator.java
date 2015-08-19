import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class simpleCalculator 
{
	public static void main(String args[])
	{
		JFrame app=new JFrame("第五题");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(200,200);
		app.setBackground(Color.GRAY);
		Container c=app.getContentPane();
		c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
		
		JPanel p1=new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
		JTextField field_1=new JTextField("操作数1");
		field_1.setEditable(false);
		JTextField field_2=new JTextField("操作数2");
		field_2.setEditable(false);
		JTextField field_3=new JTextField("运算结果");
		field_3.setEditable(false);
		p1.add(field_1);
		p1.add(field_2);
		p1.add(field_3);
		
		
		JPanel p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));
		final JTextField textfield_1=new JTextField(10);
		final JTextField textfield_2=new JTextField(10);
		final JTextField textfield_3=new JTextField(10);
		
		p2.add(textfield_1);
		p2.add(textfield_2);
		p2.add(textfield_3);
		
		JPanel p12=new JPanel();
		p12.setLayout(new BoxLayout(p12,BoxLayout.X_AXIS));
		p12.add(p1);
		p12.add(p2);
		
		c.add(p12);

		
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.X_AXIS));
		JButton button1=new JButton("加");
		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				double a=Double.valueOf(textfield_1.getText());
				double b=Double.valueOf(textfield_2.getText());
				double c=a+b;
				textfield_3.setText(String.valueOf(c));
			}
		});
		
		JButton button2=new JButton("减");
		button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				double a=Double.valueOf(textfield_1.getText());
				double b=Double.valueOf(textfield_2.getText());
				double c=a-b;
				textfield_3.setText(String.valueOf(c));
			}
		});
		
		JButton button3=new JButton("乘");
		button3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				double a=Double.valueOf(textfield_1.getText());
				double b=Double.valueOf(textfield_2.getText());
				double c=a*b;
				textfield_3.setText(String.valueOf(c));
			}
		});
		
		JButton button4=new JButton("除");
		button4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(Double.valueOf(textfield_2.getText())==0)
						textfield_3.setText("除数不能为0");
				else
				{
					double a=Double.valueOf(textfield_1.getText());
					double b=Double.valueOf(textfield_2.getText());
					double c=a/b;
					textfield_3.setText(String.valueOf(c));
				}
			}
		});

		p3.add(button1);
		p3.add(button2);
		p3.add(button3);
		p3.add(button4);
		c.add(p3);
		
		app.setVisible(true);
		
	}

}
