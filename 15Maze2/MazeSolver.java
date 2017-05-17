public class MazeSolver {
	private Maze board;
	
	public MazeSolver(String filename) {
		this(filename, false);
	}
	
	public MazeSolver(String filename, boolean animate) {
		board = new Maze(filename, animate);
	}
	
	public void solve() {solve(1);}
	
	public void solve(int style) {
		Frontier f;
		switch(style) {
			case 3:
				f = new FrontierPriorityQueue();
				f.add(board.getStart());
				
				while (f.size() > 0) {
					
				}
			break;
		}
	}
}
