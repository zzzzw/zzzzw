package example4_6;
//变量的作用域

public class example4_6 {
	int x=10;
	int y=100;
	
	void method()
	{
		int x=20;
		System.out.println("x="+x);
		System.out.println("y="+y);
		
	}
	public static void main(String args [])
	{
		example4_6 e=new example4_6();
		e.method();
	}

}
