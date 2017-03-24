public class Quick {
	
	static void swap(int ar[], int a, int b) {
		int temp = ar[a];
		ar[a] = ar[b];
		ar[b] = temp;
	}
	
	//start inclusive, end exclusive
	static int part(int data[], int start, int end) {
		int pivot = (int)((end-start) * Math.random() + start);
		//System.out.println(pivot);
		end -= 1;
		
		swap(data, pivot, end);
		//pivot = end;
		
		while(start < end && data[start] <= data[end]) start++;
		
		int lo = start;
		start = lo+1;
		
		while(start < end) {
			/*System.out.println(lo+", "+start);
			for (int x : data) System.out.print(x+" ");
			System.out.println();
			*/
			
			if (data[start] <= data[end]) {
				swap(data, start, lo++);
			}
			
			start++;
			/*
			for (int x : data) System.out.print(x+" ");
			System.out.println();
			*/
		}
		
		swap(data, end, lo);
		
		return lo;
	}
	
	public static int quickselectslow(int[] data, int k) {
		int start = 0, end = data.length;
		int res;
		while (start < end) {
			res = part(data, start, end);
			
			if (k > res) start = res+1;
			else if (k < res) end = res;
			else if (k == res) return data[res];
		}
		return -1;
	}
	
	public static int quickselect(int[] data, int k) {
		int start = 0, end = data.length;
		int pivot;
		int lo, lt, hi, gt, i;
		
		while (start < end) {
			pivot = (int)((end-start) * Math.random() + start);
			//System.out.println("pivot: " + pivot);
			
			swap(data, pivot, end-1);
			/*for (int x : data) System.out.print(x+" ");
			System.out.println();*/
			
			
			lo = lt = start;
			hi = gt = end-1;
			i = gt-1;
			
			while(i >= lt && data[i] == data[gt]) i--;
			
			while(i >= lt) {
				/*System.out.println(lo+", "+hi);
				for (int x : data) System.out.print(x+" ");
				System.out.println();
				*/
				
				if (data[i] > data[gt]) {
					swap(data, i, gt--);
				}
				else if (data[i] < data[gt]) {
					swap(data, i, lt++);
				}
				else i--;
				/*
				for (int x : data) System.out.print(x+" ");
				System.out.println();
				*/
			}
			
			//System.out.println("k: " + k + " & lt: " + lt + " & gt: " + gt);
			if (k < lt) end = lt;
			else if (k > gt) start = gt+1;
			else return data[k];
		}
		
		return data[k];
	}
	
	//only lo and hi, no need for third pointer
	static int part2(int data[], int start, int end) {
		int pivot = (int)((end-start) * Math.random() + start);
		//System.out.println("pivot: " + pivot);
		end--;
		
		swap(data, pivot, end);
		//pivot = end;
		
		int lo = start;
		int hi = end-1;
		
		while(lo <= hi && data[lo] <= data[end]) lo++;
		
		while(lo <= hi) {
			/*System.out.println(lo+", "+hi);
			for (int x : data) System.out.print(x+" ");
			System.out.println();
			*/
			
			if (data[lo] > data[end]) {
				swap(data, lo, hi--);
			}
			else lo++;
			/*
			for (int x : data) System.out.print(x+" ");
			System.out.println();
			*/
		}
		
		//System.out.println("returning: " + end + " to " + lo);
		swap(data, end, lo);
		
		return lo;
	}
	
	public static void quicksortslow(int[] data, int start, int end) {
		if (start >= end-1) return;
		
		int res = part2(data, start, end);
		
		quicksortslow(data, res+1, end);
		quicksortslow(data, start, res);
	}
	
	//triple partition, pivot at end
	private static void quicksortH(int[] data, int start, int end) {
		if (start >= end-1) return;
		
		int pivot = (int)((end-start) * Math.random() + start);
		//System.out.println("pivot: " + pivot);
		
		swap(data, pivot, end-1);
		
		int lo = start, lt = start;
		int hi = end-1, gt = end-1;
		int i = gt-1;
		
		while(i >= lt && data[i] == data[gt]) i--;
		
		while(i >= lt) {
			/*System.out.println(lo+", "+hi);
			for (int x : data) System.out.print(x+" ");
			System.out.println();
			*/
			
			if (data[i] > data[gt]) {
				swap(data, i, gt--);
			}
			else if (data[i] < data[gt]) {
				swap(data, i, lt++);
			}
			else i--;
			/*
			for (int x : data) System.out.print(x+" ");
			System.out.println();
			*/
		}
		
		quicksortH(data, start, lt+1);
		quicksortH(data, gt+1, end);
	}
	
	public static void quicksort(int[] a) {
		quicksortH(a, 0, a.length);
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
		
		//Reverse sorted list of size arg 0 
		/*int[] a = new int[Integer.parseInt(args[0])];
		for (int x = 0; x < Integer.parseInt(args[0]); x++) {
			a[x] = Integer.parseInt(args[0])-x;
		}*/
		
		
		/*
		for (int i : a) System.out.print(i + " ");
		System.out.println();
		*/
		
		quicksort(a);
		
		/*
		for (int i : a) System.out.print(i + " ");
		System.out.println();
		*/
	}
}
