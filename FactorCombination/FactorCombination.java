package FactorCombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FactorCombination {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> allFactors = new ArrayList<>();
		dfs(allFactors, new ArrayList<Integer>(), n);
		allFactors.remove(allFactors.size() - 1);
		return allFactors;
    }
	
	private void dfs(List<List<Integer>> allFactors, List<Integer> currFactors, int num) {
		if(num == 1) {
			List<Integer> toAdd = new ArrayList<>(currFactors);
			Collections.sort(toAdd);
			if(!allFactors.contains(toAdd)){
				allFactors.add(toAdd);
			}
			return;
		}
		for(int i = 2; i <= num; i++) {
			if(num % i == 0) {
				
				currFactors.add(i);
				dfs(allFactors, currFactors, num / i);
				currFactors.remove(currFactors.size() - 1);
			}
		}	
	}
	
	public static void main(String[] args) {
		FactorCombination fc = new FactorCombination();
		List<List<Integer>> allFactors = fc.getFactors(32);
		//System.out.println(allFactors.size());
		for(List<Integer> factorList : allFactors) {
			System.out.println(factorList);
		}
	}
}
