#include<stdio.h>
#include<string.h>
#include<conio.h>
#include<stdlib.h>
#define N 100   /*最多存放100个人的记录*/

void student_mycreate(char num[N][10],char name[N][10],double money[N],int info[N],int *n);
void student_buy(char num[N][10],char name[N][10],double money[N],int info[N],int n);
void student_charge_money(char num[N][10],char name[N][10],double money[N],int info[N],int n);
void student_new_card(char num[N][10],char name[N][10],double money[N],int info[N],int *n);
void student_delete_old_card(char num[N][10],char name[N][10],double money[N],int info[N],int *n);
void student_del_num(char num[N][10],char name[N][10],double money[N],int info[N],int *n);
void student_del_name(char num[N][10],char name[N][10],double money[N],int info[N],int *n);
void student_set_delete_checks(char num[N][10],char name[N][10],double money[N],int info[N],int n);
void student_mydisplay(char num[N][10],char name[N][10],double money[N],int info[N],int n);


 void main()
{
	char choose,yes_no,num[N][10],name[N][10];
	double money[N];
	int info[N];
	int n=0;
	
    
	do
	{
		system("cls");
		printf("      |-------------------------------|\n");
		printf("      |     请输入选项编号(0--7)      |\n");
		printf("      |-------------------------------|\n");
		printf("      |     1——建立饭卡文件         |\n");
		printf("      |     2——买饭                 |\n");
		printf("      |     3——续钱                 |\n");
		printf("      |     4——添加新饭卡           |\n");
		printf("      |     5——注销旧饭卡           |\n");
		printf("      |     6——设置与解除挂失       |\n");
		printf("      |     7——显示全部饭卡信息     |\n");
		printf("      |     0——退出                 |\n");
		printf("      |-------------------------------|\n");
		
		choose=getch();
		printf("\n");
		switch(choose)
		{    case '1':student_mycreate(num,name,money,info,&n);break;
		     case '2':if(n==0)
					  {  printf("\n     无记录，请建立饭卡文件\n");break;}
				 student_buy(num,name,money,info,n);break;
		     case '3':if(n==0)
					  {  printf("\n     无记录，请建立饭卡文件\n");break;}
				 student_charge_money(num,name,money,info,n);break;
			 case '4':if(n==0)
					  {  printf("\n     无记录，请建立饭卡文件\n");break;}
				 student_new_card(num,name,money,info,&n);break;
			 case '5':if(n==0)
					  {  printf("\n     无记录，请建立饭卡文件\n");break;}
				 student_delete_old_card(num,name,money,info,&n);break;
			 case '6':if(n==0)
					  {  printf("\n     无记录，请建立饭卡文件\n");break;}
				 student_set_delete_checks(num,name,money,info,n);break;
			 case '7':if(n==0)
					  {  printf("\n     无记录，请建立饭卡文件\n");break;}
				 student_mydisplay(num,name,money,info,n);break;
			 case '0':exit(0);
			 default :printf("\n		%c为非法选项！\n",choose);
		}

		printf("\n		要继续选择吗(Y/N)?\n");
		do
		{yes_no=getche();
		}while(yes_no!='Y'&&yes_no!='y'&&yes_no!='N'&&yes_no!='n');
	}while(yes_no=='Y'||yes_no=='y');
}
/*建立饭卡文件*/
void student_mycreate(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
	{
		int i=0;
		char tempnum[10],tempname[10];
	    double tempmoney;
	    int tempinfo;
		
		printf("\n		请输入第1个记录:\n");
		printf("		学号(用#结束输入):");
		do
		{
			gets(tempnum);
		}while(strcmp(tempnum,"")==0);
		printf("		姓名(用#结束输入):");
		gets(tempname);
		printf("		金额(用#结束输入):");
		scanf("%lf",&tempmoney);
		printf("		挂失信息(用#结束输入(0或1));");
		scanf("%d",&tempinfo);

		while(tempnum[0]!='#'&&tempname[0]!='#'&&tempmoney!=-1&&tempinfo!=-1)
		{
			strcpy(num[i],tempnum);
			strcpy(name[i],tempname);
		    money[i]=tempmoney;
			info[i]=tempinfo;
			i++;
			break;
		}
		(*n)=i;
	}
/*买饭*/
	void student_buy(char num[N][10],char name[N][10],double money[N],int info[N],int n)
	{
		int i;
    	double tempmoney;
		char tempnum[10];

		
		printf("		输入饭卡号:");
	    do
		{
			gets(tempnum);
		}while(strcmp(tempnum,"")==0);
		
		for(i=0;i<n;i++)
		{
			if(strcmp(tempnum,num[i])==0)
			{
				if(info[i]==1)
				{
					printf("	This card is already be lossed.\n");
					break;
				}
				else
				{
					if(money[i]<5)
					{
						printf("	The card money less $5,please save money.\n");
					    break;
					}
					else
					{
						printf("		Please input money:");
						scanf("%lf",&tempmoney);
						if(money[i]>tempmoney)
						{
							printf("		before:%.2f money.\n",money[i]);
							money[i]=money[i]-tempmoney;
							printf("		After:%.2f money.\n",money[i]);
							break;
							
						}
						else
						{
							printf("		The card is no enough,please save money.\n");
							break;
						}
					}
				}
			}
			
		}
		if(i==n)
			printf("		NO find this card.\n");
				
		return;
	}
	
		
/*续钱*/
void student_charge_money(char num[N][10],char name[N][10],double money[N],int info[N],int n)
{
	int i,find;
	char tempnum[10];
	double tempmoney;
	printf("		请输入续钱的学号:");
	do
	{
		gets(tempnum);
	}while(strcmp(tempnum,"")==0);
	for(i=0;i<n;i++)
		if(strcmp(tempnum,num[i])==0)
		{
			find=i;
			break;
		}
	if(i==n)
	{
		printf("\n		无此卡号");
		
	}

	else
	{
		printf("		添加金额\n");
        scanf("%lf",&tempmoney);
		money[i]=money[i]+tempmoney;
		printf("		充值成功，现在饭卡余额：%lf\n",money[i]);
	}
}
/*添加新饭卡*/
void student_new_card(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
{
	int i;
	char c,tempnum[10],tempname[10];
	double tempmoney;
	int tempinfo;

	do
	{
		printf("\n		请输入新学号:");
		do{
			gets(tempnum);
		}while(strcmp(tempnum,"")==0);
		printf("		请输入新纪录的姓名:");
		gets(tempname);
		printf("		请输入新的余额:");
		scanf("%lf",&tempmoney);
		printf("		请输入挂失信息(0/1):");
		scanf("%d",&tempinfo);
		for(i=0;i<(*n);i++)
			if(strcmp(tempnum,num[i])==0)
			{
				printf("\n		学号重复，要重新输入吗(Y/N)?");
				do{
					c=getche();
				}while(c!='y'&&c!='Y'&&c!='n'&&c!='N');
				putchar('\n');
				break;
			}
		if(i==(*n))
		{
			strcpy(num[i],tempnum);
			strcpy(name[i],tempname);
			money[i]=tempmoney;
			info[i]=tempinfo;
			(*n)++;
			break;
		}
	}while(c=='y'||c=='Y');
}
	
/*注销旧饭卡*/
void student_delete_old_card(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
{
	char c;

	printf("		按学好删除(h)，还是按姓名删除(m)?");
	c=getche();
	if(c=='h'||c=='H')
		student_del_num(num,name,money,info,n);
	else if(c=='m'||c=='M')
		student_del_name(num,name,money,info,n);
	else
		printf("\n		非法字符\n");
}
void student_del_num(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
{
	int i,k;
	char tempnum[10];
	
	printf("\n		请输入要删除记录的学号:");
		do
		{
			gets(tempnum);
		}while(strcmp(tempnum,"")==0);
	for(k=0;k<(*n);k++)
	{
		if(strcmp(tempnum,num[k])==0)
			break;
	}
	if(k<(*n))
	{
		for(i=k;i<(*n)-1;i++)
		{
			strcpy(num[i],num[i+1]);
			strcpy(name[i],name[i+1]);
		    money[i]=money[i+1];
			info[i]=info[i+1];
		}
		(*n)--;
	}
	else
		printf("                         无此卡号\n");
}
void student_del_name(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
{
	int i,k;
	char tempnum[10],tempname[10];

	printf("\n		请输入要删除记录的姓名:\n");
		do
		{
			gets(tempnum);
		}while(strcmp(tempnum,"")==0);
	for(k=0;k<(*n);k++)
		if(strcmp(tempname,name[k])==0)
			break;
		if(k<(*n))
		{
			for(i=k;i<(*n)-1;i++)
			{
				strcpy(num[i],num[i+1]);
				strcpy(name[i],name[i+1]);
			    money[i]=money[i+1];
				info[i]=info[i+1];
			}
			(*n)--;
		}
		else
			printf("\n         无此人\n");
	
}
/*设置解除与挂失*/
void student_set_delete_checks(char num[N][10],char name[N][10],double money[N],int info[N],int n)
{
	int i,find;
	char tempnum[10];
	int tempinfo;
	printf("\n		请输入要挂失或解除挂失的学号\n:");
		do
		{
			gets(tempnum);
		}while(strcmp(tempnum,"")==0);
	for(i=0;i<n;i++)
		if(strcmp(tempnum,num[i])==0)
		{
			find=i;
			break;
		}
	if(i==n)
		printf("\n		无此卡号");
	else
		printf("挂失信息(0/1)\n");
		scanf("%d",&tempinfo);
		info[i]=tempinfo;

}
/*创新功能*/
void student_mydisplay(char num[N][10],char name[N][10],double money[N],int info[N],int n)
{
	int i;

	printf("	学号	姓名	余额		挂失信息\n");
	for(i=0;i<n;i++)
	{
		printf("%12s%8s	%.2f		%d",num[i],name[i],money[i],info[i]);
		putchar('\n');
	}

}



