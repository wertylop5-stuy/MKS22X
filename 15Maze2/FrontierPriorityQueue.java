public class FrontierPriorityQueue implements Frontier {
	private PriorityQueue pq;
	
	public FrontierPriorityQueue () {
	}
	
	@Override
	public void add(Location l) {
		pq.add(l);
	}
	
	@Override
	public Location next() {
		return pq.remove();
	}
	
	@Override
	public int size() {return pq.size();}
}
