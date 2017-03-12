import java.io.*;
import java.util.*;

//TODO either make cell objs for each space or use 2nd array

public class USACO {
    private int getVolume(int r , int c , int e, int[][] lake) {
		int totalDepth = 0;
        for(int x = 0; x <r; x++){
			for (int y =0; y< c; y++){
				if (lake[x][y]-e < 0) totalDepth += (e-lake[x][y]);
			}
		}
		
		return totalDepth*72*72;
    }

	private void stomp(int rs, int cs, int ds, int[][] lake) {
		int highX, highY;
		int hi = -999;
		for (int x = rs; x < rs+3; x++) {
			for (int y = cs; y<cs+3; y++) {
				if (lake[x][y] > hi) {
					hi = lake[x][y];
					highX = x;
					highY = y;
				}
			}
		}

		for(int x = rs; x <rs+3; x++){
		    for (int y =cs; y< cs+3; y++){
				int temp = (ds-(hi-lake[x][y]));
				if(temp>0){
					lake[x][y] -= temp;
				}
				//System.out.print(lake[x][y] + " ");
			}
			//System.out.println();
		}
		//System.out.println(hi);
	}
	
	public int bronze(String filename) {
		BufferedReader in = null;
		//PrintWriter out = null;
		try{
		 in= new BufferedReader(new FileReader(filename));
		 //out = 
		//	new PrintWriter(new BufferedWriter(new FileWriter("makelake.out")));
		}
		catch(Exception e){System.out.println("Exception");}

		StringTokenizer st = null;
		
		int r, c, e, n;
		try{
		st = new StringTokenizer(in.readLine());
		}catch(Exception ex){System.out.println("Exception2");}
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int[][] lake = new int[r][c];
		for(int row = 0; row < r; row++) {
			try{
			st = new StringTokenizer(in.readLine());}
			catch (Exception ex){System.out.println("Exception3");}
			
			for(int col = 0; col < c; col++){
				lake[row][col] = Integer.parseInt(st.nextToken());
				//System.out.println(lake[row][col]);
			}
		}
		int rs, cs, ds;
		for(int x = 0; x<n; x++){
			try {st = new StringTokenizer(in.readLine());}
			catch(Exception ex) {System.out.println("Exception4");}
			
			rs = Integer.parseInt(st.nextToken()) - 1;
			cs = Integer.parseInt(st.nextToken()) - 1;
			ds = Integer.parseInt(st.nextToken());
			stomp(rs, cs, ds, lake);
		}
		return getVolume(r, c , e, lake);
	}
	
	/*
	private int silverH(int x, int y, int endX, int endY,
			char[][] pasture, int t) {
		if (t == 0) {
			if (x == endX && y == endY) return 1;
			return 0;
		}
		try {
			if (pasture[x][y] == '*') return 0;
		}
		catch (ArrayIndexOutOfBoundsException e) { return 0; }
		
		return silverH(x+1, y, endX, endY, pasture, t-1) +
			silverH(x, y+1, endX, endY, pasture, t-1) +
			silverH(x-1, y, endX, endY, pasture, t-1) +
			silverH(x, y-1, endX, endY, pasture, t-1);
	}
	
	public int silverSlow(String filename) {
		BufferedReader in = null;
		try{
		 in= new BufferedReader(new FileReader(filename));
		}
		catch(Exception e){System.out.println("Exception");}

		StringTokenizer st = null;
		
		int n, m, t;
		try{st = new StringTokenizer(in.readLine());}
		catch(Exception e) {}
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		char[][] pasture = new char[n][m];
		for (int x = 0; x < n; x++) {
			try {
				pasture[x] = in.readLine().toCharArray();
			}
			catch (Exception e) {}
		}
		
		int startX, startY, endX, endY;
		try{st = new StringTokenizer(in.readLine());}
		catch(Exception e) {}
		
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		endX = Integer.parseInt(st.nextToken());
		endY = Integer.parseInt(st.nextToken());
		
		return silverH(startX-1, startY-1, endX-1, endY-1, pasture, t);
	}
	*/
	
