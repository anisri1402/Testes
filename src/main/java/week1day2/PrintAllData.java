package week1day2;

public class PrintAllData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] studName= {"Prasidh","Ravi","Vignesh","Kanna","Mani"};
		int[] studAge= {25,24,24,23,25};
		char[][] studGrade= {{'A','D','B','B','C'},{'C','B','A','C','E'},{'B','A','D','D','E'},{'E','C','A','B','B'},{'C','B','C','A','B'}};
		for(int i=0;i<=4;i++)
		{
		System.out.println(studName[i] +" who is " +studAge[i] +" years old scored "+studGrade[i][0] +"," +studGrade[i][1] +"," +studGrade[i][2] +"," +studGrade[i][3] +"," +studGrade[i][4]);
		}
	}

}
