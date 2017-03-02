import java.io.*;
import java.util.*;

public class mar08bronze {
	public static void main() {
		BufferedReader in = null;
		PrintWriter out = null;
		try{
		 in= new BufferedReader(new FileReader("makelake.in"));
		 out = 
			new PrintWriter(new BufferedWriter(new FileWriter("makelake.out")));
		}
		catch(Exception e){System.out.println("Exception");}

		StringTokenizer st = null;
		String row = null;
		
		int r, c, e, n;
		st = new Stringtokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken());
	}
}
