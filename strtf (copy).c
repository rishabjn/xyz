#include<stdio.h>

void main(){

	int a[100],b[100],x[100];
	int waiting[10],tat[10],completion[10];
	int i,j,smallest,count=0,time=0,n;
	double avg=0,tt=0,end;
	printf("enter the no of processes:\n");
	scanf("%d",&n);
	for(i=0;i<n;i++){
		printf("enter the arrival time for process %d\t",i+1);
		scanf("%d",&a[i]);
		}
	for(i=0;i<n;i++){
		printf("enter the burst time of process %d\t",i+1);
		scanf("%d",&b[i]);
		}
	for(i=0;i<n;i++)
		x[i]=b[i];
		b[n+1]=9999;
	for(time=0;count!=n;time++){
		smallest=n+1;
		for(i=0;i<n;i++){
			if(a[i]<=time && b[i]<b[smallest] && b[i]>0)
			smallest=i;
		}
		b[smallest]--;
		if(b[smallest]==0)
		{
			count++;
			end=time+1;
			completion[smallest]=end;
			waiting[smallest]=end-a[smallest]-x[smallest];
			tat[smallest]=end-a[smallest];
		}
	}
	printf(" pid \t burst \t arrival \t waiting \t turnaround \t completion \n");
	for(i=0;i<n;i++)
	{
	printf("%d\t%d\t%d\t%d\t%d\t%d\n",i+1,x[i],a[i],waiting[i],tat[i],completion[i]);
	avg=avg+waiting[i];
	tt=tt+tat[i];

	}
	printf("average waiting time is %lf\n Avergae turnaround time is %lf",avg/n,tt/n);
}



