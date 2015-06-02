import javax.swing.*;
import java.awt.*;
@SuppressWarnings("serial")
public class Example9_7 extends JFrame
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		MyFrameBorder frame=new MyFrameBorder();
	}

}
@SuppressWarnings("serial")
class MyFrameBorder extends JFrame
{
	MyFrameBorder()
	{
		this.setSize(800,600);
		Container container=this.getContentPane();
		BorderLayout b=new BorderLayout(0,0);
		container.setLayout(b);
		container.add(new JButton("east"),BorderLayout.EAST);
		container.add(new JButton("west"),BorderLayout.WEST);
		container.add(new JButton("north"),BorderLayout.NORTH);
		container.add(new JButton("south"),BorderLayout.SOUTH);
		container.add(new JButton("center"),BorderLayout.CENTER);
		this.setTitle("BorderLayout");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
