package ContainsDuplicate;

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
	
	public static void main(String[] args) {
		int[] t1 = {1,2,3,4,5,6,1};
		System.out.println(containsDuplicate(t1));
	}
}
