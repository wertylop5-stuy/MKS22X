public class Merge2 {
	/*
	insertion sort faster on duplicates
	insertion sort faster on random arrays size <= 60
	ins sort faster sorted array
	merge sort faster reverse sorted
		breaks even with ins sort at 30
	*/
	
	//begin inclusive, end exclusive
	public static void insertionsort(int[] data, int start, int end) {
		int temp = 0;
		int j = 0;
		
		//Go thru all elements
		for (int i = start+1; i < end; i++) {
			
			//Is the current less than the previous?
			if (data[i] < data[i-1]) {
					
				//save current val
				temp = data[i];
				j = i;
					
				//is current less than previous
				while (j > start && temp < data[j-1]) {
					data[j] = data[j-1];
						
					//change index
					j--;
				}
				data[j] = temp;
			}
		}
    }
	
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
		/*if (endIndex-startIndex <= 1) {
			return;
		}*/
		
		if (endIndex-startIndex <= 30) {
			insertionsort(a, startIndex, endIndex);
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
		if (ary.length <= 30) {
			insertionsort(ary, 0, ary.length);
			return;
		}
		int[] targ = new int[ary.length];
		System.arraycopy(ary, 0, targ, 0, ary.length);
		mergesortH(ary, targ, 0, ary.length);
	}
	
	
	
	
	
	
	
	
	
	private static void mergesorttH(int[] a, int[] b,
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
		mergesorttH(b, a, startIndex, mid);
		//right
		mergesorttH(b, a, mid, endIndex);
		
		merge(a, b, startIndex, mid, endIndex);
	}
	
	public static void mergesortt(int[] ary) {
		int[] targ = new int[ary.length];
		System.arraycopy(ary, 0, targ, 0, ary.length);
		mergesorttH(ary, targ, 0, ary.length);
	}
	
	
	
	
	
	
	
	
	
	public static void main(String args[]) { 
		//take array from command line
		/*if (args.length < 1) System.exit(1);
		int[] a = new int[args.length];
		for (int x = 0; x < args.length; x++) {
			a[x] = Integer.parseInt(args[x]);
		}*/
		
		//random array, first arg is size, second arg is number range
		int[] a = new int[Integer.parseInt(args[0])];
		for (int x = 0; x < Integer.parseInt(args[0]); x++) {
			a[x] = (int)(Integer.parseInt(args[1])*Math.random());
		}
		
		//sorted array of size arg 0
		/*int[] a = new int[Integer.parseInt(args[0])];
		for (int x = 0; x < Integer.parseInt(args[0]); x++) {
			a[x] = x;
		}*/
		
		//Reverse sorted array of size arg 0 
		/*int[] a = new int[Integer.parseInt(args[0])];
		for (int x = 0; x < Integer.parseInt(args[0]); x++) {
			a[x] = Integer.parseInt(args[0])-x;
		}*/
		
		
		/*
		for (int i : a) System.out.print(i + " ");
		System.out.println();
		*/
		/*
		int[] b = new int[a.length];
		System.arraycopy(a, 0, b, 0, a.length);
		*/
		//long start;
		
		
		//start = System.nanoTime();
		mergesortt(a);
		/*
		for (int i : a) System.out.print(i + " ");
		System.out.println();
		*/
		//System.out.println(System.nanoTime()-start);
		
		
		//start = System.nanoTime();
		//mergesort(b);
		/*
		for (int i : b) System.out.print(i + " ");
		System.out.println();
		*/
		//System.out.println(System.nanoTime()-start);
		
	}
}
