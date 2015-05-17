#include<stdio.h>
#include<string.h>
#include<conio.h>
#include<stdlib.h>
#define N 100   /*�����100���˵ļ�¼*/

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
		printf("      |     ������ѡ����(0--7)      |\n");
		printf("      |-------------------------------|\n");
		printf("      |     1�������������ļ�         |\n");
		printf("      |     2������                 |\n");
		printf("      |     3������Ǯ                 |\n");
		printf("      |     4��������·���           |\n");
		printf("      |     5����ע���ɷ���           |\n");
		printf("      |     6��������������ʧ       |\n");
		printf("      |     7������ʾȫ��������Ϣ     |\n");
		printf("      |     0�����˳�                 |\n");
		printf("      |-------------------------------|\n");
		
		choose=getch();
		printf("\n");
		switch(choose)
		{    case '1':student_mycreate(num,name,money,info,&n);break;
		     case '2':if(n==0)
					  {  printf("\n     �޼�¼���뽨�������ļ�\n");break;}
				 student_buy(num,name,money,info,n);break;
		     case '3':if(n==0)
					  {  printf("\n     �޼�¼���뽨�������ļ�\n");break;}
				 student_charge_money(num,name,money,info,n);break;
			 case '4':if(n==0)
					  {  printf("\n     �޼�¼���뽨�������ļ�\n");break;}
				 student_new_card(num,name,money,info,&n);break;
			 case '5':if(n==0)
					  {  printf("\n     �޼�¼���뽨�������ļ�\n");break;}
				 student_delete_old_card(num,name,money,info,&n);break;
			 case '6':if(n==0)
					  {  printf("\n     �޼�¼���뽨�������ļ�\n");break;}
				 student_set_delete_checks(num,name,money,info,n);break;
			 case '7':if(n==0)
					  {  printf("\n     �޼�¼���뽨�������ļ�\n");break;}
				 student_mydisplay(num,name,money,info,n);break;
			 case '0':exit(0);
			 default :printf("\n		%cΪ�Ƿ�ѡ�\n",choose);
		}

		printf("\n		Ҫ����ѡ����(Y/N)?\n");
		do
		{yes_no=getche();
		}while(yes_no!='Y'&&yes_no!='y'&&yes_no!='N'&&yes_no!='n');
	}while(yes_no=='Y'||yes_no=='y');
}
/*���������ļ�*/
void student_mycreate(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
	{
		int i=0;
		char tempnum[10],tempname[10];
	    double tempmoney;
	    int tempinfo;
		
		printf("\n		�������1����¼:\n");
		printf("		ѧ��(��#��������):");
		do
		{
			gets(tempnum);
		}while(strcmp(tempnum,"")==0);
		printf("		����(��#��������):");
		gets(tempname);
		printf("		���(��#��������):");
		scanf("%lf",&tempmoney);
		printf("		��ʧ��Ϣ(��#��������(0��1));");
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
/*��*/
	void student_buy(char num[N][10],char name[N][10],double money[N],int info[N],int n)
	{
		int i;
    	double tempmoney;
		char tempnum[10];

		
		printf("		���뷹����:");
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
	
		
/*��Ǯ*/
void student_charge_money(char num[N][10],char name[N][10],double money[N],int info[N],int n)
{
	int i,find;
	char tempnum[10];
	double tempmoney;
	printf("		��������Ǯ��ѧ��:");
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
		printf("\n		�޴˿���");
		
	}

	else
	{
		printf("		��ӽ��\n");
        scanf("%lf",&tempmoney);
		money[i]=money[i]+tempmoney;
		printf("		��ֵ�ɹ������ڷ�����%lf\n",money[i]);
	}
}
/*����·���*/
void student_new_card(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
{
	int i;
	char c,tempnum[10],tempname[10];
	double tempmoney;
	int tempinfo;

	do
	{
		printf("\n		��������ѧ��:");
		do{
			gets(tempnum);
		}while(strcmp(tempnum,"")==0);
		printf("		�������¼�¼������:");
		gets(tempname);
		printf("		�������µ����:");
		scanf("%lf",&tempmoney);
		printf("		�������ʧ��Ϣ(0/1):");
		scanf("%d",&tempinfo);
		for(i=0;i<(*n);i++)
			if(strcmp(tempnum,num[i])==0)
			{
				printf("\n		ѧ���ظ���Ҫ����������(Y/N)?");
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
	
/*ע���ɷ���*/
void student_delete_old_card(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
{
	char c;

	printf("		��ѧ��ɾ��(h)�����ǰ�����ɾ��(m)?");
	c=getche();
	if(c=='h'||c=='H')
		student_del_num(num,name,money,info,n);
	else if(c=='m'||c=='M')
		student_del_name(num,name,money,info,n);
	else
		printf("\n		�Ƿ��ַ�\n");
}
void student_del_num(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
{
	int i,k;
	char tempnum[10];
	
	printf("\n		������Ҫɾ����¼��ѧ��:");
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
		printf("                         �޴˿���\n");
}
void student_del_name(char num[N][10],char name[N][10],double money[N],int info[N],int *n)
{
	int i,k;
	char tempnum[10],tempname[10];

	printf("\n		������Ҫɾ����¼������:\n");
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
			printf("\n         �޴���\n");
	
}
/*���ý�����ʧ*/
void student_set_delete_checks(char num[N][10],char name[N][10],double money[N],int info[N],int n)
{
	int i,find;
	char tempnum[10];
	int tempinfo;
	printf("\n		������Ҫ��ʧ������ʧ��ѧ��\n:");
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
		printf("\n		�޴˿���");
	else
		printf("��ʧ��Ϣ(0/1)\n");
		scanf("%d",&tempinfo);
		info[i]=tempinfo;

}
/*���¹���*/
void student_mydisplay(char num[N][10],char name[N][10],double money[N],int info[N],int n)
{
	int i;

	printf("	ѧ��	����	���		��ʧ��Ϣ\n");
	for(i=0;i<n;i++)
	{
		printf("%12s%8s	%.2f		%d",num[i],name[i],money[i],info[i]);
		putchar('\n');
	}

}



