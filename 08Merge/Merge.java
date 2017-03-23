public class Merge {
	private static merge(int[] src, int[] targ,
			int sStart, int tStart, int tEnd) {
		int ptrA = sStart, ptrB = tStart;
		
		while (ptrA < tStart && ptrB <= tEnd) {
			
		}
	}
	
	private static void mergesortH(int[] a, int[] b,
			int startIndex, int endIndex, int curSize) {
		if (curSize < 2) return;
		int mid = (startIndex+endIndex) / 2;
		
		//left
		mergesortH(a, b, startIndex, 
			mid, startIndex-mid+1);
		//right
		mergesortH(a, b, mid+1, endIndex, mid+1-endIndex+1);
		
		//if reached back to full array
		if (curSize == a.length) {
			merge(b, a, startIndex, mid+1, endIndex);
		}
		//otherwise, it's a subarray
		else {
			merge(a, b, startIndex, mid+1, endIndex);
		}
	}
	
	public static void mergesort(int[] ary) {
		int[] targ = new int[ary.length];
		mergesortH(ary, targ, 0, ary.length);
	}
	
	public static void main(String args[]) { 
		
	}
}
