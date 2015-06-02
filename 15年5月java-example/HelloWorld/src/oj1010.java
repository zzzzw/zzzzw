import java.util.Scanner;
import java.text.DecimalFormat;
public class oj1010 
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		while(in.hasNext())
		{
			int a=in.nextInt();
			if(a>=0)
			{
				String pattern="0.00";
				//java.text.DecimalFormat df=new java.text.DecimalFormat(pattern);
				DecimalFormat df=new DecimalFormat(pattern);
				String s=df.format(a);
				System.out.println(s);
			}
			else
			{
				a=Math.abs(a);
				String pattern="0.00";
				//java.text.DecimalFormat df=new java.text.DecimalFormat(pattern);
				DecimalFormat df=new DecimalFormat(pattern);
				String s=df.format(a);
				System.out.println(s);
			}
			
		}
	}

}
