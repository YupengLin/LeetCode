package GraphValidTree;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ValidTree {
	static final int UNVISITED = 0;
	static final int VISITING = 1;
	static final int VISITED = 2;
	int visitNode  = 0;
	public boolean validTree(int n, int[][] edge) {
		if(n <= 1) {
			return true;
		}
		Hashtable<Integer, List<Integer>> graph = new Hashtable<>();
		for(int[] pair : edge) {
			int end1 = pair[0];
			int end2 = pair[1];
			if(graph.containsKey(end1)) {
				List<Integer> adjNodes = graph.get(end1);
				adjNodes.add(end2);
				graph.put(end1, adjNodes);
			} else {
				List<Integer> adjNodes = new ArrayList<>();
				adjNodes.add(end2);
				graph.put(end1, adjNodes);
			}
			
			if(graph.containsKey(end2)) {
				List<Integer> adjNodes = graph.get(end2);
				adjNodes.add(end1);
				graph.put(end2, adjNodes);
			} else {
				List<Integer> adjNodes = new ArrayList<>();
				adjNodes.add(end1);
				graph.put(end2, adjNodes);
			}
			
		}
		
		int[] visitStatus = new int[n];
		
		if(containsCycle(graph, visitStatus, 0, -1)) {
			return false;
		} 
		for(int i = 0; i < n; i++) {
			if(visitStatus[i] == UNVISITED) {
				return false;
			}
		}
		return true;
	}
	
	private boolean containsCycle(Hashtable<Integer, List<Integer>> graph,int[] visitStatus, int currNode, int parent) {
		visitStatus[currNode] = VISITED;
		List<Integer> adjNodes = graph.get(currNode);
		if(adjNodes == null) {
			return false;
		}
		for(Integer nextNode : adjNodes) {
			if(visitStatus[nextNode] == UNVISITED) {
				if(containsCycle(graph, visitStatus, nextNode, currNode)) {
					return true;
				}
			} else {
				if( nextNode != parent) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] edges = {{0, 1},{0,2}, {0,3},{1, 4}};
		ValidTree vt = new ValidTree();
		System.out.println(vt.validTree(5, edges));
	}

}
