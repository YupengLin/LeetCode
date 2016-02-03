package CourseSchedule;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class NativeSolution {
	static final int UNVISITED = 0;
	static final int VISITING = -1;
	static final int VISITED = 1;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses <= 1) {
			return true;
		}
		Hashtable<Integer, List<Integer>> graph = new Hashtable<>();
		
		int[] isVisited = new int[numCourses];
		
		for(int[] pair : prerequisites) {
			if(graph.containsKey(pair[1])) {
				graph.get(pair[1]).add(pair[0]);
			} else {
				List<Integer> adjNodes = new ArrayList<Integer>();
				adjNodes.add(pair[0]);
				graph.put(pair[1], adjNodes);
			}
		}
		
		for(int i = 0; i < numCourses; i++) {
			boolean isCyclic = containsCycle(graph, isVisited, i, 1);
			if(isCyclic) {
				return false;
			}
		}
		return true;
		
	}
	
	public boolean containsCycle(Hashtable<Integer, List<Integer>> graph, int[] isVisited, int currNode, int totalVisited) {
		if(isVisited[currNode] == VISITED) {
			return false;
		}
		
		if(isVisited[currNode] == VISITING) {
			return true;
		}
		
		
		
		List<Integer> adjNodes = graph.get(currNode);
		if(adjNodes == null) {
			return false;
		}
		isVisited[currNode] = VISITING;
		for(Integer adj : adjNodes) {
			boolean isCyclic = containsCycle(graph, isVisited, adj, totalVisited + 1);
			if(isCyclic) {
				return true;
			}
		}
		isVisited[currNode] = VISITED;
		
		
		return false;
	}
	
	public static void main(String[] args) {
		NativeSolution course = new NativeSolution();
		int[][] prerequest = {{1,0},{0,1}};
		System.out.println(course.canFinish(3, prerequest));
	}

}
