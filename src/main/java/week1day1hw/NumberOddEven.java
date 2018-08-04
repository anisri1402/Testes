package week1day1hw;

public class NumberOddEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numOne=937;
		int i, j=0;
		for(i=2;i<numOne;i++)
		{
			if(numOne%i==0)
			{
				System.out.println(+numOne +" is not a prime number");
				j=1;
				break;
			}
		}
		if(j==0)
			System.out.println(+numOne +" is a prime number");
	
	}

}
