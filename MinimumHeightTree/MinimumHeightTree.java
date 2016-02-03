package MinimumHeightTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTree {
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> leaves = new ArrayList<Integer>();
		if(n <= 1) {
			leaves.add(0);
			return leaves;
		}
		List<Set<Integer>> adjNodes = new ArrayList<Set<Integer>>();
		for(int i = 0; i < n; i++) {
			adjNodes.add(new HashSet<Integer>());
		}
		for(int[] edge : edges) {
			adjNodes.get(edge[0]).add(edge[1]);
			adjNodes.get(edge[1]).add(edge[0]);
		}
		for(int i = 0; i < n; i++) {
			if(adjNodes.get(i).size() == 1) {
				leaves.add(i);
			}
		}
		
		while(n > 2) {
			n = n - leaves.size();
			List<Integer> nextLayer = new ArrayList<Integer>();
			for(int leaf : leaves) {
				int nextNode = adjNodes.get(leaf).iterator().next();
				adjNodes.get(nextNode).remove(leaf);
				if(adjNodes.get(nextNode).size() == 1) {
					nextLayer.add(nextNode);
				}
				leaves = nextLayer;
			}
		}
		return leaves;
	}
	
	public static boolean isBadVersion(int n) {
		return n >= 1;
	}
	public static int firstBadVersion(int n) {
		 int start = 1;
	        int end = n;
	        int mid = 1;
	        while(start <= end) {
	            System.out.println(mid);
	            mid = start + (end - start) / 2;
	            if(isBadVersion(mid)) {
	               if( (mid > 1) && isBadVersion(mid - 1) ) {
	                    System.out.println("2hit");
	                   end=mid - 1;
	               } else {
	                  System.out.println("hit");
	                  return mid;
	               }
	         } else  {
	             System.out.println("not bad");
	             start = mid + 1;
	         }
	        }
	        return mid;
	}

	public static void main(String[] args) {
	//int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		System.out.println(firstBadVersion(3));
	}
}
