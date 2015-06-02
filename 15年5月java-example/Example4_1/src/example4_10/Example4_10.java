package example4_10;

public class Example4_10 
{
	@SuppressWarnings("unused")
	public static void main(String args[])
	{
		People zhengsan=new People("zhangsan",20);
		People lisi=new People("free work",true);
		People wuming=new People();
	}

}
class People 
{
	String name,career;
	boolean sex=true;
	int age;
	double height;
	
	public People(String name,int age)
	{
		this.name=name;
		this.age=age;
		System.out.println("name:"+name+"\tage:"+age);
	}
	public People(String career,boolean sex)
	{
		this.career=career;
		this.sex=sex;
		System.out.println("work:"+career+"\tsex:"+sex);
	}
	public People()
	{
		System.out.println(sex);
	}
}
