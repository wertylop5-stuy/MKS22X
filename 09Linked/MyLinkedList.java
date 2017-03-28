public class MyLinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	
	private class Node {
		int data;
		Node next;
		
		public Node(int d, Node n) {
			data = d;
			next = n;
		}
		/*
		public void setData(int d) {data = d;}
		public void setNode(Node n) {next = n;}
		
		public int getData() {return data;}
		public Node getNext() {return next;}
		*/
	}
	
	public MyLinkedList() {}
	
	public void addHead(int data) {
		Node t = new Node(data, null);
		if (head != null) {
			t.next = head;
		}
		else tail = t;
		
		head = t;
		
		size++;
	}
	
	public void add(int pos, int data) {
		if (pos == 0) {
			addHead(data);
			return;
		}
		/* TODO
		if (pos == size) {
			addTail(data);
			return;
		}
		*/
		
		Node t = new Node(data, null);
		Node ptr = head;
		pos--;		//so we can change the pointers of the node before targ
		
		while (pos > 0 && ptr != null) {
			pos--;
			ptr = ptr.next;
		}
		
	}
	
	@Override
	public String toString() {
		String res = "[";
		Node ptr = head;
		while (ptr != null) {
			if (ptr.next == null){
				res += ptr.data;
			}
			else res += ptr.data +", ";
			ptr = ptr.next;
		}
		return res+"]";
	}
	
	public static void main(String args[]) {
		MyLinkedList l = new MyLinkedList();
		
		System.out.println(l);
		l.addHead(3);
		System.out.println(l);
		l.addHead(7);
		l.addHead(11);
		System.out.println(l);
	}
}