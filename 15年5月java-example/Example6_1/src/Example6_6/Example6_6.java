package Example6_6;

public class Example6_6 
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		Rectangle r=new Rectangle(5,6);
		System.out.println("Area of rect="+r.area());
		Circle c=new Circle(2.0);
		System.out.println("Area of cir="+r.area());
	}

}
abstract class Shape2D
{
	final double pi=3.14;
	
	public abstract double area();
}
class Circle extends Shape2D
{
	double radius;
	public Circle(double r)
	{
		radius=r;
	}
	public double area()
	{
		return (pi*radius*radius);
	}
}
class Rectangle extends Shape2D
{
	int width,height;
	public Rectangle(int w,int h)
	{
		width=w;
		height=h;
	}
	public double area()
	{
		return (width*height);
	}
	
}
