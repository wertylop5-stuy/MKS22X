public class Node {
	private int data;
	pricate Node next;
	
	public Node(int d, Node n) {
		data = d;
		next = n;
	}
	
	public void setData(int d) {data = d;}
	public void setNode(Node n) {next = n;}
	
	public int getData() {return data;}
	public Node getNext() {return next;}
}