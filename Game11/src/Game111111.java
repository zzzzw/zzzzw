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
		this.setResizable(false);//�ߴ粻�ı�        
		//����
		Container con=this.getContentPane();		
		con.add(a);
		
        timer.start();
		//a. timer.start();		
		//�˵����Ͳ˵���
		JMenuBar jmb=new JMenuBar();
		this.setJMenuBar(jmb);
		JMenu jm01=new JMenu("��Ϸ(G)");		
		JMenu jm02=new JMenu("����(H)");
		jmb.add(jm01);		
		jmb.add(jm02);
		JMenuItem jmt01=new JMenuItem("����Ϸ");
		JMenuItem jmt02=new JMenuItem("����");
		JMenuItem jmt03=new JMenuItem("��ͣ");
		JMenuItem jmt04=new JMenuItem("�˳�(X)");		
		jm01.add(jmt01);
		jm01.add(jmt02);
		jm01.add(jmt03);
		jm01.add(jmt04);
		JMenuItem help01=new JMenuItem("����(H)");
		JMenuItem help02=new JMenuItem("���ڶ���˹����(A)");
		jm02.add(help01);
		jm02.add(help02);
		//��Ϸ�е��˳���Ӽ�����	
		jmt01.addActionListener(new action1());		
		jmt02.addActionListener(new action2());		
		jmt03.addActionListener(new action3());
		jmt04.addActionListener(this);		
		//���������ڼ������������Ӽ�����
		help01.addActionListener(this);
		help02.addActionListener(this);	
		this.addKeyListener(a);
	    this.setBounds(300,100,400,495);
		this.setTitle("��־�ɶ���˹����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���д������window�رյ�ʱ�򽫳��������		
		this.setVisible(true);//��󽫿����ʾ����			
	}	
	class action1 implements  ActionListener//����Ϸ
	{
		public void actionPerformed(ActionEvent e)
		{ 
			a.newmap();
            a.drawwall();
            a.score = 0;
            a.x=4;//����Ϸ���ƶ���˹����x���м����
            a.y=-1;//����Ϸ���ƶ���˹����y����ߴ�����
           // a.blockType=(int)(Math.random()*1000)%7;
            a.blockType=a.nextb;
           // a.turnState=(int)(Math.random()*1000)%4;
            a.turnState=a.nextt;
            a.nextb=(int)(Math.random()*1000)%7;
            a.nextt=(int)(Math.random()*1000)%4;
		}
	}
	class action2 implements  ActionListener//����
	{
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
		{ 
			//a.timer.resume();	
			timer.start();
		}
	}
	class action3 implements  ActionListener//��ͣ
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
		if(e.getActionCommand()=="�˳�(X)")
		{
			//a.timer.suspend();
			timer.stop();
			int result=JOptionPane.showConfirmDialog(this,"ȷ��Ҫ�˳���Ϸ��","ϵͳ��Ϣ",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.YES_OPTION)
			{
				System.exit(0);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			//a.timer.resume();
			timer.start();
		}
		if(e.getActionCommand()=="����(H)")
		{
			//a.timer.suspend();
			timer.stop();
			JOptionPane.showMessageDialog(this,"�����Ļ��Ұٶ��£���","ϵͳ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			//a.timer.resume();
			timer.start();
		}
		if(e.getActionCommand()=="���ڶ���˹����(A)")
		{
			//a.timer.suspend();
			JOptionPane.showMessageDialog(this,"��־�ƶ���˹���飬G1����420�����ҳ��棬��Ȩ���У�����ؾ�","ϵͳ��Ϣ",JOptionPane.INFORMATION_MESSAGE);
			//a.timer.resume();
		}
	}	
}
//����һ������˹������
@SuppressWarnings("serial")
class Tetrisblok extends JPanel implements KeyListener 
{	
	//�������
	//blockType ����������
    //turnState������״̬
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
    
