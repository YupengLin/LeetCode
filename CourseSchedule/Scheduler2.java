package CourseSchedule;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Scheduler2 {
	static final int UNVISITED = 0;
	static final int VISITING = -1;
	static final int VISITED = 1;
	
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
		 	int[] oneOrder = new int[numCourses];
		 	if(numCourses == 1) {
		 		return oneOrder;
		 	}
	        ArrayList<Integer> order = new ArrayList<Integer>();
	        Hashtable<Integer, edge> course = new Hashtable<>();
	        Hashtable<Integer, List<Integer>> graph = new Hashtable<>();
	        for(int i = 0; i < numCourses; i++) {
	        	course.put(i, new edge());
	        	graph.put(i, new ArrayList<Integer>());
	        }
	        for(int[] pair : prerequisites) {
	        	course.get(pair[1]).outcoming.add(pair[0]);
	        	course.get(pair[0]).incoming.add(pair[1]);
	        }
	        
	        for(int i = 0; i < numCourses; i++) {
	        	graph.put(i, course.get(i).outcoming);
	        }
	        
	       ArrayList<Integer> emptyIncoming = new ArrayList<>();
	       for(int vertex : course.keySet()) {
	    	   if(course.get(vertex).incoming.isEmpty()) {
	    		   emptyIncoming.add(vertex);
	    	   }
	       }
	       
	       while(!emptyIncoming.isEmpty()) {
	    	   
	    	   int vertex = emptyIncoming.get(0);
	    	   emptyIncoming.remove(0);
	    	   order.add(new Integer(vertex));
	    	   ArrayList<Integer> connectedVX = course.get(vertex).outcoming;
	    	   for( int neighbor : connectedVX) {
	    		   course.get(neighbor).incoming.remove(new Integer(vertex));
	    		   if(course.get(neighbor).incoming.isEmpty()) {
	    			   emptyIncoming.add(new Integer(neighbor));
	    		   }
	    	   }
	       }
	       int[] isVisited = new int[numCourses];
	       for(int i = 0; i < numCourses; i++) {
	    	   
				boolean isCyclic = containsCycle(graph, isVisited, i, 1);
				if(isCyclic) {
					return new int[0];
				}
			}
	       for(int i = 0; i < numCourses; i++) {
	    	   oneOrder[i] = order.get(i);
	       }
	     
	       return oneOrder;
	 }
	 
	 private class edge {
		 public ArrayList<Integer> incoming = new ArrayList<Integer>();
		 public ArrayList<Integer> outcoming = new ArrayList<Integer>();
		
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
		Scheduler2 course = new Scheduler2();
		int[][] prerequest = {};
		course.findOrder(2, prerequest);
		
	}

}

