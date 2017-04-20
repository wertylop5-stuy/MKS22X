import java.util.StringTokenizer;
import java.util.Stack;

public class Eval {
	public static final String[] OPERATORS = {
		"+", "-", "*", "/"
	};
	
	public static boolean isOp(String s) {
		for (String o : OPERATORS) {
			if (s.equals(o)) return true;
		}
		return false;
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
