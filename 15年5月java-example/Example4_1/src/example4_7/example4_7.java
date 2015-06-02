package example4_7;
//用this引用属性

public class example4_7
{
	private int x,y;
	public example4_7(int x,int y)
	{
		//setX(x);
		this.setX(x);		
	}
	void setX(int x)
	{
		this.x=x;
	}
	public static void main(String args [])
	{
		example4_7 e=new example4_7(2,3);
		System.out.println("x="+e.x+",y="+e.y);
		e.setX(3);
		System.out.println("x="+e.x+",y="+e.y);
	}

}
