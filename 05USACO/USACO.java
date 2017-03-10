import java.io.*;
import java.util.*;

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
	
	public static void main(String args[]) {
		USACO u = new USACO();
		//System.out.println(u.bronze("makelake10.in"));
		System.out.println(u.silver("ctravel2.in"));
	}
}
