public class KnightBoard {
	private int mRows;
	private int mCols;
	private int[][] board;
	private int[][] possMoves;	//Possible moves for each spot
	
	private Direction[] mDirections;
	
	public KnightBoard(int row, int col) {
		mRows = row;
		mCols = col;
		board = new int[mRows][mCols];
		mDirections = initValues();
		possMoves = genMoves();
	}
	
	/*
	Strategy:
	init all values with 8
	go through each row, up to the midway point
	within each row, try each possible move on each space?
	if edge, stop at four or hit midway, reflect values
	at middle row, reflect all previous rows
	*/
	private int[][] genMoves() {
		int[][] res = new int[mRows][mCols];
		//Possible moves are reflections across the board
		for (int row = 0; row < Math.ceil(mRows/2.0); row++) {
			for (int elem = 0;
				elem < Math.ceil(mCols/2.0);
				elem++)
			{
				for (Direction d : mDirections) {
					//set init values for possible moves
					//System.out.println(isValidMove(row*mCols+elem, d));
					if (isValidMove(row*mCols+elem, d))
						res[row][elem]++;
					
				}
				//System.out.println("\n\n");
			}
			
			//reflect value in the row
			int offset = 0;
			while (0+offset < mCols-1-offset) {
				res[row][mCols-1-offset] = res[row][0+offset];
				offset++;
			}
		}
		
		
		
		//reflect the top half of board
		int offset = 0;
		while(0+offset < mRows-1-offset) {
			System.arraycopy(res[0+offset], 0,
				res[mRows-1-offset],
				0,
				mCols);
			offset++;
		}
		
		for (int[] row : res) {
			for (int e : row) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		
		return res;
	}
	
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
		double yPos = (pos + d.deltaY()) * 1.0 / mCols;
		
		//System.out.println(xPos + ", " + yPos);
		
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
	
	public void solveFast() {
		
	}
	
	public static void main(String args[]) {
		KnightBoard k = new KnightBoard(4, 3);
		//k.solve();
		//System.out.println(k);
		
		/*k = new KnightBoard(4,4);
		k.solve();
		System.out.println(k);
		
		k = new KnightBoard(3,4);
		k.solve();
		System.out.println(k);*/
	}
}

