public class Derp {
	
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
			System.out.println();*/
			
			if (data[start] <= data[end]) {
				swap(data, start, lo++);
			}
			/*else if (pivot+1<data.length && data[pivot] > data[pivot+1]) {
				swap(data, pivot, pivot+1);
				pivot += 1;
			}*/
			start++;
			/*
			for (int x : data) System.out.print(x+" ");
			System.out.println();*/
		}
		
		swap(data, end, lo);
		
		return lo;
	}
	
	public static void main(String args[]) {
		if (args.length < 1) System.exit(1);
		int[] a = new int[args.length];
		for (int x=0;x<args.length;x++) {
			a[x]=Integer.parseInt(args[x]);
		}
		
		System.out.println(part(a, 0, a.length));
		for (int x : a) System.out.print(x+" ");
		System.out.println();
	}
}