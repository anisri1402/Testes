package week1day2;

import java.util.Scanner;

public class TestStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter the status of the Testcase");
		Scanner scn= new Scanner(System.in);
		String testStatus= scn.next();
		switch(testStatus)
		{
			case "pass":
			{
				System.out.println("The testcase is passed");
				break;
			}
			case "fail":
			{
				System.out.println("The testcase is failed");
				break;
			}
			case "blocked":
			{
				System.out.println("The testcase is blocked");
				break;
			}
			case "invalid":
			{
				System.out.println("The testcase is invalid");
				break;
			}
			default:
			{
				System.out.println("Please check the status entered");
			}
		}
	}

}
