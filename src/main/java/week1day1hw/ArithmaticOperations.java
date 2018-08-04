package week1day1hw;

public class ArithmaticOperations {
	int numOne=5, numTwo=6;
	public void addtion()
	{
		int add;
		add= numOne+numTwo;
		System.out.println("The sum is: "+add);
	}
	public int subract()
	{
		int sub;
		sub= numTwo-numOne;
		System.out.println("The difference is: "+sub);
		return sub;
	}
	public int multiply()
	{
		int multi;
		multi=numOne*numTwo;
		System.out.println("The multiplication result is: "+multi);
		return multi;
	}
	public void multiplyNumOneByTwo()
	{
		int mul;
		mul= numOne*2;
		System.out.println("The multiplied result is: "+mul);
	}
	public int divideNumTwo(int divident)
	{
		int quotient;
		quotient= numTwo/divident;
		System.out.println("The quotient is "+quotient);
		return quotient;
	}

}
