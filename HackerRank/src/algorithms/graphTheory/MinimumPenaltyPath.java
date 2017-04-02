package algorithms.graphTheory;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MinimumPenaltyPath {
	private class Graph {
		private Map<Integer, Node> nodes = new HashMap<Integer, Node>();
		
		private class Edge {
			private final Node from;
			private final Node to;
			private final int penalty;
		
			public Edge(Node from, Node to, int penalty) {
				this.from = from;
				this.to= to;
				this.penalty = penalty;
			}

			public int computePenalty(int penalty) {
				return this.penalty | penalty;
			}
			
			public Node getNextNode() {
				return to;
			}

			
		}
		
		private class Node implements Comparable<Node> {
			private final int number;
			private boolean isVisited = false;
			private List<Edge> edges = new ArrayList<Edge>();
			private int minPenalty = Integer.MAX_VALUE;
			
			Node(int number) {
				this.number = number;
			}
			
			void newEdge(Node to, int penalty) {
				new Edge(this, to, penalty);
			
				edges.add(new Edge(this, to, penalty));
			}

			int getNodeNumber() {
				return number;
			}
			
			int getMinPenalty() {
				return minPenalty;
			}
			
			public int compareTo(Node o) {
				return this.number - o.number;
			}
			
			public boolean isVisited() {
				return isVisited;
			}
			
			public void clear() {
				isVisited = false;
			}
			
			
		}
		
		Graph(int numberOfNodes) {
			nodes = new HashMap<Integer, Node>();
		}
		
		void addEdge(int from, int to, int penalty) {
			Node start = nodes.get(from);
			if (start == null) {
				start = new Node(from);
				nodes.put(from, start);
			}
			
			Node end = nodes.get(to);
			if (end == null) {
				end = new Node(to);
				nodes.put(to, end);
			}

			start.newEdge(end, penalty);
			end.newEdge(start, penalty);
		}

		void clear() {
			for (Node node : nodes.values()) {
				node.clear();
			}
		}
		
		
	}
	

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	final int N = in.nextInt();
    	final int E = in.nextInt();
//    	final Graph myGraph = new Graph(N);
    	
    	int[][] edges = new int[E][3];
//    	for (int i=0; i<E; i++) {
//    		myGraph.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
//    	}
    	
    	int A = in.nextInt();
    	int B = in.nextInt();
    	in.close();
    	
    
    }
}
