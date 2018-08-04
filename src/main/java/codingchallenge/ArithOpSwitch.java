package codingchallenge;

import java.util.Scanner;

public class ArithOpSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the two numbers");
		Scanner sc= new Scanner(System.in);
		int numOne = sc.nextInt();
		Scanner scr= new Scanner(System.in);
		int numTwo= sc.nextInt();
		System.out.println("Ener the arithamatic operation you want to perform");
		Scanner op = new Scanner(System.in);
		String arithOp= op.next();
		switch(arithOp)
		{
			case "Add":
			{
				int add = numOne+ numTwo;
				System.out.println("The sum is: " +add);
				break;
			}
			case "Subtract":
			{
				int sub = numOne-numTwo;
				System.out.println("The difference is: "+sub);
				break;
			}
			case "Multiply":
			{
				int mul= numOne*numTwo;
				System.out.println("The multiplication is: "+mul);
				break;
			}
			case "Divide":
			{
				int div= numOne/numTwo;
				System.out.println("The result is: "+div);
				break;
			}
			default:
			{
				System.out.println("No such operation exists");
			}
		}
	}

}
