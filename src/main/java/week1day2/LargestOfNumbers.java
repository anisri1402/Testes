package week1day2;

public class LargestOfNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num= {25,86,55,93,47};
		int maximum=0;
		for(int i=0;i<=4;i++)
		{
			maximum=Math.max(num[i],maximum);
		}
		System.out.println("The largest of the given numbers is "+maximum);
	}

}
