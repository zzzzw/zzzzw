public class Example4_3 
{
	public static void main(String args[])
	{
		Employee e1=new Employee();
		e1.name="xiaoqiang";
		e1.salary=1000;
		e1.raise(500);
		Employee e2=new Employee("xiaozhang",20,1000);
		e2.raise(1000);
	}

}
