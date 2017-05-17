public class FrontierPriorityQueue implements Frontier {
	private PriorityQueue heap;
	
	public FrontierPriorityQueue() {
		heap = new PriorityQueue(false);
	}
	
	@Override
	public void add(Location l) {
		
	}
	
	@Override
	public Location next() {
		return null;
	}
	
	@Override
	public int size() {return heap.size();}
}
