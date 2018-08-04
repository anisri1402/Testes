package week1day2;

import java.util.Scanner;

public class LearningTwoDimensionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] studName= {"Prasidh","Ravi","Vignesh","Kanna","Mani"};
		int[] studAge= {25,24,24,23,25};
		char[][] studGrade= {{'A','D','B','B','C'},{'C','B','A','C','E'},{'B','A','D','D','E'},{'E','C','A','B','B'},{'C','B','C','A','B'}};
		System.out.println("Whose data you require?");
		Scanner scr= new Scanner(System.in);
		int input= scr.nextInt();
		input= input-1;
		System.out.println(studName[input] +" who is " +studAge[input] +" years old scored "+studGrade[input][0] +"," +studGrade[input][1] +"," +studGrade[input][2] +"," +studGrade[input][3] +"," +studGrade[input][4]);
	}

}
