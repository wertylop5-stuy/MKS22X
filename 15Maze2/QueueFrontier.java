import java.util.ArrayDeque;
import java.util.Deque;
public class QueueFrontier implements Frontier {
	private Deque<Location> locations;
	
	public QueueFrontier() {
		locations = new ArrayDeque<>(8);
	}
	
	@Override
	public void add(Location l) {
		locations.add(l);
	}
	
	@Override
	public Location next() {
		return locations.remove();
	}
	
	//don't know if this will break things
	@Override
	public int size() {
		if (locations.isEmpty()) return 0;
		else return 1;
	}
	
	public static void main(String[] args) {
		
	}
}
