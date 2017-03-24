public class Merge {
	private static void merge(int[] src, int[] targ,
			int sStart, int tStart, int tEnd) {
		int ptrA = sStart, ptrB = tStart;
		int tPos = sStart;
		
		System.out.println("sStart="+sStart+" tStart="+tStart+" tEnd="+tEnd+" tPos="+tPos);
	
		while (tPos < targ.length && ptrA < tStart && ptrB < tEnd) {
			if (src[ptrA] <= src[ptrB]) {
				targ[tPos++] = src[ptrA++];
			}
			else {
				targ[tPos++] = src[ptrB++];
			}
			
			for (int i : targ) {
				System.out.print(i + " ");
			}
			System.out.println();
			
		}
		
		while (tPos < targ.length && ptrA < tStart) {
			targ[tPos++] = src[ptrA++];
		}
		while (tPos < targ.length && ptrB <= tEnd) {
			targ[tPos++] = src[ptrB++];
		}
		
		
		for (int i : targ) {
			System.out.print(i + " ");
		}
		System.out.println();
		
	}
	
	private static void mergesortH(int[] a, int[] b,
			int startIndex, int endIndex, int curSize) {
		System.out.println("startIndex="+startIndex+" endIndex="+endIndex+" curSize="+curSize);
		
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
		
		
		
		if (endIndex-startIndex <= 1) {
			b[startIndex] = a[startIndex];
			return;
		}
		int mid = (startIndex+endIndex) / 2;
		
		//left
		mergesortH(a, b, startIndex, 
			mid, mid-startIndex);
		//right
		mergesortH(a, b, mid, endIndex, endIndex-mid);
		
		//if reached back to full array
		if (curSize == a.length) {
			merge(b, a, startIndex, mid, endIndex);
		}
		//otherwise, it's a subarray
		else {
			merge(a, b, startIndex, mid, endIndex);
		}
	}
	
	public static void mergesort(int[] ary) {
		int[] targ = new int[ary.length];
		mergesortH(ary, targ, 0, ary.length, ary.length);
	}
	
	public static void main(String args[]) { 
		if (args.length < 1) System.exit(1);
		int[] a = new int[args.length];
		for (int x = 0; x < args.length; x++) {
			a[x] = Integer.parseInt(args[x]);
		}
		
		for (int i : a) System.out.print(i + " ");
		System.out.println();
		
		mergesort(a);
		
		for (int i : a) System.out.print(i + " ");
		System.out.println();
	}
}
