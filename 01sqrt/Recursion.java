public class Recursion {
	public static String name() {
		return "Lin,Stanley";
	}
	
	public static boolean doubEq(double exp, double actual) {
		//true if less than .9%
		return Math.abs((exp-actual)/actual) < .009;
	}
	
	private static double approximate(	double n,
						double guess) {
		if (doubEq(n, guess*guess)) {
			return guess;
		}
		else {
			return approximate(n,
				((n / guess) + guess) / 2);
		}
	}
	
	public static double sqrt(double n) {
		if (n < 0)
			throw new IllegalArgumentException(
				"number less than 0: " + n);
		return approximate(n, 1);
	} 
	
	public static void main(String args[]) {
		//System.out.println(doubEq(1, 2));
		//System.out.println(doubEq(1.0, 1.00000000000000001));
		//System.out.println(doubEq(100.005, 100));
		System.out.println(sqrt(100));
		System.out.println(sqrt(2));
		System.out.println(sqrt(49));
		System.out.println(sqrt(250000));
		System.out.println(sqrt(-1));
	}
}
