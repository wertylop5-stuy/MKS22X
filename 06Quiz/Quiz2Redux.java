import java.util.*;
public class Quiz2Redux {  
	/*Returns an ArrayList<String> that contains all subsets of the
	*characters of String s. Assume s has no duplicate characters.
	*the characters should appear in the same order that they occur 
	*in the original string.
	*/
	
	public static ArrayList<String> combinations(String s){
		ArrayList<String>words = new ArrayList<String>();
		help(s, words , 0, "");
		Collections.sort(words);
		return words;
	}

	private static void help(String s, ArrayList<String> words,
			int pos, String cur){
		//String temp = cur;
		
		if (pos == s.length()) {
			if (!inList(cur, words)) words.add(cur);
			return;
		}
		
		help(s, words, pos + 1, cur);
		cur = cur + s.substring(pos, pos+1);
		help(s, words, pos + 1, cur);
		
		/*if (cur.length() > 0) {
			cur = cur.substring(cur.length() -  1);
		}*/
		
		//cur = temp;
	}
	
	private static boolean inList(String cur, ArrayList<String> words) {
		for (String s : words) {
			if (s.equals(cur)) return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		if (args.length < 1) System.exit(1);
		
		List<String> lol = combinations(args[0]);
		for (String s : lol) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}
}