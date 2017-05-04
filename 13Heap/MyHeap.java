public class MyHeap {
	private String[] heap;
	private int size;
	private int pos;
	private boolean isMax;
	
	public MyHeap() {
		this(true);
	}
	
	public MyHeap(boolean b) {
		heap = new String[2];
		isMax = b;
		pos = 1;
		size = 0;
	}
	
	private void resize() {
		//System.out.println("resize");
		String[] res = new String[heap.length*2];
		System.arraycopy(heap, 0, res, 0, heap.length);
		heap = res;
	}
	
	private void swap(int a, int b) {
		String temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	//bumps up leaf elem if greater than parent
	private void pushUp(int pos) {
		if(isMax) {
			while (pos > 1 && heap[pos].compareTo(heap[pos/2])) {
				swap(pos, pos/2);
				pos /= 2;
			}
		}
		else {
			while (pos > 1 && heap[pos] <= heap[pos/2]) {
				swap(pos, pos/2);
				pos /= 2;
			}
		}
	}
	
	public void add(String s) {
		//System.out.println(size + " " + pos + " " + heap.length);
		if (size >= heap.length - 1) {
			resize();
		}
		heap[pos++] = s;
		size++;
		
		pushUp(pos-1);
	}
	
	public String remove() {
		String res = heap[0];
		pos--;
		pushDown();
	}
	
	public String peek() {
		return heap[0];
	}
	
	public String toString() {
		String res = "[";
		for (String s : heap) {
			if (s == null) res += "_ ";
			else res += s + " ";
		}
		if (res.length() > 1)
			return res.substring(0, res.length()-1) + "]";
		return res + "]";
	}
	
	public static void main(String[] args) {
		MyHeap m = new MyHeap();
		System.out.println(m);
		m.add("t");
		System.out.println(m);
		
		m.add("r");
		System.out.println(m);
		m.add("s");
		System.out.println(m);
		m.add("t");
		System.out.println(m);
	}
}
