public class MyDeque {
	private String[] dq;
	private int front;
	private int back;
	
	public MyDeque() {
		dq = new String[8];
	}
	
	private void resize() {
		String temp[] = new String[dq.length * 2];
		int counter;
	}
	
	public void addFirst(String s) {
		if (s == null) throw new NullPointerException();
		if (front == back) resize();
		dq[front++] = s;
		front %= dq.length;
	}
	
	public void addLast(String s) {}
	
	public String removeFirst() {
		return null;
	}
	
	public String removeLast() {
		return null;
	}
	
	public String getFirst() {
		if (front == 0) return dq[dq.length+front-1];
		return dq[front-1];
	}
	
	public String getLast() {
		return dq[(back+1)%dq.length];
	}
	
	@Override
	public String toString() {
		String res = "[";
		for (String s : dq) {
			if (s == null) res+="_, "
		}
		if (res.length > 1) return res.substring(res-
	}
	
	public static void main(String args[]) {
		MyDeque d = new MyDeque();
	}
}
