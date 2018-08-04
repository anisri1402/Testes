package week1hw;

import java.util.Scanner;

public class MultiplicationTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter two numbers for multiplication table");
		Scanner sc= new Scanner(System.in);
		int num1= sc.nextInt();
		Scanner scr= new Scanner(System.in);
		int n= scr.nextInt();
		int mul;
		for(int i=1;i<=n;i++)
		{
			mul=i*num1;
			System.out.println(i +" * " +num1 +" = " +mul);
		}
	}

}
