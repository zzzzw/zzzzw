import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Game111111
{	
	public static void main(String[] args)
	{
		new game();
	}
}
@SuppressWarnings("serial")
class game extends JFrame implements ActionListener 
{	    
	Tetrisblok a = new Tetrisblok();
	Timer timer = new Timer(750, a.new TimerListener());
	game() 
	{		
		this.setSize(500,400);
		this.setResizable(false);//尺寸不改变        
		//布局
		Container con=this.getContentPane();		
		con.add(a);
		
        timer.start();
		//a. timer.start();		
		//菜单栏和菜单项
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu jm01=new JMenu("游戏(G)");		
		JMenu jm02=new JMenu("帮助(H)");
		jmb.add(jm01);		
		jmb.add(jm02);
		JMenuItem jmt01=new JMenuItem("新游戏");
		JMenuItem jmt02=new JMenuItem("继续");
		JMenuItem jmt03=new JMenuItem("暂停");
		JMenuItem jmt04=new JMenuItem("退出(X)");		
		jm01.add(jmt01);
		jm01.add(jmt02);
		jm01.add(jmt03);
		jm01.add(jmt04);
		JMenuItem help01=new JMenuItem("帮助(H)");
		JMenuItem help02=new JMenuItem("关于俄罗斯方块(A)");
		jm02.add(help01);
		jm02.add(help02);
		//游戏中的退出添加监听器	
		jmt01.addActionListener(new action1());		
		jmt02.addActionListener(new action2());		
		jmt03.addActionListener(new action3());
		jmt04.addActionListener(this);		
		//帮助，关于计算机器内容添加监听器
		help01.addActionListener(this);
		help02.addActionListener(this);	
		this.addKeyListener(a);
	    this.setBounds(300,100,400,495);
		this.setTitle("大志派俄罗斯方块");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//这行代码会在window关闭的时候将程序结束掉		
		this.setVisible(true);//最后将框架显示出来			
	}	
	class action1 implements  ActionListener//新游戏
	{
		public void actionPerformed(ActionEvent e)
		{ 
			a.newmap();
            a.drawwall();
            a.score = 0;
            a.x=4;//新游戏控制俄罗斯方块x从中间出来
            a.y=-1;//新游戏控制俄罗斯方块y从最高处下落
           // a.blockType=(int)(Math.random()*1000)%7;
            a.blockType=a.nextb;
           // a.turnState=(int)(Math.random()*1000)%4;
            a.turnState=a.nextt;
            a.nextb=(int)(Math.random()*1000)%7;
            a.nextt=(int)(Math.random()*1000)%4;
		}
	}
	class action2 implements  ActionListener//继续
	{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
		{ 
			//a.timer.resume();	
			timer.start();
		}
	}
	class action3 implements  ActionListener//暂停
	{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
		{ 
			timer.stop();
			//a.timer.suspend();	
		}
	}	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) 
	{		
		if(e.getActionCommand()=="退出(X)")
		{
			//a.timer.suspend();
			timer.stop();
			int result=JOptionPane.showConfirmDialog(this,"确定要退出游戏吗？","系统消息",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.YES_OPTION)
			{
				System.exit(0);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			//a.timer.resume();
			timer.start();
		}
		if(e.getActionCommand()=="帮助(H)")
		{
			//a.timer.suspend();
			timer.stop();
			JOptionPane.showMessageDialog(this,"不懂的话找百度呗，亲","系统消息",JOptionPane.INFORMATION_MESSAGE);
			//a.timer.resume();
			timer.start();
		}
		if(e.getActionCommand()=="关于俄罗斯方块(A)")
		{
			//a.timer.suspend();
			JOptionPane.showMessageDialog(this,"大志牌俄罗斯方块，G1——420工作室出版，版权所有，翻版必究","系统消息",JOptionPane.INFORMATION_MESSAGE);
			//a.timer.resume();
		}
	}	
}
//创建一个俄罗斯方块类
@SuppressWarnings("serial")
class Tetrisblok extends JPanel implements KeyListener 
{	
	//定义变量
	//blockType 代表方块类型
    //turnState代表方块状态
	public int blockType;
	public int turnState;
	public int nextb =(int)(Math.random()*1000)%7;
    public int nextt =(int)(Math.random()*1000)%4;
    public int score=0;
    public int x;
    public int y;
    
    
    private int i=0;
    private int j=0;
    int flag=0;
    //Timer timer=new Timer();
    
