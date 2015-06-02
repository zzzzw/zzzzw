import javax.swing.*;
import java.awt.*;

public class Example9_5 
{
	public static void main(String args[])
	{
		new MyFrame();
	}
}
@SuppressWarnings("serial")
class MyFrame extends JFrame
{
	JButton[] b=new JButton[10];
	MyFrame()
	{
		this.setSize(300,200);
		this.setLocation(500,200);
		Container container=this.getContentPane();
		FlowLayout f=new FlowLayout(FlowLayout.CENTER,10,10);
		container.setLayout(f);
		for(int i=0;i<b.length;i++)
		{
			b[i]=new JButton("button"+i);
			container.add(b[i]);
		}
		this.setTitle("FlowLayout");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
