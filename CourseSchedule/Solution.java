package CourseSchedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	boolean[] marked;
	boolean[] onStack;
	Stack<Integer> order;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
	    List<Integer>[] graph = (List<Integer>[]) new List[numCourses];
	    for(int i = 0; i<prerequisites.length; i++){
	        int key = prerequisites[i][1];
	        int ele = prerequisites[i][0];
	        if(graph[key] == null){
	            graph[key] = new ArrayList<Integer>();
	        }
	        graph[key].add(ele);
	    }
	    marked = new boolean[numCourses];
	    onStack = new boolean[numCourses];
	    order = new Stack<Integer>();
	    if(hasCycle(numCourses, graph)) return new int[0];
	    return getOrderFromStack(order);
	}
	private boolean hasCycle(int n, List<Integer>[] graph){
	    for(int i = 0; i<n;i++){
	        if(!marked[i]){
	            if(cycleDfs(i,graph)==true) return true;
	        }
	    }
	    return false;
	}
	private boolean cycleDfs(int v, List<Integer>[] graph){
	    marked[v] = true;
	    onStack[v] = true;
	    boolean cycle = false;
	    if(graph[v]!=null){
	        for(int w: graph[v]){
	            if(!marked[w]) {
	                cycle = cycleDfs(w,graph);
	                if(cycle==true) break;
	            }
	            else if(onStack[w]){
	                cycle = true;
	                break;
	            }
	        }
	    }
	    onStack[v] = false;
	    if(!cycle) order.push(v);
	    return cycle;
	}
	private int[] getOrderFromStack(Stack<Integer> stack){
	    int[] array = new int[stack.size()];
	    for(int i = 0; i<array.length; i++) array[i] = stack.pop();
	    return array;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] c = {};
		System.out.println(s.findOrder(2,c)[1]);
	}
}
