import java.io.*;
import java.util.*;

public class mar08bronze {
    
    public static int getVolume(int r , int c , int e, int[][] lake) {
	int totalDepth = 0;
        for(int x = 0; x <r; x++){
	    for (int y =0; y< c; y++){
		if (lake[x][y]-e < 0) totalDepth += (e-lake[x][y]);
	    }
	}
	
	return totalDepth*72*72;
    }

	public static void stomp(int rs, int cs, int ds, int[][] lake) {
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
	
	public static void main(String args[]) throws Exception{
		BufferedReader in = null;
		PrintWriter out = null;
		try{
		 in= new BufferedReader(new FileReader("makelake2.in"));
		 out = 
			new PrintWriter(new BufferedWriter(new FileWriter("makelake.out")));
		}
		catch(Exception e){System.out.println("Exception");}

		StringTokenizer st = null;
		
		int r, c, e, n;
		try{
		st = new StringTokenizer(in.readLine());
		}catch(Exception ex){}
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		int[][] lake = new int[r][c];
		for(int row = 0; row < r; row++) {
			try{
			st = new StringTokenizer(in.readLine());}
			catch (Exception ex){}
			
			for(int col = 0; col < c; col++){
				lake[row][col] = Integer.parseInt(st.nextToken());
//System.out.println(lake[row][col]);
			}
		}
		int rs, cs, ds;
		for(int x = 0; x<n; x++){
			st = new StringTokenizer(in.readLine());
			rs = Integer.parseInt(st.nextToken()) - 1;
			cs = Integer.parseInt(st.nextToken()) - 1;
			ds = Integer.parseInt(st.nextToken());
			stomp(rs, cs, ds, lake);
		}
		int answer = getVolume(r, c , e, lake);
		System.out.println(answer);
	}

}
