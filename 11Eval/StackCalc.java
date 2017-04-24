import java.util.StringTokenizer;
import java.util.Stack;

public class StackCalc {
	private static final String[] OPERATORS = {
		"+", "-", "*", "/", "%"
	};
	
	private static boolean isOp(String s) {
		for (String o : OPERATORS) {
			if (s.equals(o)) return true;
		}
		return false;
	}
	
	private static double apply(String op, double bd, double ad) {
		if (op.equals(OPERATORS[0])) return ad + bd;
		else if (op.equals(OPERATORS[1])) return ad - bd;
		else if (op.equals(OPERATORS[2])) return ad * bd;
		else if (op.equals(OPERATORS[3])) return ad / bd;
		else if (op.equals(OPERATORS[4])) return ad % bd;
		return -1.0;
	}
	
	public static double eval(String sg) {
		Stack<Double> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(sg);
		
		String temp;
		while (st.hasMoreTokens()) {
			temp = st.nextToken();
			//System.out.println(temp);
			if (isOp(temp)) {
				s.push(apply(temp, s.pop(), s.pop()));
			}
			else {
				s.push(Double.parseDouble(temp));
			}
		}
		return s.pop();
	}
	
	public static void main(String args[]) {
		if (args.length < 1) System.exit(1);
		StringBuilder input = new StringBuilder();
		
		for(int x = 0; x < args.length; x++) {
			if (args[x].equals("x")) input.append("* ");
			else if (args[x].equals("d")) input.append("/ ");
			else input.append(args[x]+" ");
		}
		System.out.println(eval(input.toString()));
	}
}
