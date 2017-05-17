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
				System.out.println(f.size());
				while (f.size() > 0) {
					//System.out.println(f.size());
					board.clearTerminal();
					System.out.println(
						Maze.colorize(board.toString()));
					if (getNextSpots(f)) break;
					Maze.wait(64);
				}
			break;
		}
	}
	
	private boolean getNextSpots(Frontier f) {
		Location l = f.next();
		System.out.println(l);
		board.set(l.getRow(), l.getCol(), '.');
		if (l.equals(board.getEnd())) return true;
		
		int tRow;
		int tCol;
		//Access the surrounding squares
		for (Location d : DIRECTIONS) {
			tRow = l.getRow() + d.getRow();
			tCol = l.getCol() + d.getCol();
			if(board.get(tRow, tCol) == ' ') {
				//System.out.println("("+tRow+", "+tCol+")");
				f.add(new Location(tRow, tCol, l,
					l.getDistStart()+1,
					Location.manDist(
						tRow, tCol,
						board.getEnd().getRow(),
						board.getEnd().getCol()),
					true
				));
				board.set(tRow, tCol, '?');
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		if (args.length < 1) System.exit(1);
		MazeSolver m = new MazeSolver(args[0]+".txt");
		m.solve(3);
		System.out.println(Maze.colorize(m.board.toString()));
	}
}
