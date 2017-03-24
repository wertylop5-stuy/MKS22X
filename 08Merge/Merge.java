public class Merge {
	
	//section 1: sStart inclusive, tStart exclusive
	//section 2: tStart inclusive, tEnd exclusive
	private static void merge(int[] targ, int[] src,
			int sStart, int tStart, int tEnd) {
		int ptrA = sStart, ptrB = tStart;
		int tPos = sStart;
		
		//System.out.println("sStart="+sStart+" tStart="+tStart+" tEnd="+tEnd+" tPos="+tPos);
	
		while (tPos < targ.length && ptrA < tStart && ptrB < tEnd) {
			if (src[ptrA] <= src[ptrB]) {
				targ[tPos++] = src[ptrA++];
			}
			else {
				targ[tPos++] = src[ptrB++];
			}
			/*
			for (int i : targ) {
				System.out.print(i + " ");
			}
			System.out.println();
			*/
		}
		
		//fill in remaining elements
		while (tPos < targ.length && ptrA < tStart) {
			targ[tPos++] = src[ptrA++];
		}
		while (tPos < targ.length && ptrB <= tEnd) {
			targ[tPos++] = src[ptrB++];
		}
		
		/*
		for (int i : targ) {
			System.out.print(i + " ");
		}
		System.out.println();
		*/
	}
	
	//start inclusive, end exclusive
	private static void mergesortH(int[] a, int[] b,
			int startIndex, int endIndex) {
		//System.out.println("startIndex="+startIndex+" endIndex="+endIndex+" curSize="+curSize);
		/*
		System.out.println("a:");
		for (int x = startIndex; x < endIndex; x++) {
			System.out.print(a[x] + " ");
		}
		System.out.println();
		
		System.out.println("b:");
		for (int x = startIndex; x < endIndex; x++) {
			System.out.print(b[x] + " ");
		}
		System.out.println();
		*/
		
		//aka if size==1
		if (endIndex-startIndex <= 1) {
			return;
		}
		int mid = (startIndex+endIndex) / 2;
		
		//left
		mergesortH(b, a, startIndex, mid);
		//right
		mergesortH(b, a, mid, endIndex);
		
		merge(a, b, startIndex, mid, endIndex);
	}
	
	public static void mergesort(int[] ary) {
		int[] targ = new int[ary.length];
		System.arraycopy(ary, 0, targ, 0, ary.length);
		mergesortH(ary, targ, 0, ary.length);
	}
	
	public static void main(String args[]) { 
		if (args.length < 1) System.exit(1);
		/*int[] a = new int[args.length];
		for (int x = 0; x < args.length; x++) {
			a[x] = Integer.parseInt(args[x]);
		}*/
		
		int[] a = new int[Integer.parseInt(args[0])];
		for (int x = 0; x < Integer.parseInt(args[0]); x++) {
			a[x] = (int)(Integer.parseInt(args[1])*Math.random());
		}
		/*
		for (int i : a) System.out.print(i + " ");
		System.out.println();
		*/
		mergesort(a);
		/*
		for (int i : a) System.out.print(i + " ");
		System.out.println();
		*/
	}
}
