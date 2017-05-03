public class MyHeap {
	private String[] heap;
	
	public MyHeap() {
		heap = new String[2];
	}
	
	private void resize() {
		String[] res = new String[heap.length];
		System.arraycopy(heap, 0, res, 0, heap.length);
		heap = res;
	}
	
	public void add() {
		
	}
	
	public void remove() {
		
	}
	
	public void peek() {
		
	}
	
	public static void main(String[] args) {
		
	}
}
