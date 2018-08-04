package week1day2;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		System.out.println("Enter a number");
		Scanner scn= new Scanner(System.in);
		int digit= scn.nextInt();
		while(digit!=0)
		{
			sum=sum+digit%10;
			digit=digit/10;
		}
		System.out.println("The sum of digits is "+sum);
	}

}
