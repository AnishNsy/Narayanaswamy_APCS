import java.util.*;

//A node can be constructed using only an integer as an argument. Really we could represent nodes using
//integers directly, but in order to distinguish a distance from a node it can be helpful to make the type different for
//a Node. A node will be an extremely simple class!

public class Node {

	private int identifier;
	
	public Node(int identifier) {
		this.identifier = identifier;
	}
	
	public int getId() {
		return identifier;
	}

}
