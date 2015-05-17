import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
public class paintings
{	
	public static void main(String[] args)
	{
		new painting();
	}
}
@SuppressWarnings("serial")
class painting extends JFrame implements ActionListener 
{
	
	//����
	private JButton choices[];         //��ť���飬����������ƵĹ��ܰ�ť
	JToolBar buttonPanel;              //���尴ť���
	JCheckBox  bold,italic;      //����������ѡ��� ,��ѡ�� 
	//JComboBox styles=null;          //������Ͽ�
	String style1="����";              //������ŵ�ǰ����
	/*private String styleNames[]={
	        "����","����","���Ĳ���","����_GB2312","�����п�",
	        "��������","Times New Roman","Serif","Monospaced",
	        "SonsSerif","Garamond"
	    };  */
	private JLabel a;            //��ʾ���״̬����ʾ��
	int currentChoice=3;            //����Ĭ�ϻ�ͼ״̬Ϊ��ʻ�
	public int index=0;             //��ǰ�Ѿ����Ƶ�ͼ����Ŀ 
	private float stroke=1.0f;  //���û��ʴ�ϸ��Ĭ��ֵΪ1.0f  
	private DrawPanel drawingArea;       //��ͼ����
	drawings[] itemList=new drawings[5000]; //������Ż���ͼ�ε�����        
	
	
	private ObjectInputStream input;
	private ObjectOutputStream output; //����������������������úͱ���ͼ���ļ�  
   
    private Color color=Color.black;     //��ǰ������ɫ
    int R, G, B;                          //������ŵ�ǰɫ��ֵ
    int f1, f2;                  //������ŵ�ǰ������    
    
    
    
