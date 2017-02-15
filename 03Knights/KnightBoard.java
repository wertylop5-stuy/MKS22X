public class KnightBoard {
	private static int mRows;
	private static int mCols;
	private int[][] board;
	
	public KnightBoard(int row, int col) {
		mRows = row;
		mCols = col;
		board = new int[mRows][mCols];
	}
	
	private enum Direction {
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
	}
	
	public String toString() {
		String res = "";
		for (int[] row : board) {
			for (int x : row) {
				res += String.format("%2d", x);
			}
			res += "\n";
		}
		return res;
	}
	
	private boolean solveH(int pos, int level) {
		if (level == mRows*mCols) return true;
		else {
			for (Direction d : Direction.values()) {
				//if (
			}
		}
		return true;
	}
	
	public void solve() {
		int x = 0;
		while (x < mRows*mCols && !solveH(x, 0)) x++;
	}
	
	public static void main(String args[]) {
		KnightBoard k = new KnightBoard(4, 4);
		System.out.println(k);
	}
}
