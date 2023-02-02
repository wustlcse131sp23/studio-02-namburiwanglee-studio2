package studio2;

import java.util.Scanner;

public class Pi {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int totalIterations = in.nextInt();
		int inCircle = 0;
		for(int i=0; i<totalIterations; i++)
		{
			double x = Math.random();
			double y = Math.random();
			
			if(Math.sqrt(x*x + y*y)<=1)
			{
				inCircle++;
			}
		}
		
		System.out.println((double)inCircle / (double)totalIterations);
	}

}
