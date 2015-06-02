package example4_8;

public class Platypus 
{
	String name;
	Platypus(String name)
	{
		this.name=name;
		
	}
	Platypus()
	{
		this("John/Mary Doe");
		
	}
	public static void main(String args[])
	{
		Platypus p1=new Platypus("digger");
		System.out.println("p1="+p1.name);
		Platypus p2=new Platypus();
		System.out.println("p2="+p2.name);
	}

}
