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
		
		public Node(int d) {
			data = d;
		}
		/*
		public void setData(int d) {data = d;}
		public void setNode(Node n) {next = n;}
		
		public int getData() {return data;}
		public Node getNext() {return next;}
		*/
	}
	
	public MyLinkedList() {}
	
	public boolean addHead(int data) {
		Node t = new Node(data);
		if (head != null) {
			t.next = head;
		}
		else tail = t;
		
		head = t;
		
		size++;
		return true;
	}
	
	//adds to end of list
	public boolean add(int val) {
		Node t = new Node(val);
		tail.next = t;
		tail = t;
		
		size++;
		return true;
	}
	
	public void add(int pos, int data) {
		if (pos < 0 || pos > data)
			throw new IndexOutOfBoundsException(""+pos);
		
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
	
	private Node getRef(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(""+index);
		
		Node ptr = head;
		while (index > 0) {
			ptr = ptr.next;
			index--;
		}
		return ptr;
	}
	
	public int get(int index) {
		return getRef(index).data;
	}
	
	public int set(int index, int newVal) {
		Node t = getRef(index);
		int old = t.data;
		t.data = newVal;
		return old;
	}
	
	public int indexOf(int val) {
		Node ptr = head;
		int counter = 0;
		
		while(ptr != null || counter < size) {
			if (ptr.data == val) return counter;
			
			ptr = ptr.next;
			counter++;
		}
		return -1;
	}
	
	public int size() { return size; }
	
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
		l.add(6);
		System.out.println(l);
		l.add(6);
		System.out.println(l);
		
		/*
		System.out.println(l.set(4, 99));
		System.out.println(l);
		*/
	}
}
