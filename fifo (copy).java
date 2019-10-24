import java.util.*;

class fifo{

public static void main(String args[])
{
	int a[]=new int[50];
	int frame[]=new int[50];
	int nf,n,pfcount=0,avail=0;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the no of pages and frame size");
	n=sc.nextInt();
	nf=sc.nextInt();
	System.out.println("enter the pages values");
	for(int i=0;i<n;i++)
	{
		a[i]=sc.nextInt();
	}	
	int k=0;
	int l=0,o=0;	
	for(int i=0;i<nf;i++)
		frame[i]=-1;

	for(int i=0;i<n;i++)
	{
		avail=0;
		for(int j=0;j<nf;j++)
		{
			if(a[i]==frame[j])
			{
				avail=1;
				break;
			}
		}
		if(avail==0)
		{
			frame[l]=a[i];
			pfcount++;
			l=(l+1)%nf;
		}
		for(int r=0;r<nf;r++)
			System.out.println(frame[r]);
			

	}
		
	
	System.out.println("pagefault count is :" + pfcount);
    }
}	
	
