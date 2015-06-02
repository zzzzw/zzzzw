package example4_5;
//给方法传递对象参数

class A
{
	int a;
	public A()
	{
		a=1;
	}
	public void add(int m,A n)
	{
		m++;
		n.a++;
	}
}
public class TestPassObject
{
	public static void main(String args[])
	{
		int x=5;
		A y=new A();
		System.out.println(x);
		System.out.println(y.a);
		y.add(x,y);
		System.out.println(x);
		System.out.println(y.a);
		
	}

}
