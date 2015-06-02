package Example6_5;

import Example6_3.ICylinder;

public class Cylinder implements ICylinder 
{
	double r;
	double h;
	public Cylinder(double r,double h)
	{
		this.r=r;
		this.h=h;
	}	
	public double area() 
	{		
		return 2*PI*r*(h+r);
	}	
	public double bulk() 
	{	
		return PI*r*r*h;
	}
	public static void main(String args[])
	{
		ICylinder c1=new Cylinder(10,6);
		double arearesult;
		arearesult=c1.area();
		double bulkresult;
		bulkresult=c1.bulk();
		System.out.println("面积为"+arearesult);
		System.out.println("体积为"+bulkresult);
	}
}
