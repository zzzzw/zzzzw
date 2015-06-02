import javax.swing.*;
import java.awt.*;
public class Example9_3 
{
	public static void main(String args[])
	{
		JFrame frame=new JFrame();
		frame.setSize(300,300);
		frame.setLocation(100,100);
		frame.setTitle("frame");
		JButton button1=new JButton("button_one");
		JButton button2=new JButton("button_two");
		Container container=frame.getContentPane();
		container.setLayout(new FlowLayout());
		container.add(button1);
		container.add(button2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
	}
	

}
