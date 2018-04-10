import java.util.*;

public class Dijkstra {
	final int none = -1;
	final int infin = Integer.MAX_VALUE;
	
	private Graph inGraph;
	private int inputNodeInd;
	//cost.get(nodeId) = cost of path to the node;
	//cost.set(nodeId, cost) assigns the cost of the node
	//cost must be initialized to infinity in constructor
	private ArrayList<Integer> costs;
	//initialize parent to none
	//parent of 3 = node from which lowest cost path came to 3 
	private ArrayList<Integer> parent;
	//fill with false in the constructor
	private ArrayList<Boolean> isProcessed;
	

	public Dijkstra(Graph inputgraph, Node inputNode) {
		inGraph = inputgraph;
		inputNodeInd = inputNode.getId();
		costs = new ArrayList<Integer>();
		parent = new ArrayList<Integer>();
		isProcessed = new ArrayList<Boolean>();
		for(int i = 0; i < inGraph.getNumnodes(); i++) {
			costs.add(infin);
			parent.add(none);
			isProcessed.add(false);
		}
		
		int node = inputNode.getId();
		costs.set(node, 0);
		while(node != none) {
			int cost = costs.get(node);
			ArrayList<Integer> neighbors = inGraph.getNeighbors(new Node(node));
			for(int n : neighbors) {
				int newCost  = cost + inGraph.getEdgeWeight(new Node(node), new Node(n));
				if(costs.get(n) > newCost) {
					costs.set(n, newCost);
					parent.set(n, node);
				}
			}
			isProcessed.set(node, true);
			node = findLowestCostUnprocessed();
		}
	}
	
	public ArrayList<Integer> getShortestPath(Node dest) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		int currId = dest.getId();
		while(currId != none) {
			path.add(0, currId);
			currId = parent.get(currId);
		}
		return path;
	}
	
	public int getDist(Node dest) {
		return costs.get(dest.getId());
	}
	
	private int findLowestCostUnprocessed() {
		int currCost = infin;
		int currNode = none;
		for(int i = 0; i < costs.size(); i++) {
			if(!isProcessed.get(i)) {
				if(currCost > costs.get(i)) {
					currCost = costs.get(i);
					currNode = i;
				}
			}
		}
		return currNode;
	}
	
	//returns arraylist of nodes that represent prev
	public ArrayList<Integer> getPreviousList() {
		return parent;
	}
}