	public int silver(String filename) {
		BufferedReader in = null;
		try{
		 in= new BufferedReader(new FileReader(filename));
		}
		catch(Exception e){System.out.println("Exception");}

		StringTokenizer st = null;
		
		int n, m, t;
		try{st = new StringTokenizer(in.readLine());}
		catch(Exception e) {}
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		Pair[][] pasture = new Pair[n][m];
		for (int x = 0; x < n; x++) {
			try {
				int row = 0;
				for (char c : in.readLine().toCharArray()) {
					pasture[x][row] = new Pair(0, 0);
					if (c == '.') {
						pasture[x][row].x = 0;
						pasture[x][row++].y = 0;
					}
					if (c == '*') {
						pasture[x][row].x = -1;
						pasture[x][row++].y = -1;
					}
				}
			}
			catch (Exception e) {}
		}
		
		int startX, startY, endX, endY;
		try{st = new StringTokenizer(in.readLine());}
		catch(Exception e) {}
		
		startX = Integer.parseInt(st.nextToken()) - 1;
		startY = Integer.parseInt(st.nextToken()) - 1;
		endX = Integer.parseInt(st.nextToken()) - 1;
		endY = Integer.parseInt(st.nextToken()) - 1;
		
		/*
		Cullular automata solution (i was so close :(  )
		Uses a queue?
		
		just realized the enormous amount of data this stores when n
		increases too much. would be better to use this idea with smaller
		n.
		
		First gen: intial
		2 gen: set surrounding to one, self to zero
		3...n gen: queue the position of each surrounding
			nonzero square. Then, change the value at 
		at each nonzero square, travel to the surrounding zero
			squares. Calculate value
			After all zero squares visited, set intial squares to zero
		*/
		/*
		xnor pattern
		
		if gen even and start even, nonzero
		if gen even and start odd, zero
		if gen odd and start even, zero
		if gen odd and start odd, nonzero
		
		E = even O = odd
		S = start G = gen
		   ES  OS
		EG 01  00
		OG 00  01
		*/
		pasture[startX][startY].x = 1;
		
		Pair[] moves = {
			new Pair(0, 1),
			new Pair(0, -1),
			new Pair(1, 0),
			new Pair(-1, 0)
		};
		
		//true for even start
		//false false for odd start
		boolean start;
		if ((startX + startY) % 2 == 0) start = true;
		else start = false;
		
		for (int gen = 0; gen < t; gen++) {
			/*System.out.println("gen " + gen);
			for (Pair[] rX : pasture) {
				for (Pair p : rX) System.out.print(p.x + "," + p.y + " ");
				System.out.println();
			}*/
			//adding value
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < m; col++) {
					//zero space
					if ( !((((col+row) % 2 == 0) ^ start) ^ (gen % 2 == 0)) &&
						pasture[row][col].x != -1) {
						//pasture[row][col].y = 0;
						for (Pair o : moves) {
							//System.out.println("Move " + o.x + "," + o.y);
							if (isValid(row+o.x, col+o.y, n, m) &&
								pasture[row+o.x][col+o.y].x != -1) {
								pasture[row][col].y += pasture[row+o.x][col+o.y].x;
							}
							//System.out.println("val: "+row+","+col+" "+pasture[row][col].y);
						}
					}
				}
			}
			
			//prep for next gen (zeroing values)
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < m; col++) {
					//nonzero space
					if (//!((gen % 2 == 0) ^ start) &&
						pasture[row][col].x != -1 ) {
						pasture[row][col].x = pasture[row][col].y;
						pasture[row][col].y = 0;
					}
				}
			}
		}
		
		return pasture[endX][endY].x;
	}
	
	private class Pair {
		public int x;
		public int y;
		Pair(int a, int b) {x = a; y = b;}
	}
	
	private boolean isValid(int x, int y, int a, int b) {
		return x >= 0 && x < a && y >= 0 && y < b;
	}
	
	public static void main(String args[]) {
		if (args.length != 1) System.exit(1);
		USACO u = new USACO();
		//System.out.println(u.bronze("makelake10.in"));
		System.out.println(u.silver(args[0]));
	}
}
