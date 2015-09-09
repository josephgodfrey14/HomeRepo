
public class selftest {

	public static void printRandomNumberExample()	{
		// Math.random() generates a number between 0.0 up to 0.999999...
		double betweenZeroAndOne = Math.random();
		// if we multiply that number by 2, we get a number between 0.0 and 1.99999...
		double betweenZeroAndTwo = 2.0 * betweenZeroAndOne;
		// if we "cast" (convert) it to an integer, we get either 0 or 1 (equally likely).
		int zeroOrOne = (int) betweenZeroAndTwo;
		// so about half the times you run it, this prints 0, and the other half 1
		System.out.println("Zero or one? " + zeroOrOne);
		
		
		// BUT, we could also do it all in one short expression, like this!
		System.out.println("Zero or one (again)? " + (int)(2*Math.random()));
	}
	
	
}
