public class Location implements Comparable<Location> {
	private int row;
	private int col;
	private Location previous;
	private int distToStart;
	private int distToGoal;
	private boolean aStar;
	
	public Location(int r, int c, Location prev,
		int dts, int dtg) {
		this(r, c, prev, dts, dtg, false);
	}
	
	public Location(int r, int c, Location prev,
		int dToStart, int dToGoal, boolean as) {
		row = r; col = c;
		previous = prev;
		distToStart = dToStart;
		distToGoal = dToGoal;
		aStar = as;
	}
	
	//Greater means it is farther/worse
	@Override
	public int compareTo(Location other) {
		int thisDist = distToGoal + 
			(aStar ? previous.distToStart : 0);
		
		int otherDist = other.distToGoal + 
			(aStar ? other.previous.distToStart : 0);
		
		System.out.println(thisDist + " " + otherDist);
		return thisDist - otherDist;
	}
	
	public static void main(String[] args) {
		Location a = new Location(0, 0, null, 0, 5);
		Location b = new Location(0, 0, a, 0, 6, true);
		Location c = new Location(0, 0, null, 1, 3);
		Location d = new Location(0, 0, c, 1, 4, true);
		System.out.println(b.compareTo(d));
	}
}
