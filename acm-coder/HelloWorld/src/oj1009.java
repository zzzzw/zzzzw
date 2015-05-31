import java.util.Scanner;
public class oj1009 
{
	public static void main(String args[])
	{
		int a,b;
		Scanner in=new Scanner(System.in);
		while(in.hasNext())//有多行测试用例的时候用这个方法 Scanner in中的in就是in.hasNext（）中的in
		{
			a=in.nextInt();
			b=in.nextInt();
			int c=a+b;
			System.out.println(c);
		}
		
	}

}
