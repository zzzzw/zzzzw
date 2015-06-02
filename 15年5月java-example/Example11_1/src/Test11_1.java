import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Test11_1
{
	public static void main(String args[])
	{
		new MyFrame();
	}
}
@SuppressWarnings("serial")
class MyFrame extends JFrame
{
	int j;
	JTextField t1=new JTextField(15);
	JButton b1=new JButton("begin");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	RunPanel p11=new RunPanel(1);
	RunPanel p12=new RunPanel(2);
	RunPanel p13=new RunPanel(3);
	
	RunThread r1=new RunThread(p11);
	RunThread r2=new RunThread(p12);
	RunThread r3=new RunThread(p13);
	
	MyFrame()
	{
		this.setSize(800,400);
		Container c=this.getContentPane();
		BorderLayout b=new BorderLayout(10,10);
		c.setLayout(b);
		p1.add(t1);
		p1.add(b1);
		c.add(p1,BorderLayout.SOUTH);
		p2.setLayout(new GridLayout(3,1));
		p2.add(p11);
		p2.add(p12);
		p2.add(p13);
		c.add(p2,BorderLayout.CENTER);
		this.setTitle("the horse competition game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	    
		
		b1.addActionListener(new action());
	}
	class action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			r1.start();
			r2.start();
			r3.start();
			j=Integer.parseInt(t1.getText());
		}
	}
	class RunThread extends Thread
	{
		RunPanel p;
		RunThread(RunPanel p)
		{
			this.p=p;
		}
		public void run()
		{
			while(p.result<600)
			{
				p.repaint();
				try
				{
					sleep(500);
				}catch(Exception e){}
			}
		}
	}
	public class RunPanel extends JPanel
	{
		private int i;
		public int result;
		public RunPanel(int i)
		{
			super();
			this.i=i;
			initGUI();
		}
		public void initGUI()
		{
			try{
				setPreferredSize(new Dimension(800,60));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(this.getBackground());
			g.fillRect(1,10,result,11);
			switch(i)
			{
			case 1:
				g.setColor(Color.blue);
				g.fillOval(600, 10, 20, 20);
				g.fillRect(result,10,20,20);
				break;
			case 2:
				g.setColor(Color.red);
				g.fillOval(600, 10, 20, 20);
				g.fillRect(result, 10,20,20);
				break;
			case 3:
				g.setColor(Color.yellow);
				g.fillOval(600,10,20,20);
				g.fillRect(result, 10,20,20);
				break;
			}
			result+=(int)(Math.random()*50);
			result=(result>=750?result=750:result);
			System.out.print(result);
			if(i==j)
			{
				if(result>=600)
				{
					if(t1.getText().length()<3)
					{
						t1.setText("your are right");
					}
				}
				if(result>=600)
				{
					if(i!=j)
					{
						if(t1.getText().length()<3)
						{
							t1.setText("you are wrong");
						}
					}
				}				
			}
		}
	}
}