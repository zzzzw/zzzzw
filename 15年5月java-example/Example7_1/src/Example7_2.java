
public class Example7_2 
{
	public static void main(String args[])
	{
		int array[][]={{24,2,64,16},{35,56,97,28},{29,10,81,12}};
		int max=0;
		int x=-1;
		int y=-1;
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array[i].length;j++)
			{
				if(array[i][j]>max)
				{
					max=array[i][j];
					x=i+1;
					y=j+1;
				}
				System.out.print(array[i][j]+"\t");
			}
			System.out.println(); //一个循环之后就是这样子了
			
		}
		System.out.println("the two jin zhi shu's biggest is \t"+max);
		System.out.println("the position is \t"+x+"\t"+y);
		
	}

}
