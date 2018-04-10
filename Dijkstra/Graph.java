import java.util.*;

//Model of graph:
//{{{0,11},{1,22},{3,44}}, {{1,32},{2,43},{3,27}},{{0,10}},{{2,22},{3,55}}}

//graph needs methods: getNumnodes, getNumEdges, getNeighbors(node n), getedgeWeight(node one, node two)
//all methods complete
public class Graph {
	private ArrayList<ArrayList<ArrayList<Integer>>> GraphRep;
	
	public Graph (ArrayList<ArrayList<ArrayList<Integer>>> g) {
		this.GraphRep = g;
	}
	
	public int getNumnodes() {
		return GraphRep.size();
	}
	
	
	public ArrayList<Integer> getNeighbors(Node n) {
		//for getNeighbors: graphrep.get(node identifier), make an arraylist of node id s and return
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		for(int i = 0; i < GraphRep.get(n.getId()).size(); i++) {
			neighbors.add(GraphRep.get(n.getId()).get(i).get(0));
		}
		return neighbors;
	}
	
	public int getNumEdges() {
		int ret = 0;
		for(int i = 0; i < GraphRep.size(); i++) {
				ret += GraphRep.get(i).size();
		}
		return ret;
	}

	public int getEdgeWeight(Node one, Node two) {
		//check in the first nodes adjacency list, return
		for(int i = 0; i < GraphRep.get(one.getId()).size(); i++) {
			if(GraphRep.get(one.getId()).get(i).get(0) == two.getId()) {
				return GraphRep.get(one.getId()).get(i).get(1);
			}
		}
		//return -1 if the connection is not present
		return -1;
	}
	
	public void printDot() {
		//print representation of graph
		System.out.println("digraph testgraph { ");
		System.out.println("rankdir=LR;");
		for(int i = 0; i < GraphRep.size(); i++) {
//			for(int b = 0; b < GraphRep.get(i).size(); b++) {
//				System.out.println(i + " -> " + GraphRep.get(i).get(b).get(0) + 
//						" [ label =  \"" + GraphRep.get(i).get(b).get(1) + "\"]");
//			}
			Node source = new Node(i);
			ArrayList<Integer> neighbors = getNeighbors(source);
			for(int dest : neighbors) {
				System.out.println(i + " -> " + dest + " [ label =  \"" + getEdgeWeight(source, new Node(dest)) + "\"]");
			}
		}
		System.out.println("}");
	}
	
}
