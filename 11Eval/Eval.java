import java.util.StringTokenizer;
import java.util.Stack;

public class Eval {
	private static final String[] OPERATORS = {
		"+", "-", "*", "/"
	};
	
	private static boolean isOp(String s) {
		for (String o : OPERATORS) {
			if (s.equals(o)) return true;
		}
		return false;
	}
	
	private static double apply(String op, String a, String b) {
		
	}
	
	public static double eval(String s) {
		Stack<Double> s = new Stack();
		StringTokenizer st = new StringTokenizer(s);
		
		String temp;
		while (st.hasMoreTokens()) {
			temp = st.nextToken();
			if (isOp(temp)) {
				
			}
			else {
				s.push(Double.parseDouble(temp));
			}
		}
	}
	
	public static void main(String args[]) {
		
	}
}
