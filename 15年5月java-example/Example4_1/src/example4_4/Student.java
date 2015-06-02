package example4_4;

public class Student 
{
	String name;
	int pingshi;
	int qimo;
	
	Student(String n,int p,int q)
	{
		name=n;
		pingshi=p;
		qimo=q;
	}
	void print()
	{
		System.out.print(" the \t"+name+"'s ");
	}
	double jisuan()
	{
		return pingshi+qimo*0.5;
	}
	public static void main(String args[])
	{
		Student s1=new Student("xiaoqiang",90,92);
		s1.print();
		System.out.println("final score is \t"+s1.jisuan());
	}
}
