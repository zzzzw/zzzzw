import java.util.Arrays;
import java.util.Scanner;
public class oj1099 
{
	public static void main(String args[])
	{
		
		Scanner in=new Scanner(System.in);
		
		int m=in.nextInt();
		int n=in.nextInt();
		int p=in.nextInt();
		int a[][] =new int[m][n];
		int b[][] =new int[n][p];
		
		
		for(int i=0;i<m;i++)//矩阵a
			for(int j=0;j<n;j++)
			{
				a[i][j]=in.nextInt();
				/*if(j%n==0)
				{
					System.out.print("\n");
				}*/
				
			}
		for(int u=0;u<n;u++)//矩阵b
			for(int v=0;v<p;v++)
			{
				b[u][v]=in.nextInt();
				/*if(v%p==0)
				{
					System.out.print("\n");
				}*/
			}
		/*int c[][]=new int[n][p];
		 * for(int e=0;e<n;e++)//求矩阵c 自己想的
			for(int f=0;f<p;f++)	
			{
				int result=0;
				for(int x=0;x<n;x++)
				{
					for(int y=0;y<n;y++)
					{
						c[e][f]=result+a[e][x]*b[x][f];						
					}
				}
		
			}*/
		int r[][]=new int[n][p];
		for(int e=0;e<n;e++)//求矩阵c 自己想的改错方法
			for(int f=0;f<p;f++)	
			{
				 r[e][f]=0;
				for(int x=0;x<n;x++)
				{
					
					r[e][f]=r[e][f]+a[e][x]*b[x][f];		
				}
				
			}
		
		
		/*int r[][]=new int[n][p];//自己根据网上想出来的！
		  for(int i=0;i<n;++i)
		  {
			  for(int j=0;j<p;++j)
			  {
			   //每一个r[i][j]的运算：
			   r[i][j]=0;//初始化
			   for(int k=0;k<m;++k)
				   r[i][j]+=a[i][k]*b[k][j];
			   }
		  }*/
		  /*int[][] r = new int[a[0].length][b[0].length];//网上做法
		  for(int i=0;i<r.length;++i)
		  {
			  for(int j=0;j<r[i].length;++j)
			  {
			   //每一个r[i][j]的运算：
			   r[i][j]=0;//初始化
			   for(int k=0;k<b.length;++k)
				   r[i][j]+=a[i][k]*b[k][j];
			   }
		  }*/
		  //输出结果
		  /*for(int i=0;i<r.length;++i)
		   System.out.println(Arrays.toString(r[i]));*/
		  
		  
		
		for(int g=0;g<n;g++)//输出
			for(int h=0;h<p;h++)
			{
				System.out.print(r[g][h]+" ");
				if((h+1)%p==0)
				{
					System.out.print("\n");
				}
			}
		
		
	}

}
