public class Employee
{
	String name;
	int age;
	double salary;
	public Employee()
	{
		name="xiaoming";
		age=18;
		salary=1000;
	}
	public Employee(String n,int a,double s)
	{
		name=n;
		age=a;
		salary=s;
	}
	void raise(double p)
	{
		salary=salary+p;
		System.out.println(name+"\tafter improve his salsry,his will gain\t "+salary);
	}
}