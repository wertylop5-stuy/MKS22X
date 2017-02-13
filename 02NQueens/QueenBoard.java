public class QueenBoard {
	private int[][] board;
	private int mSolutions;
	private boolean mCountSolRan;
	
	public QueenBoard(int size) {
		board = new int[size][size];
		mSolutions = 0;
		mCountSolRan = false;
		//board[0][0] = 1;
	}
	
	//number is the amount to add to each cell
	/* Will affect every row, col, and diag, but will leave inputted space
	alone */
	/*
	positive diag: +/- n-1
	neg diag: +/- n+1
	horiz: 1
	vert: n
	*/
	//only works on square boards
	/*private void cleanerModify(int row, int col) {
		int original = board.length*row + col;
		int counter = original;
		
		
		//horizontal
		counter -= col;
		while(counter != board.length*row + 1) {
			board[counter%
		}
	}*/
	
	private void modify(int row, int col, int number) {
		//check the columns in row
		for (int x = 0; x < board.length; x++) {
			/*if ( (x != col && board[row][x] == -1) ||
				(x != row && board[x][col] == -1) ) {
				System.out.println(this);
				throw new IllegalStateException("y dis neg");
			}*/
			
			//modify the columns in row
			if (board[row][x] != -1) {
				board[row][x] += number;
			}
			
			//modify the rows in col
			if (board[x][col] != -1) {
				board[x][col] += number;
			}
		}
		
		int tRow, tCol;
		//negative diagonal
		//could make this better by adding 7 to a counter variable
		tRow = row+1;
		tCol = col+1;
		while(tRow < board.length && tCol < board.length) {
			board[tRow++][tCol++] += number; 
		}
		tRow = row-1;
		tCol = col-1;
		while(tRow > -1 && tCol > -1) {
			board[tRow--][tCol--] += number;
		}
		
		//positive diagonal
		tRow = row-1;
		tCol = col+1;
		while (tRow > -1 && tCol < board.length) {
			board[tRow--][tCol++] += number;
		}
		tRow = row+1;
		tCol = col-1;
		while (tRow < board.length && tCol > -1) {
			board[tRow++][tCol--] += number;
		}
	}
	
	private boolean addQueen(int row, int col) {
		if (board[row][col] != 0) {
			return false;
		}
		else {
			modify(row, col, 1);
			board[row][col] = -1;
			return true;
		}
	}
	
	private void remQueen(int row, int col) {
		if (board[row][col] != -1) return;
		modify(row, col, -1);
		board[row][col] = 0;
	}
	
	private boolean recursiveSolve(int numQueens) {
		//assert row == numQueens;
		if (numQueens == board.length) return numQueens == board.length;
		else {
			for(int elem = 0; elem < board.length; elem++) {
				if (addQueen(numQueens, elem)) {
					if (recursiveSolve(numQueens+1)) return true;
					remQueen(numQueens, elem);
				}
			}
			return false;
		}
	}
	
	public boolean solve() {
		return recursiveSolve(0);
	}
	
	public boolean recursiveCount(int row, int numQueens) {
		boolean solFound = false;
		if (row == board.length) {
			if (numQueens == board.length) {
				mSolutions++;
				return true;
			}
			return false;
		}
		else {
			for(int elem = 0; elem < board.length; elem++) {
				if (addQueen(row, elem)) {
					if (recursiveCount(row+1, numQueens+1)) {
						solFound = true;
					}
					remQueen(row, elem);
				}
			}
			return solFound;
		}
	}
	
	public boolean countSolutions() {
		board = new int[board.length][board.length];
		mCountSolRan = true;
		mSolutions = 0;
		return recursiveCount(0, 0);
	}
	
	public int getCount() {
		if (!mCountSolRan) return -1;
		return mSolutions;
	}
	
	public String toString() {
		String res = "";
		for (int[] r : board) {
			for (int elem : r) {
				if (elem == -1) res = res + "Q ";
				else res = res + elem + " ";
			}
			res += "\n";
		}
		return res;
	}
	
	public static void main(String args[]) {
		QueenBoard q = new QueenBoard(1);
		//System.out.println(q);
		/*q.addQueen(0, 0);
		System.out.println(q);
		
		System.out.println("same");
		q.addQueen(0, 0);
		System.out.println(q);
		
		System.out.println("same");
		q.addQueen(0, 1);
		System.out.println(q);
		
		System.out.println("modif");
		q.addQueen(2, 1);
		System.out.println(q);
		
		System.out.println("modif");
		q.remQueen(0, 0);
		System.out.println(q);
		
		System.out.println("same");
		q.remQueen(0, 0);
		System.out.println(q);
		
		System.out.println("modif");
		q.remQueen(2, 1);
		System.out.println(q);*/
		
		
		q = new QueenBoard(1);
		q.solve();
		System.out.println(q);
		
		q.countSolutions();
		System.out.println(q.getCount());
		System.out.println();
		
		q = new QueenBoard(3);
		q.solve();
		System.out.println(q);
		
		q.countSolutions();
		System.out.println(q.getCount());
		System.out.println();
		
		q = new QueenBoard(2);
		q.solve();
		System.out.println(q);
		
		q.countSolutions();
		System.out.println(q.getCount());
		System.out.println();
		
		q = new QueenBoard(4);
		q.solve();
		System.out.println(q);
		
		q.countSolutions();
		System.out.println(q.getCount());
		System.out.println();
		
		q = new QueenBoard(8);
		q.solve();
		System.out.println(q);
		
		q.countSolutions();
		System.out.println(q.getCount());
		System.out.println();
	}
}
