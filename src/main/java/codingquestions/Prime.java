package codingquestions;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		
	    int i=0,temp=0;
	    Scanner sc= new Scanner(System.in);
	    System.out.print("Enter number- ");  
	    int n= sc.nextInt();  
	    for(i=2;i<=(n/2);i++){
			if(n%i==0)
			{
			temp=1;
			break;
			}
		}
		if(temp==1)
		    System.out.println("Number is not a prime");
		else
			System.out.println("Number is prime");
	}

}
