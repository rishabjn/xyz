import java.util.*;

class newlru{

public static void main(String args[])
{	int top=-1,index=-1;
	int frame[]=new int[50];
	int nf;
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the frame size and number of pages: ");
	nf=sc.nextInt();
	int n = sc.nextInt();
	int c=0;
	int ch=0;
	do{	
		index=-1;
		System.out.println("enter the pages values");
		int s = sc.nextInt();
		System.out.println("\n");
		if(top<nf-1){
			if(top==-1){
				frame[++top]=s;
				c++;
			}
			else{
				for(int i=0;i<=top;i++){
					if(s==frame[i])
						index=i;
				}
				if(index==-1){
					frame[++top]=s;
					c++;
				}
				else{
					for(int i=index;i<top;i++){
						frame[i]=frame[i+1];
					}
					frame[top]=s;
				}

			}
		}
		else if(top==nf-1){
				for(int i=0;i<=top;i++){
					if(s==frame[i])
						index=i;
				}
				if(index==-1){
					for(int i=0;i<top;i++){
						frame[i]=frame[i+1];
					}
					frame[top]=s;
					c++;
				}
				else{
					for(int i=index;i<top;i++){
						frame[i]=frame[i+1];		
				}
				frame[top]=s;
			}
		}
		for(int i=top;i>=0;i--)
			System.out.println("|" +frame[i] +"|");
		ch++;
	}while(ch!=n);
	
	System.out.println("page fault:" +c);
}
}

