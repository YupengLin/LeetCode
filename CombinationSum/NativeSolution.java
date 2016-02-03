package CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class NativeSolution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> allSum = new ArrayList<List<Integer>>();
		List<Integer> numbers = new ArrayList<>();
		dfs(allSum, numbers, 0, 0, k, n);
	
		return allSum;
	}
	
	public void dfs(List<List<Integer>> collections, List<Integer> numbers, int currSum, int num, int k, int n) {
		
		if(currSum == n && numbers.size() == k) {
			collections.add(new ArrayList<>(numbers));
			return;
		}
		if(currSum > n || numbers.size() > k) {
			return;
		}
		
		for(int i = num + 1; i <= 9; i++) {
			numbers.add(new Integer(i));
			dfs(collections, numbers, currSum + i, i, k, n);
			numbers.remove(numbers.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		NativeSolution combSum = new NativeSolution();
		List<List<Integer>> combo = combSum.combinationSum3(3 ,9);
		for(List<Integer> solution : combo) {
			System.out.println(solution.toString());
		}
	}
 }
