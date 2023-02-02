package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("The amount of money that you start with: ");
		int startAmount = in.nextInt();
		
		System.out.println("The win probability that you win a single play: ");
		double winChance = in.nextDouble();
	
		System.out.println("The maximum amount of money you can win in a single play: ");
		int winLimit = in.nextInt();
		
		System.out.println("The maximum number of simulations: ");
		int totalSimulations = in.nextInt();
		
		int round  = 0;
		int loseTimes = 0;
		int amount = startAmount;
		int totalLosses = 0;
		
		for(int i = 1; i <= totalSimulations; i++)
		{
			amount = startAmount;
			round = 0;
			while(amount > 0 && amount < winLimit)
			{
				if(Math.random() < winChance)
				{
					amount++;
					round++;
				}
				else
				{
					amount--;
					round++;
					loseTimes++;
				}
			}
			if(amount > 0)
			{
				System.out.println("Simulation " + i + ": " + round + " WIN");
			}
			else
			{
				System.out.println("Simulation " + i + ": " + round + " LOSE");
				totalLosses++;
			}
		}
		
		double alpha = (1-winChance)/(winChance);
		double expected_ruin = 0;
		if(winChance == 0.5)
		{
			expected_ruin = 1 - ((startAmount/winLimit));
		}
		else
		{
			expected_ruin = (Math.pow(alpha,startAmount) - Math.pow(alpha,winLimit))/(1-Math.pow(alpha, winLimit));
		}
		System.out.println("Losses: " + totalLosses);
		System.out.println("Simulations: " + totalSimulations);
		System.out.println("Ruin rate from Simulation: " + (double)totalLosses/(double)totalSimulations);
		System.out.println("Expected Ruin Rate: " + expected_ruin);
	}
}