    //定义已经放下的方块x=0-11,y=0-21;
    int map[][]=new int[13][23];   
    private final int shapes[][][] = new int[][][]{
            //I型方块
            { 
            	{ 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
            	{ 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } 
            },
            //S型方块
            {  
            	{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } 
            },
            //Z型方块
            { 
            	{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } 
            },
            //J型方块
            { 
            	{ 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            	{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
            },
            //O型方块
            { 
            	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
            },
            //L型方块
            { 
            	{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            	{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
            },
            //T型方块
            { 
            	{ 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 } 
            	
            }};
    Tetrisblok() 
    {
    	newblock(); 	
    	newmap();    	
        drawwall();             
    }
	// 生成新方块的方法
    public void newblock() 
    {
    	//lockType=(int)(Math.random()*1000)%7;
    	//turnState=(int)(Math.random()*1000)%4;
        blockType=nextb;
    	turnState=nextt;
        nextb=(int)(Math.random()*1000)%7;
        nextt=(int)(Math.random()*1000)%4;
        x=4;//产生新块x的位置
        y=0;//产生新块y的位置
        if(gameover(x,y)==1) //注意 是  == 符号        
        {        	 
        	int result=JOptionPane.showConfirmDialog(this,"你输了，要重新开始游戏吗？","系统消息",JOptionPane.YES_NO_OPTION);
    		if(result==JOptionPane.YES_OPTION)
    		{  
    			blockType=nextb;
            	turnState=nextt;
                nextb=(int)(Math.random()*1000)%7;
                nextt=(int)(Math.random()*1000)%4;
                newmap();
                drawwall();
                score=0;    					
    		}
    		else
    			System.exit(0);    		       
        }
    }    
    //初始化地图
    public void newmap()                                                                                                                                                                                                                                                                                                         
    {
    	for (i=0;i<12;i++)
    	{
            for (j=0; j<22;j++)
            {
                map[i][j]=0;
            }
    	}
    }
    //画围墙
    public void drawwall() 
    {
    	for(i=0;i<12;i++) 
    	{
            map[i][21]=2;
        }
        for(j=0;j<22;j++) 
        {
        	 map[0][j]=2;
        	 map[11][j]=2;
           
        }
    }    
    //是否合法的方法,hefa= =return 1;
    public int blow(int x,int y,int blockType,int turnState) 
    {
    	for (int a=0; a<4;a++) 
    	{
            for(int b=0;b<4;b++)
            {
                if(((shapes[blockType][turnState][a*4+b]==1)&&(map[x+b+1][y+a]==1))||((shapes[blockType][turnState][a*4+b]==1)&&(map[x+b+1][y+a]==2)))
                //shape中的[a*4+b]表示16中不同图形。
                {
                	return 0;//不合法
                }
            }
        }
        return 1;//合法
     }
    //判断game over的方法
    public int gameover(int x,int y) 
    {
    	if (blow(x, y,blockType,turnState)==1)//合法
    		return 0;//游戏没有结束
    	else
    		return 1;//game over
    }
    //旋转的方法
    public void turn() 
    {
    	int tempturnState=turnState;
        turnState=(turnState+1)%4;//这句是变化的关键
        if(blow(x,y,blockType,turnState)==1)
        {
        }
        if(blow(x,y,blockType,turnState)==0)//
        {
            turnState=tempturnState;
        }        
        repaint();	
    }
    //左移的方法
    public void left() 
    {
    	if(blow(x-1,y,blockType,turnState)==1)//hefa
    	{
            x=x-1;
        }
        repaint();
    }
    //右移的方法
    public void right() 
    {
    	if (blow(x+1,y,blockType,turnState)==1)//hefa
    	{
            x=x+1;
        }
        repaint();	
    }
    //下落的方法
    public void down() 
    {
    	if (blow(x,y+1,blockType,turnState)==1)
    	{
            y=y+1;
            delline();
        }
        if(blow(x,y+1,blockType,turnState)==0)
        {
        	add(x,y,blockType,turnState);
            newblock();
            delline();           
        }       
        repaint();
    } 
    //消行的方法
    public void delline() 
    {
    	int c=0;
    	for(int b=0;b<22;b++)
    	{
    		for(int a=0;a<12;a++)
    		{
    			if(map[a][b]==1)
    			{
    				c=c+1;
    				if(c==10)
    				{
    					score+=10;
    					for(int d=b;d>0;d--)
    					{
    						for(int e=0;e<11;e++)
    						{
    							map[e][d]=map[e][d-1];
    						}
    					}
    				}
    			}
    		}
    		c = 0;
    	}	
    }
    //把当前添加map
    public void add(int x,int y,int blockType,int turnState) 
    {
    	int j=0;
    	for (int a=0;a<4;a++)
    	{
    		for(int b=0;b<4;b++)
    		{
    			if (map[x+b+1][y+a]==0)
    			{
    				map[x+b+1][y+a]=shapes[blockType][turnState][j];
    			}
    			j++;
    		}
    	}
    }
    //画方块的的方法
    public void paintComponent(Graphics g) 
    {
    	super.paintComponent(g);
        for(j=0;j<16;j++)
        {
            if(shapes[blockType][turnState][j]==1)
            {
            	g.setColor(Color.blue);//下落那一块
                g.fill3DRect((j%4+x+1)*20,(j/4+y)*20,20,20,true);//矩形区域有填充色
            	g.setColor(Color.BLACK);//下落那一块的缝隙部分为黑色
                g.draw3DRect((j%4+x+1)*20,(j/4+y)*20,20,20,true);//无填充色，但是边框被覆盖了颜色被覆盖成黑色
            }
        }
       for(j=0;j<22;j++)
        {
            for(i=1;i<12;i++)
            {
            	g.setColor(Color.red);
            	g.drawRect(i*20,j*20,20,20);//画画布部门的线条，即矩形矩形，但是矩形区域没有填充色
            }
        }
        for(j=0;j<16;j++)
        {
            if (shapes[nextb][nextt][j]==1)
            {
            	g.setColor(Color.yellow);//下一块
                g.fill3DRect((j%4+1)*20+250,(j/4)*20+40, 20, 20,true);
            	g.setColor(Color.BLACK);//
                g.draw3DRect((j%4+1)*20+250,(j/4)*20+40, 20, 20, true);
            }
        }
        for(j=0;j<22;j++)
        {
            for(i=0;i<12;i++)
            {
            	if (map[i][j]==2)//画围墙
            	{
                	g.setColor(Color.blue);//围墙的颜色，矩形区域有填充色
                    g.fill3DRect(i*20,j*20,20,20,true);
                    g.setColor(Color.BLACK);//画矩形，矩形区域没有填充色
                    g.draw3DRect(i*20,j*20,20,20,true);
                }
                if (map[i][j]==1)
                {
                	g.setColor(Color.red);//固定的块
                    g.fill3DRect(i*20,j*20,20,20,true);
                	g.setColor(Color.BLACK);
                    g.draw3DRect(i*20,j*20,20,20,true);
                }                
            }
        }
        g.setColor(Color.black);//画围起来下一个矩形部门的矩形，同时设置颜色为黑色
        g.draw3DRect(250,30,100,100,true);
        g.setColor(Color.BLACK);//设置接下来两句语句中的内容为黑色
        g.drawString("下一个方块：",250,20);
        g.drawString("分数："+score,250,170);

    }
    //键盘监听
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode()) 
        {
        case KeyEvent.VK_DOWN:
        	down();
            break;
        case KeyEvent.VK_UP:
            turn();
            break;
        case KeyEvent.VK_RIGHT:
            right();
            break;
        case KeyEvent.VK_LEFT:
            left();
            break;
        }        
    }    
    public void keyReleased(KeyEvent e) 
    {
    }   
    public void keyTyped(KeyEvent e) 
    {
    }
    // 定时器监听
    //class Timer extends Thread
    class TimerListener implements ActionListener
    {   
    	 public void actionPerformed(ActionEvent e) 
    	 {
    		 down();
    	 }
    }
}