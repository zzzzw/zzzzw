
public class Example6_7 
{
	public static void main(String args[])
	{
		ColorCircle cir;
		cir=new ColorCircle(2.0);
		cir.setColor("blue");
		System.out.println("Area="+cir.area());
	}

}
abstract class Shape2D
{
	final double pi=3.14;
	
	public abstract double area();
}
interface Color
{
	void setColor(String str);	
}
class ColorCircle extends Shape2D implements Color
{
	double radius;
	
	String color;
	public ColorCircle(double r)
	{
		this.radius=r;
	}
	public double area()
	{
		return pi*radius*radius;
	}
	public void setColor(String str)
	{
		this.color=str;
		System.out.println("color:"+color);
	}
	
}

