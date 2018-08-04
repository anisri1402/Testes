package week1day2;

public class StudentNameAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] studName= {"Prasidh","Ravi","Vignesh","Kanna","Mani"};
		int[] studAge= {25,24,24,23,25};
		for (String nm : studName)
		{
			System.out.println("The name of the student is " +nm);
		}
		for (int i : studAge) {
			System.out.println("The age of the student is " +i);
		}
	}

}
