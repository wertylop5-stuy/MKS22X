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
	}
	
	public MyLinkedList() {}
	
	private boolean addHead(int data) {
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
	
	private Node getRef(int index) {
		Node ptr = head;
		while (index > 0) {
			ptr = ptr.next;
			index--;
		}
		return ptr;
	}
	
	public void add(int index, int val) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException(""+index);
		
		if (index == 0) {
			addHead(val);
			return;
		}
		if (index == size) {
			add(val);
			return;
		}
		
		Node prev = getRef(--index);	//so we can change the pointers of the node before targ
		
		Node t = new Node(val, prev.next);
		prev.next = t;
		
		size++;
	}
	
	public int remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException(""+index);
		
		int temp;
		if (index == 0) {
			temp = head.data;
			head = head.next;
			
			size--;
			return temp;
		}
		
		Node t = getRef(--index);
		temp = t.next.data;
		
		if (index == size-1) {
			tail = t;
			tail.next = null;
		}
		else {
			t.next = t.next.next;
		}
		
		size--;
		return temp;
	}
	
	public int get(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException(""+index);
		
		return getRef(index).data;
	}
	
	public int set(int index, int newVal) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException(""+index);
		
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
		
		//System.out.println(l.indexOf(0));
		
		l.add(0, -8);
		System.out.println(l);
		
		l.add(3, -8);
		System.out.println(l);
		
		l.add(7, -7);
		System.out.println(l);
		
		System.out.println(l.get(0));
		System.out.println(l.get(7));
		System.out.println(l.get(4));
		
		System.out.println("Set");
		System.out.println(l.set(0, -1));
		System.out.println(l);
		System.out.println(l.set(7, 100));
		System.out.println(l);
		System.out.println(l.set(4, 25));
		System.out.println(l);
		//System.out.println(l.get(8));
		//System.out.println(l.get(-1));
		
		System.out.println("Rem");
		System.out.println(l.remove(0));
		System.out.println(l);
		
		//System.out.println(l.remove(7));
		System.out.println(l.remove(6));
		System.out.println(l);
		System.out.println(l.remove(3));
		System.out.println(l);
		
		System.out.println(l.remove(3));
		System.out.println(l);
		
		/*
		System.out.println(l.set(4, 99));
		System.out.println(l);
		*/
	}
}
