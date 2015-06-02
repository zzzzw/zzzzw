package example4_9;

public class Example4_9 
{
	public static void main(String args[])
	{
		Employee2.setMin(600);
		Employee2 e1=new Employee2("zhangsan",40,3000);
		System.out.println("between e1,the lowest salary is:\t"+Employee2.getMin());
		Employee2 e2=new Employee2("lisi",35,300);
		System.out.println("between e2,the loweast salary is:\t"+Employee2.getMin());
		e1.raise(500);
		e2.raise(400);
	}
	

}
class Employee2
{
	String name;
	int age;
	double salary;
	static double min_salary;
	public Employee2(String n,int a,double s)
	{
		name=n;
		age=a;
		salary=s;
	}
	public static double getMin()
	{
		return min_salary;
	}
	public static void setMin(double min)
	{
		min_salary=min;
		
	}
	void raise(double p)
	{
		if(salary<min_salary)
			salary=min_salary;
		else
			salary=salary+p;
			System.out.println(name+"\tafter improve the salary\t"+salary);
		
	}
}
