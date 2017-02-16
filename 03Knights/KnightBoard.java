public class KnightBoard {
	private int mRows;
	private int mCols;
	private int[][] board;
	private Direction[] mDirections;
	
	public KnightBoard(int row, int col) {
		mRows = row;
		mCols = col;
		board = new int[mRows][mCols];
		mDirections = initValues();
	}
	
	//rip in peace lmao
	/*private enum Direction {
		ONE(-2, -mCols),
		TWO(-1, -2*mCols),
		THREE(1, -2*mCols),
		FOUR(2, -mCols),
		FIVE(2, mCols),
		SIX(1, 2*mCols),
		SEVEN(-1, 2*mCols),
		EIGHT(-2, mCols);
		
		private int xDir;
		private int yDir;
		Direction(int x, int y) {
			xDir = x;
			yDir = y;
		}
		
		public int deltaX() { return xDir; }
		public int deltaY() { return yDir; }
	}*/
	
	//enums are static :'(
	private class Direction {
		private int xDir;
		private int yDir;
		
		Direction(int x, int y) {
			xDir = x;
			yDir = y;
		}
		
		public int deltaX() { return xDir; }
		public int deltaY() { return yDir; }
	}
	
	private Direction[] initValues() {
		Direction[] res = {
			new Direction(-2,   -mCols),
			new Direction(-1, -2*mCols),
			new Direction( 1, -2*mCols),
			new Direction( 2,   -mCols),
			new Direction( 2,    mCols),
			new Direction( 1,  2*mCols),
			new Direction(-1,  2*mCols),
			new Direction(-2,    mCols)
		};
		return res;
	}
	
	public String toString() {
		String res = "";
		for (int[] row : board) {
			for (int x : row) {
				res += String.format("%3d", x);
			}
			res += "\n";
		}
		return res;
	}
	
	private boolean addK(int pos, int val) {
		if (board[pos/mCols][pos%mCols] == 0) {
			board[pos/mCols][pos%mCols] = val;
			return true;
		}
		return false;
	}
	private boolean remK(int pos) {
		if (board[pos/mCols][pos%mCols] != 0) {
			board[pos/mCols][pos%mCols] = 0;
			return true;
		}
		return false;
	}
	
	private boolean isValidMove(int pos, Direction d) {
		int xPos = (pos % mCols) + d.deltaX();
		int yPos = (pos + d.deltaY()) / mCols;
		
		if (xPos >= mCols || xPos < 0) return false;
		if (yPos >= mRows || yPos < 0) return false;
		return true;
	}
	
	private boolean solveH(int pos, int level) {
		if (level > mRows*mCols) return true;
		else {
			int temp;
			for (Direction d : mDirections) {
				if (!isValidMove(pos, d)) continue;
				
				temp = pos + d.deltaX() + d.deltaY();
				if (temp >= 0 && temp < mRows*mCols &&
						addK(pos, level)) {
					if (solveH(temp, level+1)) return true;
					remK(pos);
				}
			}
			return false;
		}
	}
	
	//note: 0 is empty, start counting at 1
	public void solve() {
		int x = 0;
		while (x < mRows*mCols && !solveH(x, 1)) x++;
	}
	
	public static void main(String args[]) {
		KnightBoard k = new KnightBoard(6, 6);
		k.solve();
		System.out.println(k);
		
		k = new KnightBoard(4,4);
		k.solve();
		System.out.println(k);
		
		k = new KnightBoard(3,4);
		k.solve();
		System.out.println(k);
	}
}

