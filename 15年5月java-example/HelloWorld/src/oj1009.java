import java.util.Scanner;
public class oj1009 
{
	public static void main(String args[])
	{
		int a,b;
		Scanner in=new Scanner(System.in);
		while(in.hasNext())//�ж��в���������ʱ����������� Scanner in�е�in����in.hasNext�����е�in
		{
			a=in.nextInt();
			b=in.nextInt();
			int c=a+b;
			System.out.println(c);
		}
		
	}

}
