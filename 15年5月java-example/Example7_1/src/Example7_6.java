
public class Example7_6
{
	public static void main(String args[])
	{
		double random=Math.random();
		String temp=String.valueOf(random);
		String s=temp.substring(3,6);
		int i=Integer.parseInt(s);//生成随机数在100-1000之间
		System.out.print("gain the ramdon between 100_1000 is \t"+i+"\n");
		double e=Math.E;
		System.out.println(e);
		double pi=Math.PI;
		System.out.println(pi);
		double r=Math.random();
		System.out.println(r);	
		
	}

}
