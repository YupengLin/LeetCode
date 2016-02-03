package Permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return permutations;
		}
		Arrays.sort(nums);
		boolean[] isVisited = new boolean[nums.length];
		dfs(permutations, new ArrayList<Integer>(), nums, isVisited);
		return permutations;
	}
	
	public void dfs(List<List<Integer>> allPermutation, List<Integer> single, int[] nums, boolean[] isVisited) {
		if(single.size() == nums.length) {
			if(!allPermutation.contains(single)){
				allPermutation.add(new ArrayList<Integer>(single)); 
			}
			return;
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(!isVisited[i]) {
				if( i > 0 && nums[i] == nums[i - 1] && isVisited[i - 1]) return;
				int num = nums[i];
				isVisited[i] = true;
				single.add(num);
				dfs(allPermutation, single, nums, isVisited);
				single.remove(single.size() - 1);
				isVisited[i] = false;
			}
		
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1,0,1};
		Permutation p =new Permutation();
		List<List<Integer>> collection = p.permuteUnique(nums);
		for(List<Integer> each : collection) {
			System.out.println(each);
		}
	}
}
