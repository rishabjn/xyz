#include<stdio.h>
#include<stdlib.h>

int main()
{
	int max[10][10],need[10][10],alloc[10][10],avail[10],completed[10],safesequence[10];
	int p,r,i,j,process,count=0;
	printf("enter the no of process :");
	scanf("%d",&p);
	for(i=0;i<p;i++)
	{
	completed[i]=0;
	}
	printf("enter the no of resources :");
	scanf("%d",&r);
	printf("enter the max matrix for each process\n");
	for(i=0;i<p;i++)
	{
		printf("for porcess %d:",i+1);
		for(j=0;j<r;j++)
		{
		scanf("%d",&max[i][j]);
		}
	}
	printf("enter the allocation for each process\n");
	for(i=0;i<p;i++)
	{
	printf("for process %d:",i+1);
		for(j=0;j<r;j++)
		{
		scanf("%d",&alloc[i][j]);
		}
	}
	printf("Enter available resources\n");
		for(i=0;i<r;i++)
		{
		scanf("%d",&avail[i]);
		}
	for(i=0;i<p;i++)
	{
		for(j=0;j<r;j++)
			need[i][j]=max[i][j]-alloc[i][j];
	}
	do {
		process=-1;
		for(i=0;i<p;i++)
		{
			if(completed[i]==0)
			{
			process=i;
				for(j=0;j<r;j++)
				{
					if(avail[j]<need[i][j])
					{
					process=-1;
					break;
					}
				}
			}
			if(process!=-1)
			break;
		}
		if(process!=-1)
		 {
			printf("Process %d runs to completion\n",process+1);
			safesequence[count]=process+1;
			count++;
			for(j=0;j<r;j++)
			{
				avail[j]+=alloc[process][j];
				alloc[process][j]=0;
				max[process][j]=0;
				completed[process]=1;
			}
		  }
	}while(count!=p && process !=-1);
	printf("%d",process);
	if(count==p)
	{
	printf("The system is in safe state\n");
	printf("Safe sequence is :");
		for(i=0;i<p;i++)
		printf("->%d",safesequence[i]);
		printf("\n");
	}
	else 
	printf("The System is in unsafe state\n");

	for(j=0;j<r;j++)		
	printf("%d ",avail[j]);
}
