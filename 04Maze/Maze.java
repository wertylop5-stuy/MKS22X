import java.util.*;
import java.io.*;

public class Maze {
    private char[][] maze;
    private boolean animate;
	private int mCols = -1;
	private int startX = -1, startY = -1;

    /*
      Constructor loads a maze text file, and sets animate to false by default.
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)
      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */

    public Maze(String filename){
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream(filename));
		}
		catch (FileNotFoundException e) {
			System.err.println("file " + filename + " does not exist");
			System.exit(1);
		}
		
		String s;
		List<String> temp = new ArrayList<>();
		while(input.hasNext()) {
			s = input.nextLine();
			//System.out.println(s);
			mCols = (mCols == -1) ? s.length() : mCols;
			temp.add(s);
		}
		//System.out.println();
		
		maze = new char[temp.size()][mCols];
		
		//Now move from temp to maze array and set start
		boolean endFound = false;
		for (int x = 0; x < temp.size(); x++) {
			maze[x] = temp.get(x).toCharArray();
			
			if (startX == -1) {
				for (int y = 0; y < maze[x].length; y++) {
					if (maze[x][y] == 'S') {
						startX = x;
						startY = y;
						maze[x][y] = ' ';
					}
					else if (maze[x][y] == 'E') endFound = true;
				}
			}
		}
		if (!(startX == -1 && endFound)) {
			System.err.println("No S or E found in maze");
			System.exit(2);
		}
		
		/*for (char[] r : maze) {
			for (char c : r) System.out.print(c);
			System.out.println();
		}*/
    }

	private void wait(int millis) {
		try { Thread.sleep(millis); }
		catch (InterruptedException e){}
	}

    public void setAnimate(boolean b) { animate = b; }

    public void clearTerminal() { System.out.println("\033[2J\033[1;1H"); }
	
	
    /*
      Recursive Solve function:
      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int x, int y) {
        if(animate){
            System.out.println(this);
            wait(20);
        }
		
		try {
			if (maze[x][y] == 'E') return true;
			if (maze[x][y] != ' ') return false;
		}
		catch(ArrayIndexOutOfBoundsException e){ return false; }
		
		maze[x][y] = '@';
		if (solve(x, y-1) || solve(x+1, y) ||
			solve(x, y+1) || solve(x-1, y)) return true;
		else {
			maze[x][y] = '.';
		}
		
        return false;
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve() {
        return solve(startX, startY);
    }
	
	@Override
	public String toString() {
		String res = "";
		for (char[] row : maze) {
			for (char c : row) res += c;
			res += "\n";
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		if (args.length < 1) System.exit(1);
		
		Maze m = new Maze(args[0]);
		
		if (args.length == 2 && args[1].equals("a")) {
			m.setAnimate(true);
		}
		
		m.solve();
		System.out.println(m);
		
		/*Maze m = new Maze("data1.dat");
		//m.setAnimate(true);
		m.solve();
		System.out.println(m);
		
		m = new Maze("data2.dat");
		m.solve();
		System.out.println(m);
		
		m = new Maze("data3.dat");
		m.setAnimate(true);
		m.solve();
		System.out.println(m);*/
	}
}
