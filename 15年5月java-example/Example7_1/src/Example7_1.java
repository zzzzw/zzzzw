
public class Example7_1
{
	public static void main(String args[])
	{
		int num1[]=new int[5];
		num1[0]=32;
		num1[1]=543;
		num1[2]=17;
		num1[3]=8;
		num1[4]=96;
		int num2[]=new int[10];
		for(int i=0;i<10;i++)              //·ûºÅ×¢Òâ
		{
			num2[i]=i+1;
		}
		System.out.println("the first team:");
		for(int j=0;j<num1.length;j++)         //·ûºÅ×¢Òâ
		{
			System.out.println(num1[j]);
		}
		System.out.println();
		System.out.println("the second team:");
		for(int z=0;z<num2.length;z++)     //·ûºÅ×¢Òâ
		{
			System.out.println(num2[z]);
		}
	}

}
