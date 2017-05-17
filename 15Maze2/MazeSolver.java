public class MazeSolver {
	private Maze board;
	private static final Location[] DIRECTIONS = {
		new Location( 0,  1, null, 0, 0),
		new Location( 0, -1, null, 0, 0),
		new Location( 1,  0, null, 0, 0),
		new Location(-1,  0, null, 0, 0)
	};
	
	public MazeSolver(String filename) {
		this(filename, false);
	}
	
	public MazeSolver(String filename, boolean animate) {
		board = new Maze(filename);
	}
	
	public void solve() {solve(1);}
	
	public void solve(int style) {
		Frontier f;
		switch(style) {
			case 3:
				f = new FrontierPriorityQueue();
				f.add(board.getStart());
				
				while (f.size() > 0) {
					getNextSpots(f);
				}
			break;
		}
	}
	
	private void getNextSpots(Frontier f) {
		Location l = f.next();
		System.out.println(l);
		int tRow;
		int tCol;
		//Access the surrounding squares
		for (Location d : DIRECTIONS) {
			tRow = l.getRow() + d.getRow();
			tCol = l.getCol() + d.getCol();
			if(board.get(tRow, tCol) == ' ') {
				System.out.println("("+tRow+", "+tCol+")");
				f.add(new Location(tRow, tCol, l,
					l.getDistStart()+1,
					Location.manDist(
						l, board.getEnd()
					)));
			}
		}
	}
	
	public static void main(String[] args) {
		MazeSolver m = new MazeSolver("Maze.txt");
		m.solve(3);
	}
}
