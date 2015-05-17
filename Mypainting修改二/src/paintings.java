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
	
	//参数
	private JButton choices[];         //按钮数组，存放以下名称的功能按钮
	JToolBar buttonPanel;              //定义按钮面板
	JCheckBox  bold,italic;      //定义字体风格选择框 ,复选框 
	//JComboBox styles=null;          //声明组合框
	String style1="宋体";              //用来存放当前字体
	/*private String styleNames[]={
	        "宋体","隶书","华文彩云","仿宋_GB2312","华文行楷",
	        "方正舒体","Times New Roman","Serif","Monospaced",
	        "SonsSerif","Garamond"
	    };  */
	private JLabel a;            //显示鼠标状态的提示条
	int currentChoice=3;            //设置默认画图状态为随笔画
	public int index=0;             //当前已经绘制的图形数目 
	private float stroke=1.0f;  //设置画笔粗细，默认值为1.0f  
	private DrawPanel drawingArea;       //画图区域
	drawings[] itemList=new drawings[5000]; //用来存放基本图形的数组        
	
	
	private ObjectInputStream input;
	private ObjectOutputStream output; //定义输入输出流，用来调用和保存图像文件  
   
    private Color color=Color.black;     //当前画笔颜色
    int R, G, B;                          //用来存放当前色彩值
    int f1, f2;                  //用来存放当前字体风格    
    
    
    
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
        "新建",
        "打开",
        "保存",
        "铅笔画",
        "直线",
        "空心矩形",
        "填充矩形",
        "空心椭圆",
        "填充椭圆",
        "空心圆形",
        "填充圆形",
        "空心圆角矩形",
        "填充圆角矩形",
        "橡皮擦",
        "颜色",
        "线条",
        "输入文本"
    };	
	painting() 
	{		
		this.setSize(1150,700);       	
		//布局
		Container con=this.getContentPane();	
	    BorderLayout b=new BorderLayout(10,10);//边界布局
		con.setLayout(b);	
		//创建各种基本图形的按钮
		drawingArea=new DrawPanel();
		choices=new JButton[names.length];
		buttonPanel=new JToolBar();	//工具栏		
		//导入工具图标
		for(int i=0;i<choices.length;i++)
		{			
			choices[i]=new JButton("");
			choices[i].setToolTipText(tipText[i]);
			choices[i].setText(names[i]);			
			buttonPanel.add(choices[i]);
		}
		//将动作侦听器加入按钮里面
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
      //字体风格选择
       // styles=new JComboBox(styleNames);//创建组合框
        //styles.setMaximumRowCount(8);
        //styles.setVisibleRowCount(4);
       /* styles.addItemListener(//ItemListener用于捕获带有item的组件产生的事件，如ComboBox，CheckBox，
        		new ItemListener() //。为了在被选中的项发生改变时获得被选中的项，所以使用的ItemStateChanged事件
        		{
        			public void itemStateChanged(ItemEvent e) 
        			{
        				//style1=styleNames[styles.getSelectedIndex()];//getSelectedIndex()得到链表中所选项目的索引，getSelectedIndex是选中项目的下标，是int型
        				style1= frontName[styles.getSelectedIndex()];  
        			}
        		});*/
        //字体选择
        bold=new JCheckBox("粗体");
        italic=new JCheckBox("斜体");        
        bold.addItemListener(new checkBoxHandler());
        italic.addItemListener(new checkBoxHandler());        
        buttonPanel.add(bold);//添加复选框粗体
        buttonPanel.add(italic);//添加复选框斜体       
        //buttonPanel.add(styles);//列表框
        //菜单项
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu jm01=new JMenu("文件(E)");		
		JMenu jm02=new JMenu("设置(S)");
		JMenu jm05=new JMenu("帮助(H)");
		jmb.add(jm01);	
		jmb.add(jm02);
		jmb.add(jm05);	
		JMenuItem jmt01=new JMenuItem("新建(N)");
		JMenuItem jmt02=new JMenuItem("保存(S)");
		JMenuItem jmt03=new JMenuItem("打开(L)");
		JMenuItem jmt07=new JMenuItem("退出(X)");	
		jm01.add(jmt01);
		jm01.add(jmt02);
		jm01.add(jmt03);
		jm01.add(jmt07);	
		JMenuItem set01=new JMenuItem("颜色(o)");
		JMenuItem set02=new JMenuItem("线条(K)");
		jm02.add(set01);
		jm02.add(set02);
		JMenuItem help01=new JMenuItem("帮助(H)");
		JMenuItem help02=new JMenuItem("关于画图(A)");
		jm05.add(help01);
		jm05.add(help02);
		//文件添加监听器
		jmt01.addActionListener(new action1());
		jmt02.addActionListener(new action2());
		jmt03.addActionListener(new action3());
		jmt07.addActionListener(this);	
		//设置添加监听器
		set01.addActionListener(new action4());
		set02.addActionListener(new action5());
		//帮助，关于计算机器内容添加监听器
		help01.addActionListener(this);
		help02.addActionListener(this);	
		con.add(buttonPanel, BorderLayout.NORTH);
		con.add(drawingArea, BorderLayout.CENTER);		
		a=new JLabel();
		con.add(a, BorderLayout.SOUTH);
		a.setText("     欢迎进入图霸!!!  :)");
		
		
		createNewItem();
		
		
		this.setTitle("图霸");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//这行代码会在window关闭的时候将程序结束掉		
		this.setVisible(true);//最后将框架显示出来			
	}		
	
	
	class action1 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			 newFile();//如果被触发，则调用新建文件函数段	
		}
	}
	class action2 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			saveFile();//如果被触发，则调用保存文件函数段 

		}
	}
	class action3 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		openFile();//如果被触发，则调用打开文件函数段	
		}
	}
	class action4 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		chooseColor();//如果被触发，则调用选择颜色函数段		 
		}
	}
	class action5 implements  ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
            setStroke();//线条
	        
		}
	}		
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand()=="退出(X)")
		{
		int result=JOptionPane.showConfirmDialog(this,"确定要退出吗？","系统消息",JOptionPane.YES_NO_OPTION);
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
		if(e.getActionCommand()=="关于画图(A)")
		{
			JOptionPane.showMessageDialog(this,"大志牌画图软件--图霸，G1——420工作室出版，版权所有，翻版必究","系统消息",JOptionPane.INFORMATION_MESSAGE);
			
		}
	}	
	//选择字体风格时候用到的事件监听器类，加入到字体风格的选择框中
    private class checkBoxHandler implements ItemListener 
    {
    	public void itemStateChanged(ItemEvent e) 
    	{
    		if(e.getSource()==bold) //粗体
    		{
                if (e.getStateChange()==ItemEvent.SELECTED)//用于判断组件是否被选中，若被选中则反回true否则为false
                {f1= Font.BOLD;} 
                else 
                {f1=Font.PLAIN;}
            }
    		if (e.getSource()==italic)//斜字体
    		{
                if (e.getStateChange()==ItemEvent.SELECTED) 
                {f2=Font.ITALIC;} //Font font=new Font("宋体",Font.BOLD+Font.ITALIC,12);
                else 
                {f2=Font.PLAIN;}
            }
        }
    } 
  //保存图形文件程序段
  //保存图像文件程序段，用到文件对（FileOupputSream）象流  
  	public void saveFile() 
  	{
  		JFileChooser fileChooser=new JFileChooser();//打开一个文件选择对话框
  		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//setFileSelectionMode()设置 JFileChooser，以允许用户只选择文件、只选择目录，或者可选择文件和目录。  
  		int result=fileChooser.showSaveDialog(this);//打开保存对话框
  		if(result==JFileChooser.CANCEL_OPTION)//选择cancel后返回该值
  		{
  			return;
  		}
  		File fileName=fileChooser.getSelectedFile();  		//获取选择的文件,也就是返回选中的文件	//getSelectedFile()返回选中的文件  		
  		fileName.canWrite();//测试应用程序是否可以修改此抽象路径名表示的文件  
  		if (fileName==null||fileName.getName().equals("")) //文件名不存在时
  		{
  			JOptionPane.showMessageDialog(fileChooser,"无效的文件名","无效的文件名", JOptionPane.ERROR_MESSAGE);
  	    }
  		else
  		{
  	        try{
  	        	fileName.delete();//删除此抽象路径名表示的文件或目录  
  	            FileOutputStream fos=new FileOutputStream(fileName);//文件输出流以字节的方式输出  
  	            
  	            output=new ObjectOutputStream(fos);//对象输出流  
  	            //drawings record;
  	            
  	            output.writeInt(index);
  	            for (int i=0;i<index;i++) 
  	            {
  	                drawings p=itemList[i];
  	                output.writeObject(p);//将所有图形信息强制转换成父类线性化存储到文件中
  	                output.flush();    //刷新该流的缓冲。此操作将写入所有已缓冲的输出字节，并将它们刷新到底层流中。  
  	            }
  	            output.close();
  	            fos.close();
  	            } catch (IOException ioe){
  	            	ioe.printStackTrace();
  	           }
  	    }
  	}
  	//打开一个图形文件程序段
  	public void openFile() 
  	{
  	    JFileChooser fileChooser = new JFileChooser();
  	    //打开一个文件选择对话框
  	    ////JFileChooser 为用户选择文件提供了一种简单的机制  
  	    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
  	    //修改对话框文件选择的模式，比如只允许选择文件夹,仅选择文件    
  	    int result = fileChooser.showOpenDialog(this);//打开保存对话框
  	    if (result == JFileChooser.CANCEL_OPTION) //选择cancel后返回该值
  	    {
  	        return;
  	    }
  	    File fileName = fileChooser.getSelectedFile();
  	    //获取选择的文件,也就是返回选中的文件
  	    ////getSelectedFile()返回选中的文件
  	    fileName.canRead();
  	    if(fileName==null||fileName.getName().equals("")) 
  	    {
  	        JOptionPane.showMessageDialog(fileChooser,"无效的文件名","无效的文件名",JOptionPane.ERROR_MESSAGE);
  	    } 
  	    else 
  	    {
  	        try{
  	            FileInputStream fis=new FileInputStream(fileName);
  	            
  	            input=new ObjectInputStream(fis);//文件输出流以字节的方式输出  
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
  	//新建一个文件程序段
  	public void newFile() 
  	{
  	    index=0;
  	    currentChoice=3;
  	    color=Color.black;
  	    stroke=1.0f;
  	    createNewItem();
  	    repaint();//将有关值设置为初始状态，并且重画
  	}
  //选择当前颜色程序段
    public void chooseColor() 
    {
        color=JColorChooser.showDialog(painting.this,"请选择颜色", color);//JAVA中自带的选色器 
        R=color.getRed();
        G=color.getGreen();
        B=color.getBlue();
        itemList[index].R=R;
        itemList[index].G=G;
        itemList[index].B=B;
    }
    //选择当前线条粗细程序段
    public void setStroke() 
    {
        String input;
        input=JOptionPane.showInputDialog("请输入你所需要的线条宽度!(>0)");
        stroke=Float.parseFloat(input);
        itemList[index].stroke=stroke;
    }
  //按钮监听器ButtonHanler类，内部类，用来监听基本按钮的操作
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
    //按钮监听器ButtonHanler1类，用来侦听颜色选择、画笔粗细设置、文字输入按钮的操作
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
                JOptionPane.showMessageDialog(null,"请选择文本输入位置","温馨提示(TIP)", JOptionPane.INFORMATION_MESSAGE);
                currentChoice=14;
                createNewItem();
                repaint();
            }
        }
    }
	//新建一个画图基本单元对象的程序段
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
	
    
    //鼠标事件mouseA类，继承了MouseAdapter，用来完成鼠标相应事件操作
    class mouseA extends MouseAdapter 
    {
    	public void mousePressed(MouseEvent e)//按住不放
    	{
    		a.setText("Mouse Pressed @:["+e.getX()+","+e.getY()+"]");//设置状态提示
            itemList[index].x1=itemList[index].x2=e.getX();
            itemList[index].y1=itemList[index].y2=e.getY();

            //如果当前选择的图形是随笔画或者橡皮擦，则进行下面的操作
            if (currentChoice==3||currentChoice==13) 
            {
                itemList[index].x1=itemList[index].x2=e.getX();
                itemList[index].y1=itemList[index].y2=e.getY();
                index++;
                createNewItem();
            }
            //如果当前选择的图形式文字输入，则进行下面操作
            if (currentChoice==14) 
            {
                itemList[index].x1 = e.getX();
                itemList[index].y1 = e.getY();

                String input;
                input=JOptionPane.showInputDialog("请输入你想输入的文本!");
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
        public void mouseReleased(MouseEvent e) //鼠标释放
        {
            a.setText("Mouse Released @:["+e.getX()+","+e.getY()+"]");

            if (currentChoice==3||currentChoice==13) //橡皮擦和画笔
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
    //鼠标事件mouseB类继承了MouseMotionAdapter，用来完成鼠标拖动和鼠标移动时的相应操作
    class mouseB extends MouseMotionAdapter 
    {
        public void mouseDragged(MouseEvent e) //鼠标拖动
        {
            a.setText("Mouse Dragged @:["+e.getX()+","+e.getY()+"]");

            if (currentChoice==3||currentChoice==13) //橡皮擦和画笔
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
    
    //画图面板类，用来画图
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
    		Graphics2D g2d=(Graphics2D)g;   //定义画笔  		
    		
    		int j=0;
    		while(j<=index) 
    		{
    			draw(g2d,itemList[j]);//讲creatitem中的所要画的图形传递下来
    			j++;
    		}
    	}
    	void draw(Graphics2D g2d,drawings a)
    	{
    		a.draw(g2d);//将画笔传入到各个子类中，用来完成各自的绘图
    	}
    }    
}
@SuppressWarnings("serial")
class drawings implements Serializable//父类，基本图形单元，用到串行化接口，保存时所用
{
	int x1,y1,x2,y2; //定义坐标属性
	int R,G,B;        //定义色彩属性
	float stroke;       //定义线条粗细属性	
	String s1;//输入的文本
	String s2;      //定义字体风格属性style1
	void draw(Graphics2D g2d) //定义绘图函数
	{
		
	}	
}
@SuppressWarnings("serial")
class Line extends drawings //直线类
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawLine(x1,y1,x2,y2);
	}
}
@SuppressWarnings("serial")
class Rect extends drawings//矩形类
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawRect(Math.min(x1, x2), Math.min(y1,y2),
		Math.abs(x1 - x2), Math.abs(y1-y2));
	}
}
@SuppressWarnings("serial")
class fillRect extends drawings//实心矩形类
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.fillRect(Math.min(x1,x2), Math.min(y1,y2),Math.abs(x1-x2), Math.abs(y1-y2));
	}
}
@SuppressWarnings("serial")
class Oval extends drawings//椭圆类
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		      
		g2d.drawOval(Math.min(x1,x2), Math.min(y1,y2),Math.abs(x1-x2), Math.abs(y1-y2));
	}
}
@SuppressWarnings("serial")
class fillOval extends drawings//实心椭圆
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));	
		g2d.fillOval(Math.min(x1, x2), Math.min(y1,y2),Math.abs(x1-x2), Math.abs(y1-y2));
	}
}
@SuppressWarnings("serial")
class Circle extends drawings//圆类
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawOval(Math.min(x1, x2), Math.min(y1,y2),Math.max(Math.abs(x1-x2), Math.abs(y1-y2)),Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
    }
}
@SuppressWarnings("serial")
class fillCircle extends drawings//实心圆
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));	
		g2d.fillOval(Math.min(x1,x2), Math.min(y1,y2),Math.max(Math.abs(x1-x2), Math.abs(y1-y2)),Math.max(Math.abs(x1-x2), Math.abs(y1-y2)));
    }
}
@SuppressWarnings("serial")
class RoundRect extends drawings//圆角矩形类
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2),Math.abs(x1-x2), Math.abs(y1-y2),50, 35);
	}
}
@SuppressWarnings("serial")
class fillRoundRect extends drawings//实心圆角矩形类
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2),Math.abs(x1-x2), Math.abs(y1-y2),50,35);
	}
}
@SuppressWarnings("serial")
class Pencil extends drawings//随笔画类
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R,G,B));		
		g2d.drawLine(x1,y1,x2,y2);
    }
}
@SuppressWarnings("serial")
class Rubber extends drawings//橡皮擦类
{
	void draw(Graphics2D g2d)
	{
		g2d.setPaint(new Color(255,255,255));		
		g2d.drawLine(x1,y1,x2,y2);
	}
}
@SuppressWarnings("serial")
class Word extends drawings//输入文字类
{
	void draw(Graphics2D g2d) 
	{
		g2d.setPaint(new Color(R, G, B));
		g2d.setFont(new Font(s2,x2+y2,((int)stroke)*18));
		//Graphics的getFont()方法和setFont()方法来操纵字体
		if (s1!=null) 
		{
			g2d.drawString(s1,x1,y1);
		}
	}
}
