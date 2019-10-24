import java.util.*;

public class roundRobin{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int count=0,flag=0,k=0;
		float total=0,tot=0;
		System.out.println("enter number of process and time quantum: ");
		int n = sc.nextInt();
		int tq = sc.nextInt();
		int bt[]=new int[n];	//stores burst time of every process i
		int rbt[]=new int[n];	//stores burst time After every iteration of a process i
		int time[]=new int[n]; //stores completion time of each corresponding process i
		int at[]=new int[n];	//stores arrival time of every process i
		for(int i=0;i<n;i++){
			System.out.print("Enter arrival time and burst time of process p"+i+": ");
			at[i]=sc.nextInt();
			bt[i]=sc.nextInt();
			rbt[i]=bt[i];
			time[i]=0;
		}
		do{
			flag=0;
			for(int i=0;i<n;i++){{
				if(rbt[i]>tq && rbt[i]!=0){
					rbt[i]=rbt[i]-tq;
					count=count+tq;
				}
				else if(rbt[i]<=tq && rbt[i]!=0){
					count=count+rbt[i];
					rbt[i]=0;
					time[i]=count;
					}
				}

			}
			for(int j=0;j<n;j++){
				if(rbt[j]!=0){
					flag=0;
					break;
				}
				flag=1;
			}

		}while(flag!=1);

		for(int i=0;i<n;i++){
			System.out.println("Completion Time of process p" +i +":" +time[i]);
			total=total+(float)(time[i]-at[i]);
			tot= tot + (float)(time[i]-at[i]-bt[i]);
		}
		float avg = total/(float)n;
		float avg1 = tot/(float)n;
		System.out.println("Average TAT: " +avg +"\n" +"Average WT:" +avg1);
	}
}
