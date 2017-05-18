import java.util.Stack;

public class StackFrontier implements Frontier {
	private Stack<Location> locations;
	
	public StackFrontier() {
		locations = new Stack<>();
	}
	
	@Override
	public void add(Location l) {
		locations.push(l);
	}
	
	@Override
	public Location next() {
		return locations.pop();
	}
	
	//don't know if this will break things
	@Override
	public int size() {
		if (locations.empty()) return 0;
		else return 1;
	}
	
	public static void main(String[] args) {
		
	}
}
