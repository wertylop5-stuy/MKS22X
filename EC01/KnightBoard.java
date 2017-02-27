import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class KnightBoard {
	private int mRows;
	private int mCols;
	private int[][] board;
	private int[][] possMoves;	//Possible moves for each spot
	
	private int[][] mDirections;
	
	public KnightBoard(int row, int col) {
		mRows = row;
		mCols = col;
		board = new int[mRows][mCols];
		mDirections = initValues();
		possMoves = genMoves();
	}
	
	/*
	Strategy:
	init all values with 0
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
				for (int x = 0; x < 8; x++) {
					//set init values for possible moves
					//System.out.println(isValidMove(row*mCols+elem, d));
					if (isValidMove(row*mCols+elem, mDirections[x]))
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
		
		/*for (int[] row : res) {
			for (int e : row) {
				System.out.print(e + " ");
			}
			System.out.println();
		}*/
		
		return res;
	}
	
	//Array accessing is faster?
	private int[][] initValues() {
		int[][] res = {
			{ 1, -2*mCols},
			{ 2,   -mCols},
			{ 2,    mCols},
			{ 1,  2*mCols},
			{-1,  2*mCols},
			{-2,    mCols},
			{-2,   -mCols},
			{-1, -2*mCols}
		};
		return res;
	}
	
	
	@Override
	public String toString() {
		String res = "";
		for (int[] row : board) {
			for (int x : row) {
				res += String.format("%4d", x);
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
	
	private boolean isValidMove(int pos, int[] d) {
		int xPos = (pos % mCols) + d[0];
		double yPos = (pos + d[1]) * 1.0 / mCols;
		
		//System.out.println(xPos + ", " + yPos);
		
		return !( (xPos >= mCols || xPos < 0) ||
				  (yPos >= mRows || yPos < 0) );
	}
	
	private boolean solveH(int pos, int level) {
		if (level > mRows*mCols) return true;
		else {
			int temp;
			for (int x = 0; x < 8; x++) {
				if (!isValidMove(pos, mDirections[x])) continue;
				
				temp = pos + mDirections[x][0] + mDirections[x][1];
				if (temp >= 0 && temp < mRows*mCols &&
						addK(pos, level)) {
					if (solveH(temp, level+1)) return true;
					remK(pos);
				}
			}
			return false;
		}
	}
	
	//POJO for storing possible moves on a single space
	private class SpacePair {
		private int mId;
		private int mPossMove;
		private int mPos;
		
		SpacePair(int a, int b) {
			mPos = a;
			mPossMove = b;
		}
		
		SpacePair(int a, int b, int c) {
			mPos = a;
			mPossMove = b;
			mId = c;
		}
		
		public int getPossMove() { return mPossMove; }
		public int getPos() { return mPos; }
	}
	
	private boolean solveFH(int pos, int level) {
		//System.out.println(level);
		if (level > mRows*mCols) return true;
		else {
			if (!addK(pos, level)) return false;
			//possMoves[pos/mCols][pos%mCols]--;
			
			int temp;
			int[] d;
			List<SpacePair> goodMoves= new ArrayList<>();
			for (int x = 0; x < 8; x++) {
				d = mDirections[x];
				
				if (!isValidMove(pos, d)) continue;
				
				temp = pos + d[0] + d[1];
				if (temp >= 0 && temp < mRows*mCols) {
					possMoves[temp/mCols][temp%mCols]--;
					goodMoves.add(new SpacePair(
						temp,
						possMoves[temp/mCols][temp%mCols],
						x));
				}
			}
			//cuz java 7
			Collections.sort(goodMoves, new Comparator<SpacePair>() {
				@Override
				public int compare(SpacePair o1, SpacePair o2) {
					return o1.getPossMove() - o2.getPossMove();
				}
			});
			
			/*for (SpacePair s : goodMoves) {
				System.out.print(s.getPossMove());
			}
			System.out.println();*/
			
			for (SpacePair s : goodMoves) {
				if (solveFH(s.getPos(), level+1)) return true;
				possMoves[s.getPos()/mCols][s.getPos()%mCols]++;
			}
			
			remK(pos);
			//possMoves[pos/mCols][pos%mCols]++;
			return false;
		}
	}
	
	//note: 0 is empty, start counting at 1
	public void solve() {
		board = new int[mRows][mCols];
		
		//int x = 0;
		//while (x < mRows*mCols && !solveH(x, 1)) x++;
		solveH(0, 1);
	}
	
	public void solveFast() {
		board = new int[mRows][mCols];
		possMoves = genMoves();
		
		//int x = 0;
		//while (x < mRows*mCols && !solveFH(x, 1)) System.out.println(x++);
		//solveFH(mRows*mRows/2 + mCols/2, 1);
		solveFH(0, 1);
	}
	
	public static void main(String args[]) {
		if (args.length < 2) System.exit(1);
		
		KnightBoard k = new KnightBoard(Integer.parseInt(args[0]),
			Integer.parseInt(args[1]));
		
		if (args.length > 2 && args[2].equals("f")) {
			System.out.println("fast");
			k.solveFast();
			System.out.println(k);
		}
		else {
			System.out.println("slow");
			k.solveH(0, 1);
			System.out.println(k);
		}
	}
}

