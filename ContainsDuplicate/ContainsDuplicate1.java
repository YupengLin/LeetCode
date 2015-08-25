package ContainsDuplicate;

import java.util.ArrayList;
import java.util.Hashtable;

public class ContainsDuplicate1 {
	public static boolean containsDuplicate(int[] nums) {
		Hashtable<Integer, Integer> summary = new Hashtable<>();
		for(int num : nums) {
			if(!summary.containsKey(num)){
				summary.put(new Integer(num), 1);
			} else {
				return true;
			}
		}
		return false;
    }
	  public boolean containsNearbyDuplicate(int[] nums, int k) {
	   Hashtable <Integer, ArrayList<Integer>> summary = new Hashtable<>();
	   for(int i = 0; i < nums.length; i++) {
		   if(!summary.containsKey(nums[i])) {
			   ArrayList<Integer> index = new ArrayList<>();
			   index.add(new Integer(i));
			   summary.put(nums[i], index);
		   } else {
			  ArrayList<Integer> index = summary.get(nums[i]);
			  int nearby = index.get(index.size() - 1);
			  if( i - nearby <= k) {
				  return true;
			  } else {
				  index.add(new Integer(i));
				  summary.put(nums[i], index);
			  }
		   }
	   }
	   
	   return false;
	  }
	
	public static void main(String[] args) {
		int[] t1 = {1,2,3,4,5,6,1};
		System.out.println(containsDuplicate(t1));
	}
}
