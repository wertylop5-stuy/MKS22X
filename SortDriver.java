public class SortDriver {
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
		
		*sort(a);
		
		/*
		for (int i : a) System.out.print(i + " ");
		System.out.println();
		*/
	}
}
