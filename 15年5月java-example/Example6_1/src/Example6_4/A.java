package Example6_4;

import Example6_3.IA;
import Example6_3.IB;

public class A implements IA,IB
{
	public int Action1()
	{
		System.out.println("this is Action1!");
		return 0;
	
	}
	public int Action2()
	{
		System.out.println("this is Action2!");
		return 0;
	
	}
	public void function()
	{
		System.out.println("this is function from IB");
	}
	public static void main(String args [])
	{
		A a=new A();
		a.Action1();
		a.Action2();
		a.function();
	}
	@Override
	public int Action() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
