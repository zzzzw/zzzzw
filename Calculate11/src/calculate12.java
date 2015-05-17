
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class calculate12
{
	
	public static void main(String[] args)
	{
		new jisuanqi();
	}
}
@SuppressWarnings("serial")
class jisuanqi extends JFrame implements ActionListener 
{
	//参数
	private String qian="", hou=""; //分别用于记录加减乘除运算符之前,之后输入的内容
    private String op; //用于记录运算符
    private String re;//用于存储运算结果的字符串格式
    private boolean flag=false; //用于记录· 是否按下了运算符
    private boolean flag1=false;//用于判断是否输入了点运算符
    private double result;//用于存储运算结果
    //面板
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();	
	//文本框
	JTextField jtf = new JTextField("0");
	//按钮
	JButton b0=new JButton("0");
	JButton b1=new JButton("1");
	JButton b2=new JButton("2");
	JButton b3=new JButton("3");
	JButton b4=new JButton("4");
	JButton b5=new JButton("5");
	JButton b6=new JButton("6");
	JButton b7=new JButton("7");
	JButton b8=new JButton("8");
	JButton b9=new JButton("9");	
	JButton b16=new JButton("<--");	
	JButton b18=new JButton("C");
	JButton b13=new JButton("/");
	JButton b14=new JButton("sqrt");
	JButton b15=new JButton("*");
	JButton b17=new JButton("-");
	JButton b19=new JButton("+");
	JButton b20=new JButton("=");
	JButton b21=new JButton("+/-");
	JButton b22=new JButton(".");
	jisuanqi() 
	{
		
		this.setSize(370,280);
		this.setResizable(false);//尺寸不改变
        jtf.setFont(new Font("黑体",Font.PLAIN,40));//设置文本框字体
		jtf.setEditable(false);//设置文本框不可编辑
		jtf.setHorizontalAlignment(SwingConstants.RIGHT);//右对齐
		jtf.setBounds(new Rectangle(33, 19, 310, 59));		
		//布局
		Container con=this.getContentPane();
		GridLayout g=new GridLayout(4,5,10,10);//网格布局
	    BorderLayout b=new BorderLayout(10,10);//边界布局
		con.setLayout(b);
		p1.setLayout(g);
		//面板p1添加组件
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(b13);
		p1.add(b14);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b15);
		p1.add(b16);
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b17);
		p1.add(b18);
		p1.add(b0);
		p1.add(b21);
		p1.add(b22);
		p1.add(b19);
		p1.add(b20);
		//面板P2添加组件
		//p2.add(b10);
		//p2.add(b11);
		//p2.add(b12);		
		//框架添加组价
		con.add(jtf,BorderLayout.NORTH);
		con.add(p1,BorderLayout.SOUTH);
		//con.add(p2,BorderLayout.CENTER);		
		//菜单项
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu jm01=new JMenu("编辑(E)");		
		JMenu jm05=new JMenu("帮助(H)");
		jmb.add(jm01);		
		jmb.add(jm05);		
		JMenuItem jmt07=new JMenuItem("退出(X)");		
		jm01.add(jmt07);		
		JMenuItem help01=new JMenuItem("帮助(H)");
		JMenuItem help02=new JMenuItem("关于计算器(A)");
		jm05.add(help01);
		jm05.add(help02);
		//编辑添加监听器
		jmt07.addActionListener(this);	
		//帮助，关于计算机器内容添加监听器
		help01.addActionListener(this);
		help02.addActionListener(this);
		//数字键添加监听器
		b0.addActionListener(new action());
		b1.addActionListener(new action());
		b2.addActionListener(new action());
		b3.addActionListener(new action());
		b4.addActionListener(new action());
		b5.addActionListener(new action());
		b6.addActionListener(new action());
		b7.addActionListener(new action());
		b8.addActionListener(new action());
		b9.addActionListener(new action());
		//加减乘除添加监听器
		b13.addActionListener(new action1());
		b15.addActionListener(new action1());
		b17.addActionListener(new action1());
		b19.addActionListener(new action1());
		//=添加监听器
		b20.addActionListener(new action2());
		//.添加监听器
		b22.addActionListener(new action3());
		//C添加监听器
		//b12.addActionListener(new action4());
		b18.addActionListener(new action4());
		//+/-添加监听器
		b21.addActionListener(new action5());
		//<--添加监听器
		//b10.addActionListener(new action6());
		b16.addActionListener(new action6());
		//CE添加监听器		
		//b11.addActionListener(new action7());
		//开根号sqrt添加监听器
		b14.addActionListener(new action7());
		
		
		this.setTitle("大志派计算机");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//这行代码会在window关闭的时候将程序结束掉		
		this.setVisible(true);//最后将框架显示出来			
	}	
	class action implements  ActionListener//加载数字
	{
		public void actionPerformed(ActionEvent e)
		{ 
			if(flag) //如果刚刚按下了运算符
			{ 
	            jtf.setText("");
	           if (flag1) //判断之前是否输入了点运算符
	            {
	            	jtf.setText("0."+e.getActionCommand());
	                flag1 = false;
	                hou=jtf.getText();
	            } 
	            else
	            {
	            	jtf.setText(e.getActionCommand());
	            	hou=jtf.getText();
	            }
	        } 
			else 
			{
	            int num=jtf.getText().indexOf(".");//小数点的个数,num为<表示没有小数点
	            if(num<0&&!jtf.getText().equals("0")) //jtf.getText().equals("0")判断获取的字符串是否是0
	            {
	            	jtf.setText(jtf.getText()+e.getActionCommand());
	            } 
	            else if(num<0&&jtf.getText().equals("0")) 
	            {
	            	jtf.setText(e.getActionCommand());
	            } 
	            else if(num>=0&&jtf.getText().equals("0")) 
	            {
	            	jtf.setText("0."+e.getActionCommand());
	            } 
	            else if(num >=0&&!jtf.getText().equals("0")) 
	            {
	            	jtf.setText(jtf.getText()+e.getActionCommand());
	            }
	        }
	        flag = false;
		}
	}
	class action1 implements  ActionListener//加载+-*/
	{
		public void actionPerformed(ActionEvent e)
		{
	        qian=jtf.getText(); //记录加减乘除运算符之前输入的内容
	        op=e.getActionCommand(); //得到刚刚按下的运算符	        
	        flag=true; //记录已经按下了加减乘除运算符的其中一个
		}
	}
	class action2 implements  ActionListener//=
	{
		public void actionPerformed(ActionEvent e)
		{				
			double a1=Double.parseDouble(qian);
	        double b1=Double.parseDouble(hou);
	         if (op=="+") 
	         {result=a1+b1;} 
	         else if(op=="-") 
	         {result=a1-b1;} 
	         else if(op=="*") 
	         {result=a1*b1;} 
	         else 
	         {result=a1/b1;}
int result1=(int)Math.round(result*100);
result=(double)result1/100.00;
	         String re=String.valueOf(result);//double转化为string
	         jtf.setText(re);  
		}
	}
	class action3 implements  ActionListener//.
	{
		public void actionPerformed(ActionEvent e)
		{
			int num=jtf.getText().indexOf(".");
	        if(num<0&&!flag)//如果没有小数点的话，而且没有按下运算符号的时候	 
	            jtf.setText(jtf.getText()+e.getActionCommand());
	        if(flag)
	            flag1=true;		
		}
	}
	class action4 implements  ActionListener//清零操作C
	{
		public void actionPerformed(ActionEvent e)
		{
			flag=false;
	        flag1=false;
	        qian="";
	        hou="";
	        re="";
	        jtf.setText("0");	 
		}
	}
	class action5 implements  ActionListener//+/-
	{
		public void actionPerformed(ActionEvent e)
		{
			if(jtf.getText().equals("0"))//如果文本框内容为0
			{
	           jtf.setText(jtf.getText());
	        }
			else if(jtf.getText().indexOf("-")>=0)//若文本框中含有负号
			{
	            String a=jtf.getText().replaceAll("-","");
	           jtf.setText(a);
	        }
			else
			{
	           jtf.setText("-"+jtf.getText());
	        }	
		}
	}
	class action6 implements  ActionListener//<--,分两步走，①只剩下一位数字的时候②有多位数字的时候
	{
		public void actionPerformed(ActionEvent e)
		{
			String a=jtf.getText();
	        if(a.length()==1)//如文本框中只剩下最后一个字符,将文本框内容置为0
	        {
	            jtf.setText("0");
	        }
	        if(a.length()>1)
	        {
	            a=a.substring(0,a.length()-1);//取字符串的第一位--->倒数第二位
	            jtf.setText(a);
	        }	
		}
	}
	class action7 implements  ActionListener//sqrt
	{
		public void actionPerformed(ActionEvent e)
		{
			double a=Double.parseDouble(jtf.getText()); 
			if(a>=0)   
			{    
				a=Math.sqrt(a);				
		        String b=String.valueOf(a);//double转化为string
		        jtf.setText(b); 
			}
			 
		}
	}
		
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="退出(X)")
		{
		int result=JOptionPane.showConfirmDialog(this,"确定要退出计算器吗？","系统消息",JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.YES_OPTION)
		{
			System.exit(0);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		}
		}
		if(e.getActionCommand()=="帮助(H)")
		{
			JOptionPane.showMessageDialog(this,"不懂的话找百度呗，亲","系统消息",JOptionPane.INFORMATION_MESSAGE);
			
		}
		if(e.getActionCommand()=="关于计算器(A)")
		{
			JOptionPane.showMessageDialog(this,"大志牌计算器，G1——420工作室出版，版权所有，翻版必究","系统消息",JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
}

