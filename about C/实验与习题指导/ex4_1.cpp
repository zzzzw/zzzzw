


#include<stdio.h>
int main()
{
	int m,n,j,k;

		do
		{
			printf("Input m:");
			scanf("%d",&m);
			printf("Input n:");
			scanf("%d",&n);
		}
		while(m<0||n<0);
		j=m;
		while(j/n!=0);
		j=j+m;
	    k=(m*n)/j;
		printf("最小公倍数是%d\n 最大公约数是%d\n",j,k);

		return 0;
}