    //�����Ѿ����µķ���x=0-11,y=0-21;
    int map[][]=new int[13][23];   
    private final int shapes[][][] = new int[][][]{
            //I�ͷ���
            { 
            	{ 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
            	{ 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } 
            },
            //S�ͷ���
            {  
            	{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } 
            },
            //Z�ͷ���
            { 
            	{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } 
            },
            //J�ͷ���
            { 
            	{ 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            	{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
            },
            //O�ͷ���
            { 
            	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
            },
            //L�ͷ���
            { 
            	{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            	{ 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
            	{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 } 
            },
            //T�ͷ���
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
	// �����·���ķ���
    public void newblock() 
    {
    	//lockType=(int)(Math.random()*1000)%7;
    	//turnState=(int)(Math.random()*1000)%4;
        blockType=nextb;
    	turnState=nextt;
        nextb=(int)(Math.random()*1000)%7;
        nextt=(int)(Math.random()*1000)%4;
        x=4;//�����¿�x��λ��
        y=0;//�����¿�y��λ��
        if(gameover(x,y)==1) //ע�� ��  == ����        
        {        	 
        	int result=JOptionPane.showConfirmDialog(this,"�����ˣ�Ҫ���¿�ʼ��Ϸ��","ϵͳ��Ϣ",JOptionPane.YES_NO_OPTION);
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
    //��ʼ����ͼ
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
    //��Χǽ
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
    //�Ƿ�Ϸ��ķ���,hefa= =return 1;
    public int blow(int x,int y,int blockType,int turnState) 
    {
    	for (int a=0; a<4;a++) 
    	{
            for(int b=0;b<4;b++)
            {
                if(((shapes[blockType][turnState][a*4+b]==1)&&(map[x+b+1][y+a]==1))||((shapes[blockType][turnState][a*4+b]==1)&&(map[x+b+1][y+a]==2)))
                //shape�е�[a*4+b]��ʾ16�в�ͬͼ�Ρ�
                {
                	return 0;//���Ϸ�
                }
            }
        }
        return 1;//�Ϸ�
     }
    //�ж�game over�ķ���
    public int gameover(int x,int y) 
    {
    	if (blow(x, y,blockType,turnState)==1)//�Ϸ�
    		return 0;//��Ϸû�н���
    	else
    		return 1;//game over
    }
    //��ת�ķ���
    public void turn() 
    {
    	int tempturnState=turnState;
        turnState=(turnState+1)%4;//����Ǳ仯�Ĺؼ�
        if(blow(x,y,blockType,turnState)==1)
        {
        }
        if(blow(x,y,blockType,turnState)==0)//
        {
            turnState=tempturnState;
        }        
        repaint();	
    }
    //���Ƶķ���
    public void left() 
    {
    	if(blow(x-1,y,blockType,turnState)==1)//hefa
    	{
            x=x-1;
        }
        repaint();
    }
    //���Ƶķ���
    public void right() 
    {
    	if (blow(x+1,y,blockType,turnState)==1)//hefa
    	{
            x=x+1;
        }
        repaint();	
    }
    //����ķ���
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
    //���еķ���
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
    //�ѵ�ǰ���map
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
    //������ĵķ���
    public void paintComponent(Graphics g) 
    {
    	super.paintComponent(g);
        for(j=0;j<16;j++)
        {
            if(shapes[blockType][turnState][j]==1)
            {
            	g.setColor(Color.blue);//������һ��
                g.fill3DRect((j%4+x+1)*20,(j/4+y)*20,20,20,true);//�������������ɫ
            	g.setColor(Color.BLACK);//������һ��ķ�϶����Ϊ��ɫ
                g.draw3DRect((j%4+x+1)*20,(j/4+y)*20,20,20,true);//�����ɫ�����Ǳ߿򱻸�������ɫ�����ǳɺ�ɫ
            }
        }
       for(j=0;j<22;j++)
        {
            for(i=1;i<12;i++)
            {
            	g.setColor(Color.red);
            	g.drawRect(i*20,j*20,20,20);//���������ŵ������������ξ��Σ����Ǿ�������û�����ɫ
            }
        }
        for(j=0;j<16;j++)
        {
            if (shapes[nextb][nextt][j]==1)
            {
            	g.setColor(Color.yellow);//��һ��
                g.fill3DRect((j%4+1)*20+250,(j/4)*20+40, 20, 20,true);
            	g.setColor(Color.BLACK);//
                g.draw3DRect((j%4+1)*20+250,(j/4)*20+40, 20, 20, true);
            }
        }
        for(j=0;j<22;j++)
        {
            for(i=0;i<12;i++)
            {
            	if (map[i][j]==2)//��Χǽ
            	{
                	g.setColor(Color.blue);//Χǽ����ɫ���������������ɫ
                    g.fill3DRect(i*20,j*20,20,20,true);
                    g.setColor(Color.BLACK);//�����Σ���������û�����ɫ
                    g.draw3DRect(i*20,j*20,20,20,true);
                }
                if (map[i][j]==1)
                {
                	g.setColor(Color.red);//�̶��Ŀ�
                    g.fill3DRect(i*20,j*20,20,20,true);
                	g.setColor(Color.BLACK);
                    g.draw3DRect(i*20,j*20,20,20,true);
                }                
            }
        }
        g.setColor(Color.black);//��Χ������һ�����β��ŵľ��Σ�ͬʱ������ɫΪ��ɫ
        g.draw3DRect(250,30,100,100,true);
        g.setColor(Color.BLACK);//���ý�������������е�����Ϊ��ɫ
        g.drawString("��һ�����飺",250,20);
        g.drawString("������"+score,250,170);

    }
    //���̼���
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
    // ��ʱ������
    //class Timer extends Thread
    class TimerListener implements ActionListener
    {   
    	 public void actionPerformed(ActionEvent e) 
    	 {
    		 down();
    	 }
    }
}