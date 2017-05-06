public class MyHeapCopy {
	private Integer[] heap;
	private int size;
	private int pos;
	private boolean isMax;
	
	public MyHeapCopy() {
		this(true);
	}
	
	public MyHeapCopy(boolean b) {
		heap = new Integer[2];
		isMax = b;
		pos = 1;
		size = 0;
	}
	
	private void resize() {
		//System.out.println("resize");
		Integer[] res = new Integer[heap.length*2];
		System.arraycopy(heap, 0, res, 0, heap.length);
		heap = res;
	}
	
	private void swap(int a, int b) {
		Integer temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}
	
	//a and b are indices of heap, b > a
	//returns the index containing a higher value
	private int maxOf(int a, int b) {
		if (heap[b] == null) return a;
		if (heap[a].compareTo(heap[b]) > 0) return a;
		return b;
	}
	
	private int minOf(int a, int b) {
		if (heap[b] == null) return a;
		if (heap[a].compareTo(heap[b]) < 0) return a;
		return b;
	}
	
	//bumps up leaf elem if greater than parent
	private void pushUp(int pos) {
		if(isMax) {
			while (pos > 1 && heap[pos].compareTo(heap[pos/2]) > 0) {
				swap(pos, pos/2);
				pos /= 2;
			}
		}
		else {
			while (pos > 1 && heap[pos].compareTo(heap[pos/2]) < 0) {
				swap(pos, pos/2);
				pos /= 2;
			}
		}
	}
	
	//oops shadowed
	private void pushDown(int pos) {
		int temp;
		if(isMax) {
			//System.out.println("prepos*2: "+ pos*2 + " size: " + size);
			while (pos*2 < size && heap[pos*2] != null
								&& (heap[pos].compareTo(heap[pos*2]) < 0
										|| heap[pos].compareTo(heap[pos*2+1]) < 0)) {
				//System.out.println("pos*2: "+ pos*2 + " size: " + size);
				temp = maxOf(pos*2, pos*2+1);
				swap(pos, temp);
				pos = temp;
			}
		}
		else {
			while (pos*2 < size && heap[pos*2] != null
								&& (heap[pos].compareTo(heap[pos*2]) > 0
										|| heap[pos].compareTo(heap[pos*2+1]) > 0)) {
				temp = minOf(pos*2, pos*2+1);
				swap(pos, temp);
				pos = temp;
			}
		}
	}
	
	public void add(Integer s) {
		//System.out.println(size + " " + pos + " " + heap.length);
		if (size >= heap.length - 1) {
			resize();
		}
		heap[pos++] = s;
		size++;
		
		pushUp(pos-1);
	}
	
	public Integer remove() {
		if (size <= 0) return null;
		Integer res = heap[1];
		//swap(1, --pos);
		heap[1] = heap[--pos];
		//System.out.println(this);
		
		pushDown(1);
		size--;
		
		return res;
	}
	
	public Integer peek() {
		return heap[1];
	}
	
	@Override
	public String toString() {
		String res = "[";
		for (int x = 1; x < pos; x++) {
			if (heap[x] == null) res += "_ ";
			else res += heap[x] + " ";
		}
		if (res.length() > 1)
			return res.substring(0, res.length()-1) + "]";
		return res + "]";
	}
	
	public String toStringD() {
		String res = "[";
		for (Integer s : heap) {
			if (s == null) res += "_ ";
			else res += s + " ";
		}
		if (res.length() > 1)
			return res.substring(0, res.length()-1) + "]";
		return res + "]";
	}
	
	public int getSize() {return size;}
	
	public static void main(String[] args) {
		
		MyHeapCopy m = new MyHeapCopy(false);
		System.out.println(m);
		m.add(3);
		System.out.println(m);
		
		m.add(3);
		System.out.println(m);
		m.add(0);
		System.out.println(m);
		m.add(-1);
		System.out.println(m);
		m.add(10);
		System.out.println(m);
		m.add(5);
		System.out.println(m);
		m.add(2);
		System.out.println(m);
		
		System.out.println(m.remove());
		System.out.println(m);
		System.out.println(m.remove());
		System.out.println(m);
		System.out.println(m.remove());
		System.out.println(m);
		System.out.println(m.remove());
		System.out.println(m);
		System.out.println(m.remove());
		System.out.println(m);
		System.out.println(m.remove());
		System.out.println(m);
		System.out.println(m.remove());
		System.out.println(m);
		System.out.println(m.remove());
		System.out.println(m);
			
		/*
		m = new MyHeap(true);
		System.out.println(m);
		m.add("A");
		System.out.println(m);
		
		m.add("G");
		System.out.println(m);
		m.add("Z");
		System.out.println(m);
		m.add("Z");
		System.out.println(m);
		m.add("E");
		System.out.println(m);
		m.add("M");
		System.out.println(m);
		
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		
		m.add("A");
		System.out.println(m);
		m.add("G");
		System.out.println(m);
		m.add("Z");
		System.out.println(m);
		m.add("Z");
		System.out.println(m);
		m.add("E");
		System.out.println(m);
		m.add("M");
		System.out.println(m);
		m.add("T");
		System.out.println(m);	
		
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		System.out.println(m.remove());
		System.out.println(m);
		//System.out.println(m.toStringD());
		*/
	}
}
