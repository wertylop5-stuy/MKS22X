public interface Frontier {
	void add(Location l);
	Location next();
	int size();
}
