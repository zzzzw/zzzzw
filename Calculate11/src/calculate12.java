
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
	//����
	private String qian="", hou=""; //�ֱ����ڼ�¼�Ӽ��˳������֮ǰ,֮�����������
    private String op; //���ڼ�¼�����
    private String re;//���ڴ洢���������ַ�����ʽ
    private boolean flag=false; //���ڼ�¼�� �Ƿ����������
    private boolean flag1=false;//�����ж��Ƿ������˵������
    private double result;//���ڴ洢������
    //���
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();	
	//�ı���
	JTextField jtf = new JTextField("0");
	//��ť
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
		this.setResizable(false);//�ߴ粻�ı�
        jtf.setFont(new Font("����",Font.PLAIN,40));//�����ı�������
		jtf.setEditable(false);//�����ı��򲻿ɱ༭
		jtf.setHorizontalAlignment(SwingConstants.RIGHT);//�Ҷ���
		jtf.setBounds(new Rectangle(33, 19, 310, 59));		
		//����
		Container con=this.getContentPane();
		GridLayout g=new GridLayout(4,5,10,10);//���񲼾�
	    BorderLayout b=new BorderLayout(10,10);//�߽粼��
		con.setLayout(b);
		p1.setLayout(g);
		//���p1������
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
		//���P2������
		//p2.add(b10);
		//p2.add(b11);
		//p2.add(b12);		
		//���������
		con.add(jtf,BorderLayout.NORTH);
		con.add(p1,BorderLayout.SOUTH);
		//con.add(p2,BorderLayout.CENTER);		
		//�˵���
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu jm01=new JMenu("�༭(E)");		
		JMenu jm05=new JMenu("����(H)");
		jmb.add(jm01);		
		jmb.add(jm05);		
		JMenuItem jmt07=new JMenuItem("�˳�(X)");		
		jm01.add(jmt07);		
		JMenuItem help01=new JMenuItem("����(H)");
		JMenuItem help02=new JMenuItem("���ڼ�����(A)");
		jm05.add(help01);
		jm05.add(help02);
		//�༭��Ӽ�����
		jmt07.addActionListener(this);	
		//���������ڼ������������Ӽ�����
		help01.addActionListener(this);
		help02.addActionListener(this);
		//���ּ���Ӽ�����
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
		//�Ӽ��˳���Ӽ�����
		b13.addActionListener(new action1());
		b15.addActionListener(new action1());
		b17.addActionListener(new action1());
		b19.addActionListener(new action1());
		//=��Ӽ�����
		b20.addActionListener(new action2());
		//.��Ӽ�����
		b22.addActionListener(new action3());
		//C��Ӽ�����
		//b12.addActionListener(new action4());
		b18.addActionListener(new action4());
		//+/-��Ӽ�����
		b21.addActionListener(new action5());
		//<--��Ӽ�����
		//b10.addActionListener(new action6());
		b16.addActionListener(new action6());
		//CE��Ӽ�����		
		//b11.addActionListener(new action7());
		//������sqrt��Ӽ�����
		b14.addActionListener(new action7());
		
		
		this.setTitle("��־�ɼ����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���д������window�رյ�ʱ�򽫳��������		
		this.setVisible(true);//��󽫿����ʾ����			
	}	
	class action implements  ActionListener//��������
	{
		public void actionPerformed(ActionEvent e)
		{ 
			if(flag) //����ոհ����������
			{ 
	            jtf.setText("");
	           if (flag1) //�ж�֮ǰ�Ƿ������˵������
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
	            int num=jtf.getText().indexOf(".");//С����ĸ���,numΪ<��ʾû��С����
	            if(num<0&&!jtf.getText().equals("0")) //jtf.getText().equals("0")�жϻ�ȡ���ַ����Ƿ���0
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
	class action1 implements  ActionListener//����+-*/
	{
		public void actionPerformed(ActionEvent e)
		{
	        qian=jtf.getText(); //��¼�Ӽ��˳������֮ǰ���������
	        op=e.getActionCommand(); //�õ��ոհ��µ������	        
	        flag=true; //��¼�Ѿ������˼Ӽ��˳������������һ��
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
	         String re=String.valueOf(result);//doubleת��Ϊstring
	         jtf.setText(re);  
		}
	}
	class action3 implements  ActionListener//.
	{
		public void actionPerformed(ActionEvent e)
		{
			int num=jtf.getText().indexOf(".");
	        if(num<0&&!flag)//���û��С����Ļ�������û�а���������ŵ�ʱ��	 
	            jtf.setText(jtf.getText()+e.getActionCommand());
	        if(flag)
	            flag1=true;		
		}
	}
	class action4 implements  ActionListener//�������C
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
			if(jtf.getText().equals("0"))//����ı�������Ϊ0
			{
	           jtf.setText(jtf.getText());
	        }
			else if(jtf.getText().indexOf("-")>=0)//���ı����к��и���
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
	class action6 implements  ActionListener//<--,�������ߣ���ֻʣ��һλ���ֵ�ʱ����ж�λ���ֵ�ʱ��
	{
		public void actionPerformed(ActionEvent e)
		{
			String a=jtf.getText();
	        if(a.length()==1)//���ı�����ֻʣ�����һ���ַ�,���ı���������Ϊ0
	        {
	            jtf.setText("0");
	        }
	        if(a.length()>1)
	        {
	            a=a.substring(0,a.length()-1);//ȡ�ַ����ĵ�һλ--->�����ڶ�λ
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
		        String b=String.valueOf(a);//doubleת��Ϊstring
		        jtf.setText(b); 
			}
			 
		}
	}
		
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="�˳�(X)")
		{
		int result=JOptionPane.showConfirmDialog(this,"ȷ��Ҫ�˳���������","ϵͳ��Ϣ",JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.YES_OPTION)
		{
			System.exit(0);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		}
		}
		if(e.getActionCommand()=="����(H)")
		{
			JOptionPane.showMessageDialog(this,"�����Ļ��Ұٶ��£���","ϵͳ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			
		}
		if(e.getActionCommand()=="���ڼ�����(A)")
		{
			JOptionPane.showMessageDialog(this,"��־�Ƽ�������G1����420�����ҳ��棬��Ȩ���У�����ؾ�","ϵͳ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			
		}
	}
}