    private String names[]={
        "New",
        "Open",
        "Save", 
        "Pencil", 
        "Line",
        "Rect", 
        "fRect", 
        "Oval", 
        "fOval", 
        "Circle", 
        "fCircle", 
        "RoundRect", 
        "frRect", 
        "Rubber", 
        "Color", 
        "Stroke", 
        "Word"     
    };   
    private String tipText[] = {
        "�½�",
        "��",
        "����",
        "Ǧ�ʻ�",
        "ֱ��",
        "���ľ���",
        "������",
        "������Բ",
        "�����Բ",
        "����Բ��",
        "���Բ��",
        "����Բ�Ǿ���",
        "���Բ�Ǿ���",
        "��Ƥ��",
        "��ɫ",
        "����",
        "�����ı�"
    };	
	painting() 
	{		
		this.setSize(1150,700);       	
		//����
		Container con=this.getContentPane();	
	    BorderLayout b=new BorderLayout(10,10);//�߽粼��
		con.setLayout(b);	
		//�������ֻ���ͼ�εİ�ť
		drawingArea=new DrawPanel();
		choices=new JButton[names.length];
		buttonPanel=new JToolBar();	//������		
		//���빤��ͼ��
		for(int i=0;i<choices.length;i++)
		{			
			choices[i]=new JButton("");
			choices[i].setToolTipText(tipText[i]);
			choices[i].setText(names[i]);			
			buttonPanel.add(choices[i]);
		}
		//���������������밴ť����
		choices[0].addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						newFile();
					}
				});
		choices[1].addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						openFile();
					}
				});
		choices[2].addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						saveFile();
					}
				});		
		for(int i=3;i<choices.length-3;i++) 
		{			
			choices[i].addActionListener(new ButtonHandler());
		}		
		choices[choices.length-3].addActionListener(new ButtonHandler1());
        choices[choices.length-2].addActionListener(new ButtonHandler1());
        choices[choices.length-1].addActionListener(new ButtonHandler1()); 
      //������ѡ��
       // styles=new JComboBox(styleNames);//������Ͽ�
        //styles.setMaximumRowCount(8);
        //styles.setVisibleRowCount(4);
       /* styles.addItemListener(//ItemListener���ڲ������item������������¼�����ComboBox��CheckBox��
        		new ItemListener() //��Ϊ���ڱ�ѡ�е�����ı�ʱ��ñ�ѡ�е������ʹ�õ�ItemStateChanged�¼�
        		{
        			public void itemStateChanged(ItemEvent e) 
        			{
        				//style1=styleNames[styles.getSelectedIndex()];//getSelectedIndex()�õ���������ѡ��Ŀ��������getSelectedIndex��ѡ����Ŀ���±꣬��int��
        				style1= frontName[styles.getSelectedIndex()];  
        			}
        		});*/
        //����ѡ��
        bold=new JCheckBox("����");
        italic=new JCheckBox("б��");        
        bold.addItemListener(new checkBoxHandler());
        italic.addItemListener(new checkBoxHandler());        
        buttonPanel.add(bold);//��Ӹ�ѡ�����
        buttonPanel.add(italic);//��Ӹ�ѡ��б��       
        //buttonPanel.add(styles);//�б��
        //�˵���
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu jm01=new JMenu("�ļ�(E)");		
		JMenu jm02=new JMenu("����(S)");
		JMenu jm05=new JMenu("����(H)");
		jmb.add(jm01);	
		jmb.add(jm02);
		jmb.add(jm05);	
		JMenuItem jmt01=new JMenuItem("�½�(N)");
		JMenuItem jmt02=new JMenuItem("����(S)");
		JMenuItem jmt03=new JMenuItem("��(L)");
		JMenuItem jmt07=new JMenuItem("�˳�(X)");	
		jm01.add(jmt01);
		jm01.add(jmt02);
		jm01.add(jmt03);
		jm01.add(jmt07);	
		JMenuItem set01=new JMenuItem("��ɫ(o)");
		JMenuItem set02=new JMenuItem("����(K)");
		jm02.add(set01);
		jm02.add(set02);
		JMenuItem help01=new JMenuItem("����(H)");
		JMenuItem help02=new JMenuItem("���ڻ�ͼ(A)");
		jm05.add(help01);
		jm05.add(help02);
		//�ļ���Ӽ�����
		jmt01.addActionListener(new action1());
		jmt02.addActionListener(new action2());
		jmt03.addActionListener(new action3());
		jmt07.addActionListener(this);	
		//������Ӽ�����
		set01.addActionListener(new action4());
		set02.addActionListener(new action5());
		//���������ڼ������������Ӽ�����
		help01.addActionListener(this);
		help02.addActionListener(this);	
		con.add(buttonPanel, BorderLayout.NORTH);
		con.add(drawingArea, BorderLayout.CENTER);		
		a=new JLabel();
		con.add(a, BorderLayout.SOUTH);
		a.setText("     ��ӭ����ͼ��!!!  :)");
		
		
		createNewItem();
		
		
		this.setTitle("ͼ��");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���д������window�رյ�ʱ�򽫳��������		
		this.setVisible(true);//��󽫿����ʾ����			
	}		
	
	
	class action1 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			 newFile();//�����������������½��ļ�������	
		}
	}
	class action2 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			saveFile();//���������������ñ����ļ������� 

		}
	}
	class action3 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		openFile();//���������������ô��ļ�������	
		}
	}
	class action4 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		chooseColor();//����������������ѡ����ɫ������		 
		}
	}
	class action5 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
            setStroke();//����
	        
		}
	}		
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="�˳�(X)")
		{
		int result=JOptionPane.showConfirmDialog(this,"ȷ��Ҫ�˳���","ϵͳ��Ϣ",JOptionPane.YES_NO_OPTION);
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
		if(e.getActionCommand()=="���ڻ�ͼ(A)")
		{
			JOptionPane.showMessageDialog(this,"��־�ƻ�ͼ���--ͼ�ԣ�G1����420�����ҳ��棬��Ȩ���У�����ؾ�","ϵͳ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			
		}
	}	
	//ѡ��������ʱ���õ����¼��������࣬���뵽�������ѡ�����
    private class checkBoxHandler implements ItemListener 
    {
    	public void itemStateChanged(ItemEvent e) 
    	{
    		if(e.getSource()==bold) //����
    		{
                if (e.getStateChange()==ItemEvent.SELECTED)//�����ж�����Ƿ�ѡ�У�����ѡ���򷴻�true����Ϊfalse
                {f1= Font.BOLD;} 
                else 
                {f1=Font.PLAIN;}
            }
    		if (e.getSource()==italic)//б����
    		{
                if (e.getStateChange()==ItemEvent.SELECTED) 
                {f2=Font.ITALIC;} //Font font=new Font("����",Font.BOLD+Font.ITALIC,12);
                else 
                {f2=Font.PLAIN;}
            }
        }
    } 
  //����ͼ���ļ������
  //����ͼ���ļ�����Σ��õ��ļ��ԣ�FileOupputSream������  
  	public void saveFile() 
  	{
  		JFileChooser fileChooser=new JFileChooser();//��һ���ļ�ѡ��Ի���
  		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//setFileSelectionMode()���� JFileChooser���������û�ֻѡ���ļ���ֻѡ��Ŀ¼�����߿�ѡ���ļ���Ŀ¼��  
  		int result=fileChooser.showSaveDialog(this);//�򿪱���Ի���
  		if(result==JFileChooser.CANCEL_OPTION)//ѡ��cancel�󷵻ظ�ֵ
  		{
  			return;
  		}
  		File fileName=fileChooser.getSelectedFile();  		//��ȡѡ����ļ�,Ҳ���Ƿ���ѡ�е��ļ�	//getSelectedFile()����ѡ�е��ļ�  		
  		fileName.canWrite();//����Ӧ�ó����Ƿ�����޸Ĵ˳���·������ʾ���ļ�  
  		if (fileName==null||fileName.getName().equals("")) //�ļ���������ʱ
  		{
  			JOptionPane.showMessageDialog(fileChooser,"��Ч���ļ���","��Ч���ļ���", JOptionPane.ERROR_MESSAGE);
  	    }
  		else
  		{
  	        try{
  	        	fileName.delete();//ɾ���˳���·������ʾ���ļ���Ŀ¼  
  	            FileOutputStream fos=new FileOutputStream(fileName);//�ļ���������ֽڵķ�ʽ���  
  	            
  	            output=new ObjectOutputStream(fos);//���������  
  	            //drawings record;
  	            
  	            output.writeInt(index);
  	            for (int i=0;i<index;i++) 
  	            {
  	                drawings p=itemList[i];
  	                output.writeObject(p);//������ͼ����Ϣǿ��ת���ɸ������Ի��洢���ļ���
  	                output.flush();    //ˢ�¸����Ļ��塣�˲�����д�������ѻ��������ֽڣ���������ˢ�µ��ײ����С�  
  	            }
  	            output.close();
  	            fos.close();
  	            } catch (IOException ioe){
  	            	ioe.printStackTrace();
  	           }
  	    }
  	}
  	//��һ��ͼ���ļ������
  	public void openFile() 
  	{
  	    JFileChooser fileChooser = new JFileChooser();
  	    //��һ���ļ�ѡ��Ի���
  	    ////JFileChooser Ϊ�û�ѡ���ļ��ṩ��һ�ּ򵥵Ļ���  
  	    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
  	    //�޸ĶԻ����ļ�ѡ���ģʽ������ֻ����ѡ���ļ���,��ѡ���ļ�    
  	    int result = fileChooser.showOpenDialog(this);//�򿪱���Ի���
  	    if (result == JFileChooser.CANCEL_OPTION) //ѡ��cancel�󷵻ظ�ֵ
  	    {
  	        return;
  	    }
  	    File fileName = fileChooser.getSelectedFile();
  	    //��ȡѡ����ļ�,Ҳ���Ƿ���ѡ�е��ļ�
  	    ////getSelectedFile()����ѡ�е��ļ�
  	    fileName.canRead();
  	    if(fileName==null||fileName.getName().equals("")) 
  	    {
  	        JOptionPane.showMessageDialog(fileChooser,"��Ч���ļ���","��Ч���ļ���",JOptionPane.ERROR_MESSAGE);
  	    } 
  	    else 
  	    {
  	        try{
  	            FileInputStream fis=new FileInputStream(fileName);
  	            
  	            input=new ObjectInputStream(fis);//�ļ���������ֽڵķ�ʽ���  
  	            drawings inputRecord;
  	            
  	            int countNumber=0;
  	            countNumber=input.readInt();

  	            for(index=0;index<countNumber;index++) 
  	            {
  	                inputRecord=(drawings)input.readObject();
  	                itemList[index]=inputRecord;
  	            }
  	            
  	            createNewItem();
  	            input.close();

  	            repaint();
  	        } catch (EOFException endofFileException){
  	            JOptionPane.showMessageDialog(this, "no more record in file","class not found", JOptionPane.ERROR_MESSAGE);
  	        } catch (ClassNotFoundException classNotFoundException){JOptionPane.showMessageDialog(this,"Unable to Create Object", "end of file", JOptionPane.ERROR_MESSAGE);
  	        } catch (IOException ioException){
  	            JOptionPane.showMessageDialog(this,"error during read from file","read Error", JOptionPane.ERROR_MESSAGE);
  	        }
  	    }
  	}
  	//�½�һ���ļ������
  	public void newFile() 
  	{
  	    index=0;
  	    currentChoice=3;
  	    color=Color.black;
  	    stroke=1.0f;
  	    createNewItem();
  	    repaint();//���й�ֵ����Ϊ��ʼ״̬�������ػ�
  	}
  //ѡ��ǰ��ɫ�����
    public void chooseColor() 
    {
        color=JColorChooser.showDialog(painting.this,"��ѡ����ɫ", color);//JAVA���Դ���ѡɫ�� 
        R=color.getRed();
        G=color.getGreen();
        B=color.getBlue();
        itemList[index].R=R;
        itemList[index].G=G;
        itemList[index].B=B;
    }
    //ѡ��ǰ������ϸ�����
    public void setStroke() 
    {
        String input;
        input=JOptionPane.showInputDialog("������������Ҫ���������!(>0)");
        stroke=Float.parseFloat(input);
        itemList[index].stroke=stroke;
    }
  //��ť������ButtonHanler�࣬�ڲ��࣬��������������ť�Ĳ���
    public class ButtonHandler implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
        	for(int p=3;p<choices.length-3;p++) 
        	{
        		if(e.getSource()==choices[p])
        		{
        			currentChoice=p;
        			createNewItem();
        			repaint();
                } 
            }
        }
    }
    //��ť������ButtonHanler1�࣬����������ɫѡ�񡢻��ʴ�ϸ���á��������밴ť�Ĳ���
    public class ButtonHandler1 implements ActionListener 
    {   
    	public void actionPerformed(ActionEvent e) 
    	{
    		if(e.getSource()==choices[choices.length-3])
    		{      
                chooseColor();
            }
            if(e.getSource()==choices[choices.length-2])
            {
                setStroke();
            }
            if(e.getSource()==choices[choices.length-1]) 
            {
                JOptionPane.showMessageDialog(null,"��ѡ���ı�����λ��","��ܰ��ʾ(TIP)", JOptionPane.INFORMATION_MESSAGE);
                currentChoice=14;
                createNewItem();
                repaint();
            }
        }
    }
	//�½�һ����ͼ������Ԫ����ĳ����
    void createNewItem() 
    {        
        switch(currentChoice) 
        {
            case 3:
                itemList[index]=new Pencil();
                break;
            case 4:
                itemList[index]=new Line();
                break;
            case 5:
                itemList[index]=new Rect();
                break;
            case 6:
                itemList[index]=new fillRect();
                break;
            case 7:
                itemList[index]=new Oval();
                break;
            case 8:
                itemList[index]=new fillOval();
                break;
            case 9:
                itemList[index]=new Circle();
                break;
            case 10:
                itemList[index]=new fillCircle();
                break;
            case 11:
                itemList[index]=new RoundRect();
                break;
            case 12:
                itemList[index]=new fillRoundRect();
                break;
            case 13:
                itemList[index]=new Rubber();
                break;
            case 14:
                itemList[index]=new Word();
                break;
        }        
        itemList[index].R=R;
        itemList[index].G=G;
        itemList[index].B=B;
        itemList[index].stroke=stroke;
    }
	
    
    //����¼�mouseA�࣬�̳���MouseAdapter��������������Ӧ�¼�����
    class mouseA extends MouseAdapter 
    {
    	public void mousePressed(MouseEvent e)//��ס����
    	{
    		a.setText("Mouse Pressed @:["+e.getX()+","+e.getY()+"]");//����״̬��ʾ
            itemList[index].x1=itemList[index].x2=e.getX();
            itemList[index].y1=itemList[index].y2=e.getY();

            //�����ǰѡ���ͼ������ʻ�������Ƥ�������������Ĳ���
            if (currentChoice==3||currentChoice==13) 
            {
                itemList[index].x1=itemList[index].x2=e.getX();
                itemList[index].y1=itemList[index].y2=e.getY();
                index++;
                createNewItem();
            }
            //�����ǰѡ���ͼ��ʽ�������룬������������
            if (currentChoice==14) 
            {
                itemList[index].x1 = e.getX();
                itemList[index].y1 = e.getY();

                String input;
                input=JOptionPane.showInputDialog("����������������ı�!");
                itemList[index].s1=input;
                itemList[index].x2=f1;
                itemList[index].y2=f2;
                itemList[index].s2=style1;

                index++;
                //currentChoice=14;
                createNewItem();
                drawingArea.repaint();
            }
        }
        public void mouseReleased(MouseEvent e) //����ͷ�
        {
            a.setText("Mouse Released @:["+e.getX()+","+e.getY()+"]");

            if (currentChoice==3||currentChoice==13) //��Ƥ���ͻ���
            {
                itemList[index].x1=e.getX();
                itemList[index].y1=e.getY();
            }
            itemList[index].x2=e.getX();
            itemList[index].y2=e.getY();
            drawingArea.repaint();
            index++;
            createNewItem();
        }
        public void mouseEntered(MouseEvent e) 
        {
            a.setText("Mouse Entered @:["+e.getX()+","+e.getY()+"]");
        }
        public void mouseExited(MouseEvent e) 
        {
            a.setText("Mouse Exited @:["+e.getX()+","+e.getY()+"]");
        }
    }
    //����¼�mouseB��̳���MouseMotionAdapter�������������϶�������ƶ�ʱ����Ӧ����
    class mouseB extends MouseMotionAdapter 
    {
        public void mouseDragged(MouseEvent e) //����϶�
        {
            a.setText("Mouse Dragged @:["+e.getX()+","+e.getY()+"]");

            if (currentChoice==3||currentChoice==13) //��Ƥ���ͻ���
            {
                itemList[index-1].x1=itemList[index].x2=itemList[index].x1=e.getX();
                itemList[index-1].y1=itemList[index].y2=itemList[index].y1=e.getY();
                index++;
                createNewItem();
            } 
            else 
            {
                itemList[index].x2=e.getX();
                itemList[index].y2=e.getY();
            }
            drawingArea.repaint();
        }
        public void mouseMoved(MouseEvent e) 
        {
            a.setText("Mouse Moved @:["+e.getX()+","+e.getY()+"]");
        }
    }
    
    //��ͼ����࣬������ͼ
    class DrawPanel extends JPanel 
    {
    	public DrawPanel() 
    	{          
    		setBackground(Color.white);
    		addMouseListener(new mouseA());
    		addMouseMotionListener(new mouseB());
    	}     
    	public void paintComponent(Graphics g) 
    	{
    		super.paintComponent(g);
    		Graphics2D g2d=(Graphics2D)g;   //���廭��  		
    		
    		int j=0;
    		while(j<=index) 
    		{
    			draw(g2d,itemList[j]);//��creatitem�е���Ҫ����ͼ�δ�������
    			j++;
    		}
    	}
    	void draw(Graphics2D g2d,drawings a)
    	{
    		a.draw(g2d);//�����ʴ��뵽���������У�������ɸ��ԵĻ�ͼ
    	}
    }    
}
@SuppressWarnings("serial")
class drawings implements Serializable//���࣬����ͼ�ε�Ԫ���õ����л��ӿڣ�����ʱ����
{
	int x1,y1,x2,y2; //������������
	int R,G,B;        //����ɫ������
	float stroke;       //����������ϸ����	
	String s1;//������ı�
	String s2;      //��������������style1
	void draw(Graphics2D g2d) //�����ͼ����
	{
		
	}	
}
@SuppressWarnings("serial")
class Line extends drawings //ֱ����
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawLine(x1,y1,x2,y2);
	}
}
@SuppressWarnings("serial")
class Rect extends drawings//������
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawRect(Math.min(x1, x2), Math.min(y1,y2),
		Math.abs(x1 - x2), Math.abs(y1-y2));
	}
}
@SuppressWarnings("serial")
class fillRect extends drawings//ʵ�ľ�����
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.fillRect(Math.min(x1,x2), Math.min(y1,y2),Math.abs(x1-x2), Math.abs(y1-y2));
	}
}
@SuppressWarnings("serial")
class Oval extends drawings//��Բ��
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		      
		g2d.drawOval(Math.min(x1,x2), Math.min(y1,y2),Math.abs(x1-x2), Math.abs(y1-y2));
	}
}
@SuppressWarnings("serial")
class fillOval extends drawings//ʵ����Բ
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));	
		g2d.fillOval(Math.min(x1, x2), Math.min(y1,y2),Math.abs(x1-x2), Math.abs(y1-y2));
	}
}
@SuppressWarnings("serial")
class Circle extends drawings//Բ��
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawOval(Math.min(x1, x2), Math.min(y1,y2),Math.max(Math.abs(x1-x2), Math.abs(y1-y2)),Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
    }
}
@SuppressWarnings("serial")
class fillCircle extends drawings//ʵ��Բ
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));	
		g2d.fillOval(Math.min(x1,x2), Math.min(y1,y2),Math.max(Math.abs(x1-x2), Math.abs(y1-y2)),Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
    }
}
@SuppressWarnings("serial")
class RoundRect extends drawings//Բ�Ǿ�����
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2),Math.abs(x1-x2), Math.abs(y1-y2),50, 35);
	}
}
@SuppressWarnings("serial")
class fillRoundRect extends drawings//ʵ��Բ�Ǿ�����
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2),Math.abs(x1-x2), Math.abs(y1-y2),50,35);
	}
}
@SuppressWarnings("serial")
class Pencil extends drawings//��ʻ���
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawLine(x1,y1,x2,y2);
    }
}
@SuppressWarnings("serial")
class Rubber extends drawings//��Ƥ����
{
	void draw(Graphics2D g2d)
	{
		g2d.setPaint(new Color(255,255,255));		
		g2d.drawLine(x1,y1,x2,y2);
	}
}
@SuppressWarnings("serial")
class Word extends drawings//����������
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R, G, B));
		g2d.setFont(new Font(s2,x2+y2,((int)stroke)*18));
		//Graphics��getFont()������setFont()��������������
		if (s1!=null) 
		{
			g2d.drawString(s1,x1,y1);
		}
	}
}
