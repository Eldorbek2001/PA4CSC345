
public class Test {

	public static void main(String[] args) {
		
		
		MaxPQ x = new MaxPQ();
		Patient y=  new Patient("Ali", 1, 1);
		Patient ya=  new Patient("Bob", 1, 1);
		Patient yb=  new Patient("Sheldon", 1, 1);
		Patient yc=  new Patient("xyz", 1, 1);
		
		x.insert(y);
		x.insert(ya);
		x.insert(yb);
		x.insert(yc);
		
		System.out.println(x);
		
	}
}
