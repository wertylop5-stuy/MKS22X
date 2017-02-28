import java.util.*;
import java.io.*;

public class Maze {
    private char[][] maze;
    private boolean animate;
	private int mCols = -1;

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
	
	maze = new char[temp.size()][mCols];
	
	//Now move from temp to maze array
	for (int x = 0; x < temp.size(); x++) {
		maze[x] = temp.get(0).toCharArray();
	}
	System.out.println(maze[0][0]);
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
	
	
        return false;
    }


    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve() {
            int startx=0,starty=0;

            //Initialize startx and starty with the location of the S. 
		maze[startx][starty] = ' ';
            return solve(startx,starty);
    }
	
	public static void main(String args[]) {
		Maze m = new Maze("data1.dat");
		m.solve();
	}
}
