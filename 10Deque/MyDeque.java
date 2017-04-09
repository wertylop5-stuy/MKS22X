import java.util.NoSuchElementException;

public class MyDeque {
	private String[] dq;
	private int front;
	private int back;
	
	public MyDeque() {
		dq = new String[4];
		back = 2;
		front = 3;
	}
	
	private void resize() {
		String temp[] = new String[dq.length * 2];
		int counter = 0;
		for (int x = back+1; x != front; x=(x+1)%dq.length, counter++) {
			temp[counter] = dq[x];
		}
		System.out.println("resized");
		for (String s : temp) {
			System.out.print(s + " ");
		}
		System.out.println();
		dq = temp;
		back = temp.length-1;
		front = counter;
	}
	
	private boolean isEmpty() {
		return front - back == -dq.length || front - back == 1;
	}
	
	public void addFirst(String s) {
		if (s == null) throw new NullPointerException();
		if (front == back) resize();
		dq[front++] = s;
		front %= dq.length;
		
		for (String e : dq) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public void addLast(String s) {
		if (s == null) throw new NullPointerException();
		if (front == back) resize();
		dq[back--] = s;
		if (back < 0) back = back+dq.length;
		
		for (String e : dq) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public String removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException("deque is empty");
		
		String temp = getFirst();
		
		if (front == 0) front = dq.length+front-1;
		else front = front - 1;
		
		return temp;
	}
	
	public String removeLast() {
		if (isEmpty())
			throw new NoSuchElementException("deque is empty");
		
		String temp = getLast();
		
		back = (back+1)%dq.length;
		
		return temp;
	}
	
	public String getFirst() {
		if (isEmpty())
			throw new NoSuchElementException("deque is empty");
		if (front == 0) return dq[dq.length+front-1];
		return dq[front-1];
	}
	
	public String getLast() {
		if (isEmpty())
			throw new NoSuchElementException("deque is empty");
		return dq[(back+1)%dq.length];
	}
	
	@Override
	public String toString() {
		String res = "[";
		for (int x = (back+1)%dq.length; x != front; x = (x+1)%dq.length) {
			System.out.println(x+": "+dq[x]);
			if (dq[x] == null) res += "_, ";
			else res += dq[x] + ", ";
		}
		//System.out.println(res+res.length());
		if (res.length() > 1) return res.substring(0, res.length()-2)+"]";
		return res+"]";
	}
	
	public static void main(String args[]) {
		MyDeque d = new MyDeque();
		//d.getFirst();
		//d.getLast();
		//d.removeFirst();
		//d.removeLast();
		System.out.println(d);
		d.addFirst("a");
		System.out.println(d);
		System.out.println("first: "+d.getFirst()+" last: "+d.getLast());
		d.addFirst("b");
		d.addFirst("e");
		System.out.println(d);
		d.addFirst("g");
		d.addFirst("u");
		System.out.println(d);
		d.addLast("y");
		System.out.println(d);
		d.addLast("x");
		System.out.println(d);
		d.addLast("q");
		System.out.println(d);
		System.out.println(d.front+" "+d.back);
		System.out.println("first: "+d.getFirst()+" last: "+d.getLast());
		System.out.println(d.removeFirst());
		System.out.println(d);
		System.out.println(d.removeLast());
		System.out.println(d);
		d.addLast("1");
		d.addFirst("5");
		System.out.println(d);
		
		
		MyDeque a = new MyDeque();
		a.addLast("r");
		System.out.println(/*a.removeFirst()*/a.removeLast());
		System.out.println(a);
		//System.out.println(a.removeLast()/*a.removeFirst()*/);
		//System.out.println(a);
		//a.addLast("e");
		a.addFirst("e");
		System.out.println(a);
		a.addFirst("e");
		System.out.println(a);
	}
}
