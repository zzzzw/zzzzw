#include<stdio.h>
#include<math.h>
int main()
{
	double a,b,c,d;

	printf("Entera,b,c:");
		scanf("%lf%lf%lf",&a,&b,&c);
		d=b*b-4*a*c;
	if(a==0){
		if(b==0){
			if(c==0)
				printf("������Ϊ�㣬���������壡\n");
			else
				printf("a��bΪ0��c��Ϊ0�����̲�����\n");
		}
		else
			printf("x=%0.2f\n",-c/b);
	}
	else
		if(d>=0){
			printf("x1=%0.2f\n",(-b+sqrt(d))/(2*a));
		    printf("x2=%0.2f\n",(-b-sqrt(d))/(2*a));
		}
		else{
			printf("x1=%0.2f+%0.2fi\n",-b/(2*a),sqrt(-d)/(2*a));
			printf("x2=%0.2f-%0.2fi\n",-b/(2*a),sqrt(-d)/(2*a));
		}

	return 0;
}