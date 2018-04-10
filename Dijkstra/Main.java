import java.util.*;

public class Main {

	public static void main(String[] args) {
		ArrayList<ArrayList<ArrayList<Integer>>> GraphRep = new ArrayList<ArrayList<ArrayList<Integer>>>();
//		Integer[][][] adj = {
//	            { {1,6}, {2,2} },
//	            { {3,1} },
//	            {{1, 3}, {3,5}},
//	            {}
//	            
//	       };
		Integer[][][] adj = {
	            { {1,5}, {2,0} },
	            { {3,20}, {4,15} },
	            { {3,35}, {4,30} },
	            { {5,10} },
	            { {5,20} },
	            {}          
	       };
		
		for(int i = 0; i < adj.length; i++ ) {
			//create a graph
			ArrayList<ArrayList<Integer>> neigbors = new ArrayList<ArrayList<Integer>>();
	        for(int j = 0; j < adj[i].length; j++) {
	        	ArrayList<Integer> nodeAndwt = new ArrayList<Integer>();
	            for(int k = 0; k < adj[i][j].length; k++) {
	            	nodeAndwt.add(adj[i][j][k]);
	            }
	            neigbors.add(nodeAndwt);
	        }
	        GraphRep.add(neigbors);
	    }
	    System.out.println(GraphRep);
		Graph testG = new Graph(GraphRep);
		
		//printing graph representation to use in graphviz
		//testG.printDot();
		
		//testing Dijkstra
		
		Dijkstra test = new Dijkstra(testG, new Node(0));
		ArrayList<Integer> parent = test.getPreviousList();
		System.out.println("The list of prev is " + parent);
	
		ArrayList<Integer> shPath = test.getShortestPath(new Node(5));
		System.out.println("The shortest path is " + shPath + " and the distance is " + test.getDist(new Node(5)));
		
	}
}
